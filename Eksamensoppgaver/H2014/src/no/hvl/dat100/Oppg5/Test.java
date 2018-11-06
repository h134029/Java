package no.hvl.dat100.Oppg5;

public class Test {

    private static boolean[][] test = {  {false, false, false},
                                            {false, true, true},
                                            {false, false, true}};

    public static void main(String[] args) {
        Login.skrivUt();
        System.out.println(Login.erMed(1,1));
        System.out.println(Login.sjekkMonster(test));
    }

}
