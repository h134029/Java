package no.hvl.dat102.OPPG3;

import no.hvl.dat102.OPPG3.ADT.CDarkivADT;
import no.hvl.dat102.OPPG3.NODE.LinearNode;
import no.hvl.dat102.OPPG1_2.CD;
import no.hvl.dat102.OPPG1_2.Sjanger;

public class CDarkiv2 implements CDarkivADT {

    private int antall;
    private LinearNode<CD> start;

    public CDarkiv2() {
        start = null;
        antall = 0;
    }
    public boolean leggTilCd(CD nyCd) {
        if (finnCd(nyCd.getCdnr()) == null) {
            LinearNode<CD> nyNode = new LinearNode<>(nyCd);
            nyNode.setNeste(start);
            start = nyNode;
            antall++;
            return true;
        }else {
            return false;
        }
    }
    public CD[] hentCdTabell() {
        LinearNode<CD> node = start;
        CD[] cdtab = new CD[antall];

        for (int i = 0; i < antall && node != null; i++) {
            cdtab[i] = node.getElement();
            node = node.getNeste();
        }
        return cdtab;
    }
    public LinearNode<CD> finnCd(int cdNr) {
        LinearNode<CD> node = start;
        LinearNode<CD> riktigNode = null;

        for (int i = 0; i < antall && node != null; i++) {
            if (node.getElement().getCdnr() == cdNr) {
                riktigNode = node;
                break;
            }
            else {
                node = node.getNeste();
            }
        }
        return riktigNode;
    }
    public LinearNode<CD> forrigeCd(int cdNr) {
        LinearNode<CD> node = start;
        LinearNode<CD> forrigeNode = null;
        boolean eksisterer = (finnCd(cdNr) != null);

        for (int i = 0; i < antall && node != null && eksisterer; i++) {
            if (node.getNeste().getElement() != null && node.getNeste().getElement().getCdnr() == cdNr) {
                forrigeNode = node;
                break;
            }
            else if (node.getElement().getCdnr() == cdNr) {
                forrigeNode = node;
                break;
            }
            else {
                node = node.getNeste();
            }
        }
        return forrigeNode;
    }
    public boolean slettCd(int cdNr) {

        LinearNode<CD> slett = finnCd(cdNr);
        LinearNode<CD> forrige = forrigeCd(cdNr);

        boolean slettet = false;

        if (slett != null && forrige != slett) {
            forrige.setNeste(slett.getNeste());
            slett.setNeste(null);
            antall--;
            slettet = true;
            System.out.println("DELETED: " + slett.getElement().toString());
            System.out.println();
        }
        else if (slett != null) {
            start = slett.getNeste();
            slett.setNeste(null);
            antall--;
            slettet = true;
            System.out.println("DELETED: " + slett.getElement().toString());
            System.out.println();
        }
        return slettet;
    }
    public CD[] sokTittel(String delstreng) {
        CD[] delTittel = new CD[antall];
        LinearNode<CD> node = start;
        int i = 0;

        while (i < antall && node != null) {
            if (node.getElement().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                delTittel[i++] = node.getElement();
            }
            node = node.getNeste();
        }
        return delTittel;
    }
    public CD[] sokArtist(String delstreng) {
        CD[] delArtist = new CD[antall];
        LinearNode<CD> node = start;
        int i = 0;

        while (i < antall && node != null) {
            if (node.getElement().getArtist().toLowerCase().contains(delstreng.toLowerCase())) {
                delArtist[i++] = node.getElement();
            }
            node = node.getNeste();
        }
        return delArtist;
    }
    public int antallSjanger(Sjanger sjanger) {
        int antallsjanger = 0;
        LinearNode<CD> node = start;

        for (int i = 0; i < antall; i++) {
            if (node.getElement().getSjanger() == sjanger) {
                antallsjanger++;
            }
            node = node.getNeste();
        }
        return antallsjanger;
    }

    public int antall() {
        return antall;
    }
    public void setAntall(int antall) {
        this.antall = antall;
    }
}
