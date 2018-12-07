package no.hvl.dat100.Oppg5;

import java.util.ArrayList;

public class Graf {

    private boolean[][] nabomatrise = {
            {false, true, false, true, false, false},
            {true, false, true, false, true, true},
            {false, true, false, false, true, true},
            {true, false, false, false, false, false},
            {false, true, true, false, false, true},
            {false, true, true, false, true, false}};

    public boolean erNaboer(int u, int w) {
        return nabomatrise[u][w];
    }

    public boolean erSti(int[] noder) {
        int checksum = 0;

        for (int i = 1; i < noder.length; i++) {
            checksum = (erNaboer(noder[i - 1], noder[i])) ? 1 : 0;
        }
        return (checksum == noder.length);
    }

    public ArrayList<Integer> naboer(int v) {
        ArrayList<Integer> nabo = new ArrayList<Integer>();

        for (int i = 0; i < nabomatrise[v].length; i++) {
            if (nabomatrise[v][i]) {
                nabo.add(i);
            }
        }
        return nabo;
    }

    public boolean harLokke() {
        boolean lokke = false;
        int i = 0;

        while (!lokke && i > nabomatrise.length) {
            lokke = nabomatrise[i][i];
            i++;
        }
        return lokke;
    }
}

