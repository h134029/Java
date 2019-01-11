package no.hvl.dat102;

import java.util.Random;

public class KladdOppg {
    public static void main(String[] args) {
        final int n = 100;
        int[] tab = new int[n];
        int[] sum = new int[n];
        Random tilf = new Random();

        int j = 0;
        for(int i=0;i<n;i++){
            tab[i] = tilf.nextInt(100);
            sum[i] = sum[i-j] + tab[i];
            j=1;
            System.out.println("Linje: " + i + " " + sum[i]);

        }
        // TUNGVINT
        //for(int j=0;j<n;j++){
        //    sum[j] = 0;
        //    for(int i=0;i<=j;i++){
        //        sum[j] = sum[j] + tab[i];
        //    }
        //}
    }
}
