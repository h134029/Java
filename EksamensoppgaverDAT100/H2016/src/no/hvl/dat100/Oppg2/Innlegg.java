package no.hvl.dat100.Oppg2;

import java.util.ArrayList;
import java.util.Iterator;

public class Innlegg {
    private String tekst;
    private ArrayList<String> tagged;

    public Innlegg(String tekst) {
        this.tekst = tekst;
        tagged = new ArrayList<String>();
    }
    public boolean erTagget(String person) {
        return tagged.contains(person);
    }
    public boolean tag(String person) {
        if (!erTagget(person)) {
            tagged.add(person);
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<String> vennerTagget(String[] venner) {
        ArrayList<String> vennerArray = new ArrayList<String>();

        for (int i = 0; i < venner.length; i++) {
            if (tagged.contains(venner[i])) {
                vennerArray.add(venner[i]);
            }
        }
        return vennerArray;
    }
    public void skrivUt() {
        System.out.println(tekst);

        Iterator iterator = tagged.iterator();
        String tags = "";
        while (iterator.hasNext()) {
            tags += "@" + iterator.next() + " ";
        }

        System.out.println(tags);
    }
}