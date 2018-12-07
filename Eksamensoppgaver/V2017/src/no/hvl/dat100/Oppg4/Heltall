package no.hvl.dat100.Oppg4;

public class Heltall extends Oppgave {
    private int korrekt;
    private int feilmargin;

    public Heltall(String sp, int p, int korr, int feil) {
        super(sp, p);
        this.korrekt = korr;
        this.feilmargin = feil;
    }
    public double poeng(int svar) {
        if (svar == korrekt) {return getMaksPoeng();}
        else if (Math.abs(korrekt-svar) <= feilmargin) {return getMaksPoeng()*0.5;}
        else {return 0;}
    }
}
