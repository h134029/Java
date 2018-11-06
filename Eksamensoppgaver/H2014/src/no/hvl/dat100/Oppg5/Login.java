package no.hvl.dat100.Oppg5;

public class Login {

    private static boolean[][] monster = {  {true, false, false},
                                            {true, true, true},
                                            {false, false, true}};

    public static boolean erMed(int r, int k) {
        return monster[r][k];
    }

    public static void skrivUt() {
        for (int j = 0; j < monster.length; j++) {
            for (int i = 0; i < monster[j].length; i++) {
                String ut = (monster[j][i]) ? "*" : " ";
                System.out.print(ut);
            }
            System.out.println();
        }
    }

    public static boolean sjekkMonster(boolean[][] mnstr) {
        boolean lik = true;
        int checksum = 0;

        while (lik && checksum < monster.length) {
            for (int j = 0; j < monster.length; j++) {
                for (int i = 0; i < monster[j].length; i++) {
                    if (monster[j][i] != mnstr[j][i]) {lik = false;}
                }
            }
            checksum++;
        }
        return lik;
    }
}
