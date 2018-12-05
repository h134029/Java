package no.hvl.dat100.Oppg2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Innlegg I1 = new Innlegg("Eksamen suger");
        I1.tag("Olav");
        I1.tag("Maria");

        String[] venner = {"Olav", "Maria"};

        ArrayList<String> test = I1.vennerTagget(venner);
        System.out.println(test.contains("Per"));
        System.out.println(test.contains("Olav"));
        System.out.println(test.contains("Maria"));

        System.out.println();
        I1.skrivUt();
    }
}
