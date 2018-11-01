package no.hvl.dat100.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import no.hvl.dat100.*;
import java.io.*;

public class TestFiler {

    private static String FILNAVNLESE = "personerkorrekt.dat";
    private static String FILNAVNSKRIVE = "personer.dat";

    @Test
    public void testskriv() {
        Filer filer = new Filer();

        Student student = new Student(134029,"DAT-B", "Fortun", "Olav",1010011900);
        Laerer laerer = new Laerer(35000,370540,"Mjaanes", "Jan",1010011700);

        PersonSamling samling = new PersonSamling();

        samling.leggTilUtvid(student);
        samling.leggTilUtvid(laerer);

        Filer.skriv(samling, FILNAVNSKRIVE);

        try {
            assertTrue(compareFiles(FILNAVNSKRIVE,FILNAVNLESE));
        } catch (IOException e) {
            System.out.println("Feil med sammenligning av filer" + e.getMessage());
            assertTrue(false);
        }
    }

    @Test
    public void testles() {
        Filer filer = new Filer();

        PersonSamling samling = Filer.les(FILNAVNLESE);
        Student student = new Student(134029,"DAT-B", "Fortun", "Olav",1010011900);
        Laerer laerer = new Laerer(35000,370540,"Mjaanes", "Jan",1010011700);

        assertEquals(samling.getAntall(), 2);
        assertTrue(samling.finnes(student));
        assertTrue(samling.finnes(laerer));
    }

    private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/";

    private boolean compareFiles(String f1, String f2) throws IOException {

        FileInputStream fles = null, fskriv = null;
        BufferedReader br1 = null, br2 = null;
        boolean like = true;

        try {

            fles = new FileInputStream(MAPPE + f1);
            fskriv = new FileInputStream(MAPPE + f2);

            DataInputStream in1 = new DataInputStream(fles);
            DataInputStream in2 = new DataInputStream(fskriv);

            br1 = new BufferedReader(new InputStreamReader(in1));
            br2 = new BufferedReader(new InputStreamReader(in2));

            String strLine1, strLine2;

            while (like && (strLine1 = br1.readLine()) != null && (strLine2 = br2.readLine()) != null) {

                if (!strLine1.equals(strLine2)) {
                    like = false;
                }
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Feil med fil: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Feil med lesing: " + e.getMessage());
        } finally {
            if (fles != null) {
                fles.close();
            }
            if (fskriv != null) {
                fskriv.close();
            }
            if (br1 != null) {
                br1.close();
            }
            if (br2 != null) {
                br2.close();
            }

        }

        return like;
    }
}