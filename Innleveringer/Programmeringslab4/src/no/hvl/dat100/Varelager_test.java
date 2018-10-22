package no.hvl.dat100;

public class Varelager_test {
    public static void main(String[] args) {
        Vare v1 = new Vare(555,"Sjokolade",13.50);
        Vare v2 = new Vare(666,"Ananas",66.66);
        Vare v3 = new Vare(777, "Cola",19.99);
        Varelager VL1 = new Varelager(10);

        VL1.leggTil(v1);
        VL1.leggTil(v1);
        VL1.leggTil(v3);
        VL1.leggTil(v2);
        VL1.leggTil(v1);
        VL1.leggTil(v2);
        VL1.leggTil(v3);
        VL1.leggTil(v2);
        VL1.leggTil(v1);
        VL1.leggTil(v1);

        VL1.slett(666);
        //int[] a = VL1.finnVare(666);
        //System.out.println(a[0] + ", " + a[1] + ", " + a[2]);
        for (int i=0; i < 10;i++) {
            System.out.println(VL1.samling[i]);
        }
    }
}
