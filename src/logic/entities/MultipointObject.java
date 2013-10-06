package logic.entities;

import java.util.ArrayList;

public class MultipointObject extends AbstractMultipointObject {

	public MultipointObject(double x, double y, double z, double w) {
		super(x, y, z, w);
	}

	public MultipointObject(double x, double y, double z, double w,
			ArrayList<Dot> dots) {
		super(x, y, z, w, dots);
	}

	public MultipointObject(String name, int vertices, double x, double y,
			double z, double w, ArrayList<Dot> dots, int[][] connectedVertices) {
		super(x, y, z, w, dots);
		this.NAME = name;
		this.VERTICES = vertices;
		this.setConnectedVertices(connectedVertices);
	}

}
