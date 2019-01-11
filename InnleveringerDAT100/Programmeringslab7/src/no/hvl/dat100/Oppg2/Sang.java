package no.hvl.dat100.Oppg2temp;

public class Sang {
    private String tittel;
    private int tid;
    private Sjanger genre;

    public Sang(String tittel, int tid, Sjanger genre) {
        this.tittel = tittel;
        this.tid = tid;
        this.genre = genre;
    }
    public Sang() {
        this("",0,null);
    }

    public Sjanger getGenre() {
        return genre;
    }

    public void skrivUt() {
        System.out.println("Tittel: " + tittel + ", Tid: " + tid + ", Genre: " + genre);
    }
    @Override
    public String toString() {
        return ("Tittel: " + tittel + ", Tid: " + tid + ", Genre: " + genre);
    }
}
