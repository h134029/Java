package no.hvl.dat100;
import static javax.swing.JOptionPane.*;


public class oppg6 {
    public static void main(String[] args) {


        int i;          // Poengsum
        int j = 1;      // Teller
        int k = 10;     // Antall studenter

        while (j <= k) {
            String inn = showInputDialog(null,"Student " + j + " - " + "Les inn poengsum [0 - 100]: ");
            i = Integer.parseInt(inn);

            if (0 <= i && i <=39) {
                showMessageDialog(null, "Karakter: F");
                j++;
            }
            else if (40 <= i && i <= 49) {
                showMessageDialog(null, "Karakter: E");
                j++;
            }
            else if (50 <= i && i <= 59) {
                showMessageDialog(null, "Karakter: D");
                j++;
            }
            else if (60 <= i && i <= 79) {
                showMessageDialog(null, "Karakter: C");
                j++;
            }
            else if (80 <= i && i <= 89) {
                showMessageDialog(null, "Karakter: B");
                j++;
            }
            else if (90 <= i & i <= 100) {
                showMessageDialog(null, "Karakter: A");
                j++;
            }
            else {
                showMessageDialog(null, "Ugyldig poengsum");
            }
        }
    }
}
