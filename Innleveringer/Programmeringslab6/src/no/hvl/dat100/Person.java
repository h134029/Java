package no.hvl.dat100;

public class Person {
    protected String etternavn;
    protected String fornavn;
    protected long foedselsnummer;
    protected int index;

    public Person(String etternavn, String fornavn, long foedselsnummer) {
        this.etternavn = etternavn;
        this.fornavn = fornavn;
        this.foedselsnummer = foedselsnummer;
    }
    public Person() {
        this("","",0);
    }

    // Get/Set
    public String getEtternavn() { return etternavn; }
    public String getFornavn() { return fornavn; }
    public long getFoedselsnummer() { return foedselsnummer; }
    public int getIndex() { return index; }

    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }
    public void setFoedselsnummer(long foedselsnummer) { this.foedselsnummer = foedselsnummer; }
    public void setIndex(int index) { this.index = index; }

    // Metoder
    public String toString() {
        return foedselsnummer + "\n" + etternavn + "\n" + fornavn;
    }
    public boolean erLik(Person p) {
        // Return true viss samme fødselsnummer og ikkje samme index (samme objekt)
        return (p.getFoedselsnummer()==foedselsnummer && p.index != index);
    }
    public boolean erKvinne() {
        String tall = String.valueOf(foedselsnummer);
        int erPar = Character.digit(tall.charAt(tall.length() - 3),10);
        return (erPar%2 == 0);
    }
    public boolean erMann() {
        String tall = String.valueOf(foedselsnummer);
        int erOdd = Character.digit(tall.charAt(tall.length() - 3),10);
        return (erOdd%2 > 0);
    }
}
