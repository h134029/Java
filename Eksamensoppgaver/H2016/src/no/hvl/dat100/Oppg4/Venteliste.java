package no.hvl.dat100.Oppg4;

public class Venteliste {
    private Pasient[] samling;
    private int antall;

    public Venteliste(int STD) {
        samling = new Pasient[STD];
        antall = 0;
    }
    public void skrivUt() {
        for (int i = 0; i < antall; i++) {
            System.out.println(samling[i].toString());
        }
    }
    public void oppdaterDager(int dager) {
        int d = 0;
        for (int i = 0; i < antall; i++) {
            d = samling[i].getDager() + dager;
            samling[i].setDager(d);
        }
    }
    public boolean leggTil(Pasient pasient) {
        boolean duplikat = false;
        boolean plass = (samling.length >= antall);

        int i = 0;

            while (!duplikat && i < antall) {
                duplikat = (samling[i].getFodselsnummer() == pasient.getFodselsnummer());
                i++;
            }


        if (!duplikat && plass) {
            samling[antall] = pasient;
            antall++;
        }
        return !duplikat && plass;
    }
    public Pasient ventetLengst() {
        int lengst = 0;
        Pasient pasient = null;

        for (int i = 0; i < antall; i++) {
            lengst = (samling[i].getDager() > lengst) ? samling[i].getDager() : lengst;
            if (samling[i].getDager() >= lengst) pasient = samling[i];
        }
        return pasient;
    }
}
