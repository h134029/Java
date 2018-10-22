package no.hvl.dat100;

public class Main {

    public static void main(String[] args) {
        //Student s1 = new Student();
        //s1.studNr = 134029;
        //s1.fornavn = "Olav";
        //s1.etternavn = "Fortun";
        //Student s2 = s1;
        //s2.etternavn = "Bruun";
        //System.out.print(s1.studNr + " " + s1.fornavn + " " + s1.etternavn);

        String tekst = "Et ord, men ikkje meir";
        String regex = "(\\.|, | |\n)+";
        String[] ordTab = tekst.split(regex);
        int antallTegn = 0;
        for (int i = 0; i < ordTab.length; i++) {
            String ord = ordTab[i];
            antallTegn += ord.length();
            System.out.println(ord + ": " + ord.length());

        }
        int snitt = antallTegn / ordTab.length;
        System.out.print("Gj. snittleg ordlengde: " + snitt);
    }
}

