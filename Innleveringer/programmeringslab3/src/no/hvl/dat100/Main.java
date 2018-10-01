package no.hvl.dat100;

public class Main {
    public static void main(String[] args) {
        int[] a = {5,4,3,4,1,1,10,15};
        int[] b = {1,2,3,4,5};

        int[] c = Arrayclass.mergesort(a,b);
        Arrayclass.arrayprint(a);
        System.out.println();
        Arrayclass.arrayprint(c);
        System.out.println();

        int[] e = Arrayclass.arraybuilder(10000000);
        Arrayclass.arraytimer(e);
    }
}
