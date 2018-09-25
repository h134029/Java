package no.hvl.dat100;

public class Klassemetoder {

    public static void skrivStjerner(int antall) {
        for (int i = 1; i <= antall; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void skrivTegn(char tegn, int antall) {
        for (int i = 1; i <= antall; i++) {
            System.out.print(tegn);
        }
        System.out.println();
    }
    // --------------- areal ---------------
    public static double arealRektangel(double bredde, double lengde) {
        return bredde * lengde;
    }
    public static double arealSirkel(double radius) {
        return Math.PI * radius * radius;
    }
    // --------------- temperatur ---------------
    public static double celciusTilfahrenheit(int celc) {
        return (celc - 32) * 5/9;
    }
    public static double fahrenheitTilcelcius(int fahr) {
        return (fahr * 9/5) + 32;
    }
    // --------------- matematikk ---------------
    public static long fakultet(int n) {
        long x = 1;
        for(int faktor = 2; faktor <= n; faktor++) {
            x = x * faktor;
        }
        return(x);
    }
    public static int min(int m, int n) {
        int x = 0;
        if (m>n) {
            x = m;
        }
        if (n>m) {
            x = n;
        }
        return(x);
    }
    public static int min2(int m, int n, int k) {
        int x = 0;
        if (m>n && m>k) {
            x = m;
        }
        if (n>m && n>k) {
            x = n;
        }
        if (k>m && k>n) {
            x = k;
        }
        return(x);
    }
}
