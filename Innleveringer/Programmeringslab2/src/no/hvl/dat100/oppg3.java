package no.hvl.dat100;

public class oppg3 {
    public static long fakultet(int n) {
        long x = 1;
        for(int faktor = 2; faktor <= n; faktor++) {
            x *= faktor;
        }
        return(x);
    }
}
