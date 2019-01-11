package no.hvl.dat100;
import static javax.swing.JOptionPane.*;

public class oppg4 {
    public static void main(String[] args) {
        String ovre = showInputDialog("Les inn øvre grense: ");
        String nedre = showInputDialog("Les inn nedre grense: ");

        int i = Integer.parseInt(ovre);
        int j = Integer.parseInt(nedre);
        StringBuilder ut = new StringBuilder();

        if (j % 2 == 0) {
            while (j < i) {
                j += 1;
                System.out.println(j);
                ut.append(" " + j + " ");
                j += 1;
            }
        }
        else {
            while (j <= i) {
                System.out.println(j);
                ut.append(" " + j + " ");
                j += 2;
            }
        }
        showMessageDialog(null, "Resultat:" + ut);
    }
}