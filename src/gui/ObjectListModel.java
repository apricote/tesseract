package gui;

import javax.swing.tree.DefaultMutableTreeNode;

import logic.entities.Dot;
import logic.entities.MultipointObject;

import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

public class ObjectListModel extends AbstractTreeTableModel {

	// ArrayList<MultipointObject> MultipointObjects;
	int numberOfObjects;
	Dot[] objects;
	String[] columnNames = { "Item Index", "X", "Y", "Z", "W", "xAtm", "yAtm",
			"zAtm", "wAtm", "Alpha", "Beta", "Gamma", "Delta", "Epsilon",
			"Zeta" };

	public ObjectListModel(DefaultMutableTreeNode root) {
		super(root);
		// this.MultipointObjects = MultipointObjects;

		/*
		 * numberOfObjects = 0; for (MultipointObject object :
		 * MultipointObjects) { numberOfObjects++;
		 * 
		 * for (Dot dot : object.getDots()) { numberOfObjects++; } } objects =
		 * new Dot[numberOfObjects];
		 * 
		 * int i = 0; for (MultipointObject object : MultipointObjects) {
		 * objects[i] = object; i++; for (Dot dot : object.getDots()) {
		 * objects[i] = dot; i++; } }
		 */

	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 0) {
			return false;
		}
		return true;
	}

	@Override
	public Object getValueAt(Object obj, int index) {
		Dot dot = null;
		if (obj instanceof Dot) {
			dot = (Dot) obj;
		} else if (obj instanceof DefaultMutableTreeNode) {
			DefaultMutableTreeNode dataNode = (DefaultMutableTreeNode) obj;
			dot = (Dot) dataNode.getUserObject();
		}
		if (dot != null) {
			switch (index) {
			case 1:
				return Math.round(dot.getX() * 100) / 100.0;
			case 2:
				return Math.round(dot.getY() * 100) / 100.0;
			case 3:
				return Math.round(dot.getZ() * 100) / 100.0;
			case 4:
				return Math.round(dot.getW() * 100) / 100.0;
			case 5:
				return Math.round(dot.getxAtm() * 100) / 100.0;
			case 6:
				return Math.round(dot.getyAtm() * 100) / 100.0;
			case 7:
				return Math.round(dot.getzAtm() * 100) / 100.0;
			case 8:
				return Math.round(dot.getwAtm() * 100) / 100.0;
			case 9:
				return Math.round(dot.getAngles()[0] * 100) / 100.0;
			case 10:
				return Math.round(dot.getAngles()[1] * 100) / 100.0;
			case 11:
				return Math.round(dot.getAngles()[2] * 100) / 100.0;
			case 12:
				return Math.round(dot.getAngles()[3] * 100) / 100.0;
			case 13:
				return Math.round(dot.getAngles()[4] * 100) / 100.0;
			case 14:
				return Math.round(dot.getAngles()[5] * 100) / 100.0;
			}
		}
		return null;
	}

	@Override
	public Object getChild(Object obj, int index) {
		if (obj instanceof DefaultMutableTreeNode) {
			DefaultMutableTreeNode nodes = (DefaultMutableTreeNode) obj;
			return nodes.getChildAt(index);
		}
		return null;
	}

	@Override
	public int getChildCount(Object obj) {
		if (obj instanceof DefaultMutableTreeNode) {
			DefaultMutableTreeNode nodes = (DefaultMutableTreeNode) obj;
			return nodes.getChildCount();
		}
		return 0;
	}

	@Override
	public int getIndexOfChild(Object parentObj, Object childObj) {
		MultipointObject moObj = (MultipointObject) parentObj;
		Dot dObj = (Dot) childObj;
		return moObj.getDots().indexOf(dObj);
	}

	public boolean isLeaf(Object node) {
		return getChildCount(node) == 0;
	}

}
