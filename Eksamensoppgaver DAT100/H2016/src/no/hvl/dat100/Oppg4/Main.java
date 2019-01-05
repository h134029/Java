package no.hvl.dat100.Oppg4;

public class Main {
    public static void main(String[] args) {

        Venteliste V = new Venteliste(10);
        Pasient P1 = new Pasient("Olav", "12345");
        V.leggTil(P1);
        V.oppdaterDager(10);
        Pasient P2 = new Pasient("Espen", "23456");
        V.leggTil(P2);

        V.skrivUt();
        Pasient P3 = V.ventetLengst();
        System.out.println(P3.toString());
    }
}