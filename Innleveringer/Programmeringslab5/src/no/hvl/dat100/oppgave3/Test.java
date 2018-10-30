package no.hvl.dat100.oppgave3;

public class Test {
    public static void main(String[] args) {

        Person P1 = new Student(134029,"DAT-B", "Fortun", "Olav", 1990,'M');
        Person P2 = new Student(135039, "INF-B", "Midttun", "Espen", 1991,'M');
        Person P3 = new Laerer(35000,370540,"Mjaanes", "Jan", 1970, 'M');
        Person P4 = new Laerer(45000, 370530, "Nordli", "Kari", 1985, 'F');
        Person P5 = new Student(263023, "DAT-B","Eitungjerde", "Sara", 1994, 'F');
        Person P6 = new Student(324392, "HETK", "Vereide", "Torbjorn", 1989, 'M');
        Person P7 = new Student(124499, "DAT-A", "Ommedal", "Stian", 1986, 'M');
        Person P8 = new Student(132399, "PSYK-B", "Geithus", "Fartein", 1950, 'M');
        Person P9 = new Student(443322, "OKADM", "Moe", "Mathias", 1966, 'F');
        Person P10 = new Student(123987, "INF-A", "Hole", "Maria", 1996, 'F');

        PersonSamling PS1 = new PersonSamling(5);
        PS1.leggTil(P1);
        PS1.leggTil(P2);
        PS1.leggTil(P3);
        PS1.leggTil(P4);
        PS1.leggTil(P5);
        PS1.leggTil(P6);
        PS1.leggTil(P7);
        PS1.leggTil(P8);
        PS1.leggTil(P9);
        PS1.leggTil(P10);

        // Skriv ut alle i PersonSamling PS1
        System.out.println("Personsamling:");
        PS1.skrivut();

        System.out.println();
        System.out.println("Den Eldste Personen:");
        System.out.println(PS1.eldst());

        // Statistikk
        System.out.println();
        PS1.statistikk();
    }
}
