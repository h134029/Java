package no.hvl.dat100.Oppgave3_4;

public class Vare {
    private int varenr;
    private String navn;
    private double pris;

    // Kontruktør
    public Vare(int varenrInit, String navnInit, double prisInit) {
        varenr = varenrInit;
        navn = navnInit;
        pris = prisInit;
    }

    // Tom Kontruktør
    public Vare() {
    this(0,"",0);
    }

    // Set/Get
    public void setVarenr(int varenr) {
        this.varenr = varenr;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public void setPris(double pris) {
        this.pris = pris;
    }
    public int getVarenr() {
        return varenr;
    }
    public String getNavn() {
        return navn;
    }
    public double getPris() {
        return pris;
    }

    // Metoder
    public double moms() {
        double moms = pris * 0.2;
        return moms;
    }

    public boolean billigareEnn(Vare v) {
        return (pris < v.pris);
    }

    public String toString() {
        return "Varenummer: " + String.format("%1$-10s", varenr)  + "Navn: " + String.format("%1$-15s", navn) + "Pris: " + String.format("%1$-15s", pris);
    }
}
