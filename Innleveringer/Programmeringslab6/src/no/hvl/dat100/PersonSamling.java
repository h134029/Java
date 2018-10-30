package no.hvl.dat100;

public class PersonSamling extends Person{

    private final static int STDK = 20;
    private int antall;
    private Person[] samling; // Usortert

    public PersonSamling() {
        this(STDK);
    }
    public PersonSamling(int startKapasitet) {
        samling = new Person[startKapasitet];
        antall = 0;
    }
    // Get
    public int getAntall() { return antall; }
    public Person[] getSamling() { return samling;
    }
    public boolean leggTilUtvid(Person p) {
        // True/False om vi legger han inn (erLik == False)
        boolean sammePers = false;
        int j = 0;
        while (!sammePers && j < antall) {
            sammePers = (samling[j++].erLik(p));
        }
        if (antall < samling.length && !sammePers) {
            samling[antall] = p;
            antall++;

        // over startkapasitet, lager ny samling[startKapasitet*2]
        } else if (antall >= samling.length && !sammePers){
            Person[] temp = new Person[samling.length * 2];
            // Kopierer samling
            for (int i = 0; i < antall;i++) {
                temp[i] = samling[i];
            }
            // Siste Person det ikkje var plass til
            temp[antall] = p;
            antall++;
            // Ny Samling, fører inn frå temp
            samling = new Person[temp.length];
            for (int i = 0; i < antall; i++) {
                samling[i] = temp[i];
            }
            temp = null;

        }
        return sammePers;
    }

    // Metoder
    public void skrivut() {
        for (int i = 0; i < antall; i++) {
            try {
                System.out.println(samling[i].toString());
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    public void statistikk() {
        int kvinner = 0;
        int menn = 0;
        int student = 0;
        int larer = 0;

        for (int i = 0; i < antall; i++) {
            kvinner += (samling[i].erKvinne()) ? 1 : 0;
            menn += (samling[i].erMann()) ? 1 : 0;
            student += (samling[i] instanceof Student) ? 1 : 0;
            larer += (samling[i] instanceof Laerer) ? 1 : 0;
        }
        System.out.println("Statistikk");
        System.out.println(String.format("%-18s","Kvinner:") + kvinner);
        System.out.println(String.format("%-18s","Menn:") + menn);
        System.out.println(String.format("%-18s","Studenter:") + student);
        System.out.println(String.format("%-18s","Lærere:") + larer);
        System.out.println(String.format("%-17s","Personer totalt:") + (kvinner + menn));
    }
    public int finnPerson(Person p) {
        int index = -1;
        int i = 0;
        while (index < 0) {
            index = (samling[i++].erLik(p)) ? i : -1;
        }
        return index;
    }
    public boolean finnes(Person p) {
        return erLik(p);
    }
    public boolean ledigPlass() {
        boolean erLedig = false;
        int i = 0;
        while (!erLedig && i < samling.length) {
            erLedig = (samling[i++] == null);
        }
        return erLedig;
    }
    public String toString() {
        StringBuilder utBuilder = new StringBuilder();
        utBuilder.append(getAntall());
        utBuilder.append("\n");
        for (int i = 0; i < antall; i++) {
            utBuilder.append(samling[i].toString());
        }
        String ut = utBuilder.toString();
        return ut;
    }
}
