package no.hvl.dat102.OPPG2.MODELL;

public class Datakontakt {
    private static int STDK = 100;
    private Medlem[] medlemstabell;
    private int antall;

    public Datakontakt() {
        this(STDK);
    }
    public Datakontakt(int storrelse) {
        this.antall = 0;
        this.medlemstabell = new Medlem[storrelse];
    }

    //GET/SET
    public static int getSTDK() {
        return STDK;
    }
    public int getAntall() {
        return antall;
    }
    public Medlem[] getMedlemstabell() {
        return medlemstabell;
    }
    public static void setSTDK(int STDK) {
        Datakontakt.STDK = STDK;
    }
    public void setMedlemstabell(Medlem[] medlemstabell) {
        this.medlemstabell = medlemstabell;
    }
    public void setAntall(int antall) {
        this.antall = antall;
    }

    public void leggTilMedlem(Medlem person) {
        if (antall == medlemstabell.length) {utvid();}
        medlemstabell[antall] = person;
        antall++;
    }
    public void utvid() {
        Medlem[] hold = new Medlem[(int)Math.ceil(2 * medlemstabell.length)];
        for (int i = 0; i < medlemstabell.length; i++) {
            hold[i] = medlemstabell[i];
        }
        medlemstabell = hold;
    }
    public int finnMedlemsIndeks(String medlemsnavn) {
        int index = -1;
        for (int i = 0; i < medlemstabell.length; i++) {
            if (medlemsnavn.equals(medlemstabell[i].getNavn())) {
                index = i;
            }
        }
        return index;
    }
    public int finnPartnerFor(String medlemsnavn) {
        int medlemsIndex = finnMedlemsIndeks(medlemsnavn);
        int matchIndex = -1;

        for (int i = 0; i < medlemstabell.length; i++) {
            if (medlemstabell[medlemsIndex].passerTil(medlemstabell[i])) {
                matchIndex = i;
                medlemstabell[medlemsIndex].setStatusIndeks(matchIndex);
                medlemstabell[matchIndex].setStatusIndeks(medlemsIndex);
            }
        }
        return matchIndex;
    }
    public void tilbakestillStatusIndex(String medlemsnavn) {
        int medlemsIndex = finnMedlemsIndeks(medlemsnavn);
        int matchIndex = finnPartnerFor(medlemsnavn);

        if (matchIndex > -1 && medlemsIndex > -1) {
            medlemstabell[medlemsIndex].setStatusIndeks(-1);
            medlemstabell[matchIndex].setStatusIndeks(-1);
        }
    }

}
