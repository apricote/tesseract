package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;

import logic.entities.Camera;

public class FrameManager {

	/**
	 * @param args
	 */
	public FrameManager(Camera leftCam, Camera rightCam){
		
		JFrame frame = new JFrame("Tesseract");
		GridLayout grid = new GridLayout(1,2);
		frame.setLayout(grid);
		
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ViewPanel leftPanel = new ViewPanel(frame.getHeight(), frame.getWidth()/2, leftCam);
		ViewPanel rightPanel = new ViewPanel(frame.getHeight(), frame.getWidth()/2, rightCam);
		
		frame.add(leftPanel);
		frame.add(rightPanel);
	}

}
