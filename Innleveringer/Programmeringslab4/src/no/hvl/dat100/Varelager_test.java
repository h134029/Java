package no.hvl.dat100;

public class Varelager_test {
    public static void main(String[] args) {
        // 3 typer varer og eit varelager med plass til 10
        Vare v1 = new Vare(555,"Sjokolade",13.59);
        Vare v2 = new Vare(666,"Ananas",66.66);
        Vare v3 = new Vare(777, "Cola",19.99);
        Varelager VL1 = new Varelager(10);

        // Legger 5 varer til i lageret
        VL1.leggTil(v1);
        VL1.leggTil(v1);
        VL1.leggTil(v3);
        VL1.leggTil(v2);
        VL1.leggTil(v1);

        // Varer i lageret
        VL1.lagerPrint();
        System.out.print("Total pris: " + String.format("%1$42s", VL1.totalPris()));

        // Slett Sjokolade
        VL1.slett(555);
        System.out.println();

        // Varer i lageret etter sletting
        VL1.lagerPrint();
        System.out.print("Total pris: " + String.format("%1$42s", VL1.totalPris()));

        System.out.println();

    }
}
