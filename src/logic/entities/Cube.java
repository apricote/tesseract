package logic.entities;

import java.util.ArrayList;
/**
 * Ein Würfel (3 Dimensionaler Würfel) bestehend aus 8 Punkten<br>
 * <b>x,y,z</b> beschreiben nun den Mittelpunkt des Würfels<br>
 * <b>x,y,z</b> der Punkte beschreiben das Relative Verhältnis der Punkte zur Würfelmitte
 * @author Julian Tölle
 * @see logic.entities.Punkt
 */
public class Cube extends Punkt {
	
	/**
	 * Die Punkte des Würfels
	 */
	private ArrayList<Punkt> punkte = new ArrayList<Punkt>();

	/**
	 * Gibt die Eckpunkte aus.
	 * @return ArrayList mit 8 Einträgen
	 */
	public ArrayList<Punkt> getPunkte() {
		return punkte;
	}

	/**
	 * Definiert eine neue ArrayList von Punkten als die Eckpunkte.
	 * @param punkte Die ArrayListe für die 8 neuen Eckpunkte des Tesserakts.
	 */
	public void setPunkte(ArrayList<Punkt> punkte) {
		this.punkte = punkte;
	}
	
	/**
	 * Initialisiert den Cube an den angegebenen Koordinaten <b>x</b>, <b>y</b>, <b>z</b><br>
	 * <b>punkte</b> Muss aus 8 Punkten bestehen.
	 * @param x Die Koordinate auf der x-Achse.
	 * @param y Die Koordinate auf der y-Achse.
	 * @param z Die Koordinate auf der z-Achse.
	 * @param punkte Die ArrayListe für die 8 Eckpunkte des Würfels.
	 */
	public Cube(double x, double y, double z, ArrayList<Punkt> punkte) {
		super(x, y, z);
		this.punkte = punkte;
	}
	
	/**
	 * Initialisiert den Cube an den angegebenen Koordinaten <b>x</b>, <b>y</b>, <b>z</b><br>
	 * Die Eckpunkte sind alle am Mittelpunkt des Würfels.<br>
	 * <b>ACHTUNG</b> Die Punkte können nichtmehr verschoben werden!
	 * @param x Die Koordinate auf der x-Achse.
	 * @param y Die Koordinate auf der y-Achse.
	 * @param z Die Koordinate auf der z-Achse.
	 */
	public Cube(double x, double y, double z) {
		super(x, y, z);
		for(int i=0; i<8; i++){
			Punkt punkt = new Punkt();
			punkte.add(punkt);
		}
	}
	
	/**
	 * Initiiert einen neuen Cube mit 8 Punkten am Mittelpunkt des Würfels<br>
	 * <b>ACHTUNG</b> Die Punkte können nichtmehr verschoben werden!
	 */
	public Cube(){
		super();
		for(int i=0; i<8; i++){
			Punkt punkt = new Punkt();
			punkte.add(punkt);
		}
	}
	
	/**
	 * Durchläuft alle Punkte des Tesseracts, setzt ihren Winkel neu und aktualisiert ihre aktuelle Position.
	 * @param rad Winkel in Radiant
	 */
	public void rotate(double rad){
		for(Punkt punkt : punkte){
			punkt.setRad(getRad() + rad);
			punkt.updateNew();
		}
	}
	
 
} 
