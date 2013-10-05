package logic;

import gui.TesseractFrame;

import java.util.ArrayList;

import logic.entities.Camera;
import logic.entities.Cube;
import logic.entities.Dot;
import logic.entities.MultipointObject;

public class Main {
	public static void main(String[] args) {
		boolean autoturnEnabled = true;

		ArrayList<Dot> newDots = new ArrayList<>();
		newDots.add(new Dot(4, 4, 4, 4));
		newDots.add(new Dot(4, 4, -4, 4));
		newDots.add(new Dot(4, -4, 4, 4));
		newDots.add(new Dot(4, -4, -4, 4));
		newDots.add(new Dot(-4, 4, 4, 4));
		newDots.add(new Dot(-4, 4, -4, 4));
		newDots.add(new Dot(-4, -4, 4, 4));
		newDots.add(new Dot(-4, -4, -4, 4));

		newDots.add(new Dot(7, 7, 7, -7));
		newDots.add(new Dot(7, 7, -7, -7));
		newDots.add(new Dot(7, -7, 7, -7));
		newDots.add(new Dot(7, -7, -7, -7));
		newDots.add(new Dot(-7, 7, 7, -7));
		newDots.add(new Dot(-7, 7, -7, -7));
		newDots.add(new Dot(-7, -7, 7, -7));
		newDots.add(new Dot(-7, -7, -7, -7));

		ArrayList<Dot> newDots2 = new ArrayList<>();
		newDots2.add(new Dot(5, 5, 5, 5));
		newDots2.add(new Dot(5, 5, -5, 5));
		newDots2.add(new Dot(5, -5, 5, 5));
		newDots2.add(new Dot(5, -5, -5, 5));
		newDots2.add(new Dot(-5, 5, 5, 5));
		newDots2.add(new Dot(-5, 5, -5, 5));
		newDots2.add(new Dot(-5, -5, 5, 5));
		newDots2.add(new Dot(-5, -5, -5, 5));

		newDots2.add(new Dot(8, 8, 8, -8));
		newDots2.add(new Dot(8, 8, -8, -8));
		newDots2.add(new Dot(8, -8, 8, -8));
		newDots2.add(new Dot(8, -8, -8, -8));
		newDots2.add(new Dot(-8, 8, 8, -8));
		newDots2.add(new Dot(-8, 8, -8, -8));
		newDots2.add(new Dot(-8, -8, 8, -8));
		newDots2.add(new Dot(-8, -8, -8, -8));

		Cube cube = new Cube(0, 0, 0, 0, newDots);
		Cube cube2 = new Cube(0, 0, 0, 0, newDots2);

		int[][] connectedVertices = {
				// Inner Cube
				{ 0, 1 }, { 0, 2 }, { 0, 4 }, { 1, 3 }, { 1, 5 }, { 2, 3 },
				{ 2, 6 }, { 3, 7 }, { 4, 5 }, { 4, 6 },
				{ 5, 7 },
				{ 6, 7 },
				// Outer Cube
				{ 8, 9 }, { 8, 10 }, { 8, 12 }, { 9, 11 }, { 9, 13 },
				{ 10, 11 }, { 10, 14 }, { 11, 15 }, { 12, 13 }, { 12, 14 },
				{ 13, 15 }, { 14, 15 },
				// Between Cubes
				{ 0, 8 }, { 1, 9 }, { 2, 10 }, { 3, 11 }, { 4, 12 }, { 5, 13 },
				{ 6, 14 }, { 7, 15 } };
		cube.setConnectedVertices(connectedVertices);
		cube2.setConnectedVertices(connectedVertices);

		ArrayList<MultipointObject> multipointObjects = new ArrayList<>();
		multipointObjects.add(cube);
		multipointObjects.add(cube2);

		Camera leftCam = new Camera(0, 0, 5, 0, multipointObjects);
		Camera rightCam = new Camera(0, 0, 5, 0, multipointObjects);
		TesseractFrame frame = new TesseractFrame(leftCam, rightCam,
				multipointObjects);

		// cube.rotate(Math.PI / 50);

		long millis = System.currentTimeMillis();

		while (true) {

			if (System.currentTimeMillis() - millis > 25) {
				if (frame.getInfoPanel().autoturnEnabled) {
					for (MultipointObject object : multipointObjects) {
						object.rotate(Math.PI * 2 / 250);
					}
				}
				millis = System.currentTimeMillis();
				frame.repaint();
			}

			try {
				Thread.sleep(5, 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
