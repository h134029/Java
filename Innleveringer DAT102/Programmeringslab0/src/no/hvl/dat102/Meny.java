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
        setLayout(new FlowLayout());

        item1 = new JTextField(10);
        item1.setToolTipText("Legg til butikk");
        add(item1);

        item2 = new JTextField(10);
        add(item2);

        item3 = new JTextField(10);
        add(item3);

        JB1 = new JButton("Legg til butikk");
        add(JB1);
        JB2 = new JButton("Legg til varer");
        add(JB2);

        theHandler handler = new theHandler();

        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);

        JB1.addActionListener(handler);
        JB2.addActionListener(handler);

    }

    private class theHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String string = "";
            Butikk B = new Butikk();

            if (event.getSource() == item1) {
                B = new Butikk(item1.getText(), Integer.parseInt(item2.getText()));
                System.out.println("Butikk lagt inn: " + item1.getText());
            }
            else if (event.getSource() == JB2 && event.getSource() == item3) {
                B.leggInnNyVare(Integer.parseInt(item3.getText()));

            }
        }
    }



    public static void main(String[] args) {
        Meny test = new Meny();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(500,500);
        test.setVisible(true);
    }
}
