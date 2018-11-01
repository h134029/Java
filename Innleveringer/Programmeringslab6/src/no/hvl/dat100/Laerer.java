package no.hvl.dat100;

public class Laerer extends Person {
    private int manadslonn;
    private int kontonummer;

    public Laerer(int manadslonn, int kontonummer, String etternavn, String fornavn, long foedselsnummer) {
        super(etternavn, fornavn, foedselsnummer);
        this.manadslonn = manadslonn;
        this.kontonummer = kontonummer;
    }
    public Laerer() { this(0,0,"","",0); }
    // Get/Set
    public int getManadslonn() { return manadslonn; }
    public int getKontonummer() { return kontonummer; }

    public void setManadslonn(int manadslonn) { this.manadslonn = manadslonn; }
    public void setKontonummer(int kontonummer) { this.kontonummer = kontonummer; }

    // Returnerer all object informasjon som String
    public String toString() {
        return "LAERER" + "\n" + super.toString() + manadslonn + "\n" + kontonummer + "\n";
    }
}
