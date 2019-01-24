package no.hvl.dat102.OPPG4.TabellStabelMedUnntak.klient;

import no.hvl.dat102.OPPG4.TabellStabelMedUnntak.TabellStabelMedUnntak;

public class StabelKlientMedUnntak {
	public static void main(String[] args) {

		String str = "netsket re etteD";
		int lengde = str.length();
		TabellStabelMedUnntak<Character> tegnStabel = new TabellStabelMedUnntak<Character>();
		for (int i = 0; i < lengde; i++) {
			tegnStabel.push(new Character(str.charAt(i)));
		}
		System.out.println(str);

		while (!tegnStabel.erTom()) {
			Character tegn = tegnStabel.pop();
			System.out.print(tegn);
		}
		System.out.println();

	}

}// class
