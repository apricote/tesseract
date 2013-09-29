package logic.entities;

import logic.MathHelp;
import logic.Matrix;
import exceptions.MatrixException;

/**
 * A dot in a three dimensional World
 * 
 * @author Julian Tölle
 */

public class Dot {
	private double xAtm;
	private double x;
	private double yAtm;
	private double y;
	private double zAtm;
	private double z;

	private double rad;

	public double getX() {
		return x;
	}

	/**
	 * Returns the rounded <i>xAtm</i><br />
	 * Uses <i>MathHelp</i>
	 * 
	 * @return Math.round(xAtm)
	 * @see logic.MathHelp
	 */
	public int getXInt(int factor) {
		return MathHelp.round(this.getxAtm(), factor);
	}

	public double getY() {
		return y;
	}

	/**
	 * Returns the rounded <i>yAtm</i><br />
	 * Uses <i>MathHelp</i>
	 * 
	 * @return Math.round(yAtm)
	 * @see logic.MathHelp
	 */
	public int getYInt(int factor) {
		return MathHelp.round(this.getyAtm(), factor);
	}

	public double getZ() {
		return z;
	}

	/**
	 * Returns the rounded <i>zAtm</i><br />
	 * Uses <i>MathHelp</i>
	 * 
	 * @return Math.round(zAtm)
	 * @see logic.MathHelp
	 */
	public int getZInt(int factor) {
		return MathHelp.round(this.getzAtm(), factor);
	}

	public double getxAtm() {
		return xAtm;
	}

	public void setxAtm(double x) {
		this.xAtm = x;
	}

	public double getyAtm() {
		return yAtm;
	}

	public void setyAtm(double y) {
		this.yAtm = y;
	}

	public double getzAtm() {
		return zAtm;
	}

	public void setzAtm(double z) {
		this.zAtm = z;
	}

	public double getRad() {
		return rad;
	}

	/**
	 * Reduces the Value of <i>this.rad</i> between 0 and 2 Math.PI (0° to 360°)
	 * 
	 * @param rad
	 *            Angle in Radiant
	 */
	public void setRad(double rad) {
		this.rad = rad % (Math.PI * 2.0);
	}

	/**
	 * Initiates a new Dot
	 * 
	 * @param x
	 *            The coordinate on the x-Axis.
	 * @param y
	 *            The coordinate on the y-Axis.
	 * @param z
	 *            The coordinate on the z-Axis.
	 */

	public Dot(double x, double y, double z) {
		this.xAtm = x;
		this.yAtm = y;
		this.zAtm = z;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Initiates a new Dot at (0|0|0)
	 */

	public Dot() {
		this.xAtm = 0;
		this.yAtm = 0;
		this.zAtm = 0;
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	/**
	 * Moves the dot by vector v
	 * 
	 * @param v
	 *            vector of movement
	 */
	public void move(Dot v) {
		this.x = this.x + v.getX();
		this.y = this.y + v.getY();
		this.z = this.z + v.getZ();
	}

	/**
	 * Updates the current position of the Dot. (xAtm,yAtm,zAtm)
	 */
	public void update() {

		double cos = Math.cos(getRad());
		double sin = Math.sin(getRad());

		double[][] xy = { { cos, -sin, 0, 0 }, { sin, cos, 0, 0 },
				{ 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		double[][] xz = { { cos, 0, sin, 0 }, { 0, 1, 0, 0 },
				{ -sin, 0, cos, 0 }, { 0, 0, 0, 1 } };
		double[][] yz = { { 1, 0, 0, 0 }, { 0, cos, -sin, 0 },
				{ 0, sin, cos, 0 }, { 0, 0, 0, 1 } };

		Matrix xyMat = new Matrix(xy);
		Matrix xzMat = new Matrix(xz);
		Matrix yzMat = new Matrix(yz);

		double[][] cord = { { getX() }, { getY() }, { getZ() }, { 0 } };
		Matrix cordMat = new Matrix(cord);

		try {
			cordMat = MathHelp.MatMult(xyMat, cordMat);
			cordMat = MathHelp.MatMult(xzMat, cordMat);
			cordMat = MathHelp.MatMult(yzMat, cordMat);

			setxAtm(cordMat.getValue(0, 0));
			setyAtm(cordMat.getValue(1, 0));
			setzAtm(cordMat.getValue(2, 0));
		} catch (MatrixException e) {
			e.printStackTrace();
		}
	}
}
