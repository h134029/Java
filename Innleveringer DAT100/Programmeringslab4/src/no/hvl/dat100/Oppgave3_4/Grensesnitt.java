package no.hvl.dat100.Oppgave3_4;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.Arrays;

public class Grensesnitt {
    // Tom konstruktør
    public Grensesnitt() {
    }
    public void lesFlereVarer(Varelager reg) {
        String ledetekst = "Programmmet leser inn vareopplysninger";
        System.out.println(ledetekst);
        String tallTxt = showInputDialog("Oppgi antall registreringer");
        int ant = parseInt(tallTxt);
        Vare vare = null;

        for (int i = 0; i < ant; i++) {
            vare = lesVare();
            reg.leggTil(vare);
        }
    }

    public void visAlleSortert(Varelager reg) {
        System.out.println();
        System.out.println("Varer i lageret sortert etter varenummer:");
        System.out.println("______________________________________________________");
        // Sorterer en tabell som er strengobjekter av vareoppl..
        int stor = reg.getAntall();
        String[] nrTab = new String[stor];
        for (int i = 0; i < nrTab.length; i++) {
            nrTab[i] = reg.getVare()[i].toString();
        }

        Arrays.sort(nrTab); // Kall til metode i klassen Arrays

        // Sortert utskrift etter varenr
        for (int i = 0; i < nrTab.length; i++) {
            System.out.println(nrTab[i]);
        }
    }
    public void visAlle(Varelager reg) {
        System.out.println();
        System.out.println("Varer i lageret usortert:");
        System.out.println("______________________________________________________");
        Vare vare = null;
        for (int i = 0; i < reg.getAntall(); i++) {
            vare = reg.getVare()[i];
            skrivVare(vare);
        }
    }
    public Vare lesVare() {
        String vareTxt = showInputDialog("Oppgi varenr: ");
        int nr = parseInt(vareTxt);
        String varenavn = showInputDialog("Oppgi varenavn: ");
        String prisTxt = showInputDialog("Oppgi pris: ");
        double pris = Double.parseDouble(prisTxt);
        Vare vare = new Vare(nr, varenavn, pris);

        return vare;
    }
    void skrivVare(Vare vare) {
        System.out.println(vare);
    }
}
