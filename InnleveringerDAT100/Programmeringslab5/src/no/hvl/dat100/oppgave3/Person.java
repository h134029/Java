package no.hvl.dat100.oppgave3;

public class Person {
    protected String etternavn;
    protected String fornavn;
    protected int foedselsaar;
    protected char kjoenn;

    public Person(String etternavn, String fornavn, int foedselsaar, char kjoenn) {
        this.etternavn = etternavn;
        this.fornavn = fornavn;
        this.foedselsaar = foedselsaar;
        this.kjoenn = kjoenn;
    }
    public Person() {
        this("","",0,' ');
    }
    // Get/Set
    public String getEtternavn() { return etternavn; }
    public String getFornavn() { return fornavn; }
    public int getFoedselsaar() { return foedselsaar; }
    public char getKjoenn() { return kjoenn; }

    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }
    public void setFoedselsaar(int foedselsaar) { this.foedselsaar = foedselsaar; }
    public void setKjoenn(char kjoenn) { this.kjoenn = kjoenn; }

    // Returnerer all object informasjon som String
    public String toString() {
        return String.format("%-25s","Etternavn: " + etternavn) + String.format("%-20s", "Fornavn: " + fornavn)
                + String.format("%-20s", "Fødselsår: " + foedselsaar) + String.format("%-12s", "Kjønn: " + kjoenn);
    }
}
