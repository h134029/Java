package no.hvl.dat100;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Filer extends Person{

    private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/";
    private static String STUDENT = "STUDENT";
    private static String LAERER = "LAERER";


    public static boolean skriv(PersonSamling samling, String filnavn) {
        File file = new File(MAPPE + filnavn);
        boolean skrevet;
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(file);
            String inn = samling.toString();
            writer.println(inn);

            skrevet = true;

        } catch(FileNotFoundException e) {
            skrevet = false;
            System.out.println("Error" + e);

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return skrevet;
    }

    public static PersonSamling les(String filnavn) {
        File file = new File(MAPPE + filnavn);

        // Finner første tall i filen som er antall personer = size
        int size = 0;
        try {
            Scanner teller = new Scanner(file);
            size = teller.nextInt();
        }catch(FileNotFoundException e) {
            System.out.println("Fil ikkje funnet " + e);
        }catch(NoSuchElementException e) {
            System.out.println();
        }

        // Initiate Objects
        PersonSamling PS = new PersonSamling(size);
        Person[] tab = new Person[size];

        int i = 0;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String linje = sc.next();
                if (linje.equals(STUDENT)) {

                    String persnrtxt = sc.next();
                    String etter = sc.next();
                    String forn = sc.next();
                    String studnrtxt = sc.next();
                    String klasse = sc.next();

                    Long persnr = Long.parseLong(persnrtxt);
                    int studnr = Integer.parseInt(studnrtxt);

                    tab[i] = new Student(studnr, klasse, etter, forn, persnr);
                    PS.leggTilUtvid(tab[i]);
                    i++;
                    PS.setAntall(i);
                } else if (linje.equals(LAERER)) {

                    String persnrtxt = sc.next();
                    String etter = sc.next();
                    String forn = sc.next();
                    String lonntxt = sc.next();
                    String kontonrtxt = sc.next();

                    Long persnr = Long.parseLong(persnrtxt);
                    int lonn = Integer.parseInt(lonntxt);
                    int kontonr = Integer.parseInt(kontonrtxt);

                    tab[i] = new Laerer(lonn,kontonr,etter,forn, persnr);
                    PS.leggTilUtvid(tab[i]);
                    i++;
                    PS.setAntall(i);
                }
            }
            sc.close();

        }catch(NoSuchElementException e) {
            System.out.println();

        }catch(FileNotFoundException e) {
            System.out.println("Fil ikkje funnet " + e);

        }catch(NullPointerException e) {
            System.out.println(e);
        }
        return PS;
    }
}