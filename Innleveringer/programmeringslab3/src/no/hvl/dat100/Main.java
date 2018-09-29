package no.hvl.dat100;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,4,5};

        int[] c = Arrayclass.merge(a,b);

        for (int i: c)
            System.out.print(i + " ");
        System.out.println();
        System.out.print(Arrayclass.equals(a, b));

        int[][] terreng = { { 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
                            { 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
                            { 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 } };
        System.out.print(terreng[2][9]);
    }

}
