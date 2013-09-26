package logic.entities;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Eine Kamera die die Blickfeldberechnung �bernimmt.<br />
 * Info: <a
 * href="http://robertokoci.com/world-view-projection-matrix-unveiled/">
 * http://robertokoci.com/world-view-projection-matrix-unveiled/</a>
 * 
 * @author Julian T�lle
 * 
 */
public class Camera extends Punkt {
	private double x;
	private double y;
	private double z;
	private ArrayList<MultipointObject> multipointObjects;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public ArrayList<MultipointObject> getMultipointObjects() {
		return multipointObjects;
	}

	public void setMultipointObjects(
			ArrayList<MultipointObject> multipointObjects) {
		this.multipointObjects = multipointObjects;
	}

	/**
	 * Initiates a new Camera
	 * 
	 * @param x
	 *            The x position of the Camera
	 * @param y
	 *            The y position of the Camera
	 * @param z
	 *            The z position of the Camera
	 * @param multipointObjects
	 *            The list of Objects to be drawn
	 */
	public Camera(double x, double y, double z,
			ArrayList<MultipointObject> multipointObjects) {
		setX(x);
		setY(y);
		setZ(z);
		setMultipointObjects(multipointObjects);
	}

	/**
	 * Draws the Objects onto the <i>g</i>-Graphics Object<br>
	 * <b>Future:</b> Calculates the perspective before drawing
	 * 
	 * @param g
	 *            The Graphics object to be drawn onto
	 * @param height
	 *            The height of <i>g</i>
	 * @param width
	 *            The width of <i>g</i>
	 */
	public void draw(Graphics g, int height, int width) {

		for (MultipointObject multipointObject : getMultipointObjects()) {
			ArrayList<Punkt> punkte = multipointObject.getPunkte();

			for (Punkt punkt : punkte) {
				int tempX = punkt.getXInt(10);
				int tempY = punkt.getYInt(10);
				// System.out.println(tempX + " : " + tempY);
				// int tempZ = punkt.getZInt();
				tempX = width / 2 + tempX - 3;
				tempY = height / 2 + tempY - 3;
				// System.out.println(tempX + " : " + tempY);

				g.fillOval(tempX, tempY, 5, 5);
			}

			int[][] connectedVertices = multipointObject.getConnectedVertices();

			for (int i = 0; i < connectedVertices.length; i++) {
				int x1 = width / 2
						+ punkte.get(connectedVertices[i][0]).getXInt(10);
				int y1 = height / 2
						+ punkte.get(connectedVertices[i][0]).getYInt(10);
				int x2 = width / 2
						+ punkte.get(connectedVertices[i][1]).getXInt(10);
				int y2 = height / 2
						+ punkte.get(connectedVertices[i][1]).getYInt(10);
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
