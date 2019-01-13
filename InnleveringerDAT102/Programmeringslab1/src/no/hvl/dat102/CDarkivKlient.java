package no.hvl.dat102;

import no.hvl.dat102.ADT.CDarkivADT;


public class CDarkivKlient {
    public static void main(String[] args) {

        CDarkiv cda = new CDarkiv();
        Meny meny = new Meny(cda);

        meny.start();
    }
}
