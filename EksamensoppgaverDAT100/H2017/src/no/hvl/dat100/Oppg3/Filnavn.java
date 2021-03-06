package no.hvl.dat100.Oppg3;

import java.util.*;
import java.lang.*;
import java.io.*;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Filnavn {

    public static void les(String filnavn) throws FileNotFoundException {
        File fil = new File(System.getProperty("user.dir") + "\\src\\no\\hvl\\dat100\\Oppg3\\" + filnavn);
        Scanner sc = new Scanner(fil);

        while (sc.hasNext()) {
            String ut = sc.nextLine();
            boolean kommentar = (ut.substring(0,2).equals("//"));
            if (!kommentar) {
                System.out.println(ut);
            }
        }
        sc.close();
    }
    public static boolean lesCatch(String filnavn) {
        try {
            les(filnavn);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
    public static void lesForsok(int forsok) {
        boolean lest = false;
        int checksum = 0;

        while (!lest && checksum < forsok) {
            String inn = showInputDialog(null, "Angi filnavn");

            if (lesCatch(inn)) lest = true;
            else {
                showMessageDialog(null, "Feil");
                checksum++;
            }
        }
    }
    public static void main(String[] args) {
        lesForsok(3);
    }
}