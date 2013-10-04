package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.entities.Camera;
import logic.entities.MultipointObject;

/**
 * The TesseractFrame just keeps track of the GUI
 * 
 * @author Julian Tölle
 * 
 */
public class TesseractFrame extends JFrame {

	private ViewPanel leftPanel;
	private ViewPanel rightPanel;
	private JPanel masterPanel;
	private InfoPanel infoPanel;

	/**
	 * Initiates a TesseractFrame with 2 Cameras for 3 Dimensional viewing.
	 * 
	 * @param leftCam
	 *            The left-eye Camera
	 * @param rightCam
	 *            The right-eye Camera
	 */

	public TesseractFrame(Camera leftCam, Camera rightCam,
			ArrayList<MultipointObject> objects) {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());

		masterPanel = new JPanel();
		leftPanel = new ViewPanel(400, 600, leftCam);
		rightPanel = new ViewPanel(400, 600, rightCam);
		infoPanel = new InfoPanel(objects);

		masterPanel.setLayout(new GridLayout(1, 3));

		masterPanel.add(leftPanel);
		masterPanel.add(rightPanel);
		masterPanel.add(infoPanel);

		this.add(masterPanel);
		this.setVisible(true);
	}

	@Override
	public void repaint() {
		leftPanel.setSize(masterPanel.getSize());
		rightPanel.setSize(masterPanel.getSize());
		infoPanel.repaint();
		super.repaint();
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}
}
