package no.hvl.dat102.OPPG4.Karakter;

/**
 * Feilhåndtering for karakter.
 *
 * @author Ole Olsen
 */
public class FeilKarakterException extends Exception {

    /**
     * Lager et nytt unntak.
     *
     * @param melding
     *            melding
     */
    public FeilKarakterException(String melding) {
        super(melding);
    }
}