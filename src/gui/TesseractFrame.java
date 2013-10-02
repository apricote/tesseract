package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

		masterPanel = new JPanel(new BorderLayout(10, 10));

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftPanel = new ViewPanel(this.getHeight(), this.getWidth() / 2,
				leftCam);
		rightPanel = new ViewPanel(this.getHeight(), this.getWidth() / 2,
				rightCam);
		masterPanel.add(leftPanel);
		masterPanel.add(rightPanel, BorderLayout.EAST);

		this.getContentPane().add(masterPanel);
		this.setVisible(true);
		this.pack();
	}

	@Override
	public void repaint() {
		leftPanel.setPreferredSize(new Dimension(this.getWidth() / 2, this
				.getHeight()));
		rightPanel.setPreferredSize(new Dimension(this.getWidth() / 2, this
				.getHeight()));
		super.repaint();
	}
}
