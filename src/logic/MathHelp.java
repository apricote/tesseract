package logic;

public abstract class MathHelp {
	public static double dist(double a, double b) {
		a = Math.abs(a);
		b = Math.abs(b);
		return Math.abs(a - b);
	}

	public static int round(double a) {
		return (int) Math.round(a);
	}

	public static int round(double a, int factor) {
		return (int) Math.round(a * factor);
	}
}
