package no.hvl.dat100.Oppg2temp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Sang s1 = new Sang("Hey ya", 4, Sjanger.ROCK);
        Sang s2 = new Sang("Slim Shady", 4, Sjanger.ANNET);
        Sang s3 = new Sang("Who Let The Dogs Out", 5, Sjanger.ANNET);
        Sang s4 = new Sang("I'm a Barby Girl", 3, Sjanger.POP);

        SpilleListe SL1 = new SpilleListe();
        SL1.leggTil(s1);
        SL1.leggTil(s2);
        SL1.leggTil(s3);
        SL1.leggTil(s4);

        SL1.visListe();
        System.out.println();

        ArrayList annet = SL1.finnSanger(Sjanger.ANNET);
        System.out.println("Sanger med sjanger: " + Sjanger.ANNET);
        System.out.println(annet);
    }
}
