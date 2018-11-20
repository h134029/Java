package no.hvl.dat100;

public class Main {

    public static void main(String[] args) {

        Object arr[] = new Object[3];
        arr[0] = new Firkant();
        arr[1] = new Bil();
        arr[2] = new Mann();

        //((Firkant) arr[0]).tegnOpp();
        //((Bil) arr[1]).tegnOpp();
        //((Mann) arr[2]).tegnOpp();

        for (Object tegning: arr) {
            tegning.tegnOpp();

        }
    }
}
