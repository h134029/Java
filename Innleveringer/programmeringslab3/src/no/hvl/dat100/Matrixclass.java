package no.hvl.dat100;

public class Matrixclass {
    public static int[][] matrixbuilder(int row, int col) {
        int[][] newArr = new int[row][col];
        int k = 0;
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                newArr[i][j] = k;
                k++;
            }
        }
        return newArr;
    }
    // Double for loop
    public static void printmatrixv1(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String str = String.format("%-15s", "[" + i + "|" + j + "] - " + arr[i][j]);
                System.out.print(str);
            }
            System.out.println();
        }
    }
    // For loop with for each loop
    public static void printmatrixv2(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            for (int value: arr[i]) {
                String str = String.format("%-15s", "[" + i + "|" + j + "] - " + value);
                System.out.print(str);
                j++;
            }
            System.out.println();
        }
    }
    // Double for each loop
    public static void printmatrixv3(int[][] arr) {
        int i = 0;
        for (int[] row: arr) {
            int j = 0;
            for (int value : row) {
                String str = String.format("%-15s", "[" + i + "|" + j + "] - " + value);
                System.out.print(str);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
