package no.hvl.dat102.OPPG3;


public class CDarkiv2Klient {
    public static void main(String[] args) {

        CDarkiv2 cda = new CDarkiv2();
        Meny meny = new Meny(cda);

        meny.start();
    }
}
