package no.hvl.dat102;

public class CDarkivKlient {
    public static void main(String[] args) {

        CDarkiv cda = new CDarkiv();
        Meny meny = new Meny(cda);

        meny.start();
    }
}
