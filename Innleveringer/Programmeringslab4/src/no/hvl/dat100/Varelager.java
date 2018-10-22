package no.hvl.dat100;

public class Varelager {
    private final static int STDK = 100;
    private int antall;
    public Vare[] samling;

    //Kontruktør
    public Varelager(int startKapasitet) {
        samling = new Vare[startKapasitet];
        antall = 0;
    }
    public Varelager() {
        this(STDK);
    }
    public Vare[] getVare() {
        return samling;
    }
    public int getAntall() {
        return antall;
    }
    public boolean erTom() {
        return (antall == 0);
    }

    // Metoder
    public void leggTil(Vare v) {
        if (antall < samling.length) {
            samling[antall] = v;
            antall++;
        } else {
            System.out.println("Lageret er fullt");
        }
    }

    public boolean soekVare(int vareNr) {
        Boolean funnet = false;
        int i = 0;
        while (!funnet && i < antall && !erTom()) {
            funnet = (samling[i++].getVarenr() == vareNr);
        }
        return funnet;
    }

    public int[] finnVare(int vareNr) {
        // Finner antall varer
        int counter = 0;
        int i = 0;
        while (i < antall && !erTom()) {
            if (samling[i].getVarenr() == vareNr) {
                counter += 1;
            }
            i++;
        }
        int j = 0;
        int k = 0;
        int[] indexVare = new int[counter];

        // Lager ein index tabell der varene er
        while (j < antall && !erTom()) {
            if(samling[j].getVarenr() == vareNr) {
                indexVare[k] = j;
                k++;
            }
            j++;
        }
        return indexVare;
    }

    public double totalPris() {
        double totpris = 0;
        int i = 0;
        while (i < antall && !erTom()) {
            totpris += samling[i++].getPris();
        }
        return totpris;
    }
    public Vare slett(int vareNr) {

        // Finner index til varer som skal slettes
        int[] index = finnVare(vareNr);

        // Alle valgte objekter blir satt til null
        for (int i = 0; i < index.length; i++) {
            int j = index[i];
            samling[j] = null;
            antall--;
        }
        // Flytter stegvis alle null verdier bakover
        for (int j = 0; j < samling.length; j++) {
            if (samling[j]==null) {
                for (int k = j+1; k < samling.length; k++) {
                    samling[k-1] = samling[k];
                }
                samling[samling.length-1] = null;
            }
        }
        return null;
    }
}
