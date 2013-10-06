package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.entities.Dot;
import logic.entities.AbstractMultipointObject;

public class InfoPanel extends JPanel {

	private double[] angles = new double[6];
	private JLabel[] anglesLabel = new JLabel[6];
	private JButton[] plusButton = new JButton[6];
	private JButton[] minusButton = new JButton[6];
	private JCheckBox autoturn;
	public boolean autoturnEnabled = true;
	private ArrayList<AbstractMultipointObject> objects;

	public InfoPanel(ArrayList<AbstractMultipointObject> objects) {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		this.objects = objects;
		updateAngles();

		for (int i = 0; i < 6; i++) {
			anglesLabel[i] = new JLabel();
			anglesLabel[i].setText("Angle " + (i + 1) + ": " + angles[i]);

			c.gridx = 0;
			c.gridy = i;
			c.weightx = 1;

			anglesLabel[i].setFont(new Font("monospace", Font.PLAIN, 12));
			FontMetrics fm = anglesLabel[i].getFontMetrics(anglesLabel[i]
					.getFont());
			int w = fm.stringWidth("000000000000");
			int h = fm.getHeight();
			Dimension size = new Dimension(w, h);
			anglesLabel[i].setMinimumSize(size);
			anglesLabel[i].setPreferredSize(size);

			this.add(anglesLabel[i], c);
		}

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;

		for (int i = 0; i < 6; i++) {
			minusButton[i] = new JButton();
			minusButton[i].setText("-");
			minusButton[i].addActionListener(new ButtonListener(false, i,
					objects));
			c.gridy = i;
			this.add(minusButton[i], c);
		}

		c.gridx = 2;

		for (int i = 0; i < 6; i++) {
			plusButton[i] = new JButton();
			plusButton[i].setText("+");
			plusButton[i]
					.addActionListener(new ButtonListener(true, i, objects));
			c.gridy = i;
			this.add(plusButton[i], c);
		}

		autoturn = new JCheckBox("Autoturn", true);
		autoturn.addItemListener(new AutoturnListener());
		c.gridx = 0;
		c.gridy = 6;
		this.add(autoturn, c);

	}

	@Override
	public void repaint() {
		if (objects != null) {
			updateAngles();
			for (int i = 0; i < 6; i++) {
				anglesLabel[i].setText("Angle " + (i + 1) + ": "
						+ Math.round(angles[i] * 100) / 100.0);
			}
		}

		super.repaint();
	}

	public void updateAngles() {
		for (AbstractMultipointObject object : objects) {
			for (Dot dot : object.getDots()) {
				this.angles = dot.getAngles();
			}
		}
	}

	class ButtonListener implements ActionListener {

		private boolean operation; // + -> true
		private int axis;
		private ArrayList<AbstractMultipointObject> objects;

		public ButtonListener(boolean operation, int axis,
				ArrayList<AbstractMultipointObject> objects) {
			super();
			this.operation = operation;
			this.axis = axis;
			this.objects = objects;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			for (AbstractMultipointObject object : objects) {
				if (operation) {
					object.rotate(Math.PI / 50, axis);
				} else {
					object.rotate(-(Math.PI / 50), axis);
				}
			}
		}
	}

	class AutoturnListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				autoturnEnabled = false;
			} else {
				autoturnEnabled = true;
			}

		}
	}
}
