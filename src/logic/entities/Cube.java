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
	public static String NAME = "Cube";

	/**
	 * Initiates the cube with a set position, but without dots.
	 * 
	 * @param x
	 *            The Center-x coordinate
	 * @param y
	 *            The Center-y coordinate
	 * @param z
	 *            The Center-z coordinate
	 * @param w
	 *            The Center-w coordinate
	 */
	public Cube(double x, double y, double z, double w) {
		super(x, y, z, w);
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
	 * @param w
	 *            the Center-w coordinate
	 * @param dots
	 *            The dots that build the cube.
	 */
	public Cube(double x, double y, double z, double w, ArrayList<Dot> dots) {
		super(x, y, z, w);
		setDots(dots);
	}

}
