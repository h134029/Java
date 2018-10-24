package no.hvl.dat100.Oppgave2;

public class Konto_test {
    public static void main(String[] args) {
        Konto k1 = new Konto("3705.01.0001", 1000);
        Konto k2 = new Konto("3705.01.0002", 10000);
        Konto k3 = new Konto("3705.01.0003", 100000);

        // Innskudd
        // Konto 1
        System.out.println("Etter Innskudd:");
        k1.setInnPenger(10000);
        System.out.println(k1.getSaldo());
        // Konto 2
        k2.setInnPenger(10000);
        System.out.println(k2.getSaldo());
        // Konto 3
        k3.setInnPenger(10000);
        System.out.println(k3.getSaldo());

        // Uttak
        // Konto 1
        System.out.println("Etter Uttak:");
        k1.taUtPenger(5000);
        System.out.println(k1.getSaldo());
        // Konto 2
        k2.taUtPenger(5000);
        System.out.println(k2.getSaldo());
        // Konto 3
        k3.taUtPenger(5000);
        System.out.println(k3.getSaldo());

        // Samlet saldo
        System.out.println("Samlet saldo:");
        System.out.println(k1.getSaldo() + k2.getSaldo() + k3.getSaldo());
    }
}
