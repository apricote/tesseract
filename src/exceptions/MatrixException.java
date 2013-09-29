package exceptions;

public class MatrixException extends Exception {

	public MatrixException() {
		super();
	}

	public MatrixException(String arg0) {
		super(arg0);
	}

	public MatrixException(Throwable arg0) {
		super(arg0);
	}

	public MatrixException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MatrixException(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
