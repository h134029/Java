package no.hvl.dat100.Oppgave5;

import java.util.Random;

// Object terning som inneholder init verdi terningkast
public class Terning {
    private int[] antall = new int[7];
    private int kast;
    private int[] kastTabell;
    private final int ANTALL = 20;

    public Terning(int kastinit) {
        kast = kastinit;
        kastTabell = new int[kast];
        Random terning = new Random();
        for (int i = 0; i < kast; i++) {
            kastTabell[i] = terning.nextInt(6) + 1;
            antall[kastTabell[i]]++;
        }
    }
    // Matematiske metoder
    public double gjennomsnitt(int[] tab) {
        double samling = 0;
        for (int i = 0; i < tab.length; i++) {
            samling += tab[i];
        }
        return samling/tab.length;
    }
    public int foersteTall(int[] tab, int tall) {
        int index = -1;
        int i = 0;
        while (index < 0) {
            index = (kastTabell[i++]==tall) ? i : -1;

        }
        return index;
    }
    public int typetallAntall(int[] tab) {
        if ( tab == null || tab.length == 0 ) return -1; // null or empty

        int storstIndex = 0;
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] > tab[storstIndex]) storstIndex = i;
        }

        return storstIndex;
    }

    // Print metode
    public void printKast() {
        // Print terningkast, ANTALL kast per linje
        System.out.println("TERNINGKASTSIMULATOR");
        System.out.println();
        int linje = kastTabell.length / ANTALL;
        for (int i = 0; i < linje; i++) {
            for (int j = 0; j < ANTALL; j++) {
                System.out.print(kastTabell[j+(i*ANTALL)] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(String.format("%1$-15s", "Antall kast") + ": " + String.format("%1$5s", kast));
        for (int i = 6; i > 0; i--) {
            System.out.println(String.format("%1$-15s", "Antall " + i + "-ere") + ": " + String.format("%1$5s", antall[i]));
        }
        System.out.println();
        System.out.println("Gjennomsnittkast : " + gjennomsnitt(kastTabell));
        System.out.println();
        System.out.println("Antall kast for å få den første 6-eren : " + foersteTall(kastTabell, 6));
        System.out.println();
        System.out.println("Terningverdier det var flest av : " + typetallAntall(antall));
    }
}
