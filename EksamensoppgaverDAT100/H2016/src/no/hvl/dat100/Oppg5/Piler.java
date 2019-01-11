package no.hvl.dat100.Oppg5;

public class Piler {

    static boolean[][] ikon= { {false,false,true,false,false},
            {false,false,false,true, false},
            {true,true,true,true,true},
            {false,false,false,true,false},
            {false,false,true,false,false},};

    public boolean erSvart(int r, int k) {
        return ikon[r][k];
    }

    public void vis() {
        String ut = "";
        for (int i = 0; i < ikon.length; i++) {
            for (int j = 0; j < ikon[i].length; j++) {
                ut = (ikon[i][j]) ? "#" : " ";
                System.out.print(ut);
            }
            System.out.println();
        }
    }

    public boolean flestSvarte() {
        int checkSvart = 0;
        int checkHvit = 0;

        for (int i = 0; i < ikon.length; i++) {
            for (int j = 0; j < ikon[i].length; j++) {
                checkSvart = (ikon[i][j]) ? 1 : 0;
                checkHvit = (ikon[i][j]) ? 0 : 1;
            }
        }
        return (checkSvart > checkHvit);
    }

    public boolean[][] inverter() {
        boolean[][] invert = new boolean[ikon.length][ikon[0].length];

        for (int i = 0; i < ikon.length; i++) {
            for (int j = 0; j < ikon[i].length; j++) {
                invert[i][j] = (!ikon[i][j]);
            }
        }
        return invert;
    }

    public boolean[][] speilVend() {
        boolean[][] speil = new boolean[ikon.length][ikon[0].length];

        for (int i = 0; i < ikon.length; i++) {
            for (int j = 0; j < ikon[i].length; j++) {
                speil[i][j] = ikon[i][ikon.length-(1+j)];
            }
        }
        return speil;
    }
}
