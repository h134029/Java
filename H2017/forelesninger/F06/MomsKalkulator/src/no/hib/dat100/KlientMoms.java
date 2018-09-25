package no.hib.dat100;

import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

//Sml. F02-MomsKalkulator der all kode var i main-klassen
public class KlientMoms {

	public static void main(String[] args) {
		String tallTxt = showInputDialog("Skriv inn bel�p:");
		double belop = parseDouble(tallTxt);
		/*
		 * Basert p� at bel�pet du oppgir er uten moms (eksl.meravgift) *
		 */

		double moms = MomsKalkulator.beregnMomsAvNetto(belop);// metodekall
		double medMoms = belop + moms;
		String ut1 = "Tolket innlest bel�p uten moms " + format("%8.2f", belop) + "\n" + "Bel�pet med moms blir "
				+ format("%8.2f", medMoms) + " kroner" + "\n" + "Momsen blir " + format("%8.2f", moms) + " kroner";

		showMessageDialog(null, ut1);

		// Basert p� at bel�pet du oppgir er med moms (inkl. meravgift)

		double utenMoms = MomsKalkulator.beregnNetto(belop); // Metodekall
		moms = belop - utenMoms;
		String ut2 = "Tolket innlest bel�p med moms " + format("%8.2f", belop) + "\n" + "Bel�pet uten moms blir  "
				+ format("%8.2f", utenMoms) + " kroner" + "\n" + "Momsen blir  " + format("%4.2f", moms) + " kroner";

		showMessageDialog(null, ut2);
	}
}
