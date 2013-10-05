package logic;

import exceptions.MatrixException;

/**
 * A class for Matrices of doubles.
 * 
 * @author Julian Toelle
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
	 * @throws MatrixException
	 */
	public void setValues(double[][] values) throws MatrixException {
		if (values.length == getCol() && values[0].length == getRow()) {
			this.values = values;
		} else {
			throw new MatrixException("setValues: Values do not fit in Matrix");
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
	 * @throws MatrixException
	 */
	public double getValue(int col, int row) throws MatrixException {
		if (col <= getCol() && row <= getRow()) {
			return values[col][row];
		} else {
			throw new MatrixException("getValue: Position is not in Matrix");
		}
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
	 * @throws MatrixException
	 */
	public void setValue(int col, int row, double value) throws MatrixException {
		if (col <= getCol() && row <= getRow()) {
			this.values[col][row] = value;
		} else {
			throw new MatrixException("setValue: Position is not in Matrix");
		}
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
		this.values = values;
	}
}
