package no.hvl.dat100.Oppg2;

public class KSamling {
    private Kommune[] kTab;
    private int antall;

    public KSamling(int STD) {
        kTab = new Kommune[STD];
        antall = 0;
    }
    public boolean leggTil(Kommune k) {
        if (antall < kTab.length) {
            kTab[antall] = k;
            antall++;
            return true;
        } else {
            return false;
        }
    }
    public Kommune tettestBefolket() {
        if(kTab == null) {
            return null;
        } else {
            int tettest = 0;
            for (int i = 1; i < antall; i++) {
                tettest = (kTab[i].tetthet() > kTab[tettest].tetthet()) ? i : tettest;
            }
            return kTab[tettest];
        }
    }
}
