package logic.entities;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * The virtual camera for perspective projection.<br />
 * 
 * @author Julian Toelle
 * 
 */
public class Camera extends Dot {
	private double x;
	private double y;
	private double z;
	private double w;
	private ArrayList<AbstractMultipointObject> abstractMultipointObjects;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void setW(double w) {
		this.w = w;
	}

	public ArrayList<AbstractMultipointObject> getMultipointObjects() {
		return abstractMultipointObjects;
	}

	public void setMultipointObjects(
			ArrayList<AbstractMultipointObject> abstractMultipointObjects) {
		this.abstractMultipointObjects = abstractMultipointObjects;
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
	 * @param The
	 *            w position of the Camera
	 * @param abstractMultipointObjects
	 *            The list of Objects to be drawn
	 */
	public Camera(double x, double y, double z, double w,
			ArrayList<AbstractMultipointObject> abstractMultipointObjects) {
		setX(x);
		setY(y);
		setZ(z);
		setW(w);
		setMultipointObjects(abstractMultipointObjects);
	}

	/**
	 * Draws the Objects onto the <i>g</i>-Graphics Object<br>
	 * <b>Future:</b> Calculates the Perspective perspective before drawing
	 * 
	 * @param g
	 *            The Graphics object to be drawn onto
	 * @param height
	 *            The height of <i>g</i>
	 * @param width
	 *            The width of <i>g</i>
	 */
	public void draw(Graphics g, int height, int width) {

		for (AbstractMultipointObject abstractMultipointObject : getMultipointObjects()) {
			ArrayList<Dot> punkte = abstractMultipointObject.getDots();

			for (Dot dot : punkte) {
				int tempX = dot.getXInt(10);
				int tempY = dot.getYInt(10);

				tempX = width / 2 + tempX - 3;
				tempY = height / 2 + tempY - 3;

				g.fillOval(tempX, tempY, 5, 5);
			}

			int[][] connectedVertices = abstractMultipointObject.getConnectedVertices();

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
