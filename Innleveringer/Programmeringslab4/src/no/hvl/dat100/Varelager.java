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
    // Legg til vare
    public void leggTil(Vare v) {
        if (antall < samling.length) {
            samling[antall] = v;
            antall++;
        } else {
            System.out.println("Lageret er fullt");
        }
    }

    // Søk om vare eksisterer true/false
    public boolean soekVare(int vareNr) {
        Boolean funnet = false;
        int i = 0;
        while (!funnet && i < antall && !erTom()) {
            funnet = (samling[i++].getVarenr() == vareNr);
        }
        return funnet;
    }

    // Finner index verdier til varene
    public int[] finnVare(int vareNr) {
        // Finner antall varer
        int counter = 0;
        int i = 0;
        while (i < antall && !erTom()) {
            if (samling[i].getVarenr() == vareNr) {
                counter++;
            }
            i++;
        }
        int j = 0;
        int k = 0;
        int[] indexVare = new int[counter];

        // Lager ein index tabell der varene er
        while (j < antall && !erTom()) {
            if (samling[j].getVarenr() == vareNr) {
                indexVare[k] = j;
                k++;
            }
            j++;
        }
        return indexVare;
    }

    // Totalpris i lageret
    public double totalPris() {
        double totpris = 0;
        int i = 0;
        while (i < antall && !erTom()) {
            totpris += samling[i++].getPris();
        }
        return round(totpris, 2);
    }

    // Sletter varer med gitt varenummer
    public void slett(int vareNr) {

        // Finner index til varer som skal slettes
        int[] index = finnVare(vareNr);

        // Alle valgte objekter blir satt til null
        for (int i = 0; i < index.length; i++) {
            int j = index[i];
            samling[j] = null;
            antall--;
        }
        // Flytter stegvis alle null verdier bakover
        int j = 0;
        int counter = 0;

        while (counter < antall) {
            int k = 1;
            boolean notnull = false;
            if (samling[j] == null) {
                while (!notnull) {
                    samling[j] = samling[k];
                    notnull = (samling[j]!=null);
                    if (samling[j]!=null) {samling[k] = null; counter++;}
                    k++;
                }
            }
            j++;
        }
    }

    // Diverse metoder
    // Runder av til gitt desimalplass
    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    // Printer lageret
    public void lagerPrint() {
        System.out.println();
        System.out.println("Varer i lageret:");
        System.out.println("______________________________________________________");
        for (int i = 0; i < antall; i++) {
            System.out.println(samling[i].toString());
        }
    }
}

