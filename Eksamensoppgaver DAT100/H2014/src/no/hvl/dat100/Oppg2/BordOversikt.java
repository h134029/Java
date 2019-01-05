package no.hvl.dat100.Oppg2;

public class BordOversikt {

    private Bord[] bt;
    private int antall;

    public BordOversikt(int kapasitet) {
        bt = new Bord[kapasitet];
        int antall = 0;
    }
    public void leggTil(Bord b) {
        bt[antall] = b;
        antall++;
    }
    // a)
    public int antallLedige() {
        int antallLedig = 0;
        for (int i = 0; i < bt.length; i++) {
            antallLedig += (bt[i].isLedig()) ? 1 : 0;
        }
        return antallLedig;
    }
    // b)
    public int finnForsteLedige(int antall) {
        int index = -1;
        int i = 0;
        while (index < 0 && i < bt.length) {
            index = (bt[i].getAntall() >= antall && bt[i].isLedig()) ? i : index;
            i++;
        }
        return index;
    }
    // c)
    public int passerBest(int antall) {
        int index = 0;
        int[] diff = new int[bt.length];
        for (int i = 0; i < bt.length; i++) {
            diff[i] = bt[i].getAntall() - antall;
        }

        int min = antall;

        for (int i = 0; i < bt.length; i++) {
            if (diff[i] < min && diff[i] > 0) {
                min = diff[i];
                index = i;
            }
        }
        return index;
    }
}


