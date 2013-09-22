package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import logic.entities.Camera;

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
		
		getCamera().draw(g, getHeight(), getWidth());		
		
	}

}


