package logic.entities;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Eine Kamera die die Blickfeldberechnung übernimmt.<br />
 * Info: <a href="http://robertokoci.com/world-view-projection-matrix-unveiled/">http://robertokoci.com/world-view-projection-matrix-unveiled/</a>
 * @author Julian
 *
 */
public class Camera extends Punkt {
	private double x;
	private double y;
	private ArrayList<MultipointObject> multipointObjects;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public ArrayList<MultipointObject> getMultipointObjects() {
		return multipointObjects;
	}

	public void setMultipointObjects(ArrayList<MultipointObject> multipointObjects) {
		this.multipointObjects = multipointObjects;
	}

	public Camera(double x, double y, ArrayList<MultipointObject> multipointObjects) {
		setX(x);
		setY(y);
		setMultipointObjects(multipointObjects);
	}

	public ArrayList<Punkt> getDrawings() {

		ArrayList<Punkt> drawings = new ArrayList<>();

		int i = 0;

		for (MultipointObject multipointObject : getMultipointObjects()) {

			ArrayList<Punkt> punkte = multipointObject.getPunkte();

			for (Punkt punkt : punkte) {

				drawings.add(punkt);
				System.out.println("No:" + i + "; x:" + punkt.getxAtm());
				i++;
			}
		}
		return drawings;
	}

	public void draw(Graphics g, int height, int width) {

		for (MultipointObject multipointObject : getMultipointObjects()) {
			ArrayList<Punkt> punkte = multipointObject.getPunkte();

			for (Punkt punkt : punkte) {

				int tempX = (int) Math.round(punkt.getxAtm());
				int tempY = (int) Math.round(punkt.getyAtm());
				tempX = width / 2 + tempX * 10 - 3;
				tempY = height / 2 + tempY * 10 - 3;

				g.fillOval(tempX, tempY, 2 * 3, 2 * 3);
			}
			
			int[][] connectedVertices = multipointObject.getConnectedVertices();
			System.out.println(connectedVertices);
			//int[][] connectedPoints = {{0,1},{0,2},{0,4},{1,3},{1,5},{2,3},{2,6},{3,7},{4,5},{4,6},{5,7},{6,7}};
			
			for(int i=0; i < connectedVertices.length; i++){
				int x1 = width / 2 + punkte.get(connectedVertices[i][0]).getXInt() * 10;
				int y1 = height / 2 + punkte.get(connectedVertices[i][0]).getYInt() * 10;
				int x2 = width / 2 + punkte.get(connectedVertices[i][1]).getXInt() * 10;
				int y2 = height / 2 + punkte.get(connectedVertices[i][1]).getYInt() * 10;
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
