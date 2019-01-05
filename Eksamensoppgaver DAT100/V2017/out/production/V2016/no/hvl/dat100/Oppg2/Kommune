package no.hvl.dat100.Oppg2;

public class Kommune {
    private String navn;
    private double areal;
    private int folketall;

    public Kommune(String navn, double areal, int folketall) {
        this.navn = navn;
        this.areal = areal;
        this.folketall = folketall;
    }
    public Kommune() {
        this("",0,0);
    }
    // GET/SET
    public String getNavn() {return navn;}
    public double getAreal() {return areal;}
    public int getFolketall() {return folketall;}
    public void setNavn(String navn) {this.navn = navn;}
    public void setAreal(double areal) {this.areal = areal;}
    public void setFolketall(int folketall) {this.folketall = folketall;}

    @Override
    public String toString() {
        return navn + ", Folketall: " + folketall + ", Fastlandsareal: " + areal + " km2";
    }

    public double tetthet() {
        return folketall / areal;
    }
}
