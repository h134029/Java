package no.hvl.dat100.Oppg2;

public class Main {

    public static void main(String[] args) {
        Flyavgang A1 = new Flyavgang(544,"Bergen","17:40",'o');
        Flyavgang A2 = new Flyavgang(634, "Trondheim","13:50",'b');
        Flyavgang A3 = new Flyavgang(350,"Oslo","15:00",'c');

        Flyavganger FA = new Flyavganger(10);

        FA.settinn(A1);
        FA.settinn(A2);
        FA.settinn(A3);

        FA.visinfo();

        FA.setStatus(544,'g');
        System.out.println(FA.antall());
        FA.slett(544);
        System.out.println();
        FA.visinfo();
    }
}
