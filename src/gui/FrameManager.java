package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;

import logic.entities.Camera;

/**
 * The FrameManager just keeps track of the GUI
 * 
 * @author Julian Tölle
 * 
 */
public class FrameManager {

	private JFrame frame = new JFrame("Tesseract");
	private GridLayout grid = new GridLayout(1, 2);

	/**
	 * Initiates a FrameManager with 2 Cameras for 3 Dimensional viewing.
	 * 
	 * @param leftCam
	 *            The lef-eye Camera
	 * @param rightCam
	 *            The right-eye Camera
	 */
	public FrameManager(Camera leftCam, Camera rightCam) {

		frame.setLayout(grid);

		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ViewPanel leftPanel = new ViewPanel(frame.getHeight(),
				frame.getWidth() / 2, leftCam);
		ViewPanel rightPanel = new ViewPanel(frame.getHeight(),
				frame.getWidth() / 2, rightCam);

		frame.add(leftPanel);
		frame.add(rightPanel);
	}

	public void repaint() {
		frame.repaint();
	}

}
