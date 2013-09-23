package logic;

import gui.FrameManager;
import java.util.ArrayList;
import logic.entities.Camera;
import logic.entities.Cube;
import logic.entities.MultipointObject;
import logic.entities.Punkt;

public class Test {
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
		int[][] connectedVertices = {{0,1},{0,2},{0,4},{1,3},{1,5},{2,3},{2,6},{3,7},{4,5},{4,6},{5,7},{6,7}};
		cube.setConnectedVertices(connectedVertices);
		ArrayList<MultipointObject> multipointObject = new ArrayList<>();
		multipointObject.add(cube);

		Camera leftCam = new Camera(0, 0, multipointObject);
		Camera rightCam = new Camera(0, 0, multipointObject);
		FrameManager fMng = new FrameManager(leftCam, rightCam);
		
		ArrayList<Punkt> punkte = cube.getPunkte();
		for(Punkt punkt : punkte){ 
			punkt.setRad(Math.PI/45);
			punkt.updateNew();
		}
		
	}
}
