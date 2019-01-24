package no.hvl.dat102.OPPG4.TabellStabelUtenUnntak.klient;

import no.hvl.dat102.OPPG4.TabellStabelUtenUnntak.TabellStabelUtenUnntak;

public class StabelKlientUtenUnntak {
	public static void main(String[] args){
		
		String str = "netsket re etteD";
		int lengde = str.length();
		TabellStabelUtenUnntak<Character>tegnStabel = new TabellStabelUtenUnntak<Character>();
		for(int i = 0; i < lengde; i++){
			tegnStabel.push(new Character(str.charAt(i)));
		}
		System.out.println(str);
		while(!tegnStabel.erTom()){
			Character tegn = tegnStabel.pop();
			System.out.print(tegn);
		}
		System.out.println();		
	}


}// class
