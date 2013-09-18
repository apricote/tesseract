package logic.entities;

import java.util.ArrayList;
/**
 * Ein Tesseract (4 Dimensionaler Würfel) bestehend aus 16 Punkten<br>
 * <b>x,y,z,w</b> beschreiben nun den Mittelpunkt des Würfels<br>
 * <b>x,y,z,w</b> der Punkte beschreiben das Relative Verhältnis der Punkte zur Würfelmitte
 * @author Julian Tölle
 * @see logic.entities.Punkt
 */
public class Tesseract extends Punkt {
	
	/**
	 * Die Punkte des Würfels
	 */
	private ArrayList<Punkt> punkte = new ArrayList<Punkt>();

	/**
	 * Gibt die Eckpunkte aus.
	 * @return ArrayList mit 16 Einträgen
	 */
	public ArrayList<Punkt> getPunkte() {
		return punkte;
	}

	/**
	 * Definiert eine neue ArrayList von Punkten als die Eckpunkte.
	 * @param punkte Die ArrayListe für die 16 neuen Eckpunkte des Tesserakts.
	 */
	public void setPunkte(ArrayList<Punkt> punkte) {
		this.punkte = punkte;
	}
	
	/**
	 * Initialisiert den Tesseract an den angegebenen Koordinaten <b>x</b>, <b>y</b>, <b>z</b>, <b>w</b><br>
	 * <b>punkte</b> Muss aus 16 Punkten bestehen.
	 * @param x Die Koordinate auf der x-Achse.
	 * @param y Die Koordinate auf der y-Achse.
	 * @param z Die Koordinate auf der z-Achse.
	 * @param w Die Koordinate auf der w-Achse.
	 * @param punkte Die ArrayListe für die 16 Eckpunkte des Tesserakts.
	 */
	public Tesseract(double x, double y, double z, double w, ArrayList<Punkt> punkte) {
		super(x, y, z, w);
		this.punkte = punkte;
	}
	
	/**
	 * Initialisiert den Tesseract an den angegebenen Koordinaten <b>x</b>, <b>y</b>, <b>z</b>, <b>w</b><br>
	 * Die Eckpunkte sind alle am Mittelpunkt des Tesserakts.<br>
	 * <b>ACHTUNG</b> Die Punkte können nichtmehr verschoben werden!
	 * @param x Die Koordinate auf der x-Achse.
	 * @param y Die Koordinate auf der y-Achse.
	 * @param z Die Koordinate auf der z-Achse.
	 * @param w Die Koordinate auf der w-Achse.
	 */
	public Tesseract(double x, double y, double z, double w) {
		super(x, y, z, w);
		for(int i=0; i<16; i++){
			Punkt punkt = new Punkt();
			punkte.add(punkt);
		}
	}
	
	/**
	 * Initiiert einen neuen Tesseract mit 16 Punkten am Mittelpunkt des Tesseracts<br>
	 * <b>ACHTUNG</b> Die Punkte können nichtmehr verschoben werden!
	 */
	public Tesseract(){
		super();
		for(int i=0; i<16; i++){
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
