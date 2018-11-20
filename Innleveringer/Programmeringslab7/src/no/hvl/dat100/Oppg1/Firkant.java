package no.hvl.dat100;

public class Firkant implements Kontrakt {

    public void tegnOpp() {
        int i = 5;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
