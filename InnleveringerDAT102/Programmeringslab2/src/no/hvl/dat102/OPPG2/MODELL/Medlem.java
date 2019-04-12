package no.hvl.dat102.OPPG2.MODELL;

import no.hvl.dat102.OPPG2.MENGDE.KJEDET.KjedetMengde;
import java.util.Iterator;

public class Medlem {
    private String navn;
    private KjedetMengde<Hobby> hobbyer;
    private int statusIndeks;

    public Medlem() {
        this("",-1);
    }

    public Medlem (String navn, int statusIndeks) {
        this.navn = navn;
        this.hobbyer = new KjedetMengde<Hobby>();
        this.statusIndeks = statusIndeks;
    }

    //GET/SET
    public int getStatusIndeks() {
        return statusIndeks;
    }
    public KjedetMengde<Hobby> getHobbyer() {
        return hobbyer;
    }
    public String getNavn() {
        return navn;
    }
    public void setStatusIndeks(int statusIndeks) {
        this.statusIndeks = statusIndeks;
    }
    public void setHobbyer(KjedetMengde<Hobby> hobbyer) {
        this.hobbyer = hobbyer;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void skrivUt() {
        Iterator<Hobby> teller = hobbyer.oppramser();

        System.out.println("Navn: " + navn);
        while (teller.hasNext()) {
            System.out.println(teller.next().toString());
        }
        System.out.println("Status: " + statusIndeks);
    }
    public boolean passerTil(Medlem medlem2) {
        return hobbyer.equals(medlem2.getHobbyer());
    }
}
