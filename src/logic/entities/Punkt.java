package logic.entities;

import logic.Rotation;


/**
 * Ein Punkt in einer 4-Dimensionalen Umgebung
 * @author Julian Tölle
 */

public class Punkt {
	private double xAtm;
	private double x;
	private double yAtm;
	private double y;
	private double zAtm;
	private double z;
	private double wAtm;
	private double w;
	
	private double rad;
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getW() {
		return w;
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
	
	public double getwAtm() {
		return wAtm;
	}
	
	public void setwAtm(double w) {
		this.wAtm = w;
	}
	
	public double getRad() {
		return rad;
	}

	public void setRad(double rad) {
		this.rad = rad;
	}

	/**
	 * Initiiert einen neuen Punkt
	 * @param x Die Koordinate auf der x-Achse.
	 * @param y Die Koordinate auf der y-Achse.
	 * @param z Die Koordinate auf der z-Achse.
	 * @param w Die Koordinate auf der w-Achse.
	 */
	
	public Punkt(double x, double y, double z, double w) {
		this.xAtm = x;
		this.yAtm = y;
		this.zAtm = z;
		this.wAtm = w;
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	/**
	 * Initiiert einen neuen Punkt bei (x|y|0|0)
	 * @param x Die Koordinate auf der x-Achse.
	 * @param y Die Koordinate auf der y-Achse.
	 */
	public Punkt(double x, double y){
		this.xAtm = x;
		this.yAtm = y;
		this.zAtm = 0;
		this.wAtm = 0;
		this.x = x;
		this.y = y;
		this.z = 0;
		this.w = 0;
	}
	
	/**
	 * Initiiert einen neuen Punkt bei (0|0|0|0)
	 */
	
	public Punkt() {
		this.xAtm = 0;
		this.yAtm = 0;
		this.zAtm = 0;
		this.wAtm = 0;
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 0;
	}
	
	/**
	 * Bewegt den Punkt um Vektor v
	 * @param v	Vektor der Bewegung
	 */
	public void move(Punkt v){
		this.x = this.x + v.getX();
		this.y = this.y + v.getY();
		this.z = this.z + v.getZ();
		this.w = this.w + v.getW();
	}
	
	
	/**
	 * Aktualisiert die aktuelle Position des Würfels. (xAtm,yAtm,zAtm,wAtm)<br>
	 * Reduziert den Wert von <i>this.rad</i> auf einen Wert zwischen 0 und 2 Math.PI (0° und 360°)
	 * @deprecated
	 */
	public void update(){
		
		this.setRad(this.getRad() % (Math.PI*2.0));
		double[] cord = Rotation.rotateXY(0, this);
		setxAtm(cord[0]);
		setyAtm(cord[1]);
		setzAtm(cord[2]);
		setwAtm(cord[3]);
		
	}
	
	/**
	 * Aktualisiert die aktuelle Position des Würfels. (xAtm,yAtm,zAtm,wAtm)<br>
	 * Reduziert den Wert von <i>this.rad</i> auf einen Wert zwischen 0 und 2 Math.PI (0° und 360°)
	 */
	public void updateNew(){
		
		this.setRad(getRad() % (Math.PI*2.0));
		
		double cos = Math.cos(getRad());
    	double sin = Math.sin(getRad());
        
    	double[][] xy = {{cos, -sin, 0, 0},
        				 {sin, cos, 0, 0},
        				 {0, 0, 1, 0},
        				 {0, 0, 0, 1}};
    	
    	double[] cord = {getX(), getY(), getZ(), getW()};
    	double[] cordAtm = {0,0,0,0};

    	// Matrix xy multipliziert mit Vektor cord
    	for(int i = 0; i < 4; i++){
    		double temp = 0;
    		for(int j = 0; j < 4; j++){
    			temp = temp + xy[i][j] * cord[j];
    			
    		}
    		cordAtm[i] = temp;
    	}
    	
		setxAtm(cordAtm[0]);
		setyAtm(cordAtm[1]);
		setzAtm(cordAtm[2]);
		setwAtm(cordAtm[3]);
		//System.out.println(this.getxAtm() + " " + cord[0]);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(rad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(w);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punkt other = (Punkt) obj;
		if (Double.doubleToLongBits(rad) != Double.doubleToLongBits(other.rad))
			return false;
		if (Double.doubleToLongBits(w) != Double.doubleToLongBits(other.w))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
	
}
