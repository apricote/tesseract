package gui;

import javax.swing.tree.DefaultMutableTreeNode;

import logic.entities.AbstractMultipointObject;
import logic.entities.Dot;

import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

public class ObjectListModel extends AbstractTreeTableModel {

	// ArrayList<AbstractMultipointObject> MultipointObjects;
	int numberOfObjects;
	Dot[] objects;
	String[] columnNames = { "Item Name", "X", "Y", "Z", "W", "xAtm", "yAtm",
			"zAtm", "wAtm", "Alpha", "Beta", "Gamma", "Delta", "Epsilon",
			"Zeta" };

	public ObjectListModel(DefaultMutableTreeNode root) {
		super(root);
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(Object obj, int index) {

		Dot dot = null;
		DefaultMutableTreeNode dataNode = null;

		if (obj instanceof DefaultMutableTreeNode) {
			dataNode = (DefaultMutableTreeNode) obj;
			dot = (Dot) dataNode.getUserObject();

		}

		if (dot != null) {
			switch (index) {
			case 0:
				if (dataNode.isLeaf()) {
					return dot.NAME;
				} else {
					AbstractMultipointObject amo = (AbstractMultipointObject) dataNode
							.getUserObject();
					return amo.NAME;
				}
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
		AbstractMultipointObject moObj = (AbstractMultipointObject) parentObj;
		Dot dObj = (Dot) childObj;
		return moObj.getDots().indexOf(dObj);
	}

	public boolean isLeaf(Object node) {
		return getChildCount(node) == 0;
	}

}
