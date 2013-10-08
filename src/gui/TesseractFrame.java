package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.tree.DefaultMutableTreeNode;

import logic.entities.AbstractMultipointObject;
import logic.entities.Camera;
import logic.entities.Dot;

import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.decorator.Highlighter;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 * The TesseractFrame just keeps track of the GUI
 * 
 * @author Julian Toelle
 * 
 */
public class TesseractFrame extends JFrame {

	private ViewPanel leftPanel;
	private ViewPanel rightPanel;
	private JPanel masterPanel;
	private InfoPanel infoPanel;
	private JTabbedPane tabbedPane;
	private JPanel viewControlPanel;
	private JScrollPane tableControlScrollPane;
	private JXTreeTable table;

	/**
	 * Initiates a TesseractFrame with 2 Cameras for 3 Dimensional viewing.
	 * 
	 * @param leftCam
	 *            The left-eye Camera
	 * @param rightCam
	 *            The right-eye Camera
	 */

	public TesseractFrame(Camera leftCam, Camera rightCam,
			ArrayList<AbstractMultipointObject> objects) {

		setMinimumSize(new Dimension(900, 500));
		setPreferredSize(new Dimension(900, 600));
		setTitle("Tesseract");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		getContentPane().setLayout(new BorderLayout());

		masterPanel = new JPanel();

		masterPanel.setLayout(new GridLayout(0, 1));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		masterPanel.add(tabbedPane);

		viewControlPanel = new JPanel();
		tabbedPane.addTab("View", null, viewControlPanel, null);
		viewControlPanel.setLayout(new GridLayout(0, 3, 0, 0));
		leftPanel = new ViewPanel(400, 600, leftCam);
		viewControlPanel.add(leftPanel);
		rightPanel = new ViewPanel(400, 600, rightCam);
		viewControlPanel.add(rightPanel);
		infoPanel = new InfoPanel(objects);
		viewControlPanel.add(infoPanel);

		tableControlScrollPane = new JScrollPane();
		tabbedPane.addTab("Control", null, tableControlScrollPane, null);

		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(new Dot());

		for (AbstractMultipointObject object : objects) {
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(
					(Dot) object);
			for (Dot dot : object.getDots()) {
				temp.add(new DefaultMutableTreeNode(dot));
			}
			rootNode.add(temp);

		}

		table = new JXTreeTable(new ObjectListModel(rootNode));
		table.setFont(new Font("Monospaced", Font.PLAIN, 11));
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.expandAll();
		table.getColumnModel().getColumn(0).setMinWidth(120);
		Highlighter highligher = HighlighterFactory
				.createSimpleStriping(HighlighterFactory.GENERIC_GRAY);
		table.setHighlighters(highligher);

		tableControlScrollPane.setViewportView(table);

		getContentPane().add(masterPanel);
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
