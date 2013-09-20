package gui;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import logic.entities.Camera;
import logic.entities.Punkt;

public class ViewPanel extends JPanel {
	/**
	 * @param args
	 */
	
	private int width;
	private int height;
	private Camera camera;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public void setCamera(Camera cam) {
		this.camera = cam;
	}

	public ViewPanel(int h, int w, Camera cam){
		setWidth(w);
		setHeight(h);
		setCamera(cam);
	}
	
	@Override
		protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillOval(getWidth()/2-6, getHeight()-75-6, 2*6, 2*6);
		
		ArrayList<Punkt> drawings = getCamera().getDrawings();
		System.out.println(drawings.size());
		for(Punkt drawing : drawings) {
			int tempX = (int) Math.round(drawing.getxAtm());
			int tempY = (int) Math.round(drawing.getyAtm());
			g.fillOval(tempX * 10 - 3 + 100, tempY * 10 - 3 + 100, 2 * 3, 2 * 3); // TODO Rework Args x and y, so the middle is the middle of the Panel
		}
		
		
	}

}


