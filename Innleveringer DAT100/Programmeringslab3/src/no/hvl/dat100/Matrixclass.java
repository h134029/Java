package no.hvl.dat100;

public class Matrixclass {
    // Oppgåve 1
    // a)
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
    // b) Double for loop
    public static void printmatrixv1(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String str = String.format("%-15s", "[" + i + "|" + j + "] - " + arr[i][j]);
                System.out.print(str);
            }
            System.out.println();
        }
    }
    // c) i) For loop with for each loop
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
    // ii) Double for each loop
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
    // d) Multiply the matrix value
    public static int[][] scale(int tall, int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[i][j]*tall;
            }
        }
        return newArr;
    }
    // e) Mirror (invert i,j index)
    public static int[][] mirror(int [][] arr) {
        if (arr.length != arr[0].length) {
            throw new IllegalArgumentException("Matrisen må vere kvadratisk");
        }
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[j][i];
            }
        }
        return newArr;

    }
    // f) Multiply matrices
    public static int[][] multiply(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2[0].length || arr1[0].length != arr2.length) {
            throw new IllegalArgumentException("Matrise 1 må ha samme antall rader som Matrise 2 har kolonner");
        }

        int[][] newArr = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    newArr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }

        }
        return newArr;
    }
}

