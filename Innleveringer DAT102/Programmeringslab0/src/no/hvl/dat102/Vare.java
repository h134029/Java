package no.hvl.dat102;

import javax.swing.*;

public class Vare {
    private int varenr;
    private String navn;
    private double pris;

    public Vare(int varenrInit, String navnInit, double prisInit) {
        varenr = varenrInit;
        navn = navnInit;
        pris = prisInit;
    }
    public Vare(int varenr) {
        this(varenr,"",0.00);
    }
    public Vare() {
        this(0,"",0.00);
    }
    //GET/SET
    public double getPris() {
        return pris;
    }

    public int getVarenr() {
        return varenr;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public void setPris(double pris) {
        this.pris = pris;
    }
    public void setVarenr(int varenr) {
        this.varenr = varenr;
    }

    public void lesVare(int varenr) {
        if (this.varenr == 0) this.varenr = varenr;
        if (this.navn.length() == 0) this.navn = JOptionPane.showInputDialog("Tildel varenavn");
        if (this.pris == 0.00) {
            double p;
            do {
                p = Double.parseDouble(JOptionPane.showInputDialog(null, "Tildel pris (Må vere eit positivt tall)"));
            } while (p <= 0);
            this.pris = p;
        }
    }
}
