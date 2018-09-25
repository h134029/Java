package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class oppg3 {
    public static void main(String[] args) {
        String innput = showInputDialog("Skriv inn sekunder:");

        int sekInn = parseInt(innput);

        /* Prosessbeskrivelse
        int timer =
        int min =
        int sek =
         */

        int timer = sekInn/(60*60);
        int min = (sekInn%(60*60))/60;
        int sek = (sekInn%(60*60))%60;

        String ut = timer + " timer, " + min + " minutter og " + sek + " sekunder";
        // System print
        System.out.println(ut);
        // Message Dialog print
        showMessageDialog(null,ut);
    }
}
