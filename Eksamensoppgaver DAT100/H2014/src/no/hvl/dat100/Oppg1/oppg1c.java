package no.hvl.dat100.Oppg1;

public class oppg1c {
    public static int c(int x) {
        int i = 0;

        do {
            x = x / 10;
            i++;
            System.out.println("x = " + x);
        }while (x != 0);
        return i;
    }
    public static void main(String[] args) {
        System.out.println(c(32812));
    }
}
