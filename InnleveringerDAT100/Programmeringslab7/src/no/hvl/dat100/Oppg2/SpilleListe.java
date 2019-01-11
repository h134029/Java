package no.hvl.dat100.Oppg2temp;

import java.util.*;

public class SpilleListe {

    private ArrayList<Sang> sanger;

    public SpilleListe() {
        sanger = new ArrayList<Sang>();
    }
    public void leggTil(Sang sang) {
        sanger.add(sang);
    }
    public boolean leggTilSjekk(Sang sang) {

        // Metoden indexOf return index, -1 if not found
        int i = sanger.indexOf(sang);

        if (i > 0) {
            sanger.add(sang);
            return true;
        }
        else return false;
    }
    public void visListe() {
        for (Sang s:sanger) {
            s.skrivUt();
        }
    }
    public ArrayList<Sang> finnSanger(Sjanger sjanger) {

        ArrayList<Sang> temp = new ArrayList<Sang>();
        for (Sang s:sanger) {
            if (s.getGenre() == sjanger) {
                temp.add(s);
            }
        }
        return temp;
    }
}
