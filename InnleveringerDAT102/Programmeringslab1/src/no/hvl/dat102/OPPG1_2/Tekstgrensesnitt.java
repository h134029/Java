package no.hvl.dat102.OPPG1_2;

import no.hvl.dat102.OPPG3.ADT.CDarkivADT;

import javax.swing.*;

public class Tekstgrensesnitt {

    public CD lesCD(){

        int cdnr = Integer.parseInt(JOptionPane.showInputDialog("CD Number: "));
        String artist = JOptionPane.showInputDialog("Artist: ");
        String tittel = JOptionPane.showInputDialog("Title: ");
        int release = Integer.parseInt(JOptionPane.showInputDialog("Release year: "));
        String plateskp = JOptionPane.showInputDialog("Record Company: ");
        Sjanger sjanger = null;

        Sjanger[] options = {Sjanger.rock, Sjanger.pop, Sjanger.klassisk, Sjanger.opera};
        int x = JOptionPane.showOptionDialog(null, "Pick genre: ",
                "Click!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options);

        if (x == 0) sjanger = Sjanger.rock;
        else if (x == 1) sjanger = Sjanger.pop;
        else if (x == 2) sjanger = Sjanger.klassisk;
        else if (x == 3) sjanger = Sjanger.klassisk;

        CD c = new CD(cdnr,artist,tittel,release,plateskp,sjanger);

        return c;
    }

    public void visCD(CD cd){
        System.out.println(cd.toString());
        System.out.println();
    }

    public void skrivUtCdDelstrengTittel(CDarkivADT cda, String delstreng) {
        CD[] hold = cda.sokTittel(delstreng);

        for (int i = 0; i < hold.length && hold[i] != null; i++) {
            System.out.println(hold[i].toString());
        }
        System.out.println();
    }

    public void skrivUtCdDelstrengArtist(CDarkivADT cda, String delstreng) {
        CD[] hold = cda.sokArtist(delstreng);

        for (int i = 0; i < hold.length && hold[i] != null;i++) {
            System.out.println(hold[i].toString());
        }
        System.out.println();
    }

    public void skrivUtStatistikk(CDarkivADT cda){

        System.out.println("CDs: " + cda.antall());
        System.out.println("Genre - ROCK: " + cda.antallSjanger(Sjanger.rock));
        System.out.println("Genre - POP: " + cda.antallSjanger(Sjanger.pop));
        System.out.println("Genre - OPERA: " + cda.antallSjanger(Sjanger.opera));
        System.out.println("Genre - KLASSISK: " + cda.antallSjanger(Sjanger.klassisk));
        System.out.println();
        System.out.println("CDNR#ARTIST#TITLE#RELEASE#LABEL#GENRE");
        for (int i = 0; i < cda.antall(); i++) {
            System.out.println(cda.hentCdTabell()[i].toString());
        }
        System.out.println();
    }
}
