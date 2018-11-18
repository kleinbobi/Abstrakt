package Nr2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class KonoverwaltungGUI extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton NeuGkB;
    private JButton buchenB;
    private JButton NeuSkB;
    private JButton uberB;
    private JButton anzeigeB;
    private JTextArea textArea1;
    private JLabel knr1L;
    private JLabel knr2L;
    private JPanel boi;

    private int stelle=0;
    private static final int MAX_KOSTEN = 100;
    private Konto[] konten;
    private static final double STARTZINSSATZ = 0.25;
    private static final double STARTUEBZUEHUNG = -1000.0;


    public KonoverwaltungGUI() {
        setTitle("BOI");
        setContentPane(boi);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        konten = new Konto[100];
        try {
            Gehaltskonto.setStartueberziehung(STARTUEBZUEHUNG);
        }catch (KontoException e){
            message(e);
        }

        NeuGkB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                konten[stelle] = new Gehaltskonto();
                textArea1.append(konten[stelle].toString()+"\n");
                stelle++;
            }
        });
        NeuSkB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    konten[stelle] = new Sparkonto(Integer.parseInt(textField1.getText()), Integer.parseInt(textField4.getText()));
                    textArea1.append(konten[stelle].toString()+"\n");
                    stelle++;
                }catch (KontoException e){
                    message(e);
                }finally {
                    textField1.setText("");
                    textField4.setText("");
                }

            }
        });
        anzeigeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int a = Integer.parseInt(textField2.getText());

                System.out.println("a == "+a);

              //  for(int i = 0 ;  i < konten.length ; i++){
                //    System.out.println(konten[i].toString());
                //}

                textArea1.append( konten[a].toString()+"\n");
                textField2.setText("");

            }
        });
        buchenB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int a = Integer.parseInt(textField2.getText());
                int betrag = Integer.parseInt(textField1.getText());

                try {
                    konten[a].buchen(betrag);
                    textArea1.append( konten[a].toString()+"\n");
                }catch (KontoException e){
                    message(e);
                }
                textField2.setText("");
                textField1.setText("");
            }
        });
        uberB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int betrag = Integer.parseInt(textField1.getText());
                int send = Integer.parseInt(textField2.getText());
                int empfang = Integer.parseInt(textField3.getText());

                try {
                    konten[send].buchen(betrag*-1);
                    try{
                        konten[empfang].buchen(betrag);
                    }catch (Exception eb){
                        konten[send].buchen(betrag);
                       message(eb);
                    }
                }catch (Exception e){
                    message(e);
                }

                textArea1.append( konten[send].toString()+"\n");
                textArea1.append( konten[empfang].toString()+"\n");



            }
        });





    }


    private void message(Exception e){
        JOptionPane.showMessageDialog(KonoverwaltungGUI.this,e.getMessage(),"UPSI!",JOptionPane.WARNING_MESSAGE);
    }

}
