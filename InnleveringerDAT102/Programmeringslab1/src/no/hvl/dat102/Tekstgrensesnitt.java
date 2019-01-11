package no.hvl.dat102;

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

    }

}
