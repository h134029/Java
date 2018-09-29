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

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while(k>0)
            newArr[--k] = (j < 0 || (i >= 0 && arr1[i] >= arr2[j])) ? arr1[i--] : arr2[j--];

        return newArr;
    }
    // bc) boolean equals
    public static boolean equals(int[] arr1, int[] arr2) {
        boolean val = Arrays.equals(arr1, arr2);
        return val;
    }

}
