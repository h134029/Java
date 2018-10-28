package no.hvl.dat100.oppgave3;

public class Laerer extends Person {
    private int manadslonn;
    private int kontonummer;

    public Laerer(int manadslonn, int kontonummer, String etternavn, String fornavn, int foedselsaar, char kjoenn) {
        super(etternavn, fornavn, foedselsaar, kjoenn);
        this.manadslonn = manadslonn;
        this.kontonummer = kontonummer;
    }
    // Get/Set
    public int getManadslonn() { return manadslonn; }
    public int getKontonummer() { return kontonummer; }

    public void setManadslonn(int manadslonn) { this.manadslonn = manadslonn; }
    public void setKontonummer(int kontonummer) { this.kontonummer = kontonummer; }

    // Returnerer all object informasjon som String
    public String toString() {
        return super.toString() + ", Månedslønn: " + manadslonn + ", Kontonummer: " + kontonummer;
    }
}
