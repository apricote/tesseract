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
	// TODO IMPLEMENT CAMERA
	private double x;
	private double y;
	private ArrayList<Cube> cubes;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public ArrayList<Cube> getCubes() {
		return cubes;
	}

	public void setCubes(ArrayList<Cube> cubes) {
		this.cubes = cubes;
	}

	public Camera(double x, double y, ArrayList<Cube> cubes) {
		setX(x);
		setY(y);
		setCubes(cubes);
	}

	public ArrayList<Punkt> getDrawings() {

		ArrayList<Punkt> drawings = new ArrayList<>();

		int i = 0;

		for (Cube cube : getCubes()) {

			ArrayList<Punkt> punkte = cube.getPunkte();

			for (Punkt punkt : punkte) {

				drawings.add(punkt);
				System.out.println("No:" + i + "; x:" + punkt.getxAtm());
				i++;
			}
		}
		return drawings;
	}

	public void draw(Graphics g, int height, int width) {

		for (Cube cube : getCubes()) {

			for (Punkt punkt : cube.getPunkte()) {

				int tempX = (int) Math.round(punkt.getxAtm());
				int tempY = (int) Math.round(punkt.getyAtm());
				tempX = width / 2 + tempX * 10 - 3;
				tempY = height / 2 + tempY * 10 - 3;

				g.fillOval(tempX, tempY, 2 * 3, 2 * 3);
			}
		}
	}
}
