package nr1.ausdrueckeerw;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class GuiNr6Int extends JFrame {


    public GuiNr6Int(DefaultTreeModel b){
        int w = 1200;
        int h = 400;
        setTitle("schware orbet");
        setBounds(500, 25, w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);



        Container contentPane =
                getContentPane();
        contentPane.setLayout(null);

        //TreeModel b = new DefaultTreeModel(k);

        JTree j = new JTree(b);

        contentPane.add(j);

        j.setBounds(0,0,w,h);

        setVisible(true);







    }

    public GuiNr6Int(){
        int w = 1200;
        int h = 800;
        setTitle("schware orbet");
        setBounds(500, 25, w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        TreeNode e = new Konstante(3.0);


        Container contentPane =
                getContentPane();
        contentPane.setLayout(null);

        Addition add = (new Addition(new Konstante(3), new Addition(new Konstante(4), new Konstante(5))));
        DefaultTreeModel treeModel = new DefaultTreeModel(add);


        JTree j = new JTree(treeModel);
       // TreeCellRenderer rend = new MeinTreeCellRenderer();
       // j.setCellRenderer(rend);

        contentPane.add(j);

        j.setBounds(0,0,w,h);

        setVisible(true);

    }


    public static void main(String[] args) {
        new GuiNr6Int();
    }

}
