package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import logic.entities.Camera;

/**
 * 
 * @author Julian Tölle
 * 
 */
public class ViewPanel extends JPanel {
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

	/**
	 * Initiates a new ViewPanel
	 * 
	 * @param h
	 *            The height of the Window
	 * @param w
	 *            The width of the Window
	 * @param cam
	 *            The camera for the drawings
	 */
	public ViewPanel(int h, int w, Camera cam) {
		setWidth(w);
		setHeight(h);
		setCamera(cam);
	}

	/**
	 * Draws the Point for easier viewing and calls the Camera to draw the
	 * Objects
	 * 
	 * @param g
	 *            The Graphics object to be drawn onto
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(getWidth() / 2 - 6, getHeight() - 75 - 6, 2 * 6, 2 * 6);

		getCamera().draw(g, getHeight(), getWidth());

	}

}
