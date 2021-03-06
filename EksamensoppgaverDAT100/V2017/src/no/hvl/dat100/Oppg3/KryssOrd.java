package no.hvl.dat100.Oppg3;

import java.util.ArrayList;

public class KryssOrd {

    public static boolean likeLange(String s, String t) {
        return (s.length() == t.length());
    }

    public static boolean matchPos(String s, String t, int p) {
        if (s.charAt(p) == t.charAt(p)) {
            return true;
        } else if (Character.toString(s.charAt(p)) == "*" || Character.toString(t.charAt(p)) == "*") {
            return true;
        } else {
            return false;
        }
    }
    public static boolean matcher(String s, String t) {
        boolean match = true;
        int pos = 0;

        while (match && pos < s.length()) {
            match = matchPos(s, t, pos++);
        }
        return match && likeLange(s, t);
    }

    public static int compareTo(String s, String t) {
        if (s.length() != t.length()) {
            return s.length() - t.length();
        }
        else {
            return s.compareTo(t);
        }
    }
    public static String forsteSomPasser(String monster, ArrayList<String> list) {
        int i = 0;
        boolean funnet = false;
        String s = "";

        while (!funnet && i < list.size()) {
            s = list.get(i);
            funnet = matcher(s, monster);
            i++;
        }
        if (funnet) {return s;}
        else {return null;}
    }
}
