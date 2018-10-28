package no.hvl.dat100.oppgave3;

public class Student extends Person {
    private int studentnummer;
    private String klasse;

    public Student(int studentnummer, String klasse, String etternavn, String fornavn, int foedselsaar, char kjoenn) {
        super(etternavn, fornavn, foedselsaar, kjoenn);
        this.studentnummer = studentnummer;
        this.klasse = klasse;
    }
    // Get/Set
    public int getStudentnummer() { return studentnummer; }
    public String getKlasse() { return klasse; }

    public void setStudentnummer(int studentnummer) { this.studentnummer = studentnummer; }
    public void setKlasse(String klasse) { this.klasse = klasse; }

    // Returnerer all object informasjon som String
    public String toString() {
        return super.toString() + ", Studentnummer: " + studentnummer + ", Klasse: " + klasse;
    }
}
