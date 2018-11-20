package no.hvl.dat100.Oppg3;

public class Main {
    public static void main(String[] args) {
        Pinkoder PIN = new Pinkoder();

        PIN.registrerPinkode(11223344,1234);
        PIN.registrerPinkode(22334455,2345);
        PIN.registrerPinkode(33445566,3456);
        PIN.registrerPinkode(44556677,4567);
        PIN.registrerPinkode(11223344,2345);

        System.out.println(PIN.sjekkPinkode(11223344,1234));

        //Legger til kortnummer som eksisterer frå før av, metoden returnerer nå false
    }
}
