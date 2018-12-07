package no.hvl.dat100.Oppg3;

public class BedriftsKunde extends Kunde {
    private int rabatt;

    public BedriftsKunde(String brukernavn, String passord, int kundenummer, int rabatt) {
        super(brukernavn, passord, kundenummer);
        this.rabatt = rabatt;
    }
    public double betal(double belop) {
        return (1-rabatt)*belop;
    }
}
