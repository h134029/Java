package no.hvl.dat100.oppgave3;

public class Test {
    public static void main(String[] args) {

        Person[] tabell = new Person[4];
        tabell[0] = new Student(134029,"DAT-B", "Fortun", "Olav", 14081990,'M');
        tabell[1] = new Student(135039, "INF-B", "Midttun", "Espen", 27091990,'M');
        tabell[2] = new Laerer(35000,370540,"Mjaanes", "Jan", 24051970, 'M');
        tabell[3] = new Laerer(45000, 370530, "Nordli", "Kari", 14061985, 'F');

        for (Person i:tabell) {
            System.out.println(i);
        }
    }
}
