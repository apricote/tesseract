package logic.entities;

import java.util.ArrayList;

/**
 * Eine Kamera die die Blickfeldberechnung übernimmt.<br />
 * Info: <a href="http://robertokoci.com/world-view-projection-matrix-unveiled/">http://robertokoci.com/world-view-projection-matrix-unveiled/</a>
 * @author Julian
 *
 */
public class Camera extends Punkt {
 //TODO IMPLEMENT CAMERA
	private double x;
	private double y;
	private ArrayList<Cube> cubes;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public ArrayList<Cube> getCubes() {
		return cubes;
	}
	public void setCubes(ArrayList<Cube> cubes) {
		this.cubes = cubes;
	}
	
	public Camera(double x, double y, ArrayList<Cube> cubes){
		setX(x);
		setY(y);
		setCubes(cubes);
	}
	
	public ArrayList<Punkt> getDrawings(){

		ArrayList<Punkt> drawings = new ArrayList<>();
		
		int i = 0;
		
		for (Cube cube : getCubes()) {
			
			ArrayList<Punkt> punkte = cube.getPunkte();
			
			for (Punkt punkt : punkte){
				
				drawings.add(punkt);
				System.out.println("No:"+i+"; x:"+punkt.getxAtm());
				i++;
			}
		}
		return drawings;
		
	}

}
