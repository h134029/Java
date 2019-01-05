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

        assertEquals(laerer.getEtternavn(),"Mjaanes");
        assertEquals(laerer.getFornavn(),"Jan");
        assertEquals(laerer.getFoedselsnummer(),1010011700);
        assertEquals(laerer.getManadslonn(),35000);
        assertEquals(laerer.getKontonummer(),370540);
    }

    @Test
    public void testSet() {
        Laerer laerer = new Laerer();

        laerer.setEtternavn("Mjaanes");
        laerer.setFornavn("Jan");
        laerer.setFoedselsnummer(1010011700);
        laerer.setManadslonn(35000);
        laerer.setKontonummer(370540);

        assertEquals(laerer.getEtternavn(),"Mjaanes");
        assertEquals(laerer.getFornavn(),"Jan");
        assertEquals(laerer.getFoedselsnummer(),1010011700);
        assertEquals(laerer.getManadslonn(),35000);
        assertEquals(laerer.getKontonummer(),370540);
    }

    @Test
    public void testToString() {
        Laerer laerer = new Laerer(35000,370540,"Mjaanes", "Jan",1010011700);

        String str = "LAERER\n1010011700\nMjaanes\nJan\n35000\n370540\n";

        assertEquals(laerer.toString(),str);
    }
}