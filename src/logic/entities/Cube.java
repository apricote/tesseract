package logic.entities;

import java.util.ArrayList;

/**
 * Ein Würfel (3 Dimensionaler Würfel) bestehend aus 8 Punkten<br>
 * 
 * @author Julian Tölle
 * @see logic.entities.MultipointObject
 */
public class Cube extends MultipointObject {

	static private int VERTICES = 8;

	public Cube(double x, double y, double z) {
		super(x, y, z);
	}

	public Cube(double x, double y, double z, ArrayList<Punkt> punkte) {
		super(x, y, z);
		setPunkte(punkte);
	}
}
