package logic.entities;

import java.util.ArrayList;
/**
 * Ein W�rfel (3 Dimensionaler W�rfel) bestehend aus 8 Punkten<br>
 * <b>x,y,z</b> beschreiben nun den Mittelpunkt des W�rfels<br>
 * <b>x,y,z</b> der Punkte beschreiben das Relative Verh�ltnis der Punkte zur W�rfelmitte
 * @author Julian T�lle
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
