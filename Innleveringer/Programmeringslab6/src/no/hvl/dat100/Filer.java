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
            skrevet = true;

            String inn = samling.toString();
            writer.println(inn);

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
        PersonSamling samling = null;
        Person P1 = new Student();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String linje = sc.next();
                if (linje==STUDENT) {
                    P1.setFoedselsnummer(Long.parseLong(sc.next()));
                    P1.setEtternavn(sc.next());
                    P1.setFornavn(sc.next());
                    ((Student) P1).setStudentnummer(Integer.parseInt(sc.next()));
                    ((Student) P1).setKlasse(sc.next());

                }else if (linje==LAERER) {

                }
            }
            sc.close();

        }catch(Exception e) {
            System.out.println();

        }
        PersonSamling PS2 = new PersonSamling();
        PS2.leggTilUtvid(P1);
        PS2.skrivut();
        return samling;
    }
}