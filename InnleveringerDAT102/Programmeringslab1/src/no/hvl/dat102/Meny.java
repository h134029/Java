package no.hvl.dat102;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ActiveEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.awt.GridLayout;

public class Meny extends JFrame {

    private Tekstgrensesnitt tekstgr;
    private CDarkivADT cda;

    private JTextField filnavn;
    private JTextField test;
    private JButton JB1;
    private JButton JB2;


    public Meny(CDarkivADT cda){
        super("Meny");
        setLayout(null);

        tekstgr = new Tekstgrensesnitt();
        this.cda = cda;

        filnavn = new JTextField();
        filnavn.setBounds(50,50,100,20);

        JB1 = new JButton("Les av fil");
        JB1.setBounds(250,50,150,20);

        JB2 = new JButton("Skriv ut CD info");
        JB2.setBounds(250,100,150,20);

        test = new JTextField(20);
        test.setBounds(200,100,100,20);


        add(filnavn);
        add(JB1);
        add(JB2);

        theHandler handler = new theHandler();

        filnavn.addActionListener(handler);
        JB1.addActionListener(handler);
        JB2.addActionListener(handler);

        setVisible(true);

    }
    private class theHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == JB1) {
                cda = Fil.lesFraFil(filnavn.getText());

            }else if (event.getSource() == JB2) {
                tekstgr.skrivUtStatistikk(cda);
            }
        }
    }
    public void start() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,200);

    }
}