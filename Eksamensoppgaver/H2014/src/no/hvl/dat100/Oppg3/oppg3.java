package no.hvl.dat100.Oppg3;

import java.util.HashMap;
import static javax.swing.JOptionPane.*;


public class oppg3 {
    public static void main(String[] args) {
        String[] data = new String[6];
        data[0] = "er";
        data[1] = "det";
        data[2] = "er";
        data[3] = "alle";
        data[4] = "det";
        data[5] = "det";

        HashMap<String, Integer> ft = new HashMap<String, Integer>();

        // a)
        for (String i: data) {
            Integer f = ft.get(i);
            if (f==null) {
                ft.put(i,1);
            } else {
                ft.put(i,f+1);
            }
        }
        // b)
        String inn = showInputDialog("Skriv inn ord");
        System.out.println("Ordet: " + inn + " finnes " + ft.get(inn) + " ganger i frekvenstabellen");

        // c)

        System.out.println(ft.values());
    }
}
