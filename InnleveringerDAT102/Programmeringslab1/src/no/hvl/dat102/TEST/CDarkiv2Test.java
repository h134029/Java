package no.hvl.dat102.TEST;

import no.hvl.dat102.ADT.CDarkivADT;
import no.hvl.dat102.NODE.LinearNode;
import no.hvl.dat102.OPPG1_2.CD;
import no.hvl.dat102.OPPG1_2.Sjanger;
import no.hvl.dat102.OPPG3.CDarkiv2;
import no.hvl.dat102.OPPG3.Fil;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CDarkiv2Test {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }
    @Test
    public void testConstructor() {
        CDarkiv2 cdTabell = new CDarkiv2();

        assertEquals(0,cdTabell.antall());
    }

    @Test
    public void testleggTil() {

        CDarkiv2 cdKjede = new CDarkiv2();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);
        CD C4 = new CD(114, "Bon Jovi", "Livin' on a Prayer", 1995, "Mercury", Sjanger.rock);
        CD C5 = new CD(115, "Queen", "Fat Bottomed Girl", 1975, "Emi Records", Sjanger.rock);
        CD C6 = new CD(116, "Bruno Mars", "Uptown Funk", 2018, "Atlantic", Sjanger.pop);
        CD C7 = new CD(117, "Bon Jovi", "You Give Love a Bad Name", 1995, "Mercury", Sjanger.rock);
        CD C8 = new CD(118, "Queen", "Somebody to Love", 1975, "Emi Records", Sjanger.rock);
        CD C9 = new CD(119, "Bruno Mars", "When I was your man", 2012, "Atlantic", Sjanger.pop);
        CD C10 = new CD(120, "Bon Jovi", "It's My Life", 1995, "Mercury", Sjanger.rock);



        assertTrue(cdKjede.leggTilCd(C1));
        assertTrue(cdKjede.leggTilCd(C2));
        assertTrue(cdKjede.leggTilCd(C3));
        assertTrue(cdKjede.leggTilCd(C4));
        assertTrue(cdKjede.leggTilCd(C5));
        assertTrue(cdKjede.leggTilCd(C6));
        assertTrue(cdKjede.leggTilCd(C7));
        assertTrue(cdKjede.leggTilCd(C8));
        assertTrue(cdKjede.leggTilCd(C9));
        assertTrue(cdKjede.leggTilCd(C10));

        assertEquals(10,cdKjede.antall());

        assertEquals(cdKjede.finnCd(120).getNeste(),cdKjede.finnCd(119));
        assertEquals(cdKjede.finnCd(119).getNeste(),cdKjede.finnCd(118));
        assertEquals(cdKjede.finnCd(111).getNeste(),null);



    }
    @Test
    public void testSlett() {
        CDarkiv2 cdKjede = new CDarkiv2();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);
        CD C4 = new CD(114, "Bon Jovi", "Livin' on a Prayer", 1995, "Mercury", Sjanger.rock);
        CD C5 = new CD(115, "Queen", "Fat Bottomed Girl", 1975, "Emi Records", Sjanger.rock);
        CD C6 = new CD(116, "Bruno Mars", "Uptown Funk", 2018, "Atlantic", Sjanger.pop);
        CD C7 = new CD(117, "Bon Jovi", "You Give Love a Bad Name", 1995, "Mercury", Sjanger.rock);
        CD C8 = new CD(118, "Queen", "Somebody to Love", 1975, "Emi Records", Sjanger.rock);
        CD C9 = new CD(119, "Bruno Mars", "When I was your man", 2012, "Atlantic", Sjanger.pop);
        CD C10 = new CD(120, "Bon Jovi", "It's My Life", 1995, "Mercury", Sjanger.rock);

        cdKjede.leggTilCd(C1);
        cdKjede.leggTilCd(C2);
        cdKjede.leggTilCd(C3);
        cdKjede.leggTilCd(C4);
        cdKjede.leggTilCd(C5);
        cdKjede.leggTilCd(C6);
        cdKjede.leggTilCd(C7);
        cdKjede.leggTilCd(C8);
        cdKjede.leggTilCd(C9);
        cdKjede.leggTilCd(C10);


        CD[] tabell = cdKjede.hentCdTabell();

        // Pre delete
        assertEquals(C1,tabell[9]);
        assertEquals(C2,tabell[8]);
        assertEquals(C3,tabell[7]);
        assertEquals(10,cdKjede.antall());

        assertEquals(cdKjede.finnCd(113).getNeste(),cdKjede.finnCd(112));
        assertEquals(cdKjede.finnCd(112).getNeste(),cdKjede.finnCd(111));
        assertNull(cdKjede.finnCd(111).getNeste());

        assertEquals(cdKjede.forrigeCd(113).getElement(),C4);
        assertEquals(cdKjede.forrigeCd(112).getElement(),C3);
        assertEquals(cdKjede.forrigeCd(111).getElement(),C2);

        // Test forrige på første element i kjeden
        assertEquals(cdKjede.forrigeCd(119).getElement(),C10);
        assertEquals(cdKjede.forrigeCd(120).getElement(),C10);

        // Check delete
        assertTrue(cdKjede.slettCd(C1.getCdnr()));
        assertTrue(cdKjede.slettCd(C5.getCdnr()));
        assertTrue(cdKjede.slettCd(C10.getCdnr()));

        // Post delete
        //assertNull(cdKjede.finnCd(111).getNeste());
        //assertNull(cdKjede.finnCd(115).getNeste());
        //assertNull(cdKjede.finnCd(120).getNeste());

        assertEquals(cdKjede.finnCd(113).getNeste(),cdKjede.finnCd(112));
        assertEquals(cdKjede.finnCd(116).getNeste(),cdKjede.finnCd(114));
        assertEquals(cdKjede.finnCd(119).getNeste(),cdKjede.finnCd(118));

        assertEquals(cdKjede.forrigeCd(112).getElement(),C3);
        assertEquals(cdKjede.forrigeCd(114).getElement(),C6);
        assertEquals(cdKjede.forrigeCd(118).getElement(),C9);

        assertEquals(cdKjede.forrigeCd(119).getElement(),C9);

        assertEquals(7,cdKjede.antall());

    }
    @Test
    public void testSokTittel() {
        CDarkiv2 cdKjede = new CDarkiv2();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);
        CD C4 = new CD(114, "Bon Jovi", "Livin' on a Prayer", 1995, "Mercury", Sjanger.rock);
        CD C5 = new CD(115, "Queen", "Fat Bottomed Girl", 1975, "Emi Records", Sjanger.rock);
        CD C6 = new CD(116, "Bruno Mars", "Uptown Funk", 2018, "Atlantic", Sjanger.pop);

        String delstreng = "up";

        assertTrue(cdKjede.leggTilCd(C1));
        assertTrue(cdKjede.leggTilCd(C2));
        assertTrue(cdKjede.leggTilCd(C3));
        assertTrue(cdKjede.leggTilCd(C4));
        assertTrue(cdKjede.leggTilCd(C5));
        assertTrue(cdKjede.leggTilCd(C6));

        CD[] deltabell = cdKjede.sokTittel(delstreng);

        assertEquals(116,deltabell[0].getCdnr());
        assertEquals(113,deltabell[1].getCdnr());

    }
    @Test
    public void testSokArtist() {
        CDarkiv2 cdKjede = new CDarkiv2();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);
        CD C4 = new CD(114, "Bon Jovi", "Livin' on a Prayer", 1995, "Mercury", Sjanger.rock);
        CD C5 = new CD(115, "Queen", "Fat Bottomed Girl", 1975, "Emi Records", Sjanger.rock);
        CD C6 = new CD(116, "Bruno Mars", "Uptown Funk", 2018, "Atlantic", Sjanger.pop);

        String delstreng = "een";

        assertTrue(cdKjede.leggTilCd(C1));
        assertTrue(cdKjede.leggTilCd(C2));
        assertTrue(cdKjede.leggTilCd(C3));
        assertTrue(cdKjede.leggTilCd(C4));
        assertTrue(cdKjede.leggTilCd(C5));
        assertTrue(cdKjede.leggTilCd(C6));

        CD[] deltabell = cdKjede.sokArtist(delstreng);

        assertEquals(115,deltabell[0].getCdnr());
        assertEquals(112,deltabell[1].getCdnr());
    }
    @Test
    public void testAntallSjanger() {
        CDarkiv2 cdKjede = new CDarkiv2();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);
        CD C4 = new CD(114, "Bon Jovi", "Livin' on a Prayer", 1995, "Mercury", Sjanger.rock);
        CD C5 = new CD(115, "Queen", "Fat Bottomed Girl", 1975, "Emi Records", Sjanger.rock);
        CD C6 = new CD(116, "Bruno Mars", "Uptown Funk", 2018, "Atlantic", Sjanger.pop);
        CD C7 = new CD(117, "Carl Orff", "Carmina Burana",1976,"Tyskland",Sjanger.klassisk);

        assertTrue(cdKjede.leggTilCd(C1));
        assertTrue(cdKjede.leggTilCd(C2));
        assertTrue(cdKjede.leggTilCd(C3));
        assertTrue(cdKjede.leggTilCd(C4));
        assertTrue(cdKjede.leggTilCd(C5));
        assertTrue(cdKjede.leggTilCd(C6));
        assertTrue(cdKjede.leggTilCd(C7));

        assertEquals(4,cdKjede.antallSjanger(Sjanger.rock));
        assertEquals(2,cdKjede.antallSjanger(Sjanger.pop));
        assertEquals(1,cdKjede.antallSjanger(Sjanger.klassisk));
    }
    @Test
    public void testFilLeser() {
        CDarkivADT cdKjede = Fil.lesFraFil("CDER1");

        assertEquals(15,cdKjede.antall());
    }
}
