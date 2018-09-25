package no.hvl.dat100;

public class KlientKlassemetoder {
    public static void main(String[] args) {
        // eventuelt innlesing og sjekk på verdi

        // --------utskrift--------

        Klassemetoder.skrivStjerner(2);
        Klassemetoder.skrivStjerner(4);
        Klassemetoder.skrivStjerner(8);

        Klassemetoder.skrivTegn('c',5);

        double br = 2.0;
        double le = 3.0;
        double arealet = Klassemetoder.arealRektangel(br, le);
        System.out.println("Areal av rektangel er " + arealet);

        System.out.println(Klassemetoder.celciusTilfahrenheit(20));

        System.out.println(Klassemetoder.fakultet(4));

        System.out.println(Klassemetoder.min(8,4));

        System.out.println(Klassemetoder.min2(4, 6, 9));
    }
}
