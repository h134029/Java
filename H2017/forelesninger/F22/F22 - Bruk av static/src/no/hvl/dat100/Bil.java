package no.hvl.dat100;

/*
 * Ein statisk metode (klassemetode) kan berre bruke statiske variable,
 * statiske metodar og eventuelle parametrar.
 */
public class Bil {
	private static int nesteNummer = 1;
	
	private int id;
	private String regNr;
	
	public Bil(String regNr) {
		id = nesteNummer;
		nesteNummer++;
		this.regNr = regNr;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + ", RegNr: " + regNr + ", Nestenummer: " + nesteNummer;
	}

	public static void tullEn() {
		// Ikkje lov � kalle objektmetode fr� statisk metode eller bruke objektvariablar
		// tullTo();
	}
	
	public void tullTo() {
		// Lov � kalle statisk metode fr� objektmetode
		tullEn();
	}
	
	public static int nesteNr() {
		// kan kalle static metode fra ein staticmetode
		tullEn();
		return nesteNummer;
	}
}