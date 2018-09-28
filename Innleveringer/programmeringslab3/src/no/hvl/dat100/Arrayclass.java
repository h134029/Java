package no.hvl.dat100;

public class Arrayclass {
    // Oppgåve 2
    // a)
    public static int[] merge(int[] arr1,int[] arr2) {
        int i = arr1.length-1;
        int j = arr2.length-1;
        int[] newArr = new int[i + j + 2];
        int k = newArr.length;

        while (k > 0)
            newArr[--k] = (j < 0 || (i >= 0 && arr1[i] >= arr2[j])) ? arr1[i--] : arr2[j--];
        return newArr;
    }
}
