package no.hvl.dat102;

import no.hvl.dat102.ADT.CDarkivADT;
import javax.swing.*;

public class Tekstgrensesnitt {

    public CD lesCD(){

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

        CD c = new CD(cdnr,artist,tittel,release,plateskp,sjanger);

        return c;
    }

    public void visCD(CD cd){
        System.out.println(cd.toString());
        System.out.println();
    }

    public void skrivUtCdDelstrengTittel(CDarkivADT cda, String delstreng){
        CD[] hold = cda.sokTittel(delstreng);

        for (CD cd:hold) {
            System.out.println(cd.toString());
        }
        System.out.println();
    }

    public void skrivUtCdDelstrengArtist(CDarkivADT cda, String delstreng) {
        CD[] hold = cda.sokArtist(delstreng);

        for (CD cd:hold) {
            System.out.println(cd.toString());
        }
        System.out.println();
    }

    public void skrivUtStatistikk(CDarkivADT cda){

        System.out.println("Antall CDER " + cda.antall());
        System.out.println("Antall Sjanger - ROCK: " + cda.antallSjanger(Sjanger.rock));
        System.out.println("Antall Sjanger - POP: " + cda.antallSjanger(Sjanger.pop));
        System.out.println("Antall Sjanger - OPERA: " + cda.antallSjanger(Sjanger.opera));
        System.out.println("Antall Sjanger - KLASSISK: " + cda.antallSjanger(Sjanger.klassisk));
        System.out.println();
        System.out.println("CDNR#ARTIST#TITTEL#RELEASE#LABEL#SJANGER");
        for (int i = 0; i < cda.antall(); i++) {
            System.out.println(cda.hentCdTabell()[i].toString());
        }
        System.out.println();
    }
}
