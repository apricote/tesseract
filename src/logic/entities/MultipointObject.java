package logic.entities;

import java.util.ArrayList;

/**
 * @author Julian Tölle
 *
 */
public class MultipointObject extends Punkt {
	
	private ArrayList<Punkt> punkte = new ArrayList<Punkt>();
	private int[][] connectedVertices;
	static private int VERTICES;
	
	public ArrayList<Punkt> getPunkte() {
		return this.punkte;
	}
	
	public void setPunkte(ArrayList<Punkt> punkte){
		this.punkte = punkte;
	}
	
	public int[][] getConnectedVertices(){
		System.out.println("MO CV: " + this.connectedVertices);
		return this.connectedVertices;
	}
	
	public void setConnectedVertices(int[][] connectedVertices){
		this.connectedVertices = connectedVertices;
	}
	
	public int getVertices(){
		return this.VERTICES;
	}
	
	private void setVertices(int vertices){
		this.VERTICES = vertices;
	}
	
	public MultipointObject(double x, double y, double z){
		super(x,y,z);
	}
	
	public MultipointObject(double x, double y, double z, ArrayList<Punkt> punkte) {
		super(x, y, z);
		this.punkte = punkte;
	}

	public void rotate(double rad){
		for(Punkt punkt : this.getPunkte()){
			punkt.setRad(getRad() + rad);
			punkt.updateNew();
		}
	}
	
	

}
