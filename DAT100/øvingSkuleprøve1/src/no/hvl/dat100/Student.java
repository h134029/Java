package no.hvl.dat100;

public class Student {
    int studNr;
    String fornavn;
    String etternavn;

    public Student(int studNrInit, String fornavnInit, String etternavnInit) {

        studNr = studNrInit;
        fornavn = fornavnInit;
        etternavn = etternavnInit;
    }
    public void skrivUt() {
        System.out.println(studNr + ": " + fornavn + " " + etternavn);
    }
    public String navn() {
        return etternavn + ", " + fornavn;
    }
    public void endreEtternavn(String nyttEtternavn) {
        etternavn = nyttEtternavn;
    }
}
