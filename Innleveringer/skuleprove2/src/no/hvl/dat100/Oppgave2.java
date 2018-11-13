package no.hvl.dat100;

public class Oppgave2 {
    public static void metodeA(int x) {
        if (x < 0) {
            throw new ArithmeticException("X er negativ");
        }else {
            System.out.print(x + " ");
        }
    }

    public static void metodeB() {
        int[] tab = {0, 1, -1, 2, 3};

        int x = 0;

        try {
            for (int i = 0; i < tab.length; i++) {
                x = i;
                metodeA(tab[i]);
            }
        }catch (ArithmeticException exception) {
            System.out.println();
            System.out.println(tab[x]);
        }finally {
            System.out.println("x = " + x);
        }
    }
    public static void main(String[] args) {
        metodeB();
    }
}
