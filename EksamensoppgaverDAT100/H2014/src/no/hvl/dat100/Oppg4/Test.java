package no.hvl.dat100.Oppg4;

public class Test {
    public static void main(String[] args) {
        Innlegg Post1 = new Bilde("Olav","06.11.2018","www.bilde.com");
        Innlegg Post2 = new Tekst("Olav","06.11.2018","Lorem Ipsum");

        Post1.skrivUt();
        System.out.println();
        Post2.atLike();
        Post2.skrivUt();
    }
}
