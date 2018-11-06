package no.hvl.dat100.Oppg1;

public class oppg1d {
    public static double f(int a, double b) {
        return a - b;
    }
    public static double f(double a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        System.out.println(f(4.0, 7));
    }
}
