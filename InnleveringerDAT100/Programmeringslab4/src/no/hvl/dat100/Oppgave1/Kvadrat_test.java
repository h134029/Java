package no.hvl.dat100.Oppgave1;

public class Kvadrat_test {
    public static void main(String[] args) {

        Kvadrat kv3 = new Kvadrat(3);
        Kvadrat kv4 = new Kvadrat(4);
        Kvadrat kv5 = new Kvadrat(5);

        // Kv 3
        kv3.PrintInfo();
        kv3.Tegne();
        System.out.println();

        // Kv 4
        kv4.PrintInfo();
        kv4.Tegne();
        System.out.println();

        // Kv 5
        kv5.PrintInfo();
        kv5.Tegne();
        System.out.println();

        // Sum
        System.out.println(kv5.sum(kv3, kv4));
    }
}
