package logic;

import java.util.ArrayList;

import logic.entities.Punkt;
import logic.entities.Tesseract;

public class Test {

	/**
	 * @param args Keine Argumente
	 */
	public static void main(String[] args) {
		ArrayList<Punkt> newPunkte = new ArrayList<>();
		newPunkte.add(new Punkt(1,2,3,4));
		newPunkte.add(new Punkt(2,2,3,4));
		newPunkte.add(new Punkt(3,2,3,4));
		newPunkte.add(new Punkt(4,2,3,4));
		newPunkte.add(new Punkt(5,2,3,4));
		newPunkte.add(new Punkt(6,2,3,4));
		newPunkte.add(new Punkt(7,2,3,4));
		newPunkte.add(new Punkt(8,2,3,4));
		newPunkte.add(new Punkt(9,2,3,4));
		newPunkte.add(new Punkt(10,2,3,4));
		newPunkte.add(new Punkt(11,2,3,4));
		newPunkte.add(new Punkt(12,2,3,4));
		newPunkte.add(new Punkt(13,2,3,4));
		newPunkte.add(new Punkt(14,2,3,4));
		newPunkte.add(new Punkt(15,2,3,4));
		newPunkte.add(new Punkt(16,2,3,4));
		
		Tesseract cube = new Tesseract(1,2,3,4, newPunkte);
		
		ArrayList<Punkt> punkte = cube.getPunkte();
		
		for(Punkt punkt : punkte){
			punkt.setRad(Math.PI*2);
			punkt.updateNew();
		}
		punkte = null;
		punkte = cube.getPunkte();

		int i = 0;
		
		for (Punkt punkt : punkte) {
			i++;
			System.out.println("Punkt " + i +"; x: " + punkt.getxAtm() +"; y: " + punkt.getyAtm());			
		}
	}
}
