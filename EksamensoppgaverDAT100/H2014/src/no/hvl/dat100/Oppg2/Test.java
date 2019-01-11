package no.hvl.dat100.Oppg2;

public class Test {
    public static void main(String[] args) {
        Bord b1 = new Bord(10, true);
        Bord b2 = new Bord(11, false);
        Bord b3 = new Bord(12, true);
        Bord b4 = new Bord(13, false);
        Bord b5 = new Bord(14, true);
        Bord b6 = new Bord(15, false);
        Bord b7 = new Bord(16, true);
        Bord b8 = new Bord(17, false);
        Bord b9 = new Bord(18, true);
        Bord b10 = new Bord(19, false);

        BordOversikt BO1 = new BordOversikt(10);
        BO1.leggTil(b1);
        BO1.leggTil(b2);
        BO1.leggTil(b3);
        BO1.leggTil(b4);
        BO1.leggTil(b5);
        BO1.leggTil(b6);
        BO1.leggTil(b7);
        BO1.leggTil(b8);
        BO1.leggTil(b9);
        BO1.leggTil(b10);

        System.out.println(BO1.antallLedige());
        System.out.println(BO1.finnForsteLedige(8));
        System.out.println(BO1.passerBest(13));

    }

}
