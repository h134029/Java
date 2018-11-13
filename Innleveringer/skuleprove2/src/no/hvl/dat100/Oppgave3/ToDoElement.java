package no.hvl.dat100.Oppgave3;

public class ToDoElement {
    private String beskrivelse;
    private int nummer;
    private int prioritet;

    public ToDoElement(String beskrivelse, int nummer, int prioritet) {
        this.beskrivelse = beskrivelse;
        this.nummer = nummer;
        this.prioritet = prioritet;
    }
    // Get/Set
    public String getBeskrivelse() {return beskrivelse;}
    public int getNummer() {return nummer;}
    public int getPrioritet() {return prioritet;}

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
    public void setPrioritet(int prioritet) {
        this.prioritet = prioritet;
    }
    // Metode
        public String toString() {
        String ut = beskrivelse + "\n" + String.format("%-10s", "Nummer") + ": " + nummer + "\n" + String.format("%-10s", "Prioritet") + ": " + prioritet;
        return ut;

    }
}
