package no.hvl.dat100.Oppgave4;

public class Bestilling {
    private int kontaktnummer;
    private String kundenavn;
    private String adresse;

    public Bestilling(int kontaktnummer, String kundenavn, String adresse) {
        this.kontaktnummer = kontaktnummer;
        this.kundenavn = kundenavn;
        this.adresse = adresse;
    }
    public Bestilling() {
        this(0,"","");
    }

    // Get/Set
    public int getKontaktnummer() {return kontaktnummer;}
    public String getKundenavn() {return kundenavn;}
    public String getAdresse() {return adresse;}

    public void setKontaktnummer(int kontaktnummer) {
        this.kontaktnummer = kontaktnummer;
    }
    public void setKundenavn(String kundenavn) {
        this.kundenavn = kundenavn;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    // Metoder
    // Skriver ut alt på ein linje
    public void skrivUt() {
        System.out.print("Kontaktnummer: " + kontaktnummer + ", Kundenavn: " + kundenavn + ", Adresse: " + adresse);
    }
}

