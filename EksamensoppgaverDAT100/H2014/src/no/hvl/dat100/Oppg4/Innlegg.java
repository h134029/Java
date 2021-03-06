package no.hvl.dat100.Oppg4;

public class Innlegg {

    private String bruker;
    private String dato;
    private int likes;

    public Innlegg() {
        this("","");
        this.likes = 0;
    }

    public Innlegg(String bruker, String dato) {
        this.bruker = bruker;
        this.dato = dato;
        this.likes = 0;
    }
    // GET/SET
    public String getBruker() { return bruker; }
    public String getDato() { return dato; }
    public int getLikes() { return likes; }

    public void setBruker(String bruker) {
        this.bruker = bruker;
    }
    public void setDato(String dato) {
        this.dato = dato;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    // Metoder

    public void skrivUt() {
        System.out.print("Bruker: " + bruker + ", Dato: " + dato + ", Antall likes: " + likes);
    }
    public void atLike() {
        this.likes += 1;
    }
}
