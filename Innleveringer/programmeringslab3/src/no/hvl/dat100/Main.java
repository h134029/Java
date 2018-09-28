package no.hvl.dat100;

public class Main {
    public static void main(String[] args) {
        int[][] test = Matrixclass.matrixbuilder(4,8);
        int[][] test1 = Matrixclass.matrixbuilder(8,4);
        // Tester

        int[][] test2 = Matrixclass.scale(2, test);

        //int[][] test3 = Matrixclass.mirror(test2);
        Matrixclass.printmatrixv1(test);
        System.out.println();
        Matrixclass.printmatrixv1(test1);
        System.out.println();
        int[][] test4 = Matrixclass.multiply(test, test1);
        Matrixclass.printmatrixv1(test4);

    }

}
