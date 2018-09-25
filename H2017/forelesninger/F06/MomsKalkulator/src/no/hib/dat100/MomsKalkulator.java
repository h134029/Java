package no.hib.dat100;

public class MomsKalkulator {
	/* Formler
	 * Netto er bel�p uten moms
	 * Brutto er bel�p med moms
	 * 1. Moms = Netto*MVA/100
	 * 2. Brutto = Netto + Moms
	 * Innsatt for Moms i ligning 2 f�r vi:
	 * Brutto = Netto + Netto*MVA/100 
	 *         = Netto(1 + MVA/100)		 * 
	 * => Netto = Brutto/(1 + MVA/100)
	 */
	
	final static double MVA = 25.0;
	final static double FAKTOR = 1 + MVA/100;
	
	static double beregnMomsAvNetto(double belop){
	   // Basert p� at bel�pet du oppgir er uten moms (eksl.meravgift)		
	       return (belop*MVA/100);
	 }
	
	static double beregnNetto(double belop){
		// Basert p� at bel�pet du oppgir er med moms (inkl. meravgift)	
		  return (belop/FAKTOR);
	}
}
