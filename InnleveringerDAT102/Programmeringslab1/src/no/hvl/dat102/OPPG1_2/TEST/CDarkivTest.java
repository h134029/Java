package no.hvl.dat102.OPPG1_2.TEST;

import no.hvl.dat102.OPPG1_2.CD;
import no.hvl.dat102.OPPG1_2.CDarkiv;

import static org.junit.Assert.*;

import no.hvl.dat102.OPPG1_2.Sjanger;
import org.junit.*;

public class CDarkivTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }
    @Test
    public void testStandardConstructor() {
        CDarkiv cdTabell = new CDarkiv();

        assertEquals(0,cdTabell.antall());
        assertEquals(20,cdTabell.hentCdTabell().length);
    }
    @Test
    public void testConstructor() {
        CDarkiv cdTabell = new CDarkiv(40);

        assertEquals(0,cdTabell.antall());
        assertEquals(40,cdTabell.hentCdTabell().length);
    }
    @Test
    public void testIndex() {
        CDarkiv cdTabell = new CDarkiv();

        CD C1 = new CD(111,"Bon Jovi","Always",1995,"Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen","Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);

        CD[] tabell = cdTabell.hentCdTabell();

        assertEquals(-1,cdTabell.cdIndex(111));

        tabell[0] = C1;
        tabell[1] = C2;

        cdTabell.setAntall(2);

        assertEquals(0,cdTabell.cdIndex(C1.getCdnr()));
        assertEquals(1,cdTabell.cdIndex(C2.getCdnr()));
        assertEquals(-1,cdTabell.cdIndex(C3.getCdnr()));
    }
    @Test
    public void testFinnes() {
        CDarkiv cdTabell = new CDarkiv();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);

        CD[] tabell = cdTabell.hentCdTabell();

        assertFalse(cdTabell.cdFinnes(C1.getCdnr()));

        tabell[0] = C1;
        tabell[1] = C2;

        cdTabell.setAntall(2);

        assertTrue(cdTabell.cdFinnes(C1.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C2.getCdnr()));
        assertFalse(cdTabell.cdFinnes(C3.getCdnr()));
    }
    @Test
    public void testleggTil() {

        CDarkiv cdTabell = new CDarkiv(10);

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
        CD C11 = new CD(121, "Queen", "Everyone Bites the Dust", 1975, "Emi Records", Sjanger.rock);
        CD C12 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);


        assertTrue(cdTabell.leggTilCd(C1));
        assertTrue(cdTabell.leggTilCd(C2));
        assertTrue(cdTabell.leggTilCd(C3));
        assertTrue(cdTabell.leggTilCd(C4));
        assertTrue(cdTabell.leggTilCd(C5));
        assertTrue(cdTabell.leggTilCd(C6));
        assertTrue(cdTabell.leggTilCd(C7));
        assertTrue(cdTabell.leggTilCd(C8));
        assertTrue(cdTabell.leggTilCd(C9));
        assertTrue(cdTabell.leggTilCd(C10));

        assertEquals(10,cdTabell.antall());

        assertTrue(cdTabell.cdFinnes(C1.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C2.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C3.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C4.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C5.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C6.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C7.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C8.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C9.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C10.getCdnr()));

        assertTrue(cdTabell.leggTilCd(C11));

        assertEquals(11,cdTabell.antall());

        assertFalse(cdTabell.leggTilCd(C12));

    }
    @Test
    public void testSlett() {
        CDarkiv cdTabell = new CDarkiv();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);

        CD[] tabell = cdTabell.hentCdTabell();

        assertFalse(cdTabell.cdFinnes(C1.getCdnr()));

        tabell[0] = C1;
        tabell[1] = C2;
        tabell[2] = C3;

        cdTabell.setAntall(3);

        assertTrue(cdTabell.cdFinnes(C1.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C2.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C3.getCdnr()));

        assertTrue(cdTabell.slettCd(C1.getCdnr()));

        assertEquals(2,cdTabell.antall());

        assertTrue(cdTabell.cdFinnes(C3.getCdnr()));
        assertTrue(cdTabell.cdFinnes(C2.getCdnr()));
        assertFalse(cdTabell.cdFinnes(C1.getCdnr()));

    }
    @Test
    public void testSokTittel() {
        CDarkiv cdTabell = new CDarkiv();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);
        CD C4 = new CD(114, "Bon Jovi", "Livin' on a Prayer", 1995, "Mercury", Sjanger.rock);
        CD C5 = new CD(115, "Queen", "Fat Bottomed Girl", 1975, "Emi Records", Sjanger.rock);
        CD C6 = new CD(116, "Bruno Mars", "Uptown Funk", 2018, "Atlantic", Sjanger.pop);

        String delstreng = "up";

        assertTrue(cdTabell.leggTilCd(C1));
        assertTrue(cdTabell.leggTilCd(C2));
        assertTrue(cdTabell.leggTilCd(C3));
        assertTrue(cdTabell.leggTilCd(C4));
        assertTrue(cdTabell.leggTilCd(C5));
        assertTrue(cdTabell.leggTilCd(C6));

        CD[] deltabell = cdTabell.sokTittel(delstreng);

        CDarkiv cdDelTabell = new CDarkiv(2);
        assertTrue(cdDelTabell.leggTilCd(deltabell[0]));
        assertTrue(cdDelTabell.leggTilCd(deltabell[1]));

        // Finnes fra før
        assertTrue(cdDelTabell.cdFinnes(deltabell[0].getCdnr()));
        assertTrue(cdDelTabell.cdFinnes(deltabell[1].getCdnr()));
        // "Up"
        assertTrue(C3.getCdnr() == deltabell[0].getCdnr());
        assertTrue(C6.getCdnr() == deltabell[1].getCdnr());
        assertFalse(C1.getCdnr() == deltabell[0].getCdnr());
    }
    @Test
    public void testSokArtist() {
        CDarkiv cdTabell = new CDarkiv();

        CD C1 = new CD(111, "Bon Jovi", "Always", 1995, "Mercury", Sjanger.rock);
        CD C2 = new CD(112, "Queen", "Bohemian Rhapsody", 1975, "Emi Records", Sjanger.rock);
        CD C3 = new CD(113, "Bruno Mars", "Wake Up in the Sky", 2018, "Atlantic", Sjanger.pop);
        CD C4 = new CD(114, "Bon Jovi", "Livin' on a Prayer", 1995, "Mercury", Sjanger.rock);
        CD C5 = new CD(115, "Queen", "Fat Bottomed Girl", 1975, "Emi Records", Sjanger.rock);
        CD C6 = new CD(116, "Bruno Mars", "Uptown Funk", 2018, "Atlantic", Sjanger.pop);

        String delstreng = "een";

        assertTrue(cdTabell.leggTilCd(C1));
        assertTrue(cdTabell.leggTilCd(C2));
        assertTrue(cdTabell.leggTilCd(C3));
        assertTrue(cdTabell.leggTilCd(C4));
        assertTrue(cdTabell.leggTilCd(C5));
        assertTrue(cdTabell.leggTilCd(C6));

        CD[] deltabell = cdTabell.sokArtist(delstreng);

        CDarkiv cdDelTabell = new CDarkiv(2);
        assertTrue(cdDelTabell.leggTilCd(deltabell[0]));
        assertTrue(cdDelTabell.leggTilCd(deltabell[1]));

        // Finnes fra før
        assertTrue(cdDelTabell.cdFinnes(deltabell[0].getCdnr()));
        assertTrue(cdDelTabell.cdFinnes(deltabell[1].getCdnr()));
        // "Up"
        assertTrue(C2.getCdnr() == deltabell[0].getCdnr());
        assertTrue(C5.getCdnr() == deltabell[1].getCdnr());
        assertFalse(C1.getCdnr() == deltabell[0].getCdnr());

    }
}
