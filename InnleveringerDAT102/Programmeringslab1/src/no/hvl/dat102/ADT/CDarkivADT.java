package no.hvl.dat102.ADT;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDarkivADT {

    /**
     * Returnere en tabell av CD-er
     * @return CD[] objekter
     */
    CD[] hentCdTabell();

    /**
     * Legger til ein ny CD i arkiv klassen
     * @param nyCd CD objekt-peker
     */
    boolean leggTilCd(CD nyCd);

    /**
     * Prompter bruker for CD nummer, sletter gitt CD frå arkivet
     * @param cdNr CD nummer
     * @return returnerer true/false om CD er slettet
     */
    boolean slettCd(int cdNr);

    /**
     * Søker og henter CD-er med en gitt delstreng
     * @param delstreng del av streng i tittel
     * @return CD[] objekter
     */
    CD[] sokTittel(String delstreng);

    /**
     * Søker og henter artister med en gitt delstreng
     * @param delstreng del av streng i artist
     * @return CD[] objekter
     */
    CD[] sokArtist(String delstreng);

    /**
     * Henter antall CD-er for en gitt sjanger
     * @param sjanger kva type musikksjanger
     * @return antall CD objekter
     */
    int antallSjanger(Sjanger sjanger);

    /**
     * Returnerer hvor mange CD er det er
     * @return antall CD objekter
     */
    int antall();

}
