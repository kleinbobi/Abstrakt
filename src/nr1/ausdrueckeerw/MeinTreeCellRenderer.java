package nr1.ausdrueckeerw;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class MeinTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object o, boolean b, boolean b1, boolean b2, int i, boolean b3) {
        Component ret = null;
        ret = super.getTreeCellRendererComponent(jTree, o, b, b1, b2, i, b3);

        if (o instanceof Addition) {
            ImageIcon get  = new ImageIcon(new ImageIcon(this.getClass().getResource("plus.png")).getImage());
            setIcon(get);

        }
        if (o instanceof Division) {
            ImageIcon get  = new ImageIcon(new ImageIcon(this.getClass().getResource("geteilt.jpg")).getImage());
            setIcon(get);

        }
        if (o instanceof Subtraktion) {
            ImageIcon get  = new ImageIcon(new ImageIcon(this.getClass().getResource("minus.png")).getImage());
            setIcon(get);

        }
        if (o instanceof Multiplikation) {
            ImageIcon get = new ImageIcon(new ImageIcon(this.getClass().getResource("mal.png")).getImage());
            setIcon(get);

        }
        if (o instanceof Konstante) {
            ImageIcon get  = new ImageIcon(new ImageIcon(this.getClass().getResource("konstante.png")).getImage());
            setIcon(get);

        }
        return ret;
    }
}
