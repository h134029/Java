package no.hvl.dat102.OPPG1_2;

import no.hvl.dat102.OPPG3.ADT.CDarkivADT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fil {

    private static final String SKILLE = "#";
    private static String CDdir = System.getProperty("user.dir") + "/src/no/hvl/dat102/OPPG1_2/SAMLINGER/";

    public static CDarkivADT lesFraFil(String filnavn) {
        CDarkivADT cda = null;
        try {

            // Byte-innstrømm
            FileReader ansFil = new FileReader(CDdir + filnavn);
            // Buffret innlesing
            BufferedReader innfil = new BufferedReader(ansFil);

            // Første linje skal vere tall antall CD'er
            String linje = innfil.readLine();
            int n = Integer.parseInt(linje);
            cda = new CDarkiv(n);

            for (int i = 0; i < n; i++) {
                String post = innfil.readLine();
                String[] felt = post.split(SKILLE);

                int nr = Integer.parseInt(felt[0]);
                String artist = felt[1];
                String tittel = felt[2];
                int aar = Integer.parseInt(felt[3]);

                String plselskap = felt[4];
                String sjStr = felt[5];
                Sjanger sj = Sjanger.valueOf(sjStr);
                CD cd = new CD(nr, artist, tittel, aar, plselskap, sj);
                cda.leggTilCd(cd);
            }
            // Lukk filen
            innfil.close();
        } catch (FileNotFoundException unntak) {
            System.out.println("Finner ikke filen " + filnavn);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Feil ved lesing av fil: " + e);
            System.exit(2);
        }

        return cda;
    }
    public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn)  {
        try {

            // Definerer et FileWriter-objekt som åpner filen
			FileWriter ansFil = new FileWriter(CDdir + filnavn, false);
            // Definerer et PrintWriter-objekt som kobles til FileWriter-objektet
			PrintWriter utfil = new PrintWriter(ansFil);

            // Skriver ut antall cder på første linje
			int antall = cdarkiv.antall();
			utfil.println(antall);

			CD[] tabell = cdarkiv.hentCdTabell();
			for (int i = 0; i < antall; i++) {
				// kriver postene, felt for felt
				utfil.print(tabell[i].getCdnr());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getArtist());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getRelease());
				utfil.print(SKILLE);
                utfil.print(tabell[i].getPlateselskap());
                utfil.print(SKILLE);
                utfil.println(tabell[i].getSjanger());
			}
			// Lukk filen
			utfil.close();
		} catch(FileNotFoundException e) {
			System.out.print("feil ved åpning av fil: " + filnavn);
			System.exit(1); // avbryte utføringen
		} catch (IOException e) {
			System.out.println("Feil på skriving til fil: " + e);
			System.exit(2);// avbryte utføringen
		}
	}
}