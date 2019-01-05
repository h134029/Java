package no.hvl.dat100;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LeseFraFil {
    static String MAPPE_STR = System.getProperty("user.dir") + "/src/no/hvl/dat100/LeseFraFil/";

    static public void main(String[] args) {

        String filnavn;
        int forsok = 0;
        int bryt = 3;
        do {
        filnavn = JOptionPane.showInputDialog("Filnavn i mappen " + MAPPE_STR);
        File file = new File(MAPPE_STR + filnavn);

            try {
                Scanner reader = new Scanner(file);

                int linenumber = 1;

                // les innhold i filen linje for linje
                String line;

                while (reader.hasNextLine()) {
                    line = reader.nextLine();
                    System.out.println(linenumber + " " + line);
                    linenumber++;
                }

                reader.close();
                forsok = bryt;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Filen " + filnavn + " finnes ikke. \n" + e.getMessage());
                forsok++;
            }
        }while(forsok < bryt);

    }
}

