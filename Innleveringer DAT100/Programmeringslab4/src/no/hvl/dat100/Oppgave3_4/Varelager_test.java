package no.hvl.dat100.Oppgave3_4;

public class Varelager_test {
    public static void main(String[] args) {
        // 3 typer varer og eit varelager med plass til 10
        Vare v1 = new Vare(555, "Sjokolade", 13.59);
        Vare v2 = new Vare(666, "Ananas", 66.66);
        Vare v3 = new Vare(777, "Cola", 19.99);
        Vare v4 = new Vare(888, "Pepsi", 18.99);
        Vare v5 = new Vare(999, "Baguette", 40);
        Varelager VL1 = new Varelager(10);

        // Legger 5 varer til i lageret
        VL1.leggTil(v1);
        VL1.leggTil(v2);
        VL1.leggTil(v3);
        VL1.leggTil(v4);
        VL1.leggTil(v5);

        // Varer i lageret
        VL1.lagerPrint();
        System.out.print("Total pris: " + String.format("%1$42s", VL1.totalPris()));

        //Slett Ananas;
        VL1.slett(666);
        System.out.println();

        // Varer i lageret etter sletting
        VL1.lagerPrint();
        System.out.print("Total pris: " + String.format("%1$42s", VL1.totalPris()));

        //Grensesnitt.lesFlereVarer(VL1);
    }
}

