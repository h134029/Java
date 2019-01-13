package no.hvl.dat102;

import no.hvl.dat102.ADT.CDarkivADT;

public class Tekstgrensesnitt {

    public CD lesCD(){
        return null;
    }

    public void visCD(CD cd){
        System.out.println(cd.toString());
    }

    public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng){
        CD[] hold = cda.sokTittel(delstreng);

        for (CD cd:hold) {
            System.out.println(cd.toString());
        }
    }

    public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
        CD[] hold = cda.sokArtist(delstreng);

        for (CD cd:hold) {
            System.out.println(cd.toString());
        }
    }

    public void skrivUtStatistikk(CDarkivADT cda){
        CD[] hold = cda.hentCdTabell();

        System.out.println("Antall Sanger: " + cda.antall());
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
