package no.hvl.dat100.Oppg2;

public class Main {
    public static void main(String[] args) {
        Kommune K1 = new Kommune("Bergen", 435.32, 300000);
        Kommune K2 = new Kommune("Gloppen", 102.32, 6000);

        KSamling KS = new KSamling(5);

        KS.leggTil(K1);
        KS.leggTil(K2);

        System.out.println(K1.tetthet());
        System.out.println(K2.tetthet());

        Kommune K3 = KS.tettestBefolket();
        System.out.println(K3.toString());
    }
}
