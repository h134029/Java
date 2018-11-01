package no.hvl.dat100;

public class Test {
    public static void main(String[] args) {

        Person P1 = new Student(134029,"DAT-B", "Fortun", "Olav",1010011900);
        Person P2 = new Student(135039, "INF-B", "Midttun", "Espen",1010011800);
        Person P3 = new Laerer(35000,370540,"Mjaanes", "Jan",1010011700);
        Person P4 = new Laerer(45000, 370530, "Nordli", "Kari",1010011600);
        Person P5 = new Student(263023, "DAT-B","Eitungjerde", "Sara",1010011500);
        Person P6 = new Student(324392, "HETK", "Vereide", "Torbjorn",1010011400);
        Person P7 = new Student(124499, "DAT-A", "Ommedal", "Stian",1010011300);
        Person P8 = new Student(132399, "PSYK-B", "Geithus", "Fartein",1010011200);
        Person P9 = new Student(443322, "OKADM", "Moe", "Mathias",1010011100);
        Person P10 = new Student(123987, "INF-A", "Hole", "Maria",1010011000);

        Person[] tab = new Person[10];
        tab[0] = new Student();
        tab[1] = new Laerer(35000,370540,"Mjaanes", "Jan",1010011700);



        PersonSamling PS1 = new PersonSamling(5);
        PS1.leggTilUtvid(P1);
        PS1.leggTilUtvid(P2);
        PS1.leggTilUtvid(P3);
        PS1.leggTilUtvid(P4);
        PS1.leggTilUtvid(P5);
        PS1.leggTilUtvid(P6);
        PS1.leggTilUtvid(P7);
        PS1.leggTilUtvid(P8);
        PS1.leggTilUtvid(P9);
        //PS1.leggTilUtvid(P10);


        System.out.println(PS1.finnes(P10));
        System.out.println(P9.getFoedselsnummer());
        System.out.println(P9.foedselsnummer);

        //Filer.skriv(PS1,"personer.dat");
        PersonSamling test = Filer.les("personer.dat");

        //test.skrivut();



    }
}
