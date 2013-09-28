package logic;

/**
 * A class for Matrices of doubles.
 * 
 * @author Julian Tölle
 * 
 */
public class Matrix {
	private double[][] values;
	private int col;
	private int row;

	public double[][] getValues() {
		return values;
	}

	/**
	 * Sets Values if the dimensions are equal.
	 * 
	 * @param values
	 *            The new values.
	 */
	public void setValues(double[][] values) {
		if (values.length == getCol() && values[0].length == getRow()) {
			this.values = values;
		} else {
			System.out.println("ERROR: VALUES DO NOT FIT IN MATRIX");
		}
	}

	/**
	 * Returns the value at the location
	 * 
	 * @param col
	 *            Column of the location
	 * @param row
	 *            Row of the location
	 * @return Double at the location
	 */
	public double getValue(int col, int row) {
		return values[col][row];
	}

	/**
	 * Sets value at the location
	 * 
	 * @param col
	 *            Column of the location
	 * @param row
	 *            Row of the location
	 * @param value
	 *            Value to be set into that location
	 */
	public void setValue(int col, int row, double value) {
		this.values[col][row] = value;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Initiates a new Matrix with <i>col</i> Columns and <i>row</i> Rows.
	 * 
	 * @param col
	 *            Number of columns
	 * @param row
	 *            Number of rows
	 */
	public Matrix(int col, int row) {
		setCol(col);
		setRow(row);
		this.values = new double[col][row];
	}

	/**
	 * Initiates a new Matrix with the given Values.<br />
	 * Dimensions are taken from the given Values.
	 * 
	 * @param values
	 *            Values
	 */
	public Matrix(double[][] values) {
		setCol(values.length);
		setRow(values[0].length);
		setValues(values);
	}
}
