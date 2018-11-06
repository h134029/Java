package no.hvl.dat100.Oppg2;

public class Bord {
    public int antall;
    public boolean ledig;

    public Bord(int antall, boolean ledig) {
        this.antall = antall;
        this.ledig = ledig;
    }
    public Bord() {
        this(0,true);
    }
    public int getAntall() {
        return antall;
    }
    public boolean isLedig() {
        return ledig;
    }
    public void setAntall(int antall) {
        this.antall = antall;
    }
    public void setLedig(boolean ledig) {
        this.ledig = ledig;
    }
}
