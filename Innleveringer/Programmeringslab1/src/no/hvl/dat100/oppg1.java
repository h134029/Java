package no.hvl.dat100;

// Can replace "System" in the print line
//import static java.lang.System.*;

public class oppg1 {

    public static void main(String[] args) {

        int x = 8;
        int y = 9;
        int z = 10;

        int hx = x;
        int hy = y;

        x = z;
        y = hx;
        z = hy;

        System.out.println("Ny x verdi:" + x);
        System.out.println("Ny y verdi:" + y);
        System.out.println("Ny z verdi:" + z);
    }
}
