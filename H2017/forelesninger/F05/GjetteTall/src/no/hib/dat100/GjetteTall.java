package no.hib.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
//En feil i den som ligger p� bokens side
public class GjetteTall {

	public static void main(String[] args) {
		int laveste = 0, hoyeste = 1000;
		String melding = "Tenk p� et tall i omr�det " + laveste + " -- " + hoyeste + ".";
		showMessageDialog(null, melding);
		int tall = (laveste + hoyeste) / 2;
		boolean riktigGjettet = false;

		while (!riktigGjettet) {
			melding = "Tenkte du p� " + tall + "? " + "Skriv 0 for ja, -1 hvis for h�yt, " + "1 hvis for lavt:";
			int svar = parseInt(showInputDialog(melding));

			if (svar == 0) {
				riktigGjettet = true;
			} else if (svar == -1) {
				hoyeste = tall - 1;
			} else {
				laveste = tall + 1;
			}
			if (laveste == hoyeste) { 
				riktigGjettet = true;
			} 
				tall = (laveste + hoyeste) / 2; // Modifisert
			} // while

		melding = "Du tenkte p� " + tall + "!";
		showMessageDialog(null, melding);
	}

}
