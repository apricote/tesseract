package logic;

import gui.TesseractFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import logic.entities.AbstractMultipointObject;
import logic.entities.Camera;
import logic.entities.Dot;
import logic.entities.MultipointObject;

public class Main {
	public static void main(String[] args) {
		boolean autoturnEnabled = true;

		ArrayList<AbstractMultipointObject> abstractMultipointObjects = readObjects();

		Camera leftCam = new Camera(0, 0, 5, 0, abstractMultipointObjects);
		Camera rightCam = new Camera(0, 0, 5, 0, abstractMultipointObjects);
		TesseractFrame frame = new TesseractFrame(leftCam, rightCam,
				abstractMultipointObjects);

		// cube.rotate(Math.PI / 50);

		long millis = System.currentTimeMillis();

		while (true) {

			if (System.currentTimeMillis() - millis > 25) {
				if (frame.getInfoPanel().autoturnEnabled) {
					for (AbstractMultipointObject object : abstractMultipointObjects) {
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

	public static ArrayList<AbstractMultipointObject> readObjects() {

		String source = "";

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("objects.txt"));
			source = in.readLine();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] stringObjects = source.split("[$]+");

		ArrayList<AbstractMultipointObject> objects = new ArrayList<>();

		for (int i = 0; i < stringObjects.length; i++) {
			String[] stringObject = stringObjects[i].split("[|]+");
			String name = stringObject[0];
			int vertices = Integer.parseInt(stringObject[1]);
			double x = Double.parseDouble(stringObject[2]);
			double y = Double.parseDouble(stringObject[3]);
			double z = Double.parseDouble(stringObject[4]);
			double w = Double.parseDouble(stringObject[5]);

			ArrayList<Dot> dots = new ArrayList<>();

			for (int j = 6; j < (4 * vertices) + 6; j += 4) {
				double xDot = Double.parseDouble(stringObject[j]);
				double yDot = Double.parseDouble(stringObject[j + 1]);
				double zDot = Double.parseDouble(stringObject[j + 2]);
				double wDot = Double.parseDouble(stringObject[j + 3]);

				dots.add(new Dot(xDot, yDot, zDot, wDot));
			}

			int numberOfConnectedVertices = (stringObject.length - (4 * vertices + 6)) / 2;
			int beginningOfCV = 4 * vertices + 6;
			int[][] connectedVertices = new int[numberOfConnectedVertices][2];

			for (int k = 0; k < numberOfConnectedVertices; k++) {
				int first = Integer.parseInt(stringObject[beginningOfCV
						+ (k * 2)]);
				int second = Integer.parseInt(stringObject[beginningOfCV
						+ (k * 2) + 1]);
				connectedVertices[k][0] = first;
				connectedVertices[k][1] = second;
			}

			MultipointObject object = new MultipointObject(name, vertices, x,
					y, z, w, dots, connectedVertices);
			objects.add(object);

		}
		return objects;
	}
}
