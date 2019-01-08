package no.hvl.dat102;

import javax.swing.*;

public class Butikk {
    private String navn;
    private Vare[] samling;
    private int[] lagerStatus;
    private int antallTyper;


    public Butikk(String navn, int STDK) {
        this.navn = navn;
        samling = new Vare[STDK];
        lagerStatus = new int[STDK];
        antallTyper = 0;
    }
    public Butikk() {
        this("",0);
    }
    public int finnVare(int varenr) {
        boolean funnet = false;
        int i = 0;

        while (!funnet && i < antallTyper) {
            funnet = (samling[i++].getVarenr() == varenr);
        }
        return (funnet) ? i : -1;
    }
    public boolean erLedigPlass() {
        return (samling.length != antallTyper);
    }
    public void leggInnNyVare(int varenr) {
        int i = 0;
        boolean plass = false;

        if (erLedigPlass() && finnVare(varenr) < 0) {
            Vare vare = new Vare();
            vare.lesVare(varenr);

            while (!plass && i < samling.length) {
                if (samling[i] == null) {
                    samling[i] = vare;
                    lagerStatus[i] = 0;
                    antallTyper++;
                    plass = true;
                }
                i++;
            }
        } else if (erLedigPlass()) {
            JOptionPane.showMessageDialog(null, "Varen finnes fra før av");
        } else {
            JOptionPane.showMessageDialog(null, "Lageret er fullt");
        }
    }
    public void slettVare(int varenr) {
        if (finnVare(varenr) >= 0) {
            samling[finnVare(varenr)] = samling[antallTyper];
            lagerStatus[finnVare(varenr)] = lagerStatus[antallTyper];
            samling[antallTyper] = null;
            lagerStatus[antallTyper] = 0;
            antallTyper--;
        }
        else {
            JOptionPane.showMessageDialog(null,"Varen finnes ikkje");
        }
    }
    public void detaljSalg(int varenr) {
        if (finnVare(varenr) > 0) {
            lagerStatus[finnVare(varenr)] -= 1;
        }
        else if (finnVare(varenr) == 0) {
            JOptionPane.showMessageDialog(null,"Det er tomt for varen");
        }
        else {
            JOptionPane.showMessageDialog(null, "Varen finnes ikkje");
        }
    }
    public void grossInnkjop(int varenr, int tall) {
        if (finnVare(varenr) > 0 && tall > 0) {
            lagerStatus[finnVare(varenr)] += tall;
        }else if (finnVare(varenr) > 0) {
            JOptionPane.showMessageDialog(null, "Tallet må vere positivt");
        }else {
            JOptionPane.showMessageDialog(null, "Varen finnes ikkje");
        }
    }

    public void salgsVerdi() {
        double lagerVerdi = 0.00;

        for (int i = 0; i < antallTyper; i++) {
            System.out.println(String.format("%1$-5s","Navn: ") + String.format("%1$-15s",samling[i].getNavn()) +
                    String.format("%1$-10s","Varenummer: ") + String.format("%1$-10s",samling[i].getVarenr()) +
                    String.format("%1$-5s","Pris: ") + String.format("%1$-10s",samling[i].getPris()));
            lagerVerdi += samling[i].getPris();
        }
        System.out.print(String.format("%1$49s", "Total lagerverdi: ") + lagerVerdi);
        System.out.println();
    }
}
