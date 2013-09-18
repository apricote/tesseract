package logic.entities;

import java.util.ArrayList;
/**
 * Ein W�rfel (3 Dimensionaler W�rfel) bestehend aus 8 Punkten<br>
 * <b>x,y,z</b> beschreiben nun den Mittelpunkt des W�rfels<br>
 * <b>x,y,z</b> der Punkte beschreiben das Relative Verh�ltnis der Punkte zur W�rfelmitte
 * @author Julian T�lle
 * @see logic.entities.Punkt
 */
public class Cube extends Punkt {
	
	/**
	 * Die Punkte des W�rfels
	 */
	private ArrayList<Punkt> punkte = new ArrayList<Punkt>();

	/**
	 * Gibt die Eckpunkte aus.
	 * @return ArrayList mit 8 Eintr�gen
	 */
	public ArrayList<Punkt> getPunkte() {
		return punkte;
	}

	/**
	 * Definiert eine neue ArrayList von Punkten als die Eckpunkte.
	 * @param punkte Die ArrayListe f�r die 8 neuen Eckpunkte des Tesserakts.
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
	 * @param punkte Die ArrayListe f�r die 8 Eckpunkte des W�rfels.
	 */
	public Cube(double x, double y, double z, ArrayList<Punkt> punkte) {
		super(x, y, z);
		this.punkte = punkte;
	}
	
	/**
	 * Initialisiert den Cube an den angegebenen Koordinaten <b>x</b>, <b>y</b>, <b>z</b><br>
	 * Die Eckpunkte sind alle am Mittelpunkt des W�rfels.<br>
	 * <b>ACHTUNG</b> Die Punkte k�nnen nichtmehr verschoben werden!
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
	 * Initiiert einen neuen Cube mit 8 Punkten am Mittelpunkt des W�rfels<br>
	 * <b>ACHTUNG</b> Die Punkte k�nnen nichtmehr verschoben werden!
	 */
	public Cube(){
		super();
		for(int i=0; i<8; i++){
			Punkt punkt = new Punkt();
			punkte.add(punkt);
		}
	}
	
	/**
	 * Durchl�uft alle Punkte des Tesseracts, setzt ihren Winkel neu und aktualisiert ihre aktuelle Position.
	 * @param rad Winkel in Radiant
	 */
	public void rotate(double rad){
		for(Punkt punkt : punkte){
			punkt.setRad(getRad() + rad);
			punkt.updateNew();
		}
	}
	
 
} 
