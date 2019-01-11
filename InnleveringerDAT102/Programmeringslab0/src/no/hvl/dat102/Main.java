package no.hvl.dat102;

public class Main {

    public static void main(String[] args) {
		Butikk B1 = new Butikk("Spar", 10);
    	Butikk[] btab = new Butikk[10];
    	btab[0] = new Butikk("Coop",10);

		//btab[0].leggInnNyVare(555);
		//B1.leggInnNyVare(666);
		B1.leggInnNyVare(777);

		B1.salgsVerdi();
		//btab[0].salgsVerdi();
		B1.slettVare(777);
		B1.salgsVerdi();

    }
}
