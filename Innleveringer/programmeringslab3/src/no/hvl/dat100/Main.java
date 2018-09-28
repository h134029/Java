package no.hvl.dat100;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,4,8,10};

        int[] c = Arrayclass.merge(a,b);

        for (int i: c)
            System.out.print(i + " ");


    }

}
