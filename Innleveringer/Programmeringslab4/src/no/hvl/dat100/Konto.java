package no.hvl.dat100;

public class Konto {
    private String kontoNr;
    private double saldo;

    public Konto(String kontoNrInit, double saldoInit) {
        kontoNr = kontoNrInit;
        saldo = saldoInit;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setInnPenger(double innskudd) {
        this.saldo += innskudd;
    }
    public void taUtPenger(double uttak) {
        this.saldo -= uttak;
    }
}
