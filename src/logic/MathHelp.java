package logic;

import exceptions.MatrixException;

/**
 * Abstract class with some useful Math functions
 * 
 * @author Julian Toelle
 * 
 */
public abstract class MathHelp {

	/**
	 * Calculates the absolute difference between to doubles.
	 * 
	 * @param a
	 *            First double for difference
	 * @param b
	 *            Second double for difference
	 * @return Absolute difference between points
	 */
	public static double dist(double a, double b) {
		a = Math.abs(a);
		b = Math.abs(b);
		return Math.abs(a - b);
	}

	/**
	 * Rounds a double to a int.
	 * 
	 * @param a
	 *            The double to be rounded
	 * @return Rounded, int-casted double
	 */
	public static int round(double a) {
		return (int) Math.round(a);
	}

	/**
	 * Rounds a double to a int, after the double was multiplied by the
	 * <i>factor</i>
	 * 
	 * @param a
	 *            The double to be rounded
	 * @param factor
	 *            The number a is multiplied with before the rounding.
	 * @return Multiplied, rounded, int-casted double
	 */
	public static int round(double a, int factor) {
		return (int) Math.round(a * factor);
	}

	/**
	 * Multiplies two Matrices according to normale Matrix Multiplication<br />
	 * <b>Warning: </b><i>a.getRow()</i> must equal <i>b.getCol()</i>
	 * 
	 * @param a
	 *            Matrix a
	 * @param b
	 *            Matrix b
	 * @return Multiplied Matrix
	 * @throws MatrixException
	 */
	public static Matrix MatMult(Matrix a, Matrix b) throws MatrixException {
		Matrix c = new Matrix(a.getCol(), b.getRow());

		if (a.getRow() == b.getCol()) {
			for (int i = 0; i < a.getCol(); i++) {
				for (int k = 0; k < b.getRow(); k++) {
					double temp = 0;
					for (int j = 0; j < a.getRow(); j++) {
						temp += a.getValue(i, j) * b.getValue(j, k);
					}
					c.setValue(i, k, temp);
				}
			}
		} else {
			throw new MatrixException("MatMult: Matrixes cannot be multiplied");
		}
		return c;
	}
}