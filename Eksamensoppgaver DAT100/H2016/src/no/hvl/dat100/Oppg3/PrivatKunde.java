package no.hvl.dat100.Oppg3;

public class PrivatKunde extends Kunde {
    private int avslag;
    private double grense;
    private double total;

    public PrivatKunde(String brukernavn, String passord, int kundenummer, int avslag, float grense, float total) {
        super(brukernavn, passord, kundenummer);
        this.avslag = avslag;
        this.grense = grense;
        this.total = total;
    }
    public double betal(double belop) {
        double betalingsBelop = 0;
        double nyTotal = total + belop;

        // Under grense
        if (total < grense) {
            // True/False om kunden akkurat kom over grensebelopet
            boolean nyRabatt = (nyTotal > grense);

            double overGrense = nyTotal-grense;
            double underGrense = belop - overGrense;

            betalingsBelop = (nyRabatt) ? (1-avslag)*overGrense + underGrense : belop;
            total = nyTotal;
        }
        // Over grense
        else {
            betalingsBelop = (1-avslag)*belop;
            total = nyTotal;
        }
        return betalingsBelop;

        //public BedriftsKunde tilBedriftsKunde (PrivatKunde pkunde) {
        //    BedriftsKunde kunde = new BedriftsKunde(pkunde.getBrukernavn(), pkunde.getPassord(), pkunde.getKundenummer(), 5);
        //    return kunde;
        //}

    }
}
