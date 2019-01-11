package no.hvl.dat100.Oppg2;

public class Flyavganger {
    private Flyavgang[] tab;

    public Flyavganger(int STD) {
        tab = new Flyavgang[STD];
    }
    public boolean erNull(int p) {
        return (tab[p] == null);
    }
    public int antall() {
        int checksum = 0;

        for (Flyavgang f: tab) {
            checksum += (f != null) ? 1 : 0;
        }
        return checksum;
    }
    public void visinfo() {
        for (int i = 0; i < tab.length; i++) {
            if (!erNull(i)) {
                System.out.print(tab[i].toString());
            }
        }
    }
    public boolean setStatus(int nummer, char status) {
        boolean funnet = false;
        int i = 0;

        while (!funnet && i < tab.length) {
            if (!erNull(i) && tab[i].getNummer() == nummer) {
                tab[i].setStatus(status);
                funnet = true;
            }
            i++;
        }
        return funnet;
    }
    public boolean settinn(Flyavgang flyavgang) {
        boolean sattInn = false;
        int i = 0;

        while (!sattInn && i < tab.length) {
            if (erNull(i)) {
                tab[i] = flyavgang;
                sattInn = true;
            }
            i++;
        }
        return sattInn;
    }
    public boolean slett(int nummer) {
        boolean funnet = false;
        int i = 0;

        while(!funnet && i < tab.length) {
            if (!erNull(i) && tab[i].getNummer() == nummer) {
                tab[i] = null;
                funnet = true;
            }
            i++;
        }
        return funnet;
    }
}

