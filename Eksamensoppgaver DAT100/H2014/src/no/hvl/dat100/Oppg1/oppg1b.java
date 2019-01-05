package no.hvl.dat100.Oppg1;

public class oppg1b {
    public static int b(int x, int y) {

        while (x != y) {
            System.out.println("x = " + x + ", y = " + y);
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(b(28,12));
    }
}
