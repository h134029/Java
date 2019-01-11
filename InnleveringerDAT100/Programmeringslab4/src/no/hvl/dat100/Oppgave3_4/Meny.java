package no.hvl.dat100.Oppgave3_4;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

public class Meny {
    private Varelager varereg;
    private Grensesnitt gr;

    public Meny(Varelager varereg) {
        gr = new Grensesnitt();
        this.varereg = varereg;
    }

    public void start() {
        System.out.println(" Meny");
        System.out.println(" 1 - Registrer");
        System.out.println(" 2 - Søk");
        System.out.println(" 3 - Slett");
        System.out.println(" 4 - VisAlle");
        System.out.println(" 5 - VisAlleSortert");
        System.out.println(" 9 - Avslutt");

        int nr = -1;
        int kode = -1;
        Vare vare = null;
        do {
            String tallTxt = showInputDialog("Kode");
            kode = parseInt(tallTxt);

            switch (kode) {
                case 1:
                    gr.lesFlereVarer(varereg);
                    break;

                case 2:
                    tallTxt = showInputDialog("Oppgi varenr med samme antall sifre");
                    nr = parseInt(tallTxt);
                    vare = varereg.sok(nr);
                    if (vare == null) {
                        System.out.println("Varen er ikke registerert");
                    } else {
                        System.out.println("Varen som ble søkt etter:");
                        gr.skrivVare(vare);
                    }
                    break;

                case 3:
                    tallTxt = showInputDialog("Oppgi varenr");
                    nr = parseInt(tallTxt);
                    vare = varereg.slett(nr);
                    if (vare == null) {
                        System.out.println("Varen er ikke registerert");
                    } else {
                        System.out.println("Varen som er slettet:");
                        gr.skrivVare(vare);
                    }
                    break;

                case 4:
                    gr.visAlle(varereg);
                    break;

                case 5:
                    gr.visAlleSortert(varereg);
                    break;

                case 9:
                    System.out.println("\nAvsluttet");
                    break;

                default:
                    System.out.println("Feil kode");
            }
        } while (kode != 9);
    }
}