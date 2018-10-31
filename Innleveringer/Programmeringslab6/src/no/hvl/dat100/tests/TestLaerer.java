package no.hvl.dat100.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat100.*;
public class TestLaerer {

    private int maanedslonn;
    private int kontonummer;

    @Test
    public void testConstructor() {
        Laerer laerer = new Laerer(35000,370540,"Mjaanes", "Jan",1010011700);

        assertEquals(laerer.getEtternavn(),"Olsen");
        assertEquals(laerer.getFornavn(),"Ole");
        assertEquals(laerer.getFoedselsnummer(),7);
        assertEquals(laerer.getManadslonn(),1000);
        assertEquals(laerer.getKontonummer(),7676);
    }

    @Test
    public void testSet() {
        Laerer laerer = new Laerer();

        laerer.setEtternavn("Olsen");
        laerer.setFornavn("Ole");
        laerer.setFoedselsnummer(7);
        laerer.setManadslonn(1000);
        laerer.setKontonummer(7676);

        assertEquals(laerer.getEtternavn(),"Olsen");
        assertEquals(laerer.getFornavn(),"Ole");
        assertEquals(laerer.getFoedselsnummer(),7);
        assertEquals(laerer.getManadslonn(),1000);
        assertEquals(laerer.getKontonummer(),7676);
    }

    @Test
    public void testToString() {
        Laerer laerer = new Laerer(35000,370540,"Mjaanes", "Jan",1010011700);

        String str = "LAERER\n7\nOlsen\nOle\n1000\n7676\n";

        assertEquals(laerer.toString(),str);
    }
}