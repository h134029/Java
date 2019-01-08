package no.hvl.dat102;

public class Main {

    public static void main(String[] args) {
	Butikk B1 = new Butikk("Spar", 10);

	B1.leggInnNyVare(555);
	B1.leggInnNyVare(666);
	B1.leggInnNyVare(777);

	B1.salgsVerdi();
    }
}
