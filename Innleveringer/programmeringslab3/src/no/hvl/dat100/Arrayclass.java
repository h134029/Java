package no.hvl.dat100;

import java.util.Arrays;


public class Arrayclass {
    // Oppgåve 2
    // a) Merge sort array
    public static int[] merge(int[] arr1,int[] arr2) {
        int i = arr1.length-1;
        int j = arr2.length-1;
        int[] newArr = new int[i + j + 2];
        int k = newArr.length;

        int[] a = arr1;
        int[] b = arr2;

        Arrays.sort(a);
        Arrays.sort(b);

        while(k>0)
            newArr[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];

        return newArr;
    }
    // bc) boolean equals
    public static boolean equals(int[] arr1, int[] arr2) {
        boolean val = Arrays.equals(arr1, arr2);
        return val;
    }

}
