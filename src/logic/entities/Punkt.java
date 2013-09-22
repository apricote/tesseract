package logic.entities;

/**
 * Ein Punkt in einer 3-Dimensionalen Umgebung
 * 
 * @author Julian Tölle
 */

public class Punkt {
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
	
	public int getXInt() {
		return (int) Math.round(this.getxAtm());
	}

	public double getY() {
		return y;
	}
	
	public int getYInt() {
		return (int) Math.round(this.getyAtm());
	}

	public double getZ() {
		return z;
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

	public void setRad(double rad) {
		this.rad = rad;
	}

	/**
	 * Initiiert einen neuen Punkt
	 * 
	 * @param x
	 *            Die Koordinate auf der x-Achse.
	 * @param y
	 *            Die Koordinate auf der y-Achse.
	 * @param z
	 *            Die Koordinate auf der z-Achse.
	 */

	public Punkt(double x, double y, double z) {
		this.xAtm = x;
		this.yAtm = y;
		this.zAtm = z;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Initiiert einen neuen Punkt bei (x|y|0)
	 * 
	 * @param x
	 *            Die Koordinate auf der x-Achse.
	 * @param y
	 *            Die Koordinate auf der y-Achse.
	 */
	public Punkt(double x, double y) {
		this.xAtm = x;
		this.yAtm = y;
		this.zAtm = 0;
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	/**
	 * Initiiert einen neuen Punkt bei (0|0|0)
	 */

	public Punkt() {
		this.xAtm = 0;
		this.yAtm = 0;
		this.zAtm = 0;
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	/**
	 * Bewegt den Punkt um Vektor v
	 * 
	 * @param v
	 *            Vektor der Bewegung
	 */
	public void move(Punkt v) {
		this.x = this.x + v.getX();
		this.y = this.y + v.getY();
		this.z = this.z + v.getZ();
	}

	/**
	 * Aktualisiert die aktuelle Position des Würfels. (xAtm,yAtm,zAtm)<br>
	 * Reduziert den Wert von <i>this.rad</i> auf einen Wert zwischen 0 und 2
	 * Math.PI (0° und 360°)
	 */
	public void updateNew() {

		this.setRad(getRad() % (Math.PI * 2.0));

		double cos = Math.cos(getRad());
		double sin = Math.sin(getRad());

		double[][] xy = { { cos, -sin, 0 }, { sin, cos, 0 }, { 0, 0, 1 }, { 0, 0, 0 } };
		double[][] xz = { { cos, 0, sin }, { 0, 1, 0 }, { -sin, 0, cos }, { 0, 0, 0 } };
		double[][] yz = { { 1, 0, 0 }, { 0, cos, -sin }, { 0, sin, cos }, { 0, 0, 0 } };

		double[] cord = { getX(), getY(), getZ() };
		double[] cordAtm = { 0, 0, 0 };

		// Matrix xy multipliziert mit Vektor cord
		for (int i = 0; i < 3; i++) {
			double temp = 0;
			for (int j = 0; j < 3; j++) {
				temp = temp + xy[i][j] * cord[j];
			}
			cordAtm[i] = temp;
		}
		
		for (int i = 0; i < 3; i++) {
			double temp = 0;
			for (int j = 0; j < 3; j++) {
				temp = temp + xz[i][j] * cordAtm[j];
			}
			cord[i] = temp;
		}
		
		for (int i = 0; i < 3; i++) {
			double temp = 0;
			for (int j = 0; j < 3; j++) {
				temp = temp + yz[i][j] * cord[j];
			}
			cordAtm[i] = temp;
		}
		

		setxAtm(cordAtm[0]);
		setyAtm(cordAtm[1]);
		setzAtm(cordAtm[2]);

	}

}
