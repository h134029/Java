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

public class Meny extends JFrame{

    private JTextField item1;
    private JTextField item2;
    private JTextField item3;
    private JButton JB1;
    private JButton JB2;


    public Meny() {
        super("The title bar");
        setLayout(null);

        item1 = new JTextField();
        item1.setBounds(50,50,100,20);
        add(item1);

        item2 = new JTextField();
        item2.setBounds(200,50,100,20);
        add(item2);

        item3 = new JTextField();
        item3.setBounds(200,100,100,20);
        add(item3);

        JB1 = new JButton("Legg til butikk");
        JB1.setBounds(350,50,150,20);
        add(JB1);
        JB2 = new JButton("Legg til varer");
        JB2.setBounds(350,100,150,20);
        add(JB2);

        theHandler handler = new theHandler();

        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);

        JB1.addActionListener(handler);
        JB2.addActionListener(handler);

    }

    private class theHandler implements ActionListener {

        Butikk[] btab = new Butikk[50];

        public void actionPerformed(ActionEvent event) {


            if (event.getSource() == JB1) {
                int i = 0;
                btab[i] = new Butikk(item1.getText(), Integer.parseInt(item2.getText()));
                System.out.println("Butikk lagt inn: " + item1.getText());
                i++;

            }
            if (event.getSource() == JB2) {
                btab[0].leggInnNyVare(Integer.parseInt(item3.getText()));

            }
            btab[0].salgsVerdi();
        }
    }


    public static void main(String[] args) {
        Meny test = new Meny();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(600,500);
        test.setVisible(true);
    }
}
