package no.hvl.dat100.Oppgave3_4;

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
            funnet = (samling[i].getVarenr() == vareNr);
            i++;
        }
        return funnet;
    }
    public Vare sok(int vareNr) {
        Vare resultat = null;
        int index = finnVare(vareNr);
        if (index == -1) {
            resultat = null;
        } else {
            resultat = samling[index];
        }
        return resultat;
    }

    // Finner index verdier til varene
    public int finnVare(int vareNr) {
        // Finner antall varer

        int indexVare = -1;
        int j = 0;
        // Lager ein index verdi der varen er
        while (j < antall && !erTom()) {
            if (samling[j].getVarenr() == vareNr) {
                indexVare = j;
                break;
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
    public Vare slett(int vareNr) {
        int index = finnVare(vareNr);
        Vare vare = null;
        if (index != -1) {
            vare = samling[index];
            samling[index] = samling[antall-1];
            samling[antall-1] = null;
            antall--;
        }
        return vare;
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

