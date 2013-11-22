package logic;

import gui.TesseractFrame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logic.entities.AbstractMultipointObject;
import logic.entities.Camera;
import logic.entities.Dot;
import logic.entities.MultipointObject;

public class Main {
	private static ArrayList<AbstractMultipointObject> abstractMultipointObjects;
	private static boolean autoturnEnabled = true;
	private static TesseractFrame frame;
	
	public static void main(String[] args) {

		abstractMultipointObjects = readObjects();

		Camera leftCam = new Camera(0, 0, 5, 0, abstractMultipointObjects);
		Camera rightCam = new Camera(0, 0, 5, 0, abstractMultipointObjects);
		frame = new TesseractFrame(leftCam, rightCam,
				abstractMultipointObjects);

		mainLoop();

	}

	public static ArrayList<AbstractMultipointObject> readObjects() {

		String source = "Tesseract|16|0.0|0.0|0.0|0.0|4.0|4.0|4.0|4.0|4.0|4.0|4.0|-4.0|4.0|4.0|-4.0|4.0|4.0|4.0|-4.0|-4.0|4.0|-4.0|4.0|4.0|4.0|-4.0|4.0|-4.0|4.0|-4.0|-4.0|4.0|4.0|-4.0|-4.0|-4.0|-4.0|4.0|4.0|4.0|-4.0|4.0|4.0|-4.0|-4.0|4.0|-4.0|4.0|-4.0|4.0|-4.0|-4.0|-4.0|-4.0|4.0|4.0|-4.0|-4.0|4.0|-4.0|-4.0|-4.0|-4.0|4.0|-4.0|-4.0|-4.0|-4.0|0|1|0|2|0|4|1|3|1|5|2|3|2|6|3|7|4|5|4|6|5|7|6|7|8|9|8|10|8|12|9|11|9|13|10|11|10|14|11|15|12|13|12|14|13|15|14|15|0|8|1|9|2|10|3|11|4|12|5|13|6|14|7|15$";

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("objects.txt"));
			source = in.readLine();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			try {
				File file = new File("objects.txt");
				BufferedWriter output = new BufferedWriter(new FileWriter(file));
				output.write(source);
				output.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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

	public static void saveObjects(ArrayList<AbstractMultipointObject> objects) {

		String saveString = "";

		for (AbstractMultipointObject object : objects) {
			saveString += object.NAME + "|";
			saveString += object.VERTICES + "|";
			saveString += object.getX() + "|" + object.getY() + "|"
					+ object.getZ() + "|" + object.getW();

			for (Dot dot : object.getDots()) {
				saveString += "|" + dot.getX() + "|" + dot.getY() + "|"
						+ dot.getZ() + "|" + dot.getW();
			}

			int[][] connectedVertices = object.getConnectedVertices();

			for (int i = 0; i < connectedVertices.length; i++) {
				saveString += "|" + connectedVertices[i][0] + "|"
						+ connectedVertices[i][1];
			}
			saveString += "$";

		}

		try {
			File file = new File("objects.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(saveString);
			output.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public static void mainLoop(){
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
}
