package no.hvl.dat100;

public class Main {
    public static void main(String[] args) {
        Epost e1 = new Epost("Olav","Du har bestått","Kødda!",10,11);

        Epost e2 = new Epost("Ivar","Du liker musikk","Veldig",4,10);
        e2.setDag(5);
        e2.setTil("Olav");
        System.out.println(e2.getDag());
        System.out.println(e2.toString());
        System.out.println(e2.lengde());
        System.out.println(e1.harSammeMottaker(e2));
        System.out.println(e1.compareTo(e2));


    }
}