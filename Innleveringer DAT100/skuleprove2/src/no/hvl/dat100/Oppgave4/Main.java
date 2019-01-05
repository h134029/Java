package no.hvl.dat100.Oppgave4;

public class Main {
    public static void main(String[] args) {

        Bestilling B1 = new SnarestMulig(12345, "Olav", "Bjørneveien 1", 300);
        Bestilling B2 = new Tidspunkt(54321, "Bjørn", "Olaveien 2", "07.11", "20:00");

        B1.skrivUt();
        System.out.println();
        B2.skrivUt();
    }
}
