package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.entities.Camera;

/**
 * The TesseractFrame just keeps track of the GUI
 * 
 * @author Julian Tölle
 * 
 */
public class TesseractFrame extends JFrame {

	ViewPanel leftPanel;
	ViewPanel rightPanel;
	JPanel masterPanel;

	/**
	 * Initiates a TesseractFrame with 2 Cameras for 3 Dimensional viewing.
	 * 
	 * @param leftCam
	 *            The left-eye Camera
	 * @param rightCam
	 *            The right-eye Camera
	 */

	public TesseractFrame(Camera leftCam, Camera rightCam) {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());

		masterPanel = new JPanel();
		leftPanel = new ViewPanel(400, 600, leftCam);
		rightPanel = new ViewPanel(400, 600, rightCam);

		masterPanel.setLayout(new GridLayout(1, 2));

		masterPanel.add(leftPanel);
		masterPanel.add(rightPanel);

		this.add(masterPanel);
		this.setVisible(true);
	}

	@Override
	public void repaint() {
		leftPanel.setSize(masterPanel.getSize());
		rightPanel.setSize(masterPanel.getSize());
		super.repaint();
	}
}
