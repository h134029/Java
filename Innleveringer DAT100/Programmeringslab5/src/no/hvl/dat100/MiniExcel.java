package no.hvl.dat100;

public class MiniExcel {
    private static int[][] data = { { 1, 2, 0 }, { 3, 4, 0 }, { 5, 6, 0 }, { 0, 0, 0 } };

    public static void skrivUt() {

        System.out.println("-----");

        // TODO - START
        for (int[] i:data) {
            for (int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // TODO _END

        System.out.println("-----");
    }

    public static void beregnSum() {

        // TODO - START
        System.out.println("-------");
        for (int i = 0; i < data.length; i++) {
            int k = 0;
            int n = -1;
            for (int j = 0; j < data[i].length + 1; j++) {
                try {
                    k += data[i][j];
                    System.out.print(data[i][j] + " ");
                }
                catch(Exception e) {
                    System.out.print(k);

                }

            }
            System.out.println();
        }

        // TODO - END


        // TODO - START
        for (int j = 0; j < data[j].length; j++) {
            int k = 0;
            for (int i = 0; i < data.length; i++) {
                k += data[i][j];
            }
            System.out.print(k + " ");
        }
        System.out.println();



        // TODO - END
        System.out.println("-------");

    }

    public static void main(String args[]) {

        skrivUt();

        beregnSum();

        skrivUt();
    }
}
