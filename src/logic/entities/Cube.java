package logic.entities;

import java.util.ArrayList;
/**
 * Ein Würfel (3 Dimensionaler Würfel) bestehend aus 8 Punkten<br>
 * <b>x,y,z</b> beschreiben nun den Mittelpunkt des Würfels<br>
 * <b>x,y,z</b> der Punkte beschreiben das Relative Verhältnis der Punkte zur Würfelmitte
 * @author Julian Tölle
 * @see logic.entities.Punkt
 */
public class Cube extends MultipointObject {
	
	static private int VERTICES = 8;
	
	public Cube(double x, double y, double z, ArrayList<Punkt> punkte) {
		super(x, y, z, punkte);
	}
	
	//public int[][] getConnectedVertices(){
	//	return this.connectedVertices;
	//}
} 
