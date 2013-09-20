package logic;

import gui.FrameManager;

import java.util.ArrayList;

import logic.entities.Camera;
import logic.entities.Cube;
import logic.entities.Punkt;

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
		ArrayList<Cube> cubes = new ArrayList<>();
		cubes.add(cube);

		//ArrayList<Punkt> punkte = cube.getPunkte();

		//for(Punkt punkt : punkte){ punkt.setRad(Math.PI);
		//punkt.updateNew(); } punkte = null; punkte = cube.getPunkte();

		/*int i = 0;

		for (Punkt punkt : punkte) { 
			i++;
			System.out.println("##### Punkt " + i + " #####");
			System.out.println("X-Koordinate: " + punkt.getxAtm());
			System.out.println("Y-Koordinate: " + punkt.getyAtm());
			System.out.println("Z-Koordinate: " + punkt.getzAtm());
		}*/
				 
				/*for (int i = 0; i < 1000; i++) {
					punkte.get(0).updateNew();
					System.out.println("i:"+i+" x:" + punkte.get(0).getxAtm() + "; Rad:"
							+ punkte.get(0).getRad());
					punkte.get(0).setRad(punkte.get(0).getRad() + (Math.PI * 2 / 36));
				}*/

		Camera leftCam = new Camera(0, 0, cubes);
		Camera rightCam = new Camera(0, 0, cubes);
		FrameManager fMng = new FrameManager(leftCam, rightCam);
		
		ArrayList<Punkt> punkte = cube.getPunkte();
		for(Punkt punkt : punkte){ 
			punkt.setRad(Math.PI/4); // A quarter Turn
			punkt.updateNew();
		}
		
	}
}
