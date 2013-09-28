package logic.entities;

import java.util.ArrayList;

/**
 * Describes an Object that contains multiple <i>logic.punkt</i> called Vertices<br>
 * <b>x,y,z</b> describe the center of the Object<br>
 * <b>x,y,z</b> of the Vertices describe their relative position to the center
 * of the Object<br>
 * <b>connectedVertices</b> contains the Vertices that are connected by a line<br>
 * 
 * @author Julian Tölle
 * 
 */
public abstract class MultipointObject extends Dot {

	private ArrayList<Dot> dots = new ArrayList<Dot>();
	private int[][] connectedVertices;
	private int VERTICES;

	public ArrayList<Dot> getDots() {
		return this.dots;
	}

	public void setDots(ArrayList<Dot> dots) {
		this.dots = dots;
	}

	public int[][] getConnectedVertices() {
		return this.connectedVertices;
	}

	public void setConnectedVertices(int[][] connectedVertices) {
		this.connectedVertices = connectedVertices;
	}

	public int getVertices() {
		return this.VERTICES;
	}

	private void setVertices(int vertices) {
		this.VERTICES = vertices;
	}

	/**
	 * Initiates a new Object
	 * 
	 * @param x
	 *            The Center-x coordinate
	 * @param y
	 *            The Center-y coordinate
	 * @param z
	 *            The Center-z coordinate
	 */
	public MultipointObject(double x, double y, double z) {
		super(x, y, z);
	}

	/**
	 * Initiates a new Object and sets the Vertices
	 * 
	 * @param x
	 *            The Center-x coordinate
	 * @param y
	 *            The Center-y coordinate
	 * @param z
	 *            The Center-z coordinate
	 * @param dots
	 *            The dots that build the cube.
	 */
	public MultipointObject(double x, double y, double z, ArrayList<Dot> dots) {
		super(x, y, z);
		this.setDots(dots);
	}

	/**
	 * Sets the Radiant for every Vertices new and then updates it's position.
	 * 
	 * @param rad
	 *            Angle in Radiant
	 */
	public void rotate(double rad) {
		for (Dot dot : this.getDots()) {
			dot.setRad(dot.getRad() + rad);
			dot.update();
		}
	}

}
