package logic.entities;

import java.util.ArrayList;

/**
 * A Cube (3 Dimensional), containing 8 Vertices <br />
 * 
 * @author Julian Tölle
 * @see logic.entities.MultipointObject
 */
public class Cube extends MultipointObject {

	static private int VERTICES = 8;

	/**
	 * Initiates the cube with a set position, but without dots.
	 * 
	 * @param x
	 *            The Center-x coordinate
	 * @param y
	 *            The Center-y coordinate
	 * @param z
	 *            The Center-z coordinate
	 */
	public Cube(double x, double y, double z) {
		super(x, y, z);
	}

	/**
	 * Initiates the cube with a set Position and dots
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
	public Cube(double x, double y, double z, ArrayList<Dot> dots) {
		super(x, y, z);
		setDots(dots);
	}

}
