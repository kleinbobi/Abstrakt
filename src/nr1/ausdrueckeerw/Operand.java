package nr1.ausdrueckeerw;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public abstract class Operand implements MutableTreeNode
{
	public abstract double getErgebnis();
	private DefaultMutableTreeNode def = new DefaultMutableTreeNode();



	@Override
	public boolean isLeaf() {
		return def.isLeaf();
	}

	@Override
	public int getChildCount() {
		return def.getChildCount();
	}

	@Override
	public TreeNode getParent() {

		return def.getParent();
	}

	@Override
	public int getIndex(TreeNode treeNode) {
		return def.getIndex( treeNode );
	}

	@Override
	public Enumeration children() {
		return def.children();
	}

	@Override
	public TreeNode getChildAt(int i) {
		return def.getChildAt(i);
	}






	@Override
	public void insert(MutableTreeNode mutableTreeNode, int i) {
		def.insert(mutableTreeNode,i);
	}

	@Override
	public void remove(int i) {
		def.remove(i);
	}

	@Override
	public void remove(MutableTreeNode mutableTreeNode) {
		def.remove(mutableTreeNode);
	}

	@Override
	public void setUserObject(Object o) {
		def.setUserObject(o);
	}

	@Override
	public void removeFromParent() {
		def.removeFromParent();
	}

	@Override
	public void setParent(MutableTreeNode mutableTreeNode) {
		def.setParent(mutableTreeNode);
	}

	public void add(MutableTreeNode mutableTreeNode){
		def.add(mutableTreeNode);
	}
}
