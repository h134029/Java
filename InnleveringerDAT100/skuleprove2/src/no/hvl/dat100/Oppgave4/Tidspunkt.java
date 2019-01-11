package no.hvl.dat100.Oppgave4;

public class Tidspunkt extends Bestilling {
    private String dato;
    private String tidspunkt;

    public Tidspunkt(int kontaktnummer, String kundenavn, String adresse, String dato, String tidspunkt) {
        super(kontaktnummer, kundenavn, adresse);
        this.dato = dato;
        this.tidspunkt = tidspunkt;
    }
    // Skriver ut alt på ein linje
    public void skrivUt() {
        super.skrivUt();
        System.out.print(", Dato: " + dato + ", Tidspunkt: " + tidspunkt);
    }
}

