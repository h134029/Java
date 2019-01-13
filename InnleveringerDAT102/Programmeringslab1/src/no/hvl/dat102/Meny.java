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
    private JTextField artistNavn;
    private JTextField tittelNavn;
    private JTextField filskriv;
    private JButton artistSok;
    private JButton tittelSok;
    private JButton lesFil;
    private JButton skrivInfo;
    private JButton nyCD;
    private JButton skrivFil;
    private JLabel info;


    public Meny(CDarkivADT cda){
        super("Meny");
        setLayout(null);

        tekstgr = new Tekstgrensesnitt();
        this.cda = cda;

        filnavn = new JTextField();
        filnavn.setBounds(50,50,150,20);

        lesFil = new JButton("Les av fil");
        lesFil.setBounds(250,50,150,20);

        filskriv = new JTextField();
        filskriv.setBounds(50,100,150,20);

        skrivFil = new JButton("Skriv til fil");
        skrivFil.setBounds(250,100,150,20);

        nyCD = new JButton("Legg til ny CD");
        nyCD.setBounds(250,150,150,20);

        skrivInfo = new JButton("Skriv ut CD info");
        skrivInfo.setBounds(250,200,150,20);

        artistNavn = new JTextField();
        artistNavn.setBounds(50,250,150,20);

        artistSok = new JButton("Søk etter Artist");
        artistSok.setBounds(250,250,150,20);

        tittelNavn = new JTextField();
        tittelNavn.setBounds(50,300,150,20);

        tittelSok = new JButton("Søk etter Tittel");
        tittelSok.setBounds(250,300,150,20);

        info = new JLabel();
        info.setBounds(50,30,150,20);


        add(filnavn);
        add(filskriv);
        add(info);
        add(lesFil);
        add(skrivFil);
        add(nyCD);
        add(skrivInfo);
        add(artistNavn);
        add(artistSok);
        add(tittelNavn);
        add(tittelSok);


        theHandler handler = new theHandler();

        filnavn.addActionListener(handler);
        filskriv.addActionListener(handler);
        lesFil.addActionListener(handler);
        skrivFil.addActionListener(handler);
        nyCD.addActionListener(handler);
        skrivInfo.addActionListener(handler);
        artistSok.addActionListener(handler);
        artistNavn.addActionListener(handler);
        tittelSok.addActionListener(handler);
        tittelNavn.addActionListener(handler);

        setVisible(true);

    }
    private class theHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Read File
            if (event.getSource() == lesFil) {
                cda = Fil.lesFraFil(filnavn.getText());
                info.setText("Lastet inn: " + filnavn.getText());
                filnavn.setText(null);
            }
            // Write Info
            else if (event.getSource() == skrivInfo) {
                tekstgr.skrivUtStatistikk(cda);
            }
            // Add new CD
            else if (event.getSource() == nyCD) {

                CD c = tekstgr.lesCD();
                cda.leggTilCd(c);
                System.out.print("CD Lagt til: ");
                tekstgr.visCD(c);
            }
            // Write File
            else if (event.getSource() == skrivFil) {
                Fil.skrivTilFil(cda,filskriv.getText());
                System.out.println("Skrevet til filen: " + filskriv.getText());
                System.out.println();
                filskriv.setText(null);

            }
            // Search Artist
            else if (event.getSource() == artistSok) {
                System.out.println("Søk i Artist: \"" + artistNavn.getText() + "\"");
                tekstgr.skrivUtCdDelstrengArtist(cda,artistNavn.getText());
                artistNavn.setText(null);
            }
            //Search Title
            else if (event.getSource() == tittelSok) {
                System.out.println("Søk i Tittel: \"" + tittelNavn.getText() + "\"");
                tekstgr.skrivUtCdDelstrengTittel(cda,tittelNavn.getText());
                tittelNavn.setText(null);
            }
        }
    }
    public void start() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

    }
}