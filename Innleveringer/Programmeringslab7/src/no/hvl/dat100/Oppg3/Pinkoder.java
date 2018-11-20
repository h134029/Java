package no.hvl.dat100.Oppg3;

import java.util.*;

public class Pinkoder {
    private HashMap<Integer, Integer> pinkoder;

    public Pinkoder() {
        pinkoder = new HashMap<>();
    }
    public void registrerPinkode(Integer kortnummer, Integer pinkode) {
        pinkoder.put(kortnummer,pinkode);
    }
    public boolean sjekkPinkode(Integer kortnummer, Integer pinkode) {
        return pinkoder.containsKey(kortnummer) && pinkoder.containsValue(pinkode);
    }
}