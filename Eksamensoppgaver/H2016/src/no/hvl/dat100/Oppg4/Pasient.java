package no.hvl.dat100.Oppg4;

public class Pasient {
    private String navn;
    private String fodselsnummer;
    private int dager;

    public Pasient(String navn, String fodselsnummer) {
        this.navn = navn;
        this.fodselsnummer = fodselsnummer;
        dager = 0;
    }
    //GET/SET
    public String getNavn() {return navn;}
    public String getFodselsnummer() {return fodselsnummer;}
    public int getDager() {return dager;}

    public void setNavn(String navn){this.navn = navn;}
    public void setFodselsnummer(String fodselsnummer) {this.fodselsnummer = fodselsnummer;}
    public void setDager(int dager) {this.dager = dager;}

    public String toString() {
        return navn + "\n" + fodselsnummer + "\n" + dager;
    }
}