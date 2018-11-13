package no.hvl.dat100.Oppgave4;

public class SnarestMulig extends Bestilling {
    private int maxtid;

    public SnarestMulig(int kontaktnummer, String kundenavn, String adresse, int maxtid) {
        super(kontaktnummer, kundenavn, adresse);
        this.maxtid = maxtid;
    }
    // Skriver ut alt på ein linje
    public void skrivUt() {
        super.skrivUt();
        System.out.print(", Maxtid: " + maxtid);
    }
}

