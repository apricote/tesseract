package logic;

import java.util.ArrayList;

import logic.entities.Punkt;
import logic.entities.Cube;

public class Test {

	/**
	 * @param args
	 *            Keine Argumente
	 */
	public static void main(String[] args) {
		ArrayList<Punkt> newPunkte = new ArrayList<>();
		newPunkte.add(new Punkt(4, 4, 4));
		newPunkte.add(new Punkt(4, 4, -4));
		newPunkte.add(new Punkt(4, -4, 4));
		newPunkte.add(new Punkt(4, -4, -4));
		newPunkte.add(new Punkt(-4, 4, 4));
		newPunkte.add(new Punkt(-4, 4, -4));
		newPunkte.add(new Punkt(-4, -4, 4));
		newPunkte.add(new Punkt(-4, -4, -4));

		Cube cube = new Cube(0, 0, 0, newPunkte);

		ArrayList<Punkt> punkte = cube.getPunkte();
		/*
		 * for(Punkt punkt : punkte){ punkt.setRad(Math.PI*2);
		 * punkt.updateNew(); } punkte = null; punkte = cube.getPunkte();
		 * 
		 * int i = 0;
		 * 
		 * for (Punkt punkt : punkte) { i++; System.out.println("##### Punkt " +
		 * i + " #####"); System.out.println("X-Koordinate: " +
		 * punkt.getxAtm()); System.out.println("Y-Koordinate: " +
		 * punkt.getyAtm()); System.out.println("Z-Koordinate: " +
		 * punkt.getzAtm()); }
		 */
		for (int i = 0; i < 1000; i++) {
			punkte.get(0).updateNew();
			System.out.println("i:"+i+" x:" + punkte.get(0).getxAtm() + "; Rad:"
					+ punkte.get(0).getRad());
			punkte.get(0).setRad(punkte.get(0).getRad() + (Math.PI * 2 / 36));
		}
	}
}
