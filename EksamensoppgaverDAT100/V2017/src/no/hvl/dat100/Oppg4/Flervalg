package no.hvl.dat100.Oppg4;

public class Flervalg extends Oppgave {
    private String[] alternativ;
    private int korrekt;

    public Flervalg(String sp, int p, String[] alt, int korr) {
        super(sp, p);
        this.alternativ = alt;
        this.korrekt = korr;
    }
    public double poeng(int svar) {
        return (alternativ[svar] == alternativ[korrekt]) ? getMaksPoeng() : 0;
    }
}
