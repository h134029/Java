package no.hvl.dat102.OPPG3;

import no.hvl.dat102.OPPG3.ADT.CDarkivADT;
import no.hvl.dat102.OPPG1_2.CD;
import no.hvl.dat102.OPPG1_2.Tekstgrensesnitt;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton slettCD;
    private JButton skrivFil;
    private JLabel info;


    public Meny(CDarkivADT cda){
        super("Menu");
        setLayout(null);
        theHandler handler = new theHandler();
        tekstgr = new Tekstgrensesnitt();

        filnavn = new JTextField();
        filnavn.setBounds(50,50,150,20);
        add(filnavn);
        filnavn.addActionListener(handler);

        filskriv = new JTextField();
        filskriv.setBounds(50,100,150,20);
        add(filskriv);
        filskriv.addActionListener(handler);

        artistNavn = new JTextField();
        artistNavn.setBounds(50,300,150,20);
        add(artistNavn);
        artistNavn.addActionListener(handler);

        tittelNavn = new JTextField();
        tittelNavn.setBounds(50,350,150,20);
        add(tittelNavn);
        tittelNavn.addActionListener(handler);

        lesFil = new JButton("Read from file");
        lesFil.setBounds(250,50,150,20);
        add(lesFil);
        lesFil.addActionListener(handler);

        skrivFil = new JButton("Print to file");
        skrivFil.setBounds(250,100,150,20);
        add(skrivFil);
        skrivFil.addActionListener(handler);

        nyCD = new JButton("Add new CD");
        nyCD.setBounds(250,150,150,20);
        add(nyCD);
        nyCD.addActionListener(handler);

        slettCD = new JButton("Delete CD");
        slettCD.setBounds(250, 200, 150,20);
        add(slettCD);
        slettCD.addActionListener(handler);

        skrivInfo = new JButton("Print CD table info");
        skrivInfo.setBounds(250,250,150,20);
        add(skrivInfo);
        skrivInfo.addActionListener(handler);

        artistSok = new JButton("Search for artist");
        artistSok.setBounds(250,300,150,20);
        add(artistSok);
        artistSok.addActionListener(handler);

        tittelSok = new JButton("Search for title");
        tittelSok.setBounds(250,350,150,20);
        add(tittelSok);
        tittelSok.addActionListener(handler);

        info = new JLabel();
        info.setBounds(50,30,150,20);
        add(info);

        setVisible(true);

    }
    private class theHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Read File
            if (event.getSource() == lesFil) {
                cda = Fil.lesFraFil(filnavn.getText());
                info.setText("Loaded: " + filnavn.getText());
                filnavn.setText(null);
            }
            // Write Info
            else if (event.getSource() == skrivInfo) {
                tekstgr.skrivUtStatistikk(cda);
            }
            // Add new CD
            else if (event.getSource() == nyCD) {
                try {
                    CD c = tekstgr.lesCD();
                    boolean lagtTil = cda.leggTilCd(c);
                    if (lagtTil) {
                        System.out.print("CD added: ");
                        tekstgr.visCD(c);
                    }else {
                        System.out.println("ERROR: Duplicate CD Number");
                        System.out.println();
                    }
                }catch(NumberFormatException e) {
                    System.out.println("Abort");
                }
            }
            // Write File
            else if (event.getSource() == skrivFil) {
                Fil.skrivTilFil(cda,filskriv.getText());
                System.out.println();
                filskriv.setText(null);

            }
            // Search Artist
            else if (event.getSource() == artistSok) {
                System.out.println("Search for artist: \"" + artistNavn.getText() + "\"");
                tekstgr.skrivUtCdDelstrengArtist(cda,artistNavn.getText());
                artistNavn.setText(null);
            }
            // Search Title
            else if (event.getSource() == tittelSok) {
                System.out.println("Search for title: \"" + tittelNavn.getText() + "\"");
                tekstgr.skrivUtCdDelstrengTittel(cda,tittelNavn.getText());
                tittelNavn.setText(null);
            }
            // Delete file
            else if (event.getSource() == slettCD) {
                try {
                    int cdnr = Integer.parseInt(JOptionPane.showInputDialog("CD Number: "));
                    boolean slettet = cda.slettCd(cdnr);
                    if (!slettet) {
                        System.out.println("CD Not found");
                        System.out.println();
                    }

                }catch (NumberFormatException e) {
                    System.out.println("Abort delete");
                    System.out.println();
                }
            }
        }
    }
    public void start() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,450);
    }
}