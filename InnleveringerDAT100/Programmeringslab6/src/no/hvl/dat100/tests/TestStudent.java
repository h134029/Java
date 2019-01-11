package no.hvl.dat100.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat100.*;
public class TestStudent {

    @Test
    public void testConstructor() {
        Student student = new Student(134029,"DAT-B", "Fortun", "Olav",1010011900);

        assertEquals(student.getEtternavn(),"Fortun");
        assertEquals(student.getFornavn(),"Olav");
        assertEquals(student.getFoedselsnummer(),1010011900);
        assertEquals(student.getStudentnummer(),134029);
        assertEquals(student.getKlasse(),"DAT-B");
    }

    @Test
    public void testSet() {
        Student student = new Student();

        student.setEtternavn("Fortun");
        student.setFornavn("Olav");
        student.setFoedselsnummer(1010011900);
        student.setStudentnummer(134029);
        student.setKlasse("DAT-B");

        assertEquals(student.getEtternavn(),"Fortun");
        assertEquals(student.getFornavn(),"Olav");
        assertEquals(student.getFoedselsnummer(),1010011900);
        assertEquals(student.getStudentnummer(),134029);
        assertEquals(student.getKlasse(),"DAT-B");
    }

    @Test
    public void testToString() {
        Student student = new Student(134029,"DAT-B", "Fortun", "Olav",1010011900);

        String str = "STUDENT\n1010011900\nFortun\nOlav\n134029\nDAT-B\n";

        assertEquals(student.toString(),str);
    }

}