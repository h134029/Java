package no.hvl.dat102;

import no.hvl.dat102.ADT.CDarkivADT;

public class CDarkiv implements CDarkivADT {

    private CD[] cdTabell;
    private int antall;
    private final static int STDK = 20;

    public CDarkiv(int startKapasitet) {
        cdTabell = new CD[startKapasitet];
        antall = 0;
    }
    public CDarkiv() {
        this(STDK);
    }

    public CD[] hentCdTabell() {
        return cdTabell;
    }

    public boolean cdFinnes(int cdNr) {
        boolean funnet = false;
        int teller = 0;

        while(!funnet && teller < antall) {
            funnet = (cdTabell[teller++].getCdnr() == cdNr);
        }
        return funnet;
    }

    public int cdIndex(int cdNr) {
        int index = -1;
        int teller = 0;

        while (index < 0 && teller < antall) {
            index = (cdTabell[teller].getCdnr() == cdNr) ? teller : -1;
            teller++;
        }
        return index;
    }
    private void utvidKapasitet() {
        CD[] hjelpetabell = new CD[(int)Math.ceil(1.1 * antall)];

        for (int i = 0; i < antall; i++) {
            hjelpetabell[i] = cdTabell[i];
        }
        cdTabell = hjelpetabell;

    }

    public boolean leggTilCd(CD nyCd) {
        if (cdFinnes(nyCd.getCdnr())) {
            System.out.println("Error, duplikat CD nummer");
            return false;
        }
        else if (antall == cdTabell.length) {
            utvidKapasitet();
            cdTabell[antall] = nyCd;
            antall++;
            return true;
        }else {
            cdTabell[antall] = nyCd;
            antall++;
            return true;
        }
    }

    public boolean slettCd(int cdNr) {
        if (!cdFinnes(cdNr)) {
            System.out.println("Error, feil CD nummer");
            return false;
        }
        else {

            // Slett og trim null verdier bakerst
            System.out.println("Slettet CD: " + cdTabell[(cdIndex(cdNr))].toString());
            System.out.println();
            cdTabell[(cdIndex(cdNr))] = cdTabell[antall-1];
            cdTabell[antall-1] = null;
            antall--;
            return true;
        }
    }

    public CD[] sokTittel(String delstreng) {
        int teller = 0;

        for (int i = 0; i < antall; i++) {
            teller += (cdTabell[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) ? 1 : 0;
        }

        CD[] delTittel = new CD[teller];
        int j = 0;

        for (int i = 0; i < antall; i++) {
            if (cdTabell[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                delTittel[j++] = cdTabell[i];
            }
        }
        return delTittel;
    }

    public CD[] sokArtist(String delstreng) {
        int teller = 0;

        for (int i = 0; i < antall; i++) {
            teller += (cdTabell[i].getArtist().toLowerCase().contains(delstreng.toLowerCase())) ? 1 : 0;
        }

        CD[] delArtist = new CD[teller];
        int j = 0;

        for (int i = 0; i < antall; i++) {
            if (cdTabell[i].getArtist().toLowerCase().contains(delstreng.toLowerCase())) {
                delArtist[j++] = cdTabell[i];
            }
        }
        return delArtist;
    }

    public int antallSjanger(Sjanger sjanger) {
        int teller = 0;

        for (int i = 0; i < antall; i++) {
            teller += (cdTabell[i].getSjanger() == sjanger) ? 1 : 0;
        }
        return teller;
    }

    public int antall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

}
