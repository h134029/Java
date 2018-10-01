package no.hvl.dat100;

import java.util.Arrays;


public class Arrayclass {
    // Oppgåve 2
    // a) Merge sort array
    public static int[] mergesort(int[] arr1,int[] arr2) {
        int i = arr1.length-1;
        int j = arr2.length-1;
        int[] newArr = new int[i + j + 2];
        int k = newArr.length;

        int[] a = new int[i+1];
        int[] b = new int[j+1];
        // arraycopy to avoid altering entered arrays
        System.arraycopy(arr1,0,a,0,i+1);
        System.arraycopy(arr2,0,b,0,j+1);
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
    // Oppgåve 5
    public static int[] arraybuilder(int i) {
        int[] arr = new int[i];

        while (i >= 1) {
            arr[--i] = (int)(Math.random()+0.5);
        }
        return arr;
    }
    public static void arraytimer(int[] arr) {
        int[] newArr = new int[arr.length];
        // arraycopy to avoid altering entered array
        System.arraycopy(arr,0,newArr,0,arr.length);

        long start_time = System.currentTimeMillis();

        Arrays.sort(newArr);

        long end_time = System.currentTimeMillis();
        long total = end_time-start_time;

        System.out.print(total);
        System.out.println();
    }
    public static void arrayprint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String str = String.format("%-5s", " | " + arr[i]);
            System.out.print(str);
        }
        System.out.println();
    }
}
