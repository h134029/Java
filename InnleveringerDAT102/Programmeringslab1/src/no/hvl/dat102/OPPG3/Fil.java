package no.hvl.dat102.OPPG3;

import no.hvl.dat102.OPPG1_2.Tekstgrensesnitt;
import no.hvl.dat102.OPPG3.ADT.CDarkivADT;
import no.hvl.dat102.OPPG1_2.CD;
import no.hvl.dat102.OPPG1_2.Sjanger;

import java.io.*;

public class Fil {

    private static final String SKILLE = "#";
    private static String CDdir = System.getProperty("user.dir") + "/src/no/hvl/dat102/OPPG3/SAMLINGER/";

    public static CDarkivADT lesFraFil(String filnavn) {
        CDarkiv2 cda = new CDarkiv2();
        Tekstgrensesnitt tekstgr = new Tekstgrensesnitt();
        try {

            // Byte-innstrømm
            FileReader ansFil = new FileReader(CDdir + filnavn);
            // Buffret innlesing
            BufferedReader innfil = new BufferedReader(ansFil);

            // Første linje skal vere tall antall CD'er
            String linje = innfil.readLine();
            int n = Integer.parseInt(linje);

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
            System.out.println("File not found" + filnavn);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
        System.out.println();
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
				// skriver postene, felt for felt
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
            System.out.println("Written to file: " + filnavn);

            // Lukk filen
			utfil.close();
		} catch(FileNotFoundException e) {
			System.out.print("Error writing to file " + filnavn);
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e);
		}
	}
}