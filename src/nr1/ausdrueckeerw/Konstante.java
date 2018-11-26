package nr1.ausdrueckeerw;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class Konstante extends Operand
{
	private double ergebnis = 0.0;
	private TreeNode def = new DefaultMutableTreeNode();
	
	public Konstante(double ergebnis) {
		this.ergebnis = ergebnis;
	}
	public Konstante() {
		super();
	}
	
	public void setErgebnis(double ergebnis) {
		this.ergebnis = ergebnis;
	}
	public double getErgebnis() {
		return this.ergebnis;
	}
	public String toString() {
		return this.ergebnis+"";
	}



    @Override
    public boolean getAllowsChildren() {
        return false;
    }
}
