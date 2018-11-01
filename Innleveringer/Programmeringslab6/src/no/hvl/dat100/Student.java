package no.hvl.dat100;

public class Student extends Person {
    private int studentnummer;
    private String klasse;

    public Student(int studentnummer, String klasse, String etternavn, String fornavn, long foedselsnummer) {
        super(etternavn, fornavn, foedselsnummer);
        this.studentnummer = studentnummer;
        this.klasse = klasse;
    }
    public Student() {this(0,"","","",0);}
    // Get/Set
    public int getStudentnummer() { return studentnummer; }
    public String getKlasse() { return klasse; }

    public void setStudentnummer(int studentnummer) { this.studentnummer = studentnummer; }
    public void setKlasse(String klasse) { this.klasse = klasse; }

    // Returnerer all object informasjon som String
    public String toString() {
        return "STUDENT" + "\n" + super.toString() + studentnummer + "\n" + klasse + "\n";
    }
}
