package no.hvl.dat100;

public class Oppgave1 {

    public static String c(int kode) {
        String svar;

        switch (kode) {
            case 1:
                svar = "kontor";
                break;
            case 2:
                svar = "klasserom";
                break;
            case 3:
                svar = "møterom";
                break;
            default:
                svar = "ukjent";
        }
        return svar;
    }

    public static void main(String[] args) {
        System.out.println(c(2));
        System.out.println(c(5));

        int b = 0;

        for (int i = 0; i < 5; i++) {
            b = 1-b;
            System.out.print(b);
        }
    }
}
