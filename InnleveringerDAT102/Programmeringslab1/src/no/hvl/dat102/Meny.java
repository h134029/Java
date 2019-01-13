package no.hvl.dat102;

import no.hvl.dat102.ADT.CDarkivADT;
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

import static javax.swing.JOptionPane.showInputDialog;

public class Meny extends JFrame {

    private Tekstgrensesnitt tekstgr;
    private CDarkivADT cda;

    private JTextField filnavn;
    private JLabel test;
    private JButton lesFil;
    private JButton skrivInfo;
    private JButton nyCD;
    private JButton skrivFil;


    public Meny(CDarkivADT cda){
        super("Meny");
        setLayout(null);

        tekstgr = new Tekstgrensesnitt();
        this.cda = cda;

        filnavn = new JTextField();
        filnavn.setBounds(50,50,100,20);

        lesFil = new JButton("Les av fil");
        lesFil.setBounds(250,50,150,20);

        skrivFil = new JButton("Skriv til fil");
        skrivFil.setBounds(250,100,150,20);

        nyCD = new JButton("Legg til ny CD");
        nyCD.setBounds(250,150,150,20);

        skrivInfo = new JButton("Skriv ut CD info");
        skrivInfo.setBounds(250,200,150,20);



        test = new JLabel();
        test.setBounds(50,100,100,20);


        add(filnavn);
        add(test);
        add(lesFil);
        add(skrivFil);
        add(nyCD);
        add(skrivInfo);

        theHandler handler = new theHandler();

        filnavn.addActionListener(handler);
        lesFil.addActionListener(handler);
        skrivFil.addActionListener(handler);
        nyCD.addActionListener(handler);
        skrivInfo.addActionListener(handler);

        setVisible(true);

    }
    private class theHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == lesFil) {
                cda = Fil.lesFraFil(filnavn.getText());
                test.setText(filnavn.getText());

            }else if (event.getSource() == skrivInfo) {
                tekstgr.skrivUtStatistikk(cda);

            }else if (event.getSource() == nyCD) {

                int cdnr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn CD nummer: "));
                String artist = JOptionPane.showInputDialog("Skriv inn Artist: ");
                String tittel = JOptionPane.showInputDialog("Skriv inn Tittel: ");
                int release = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn Release år "));
                String plateskp = JOptionPane.showInputDialog("Skriv inn Plateselskap: ");
                Sjanger sjanger = null;

                Sjanger[] options = {Sjanger.rock, Sjanger.pop, Sjanger.klassisk, Sjanger.opera};
                int x = JOptionPane.showOptionDialog(null, "Velg Sjanger",
                        "Klikk!",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options);

                if (x == 0) sjanger = Sjanger.rock;
                else if (x == 1) sjanger = Sjanger.pop;
                else if (x == 2) sjanger = Sjanger.klassisk;
                else if (x == 3) sjanger = Sjanger.klassisk;

                cda.leggTilCd(new CD(cdnr,artist,tittel,release,plateskp,sjanger));
            }
            else if (event.getSource() == skrivFil) {
                Fil.skrivTilFil(cda,filnavn.getText());
            }
        }
    }
    public void start() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);

    }
}