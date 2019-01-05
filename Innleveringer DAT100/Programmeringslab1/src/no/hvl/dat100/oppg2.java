package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class oppg2 {
    public static void main(String[] args) {
        String dagnr = showInputDialog("Skriv inn dagnummer:");
        String mndnr = showInputDialog("Skriv inn månedsnummer:");
        String årsnr = showInputDialog("Skriv inn årsnummer:");

        String ut = dagnr+"."+mndnr+"."+årsnr;
        // System print
        System.out.println(ut);
        // Message Dialog print
        showMessageDialog(null,ut);
    }
}
