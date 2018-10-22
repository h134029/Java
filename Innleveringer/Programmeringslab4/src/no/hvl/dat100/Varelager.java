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
        int i = 0;
        int j = 0;
        int[] indexVare = new int[antall];
        while (i < antall && !erTom()) {
            if(samling[i].getVarenr() == vareNr) {
                indexVare[j++] = i;
            }
            i++;
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

        // Alle med slett vareNr = null
        int index[] = finnVare(vareNr);
        for (int i = 0; i < index.length; i++) {
            samling[index[i]] = null;
            antall--;
        }
        int j = 0;
        int counter = 0;
        int seeker = 1;
        // insert next value j+seeker if null
        while (counter < samling.length) {
            if (samling[j]==null) {
                samling[j] = samling[j+seeker];
                if (samling[j]!=null) {
                    samling[j+seeker] = null;
                    j++;
                    seeker = 0;
                }
                seeker += 1;
            } else {
                j++;
            }
            counter++;

        }
        return null;
    }
}
