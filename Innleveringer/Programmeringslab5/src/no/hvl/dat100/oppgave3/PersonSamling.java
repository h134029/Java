package no.hvl.dat100.oppgave3;

public class PersonSamling extends Person{

    private final static int STDK = 100;
    private int antall;
    private Person[] samling; // Usortert

    public PersonSamling() {
        this(STDK);
    }
    public PersonSamling(int startKapasitet) {
        samling = new Person[startKapasitet];
        antall = 0;
    }
    public void leggTil(Person p) {
        if (antall < samling.length) {
            samling[antall] = p;
            antall++;
        } else { // over startkapasitet, lager ny samling[startKapasitet*2]
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
    }
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
    public Person eldst() {
        int storst = 0;
        for (int i = 1; i < antall; i++) {
            storst = (samling[i].getFoedselsaar() < samling[storst].getFoedselsaar()) ? i : storst;
        }
        return samling[storst];
    }
    public void statistikk() {
        int kvinner = 0;
        int menn = 0;
        int student = 0;
        int larer = 0;

        for (int i = 0; i < antall; i++) {
            kvinner += (samling[i].kjoenn == 'F') ? 1 : 0;
            menn += (samling[i].kjoenn == 'M') ? 1 : 0;
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
}
