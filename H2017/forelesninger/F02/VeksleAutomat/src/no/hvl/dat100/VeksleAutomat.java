package no.hvl.dat100;
import static javax.swing.JOptionPane.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.*;
public class VeksleAutomat {
/*
 * Vekslingen er begrenset til myntene 20-kroner, 10-kroner og 1-kroner
 * Automaten gir f�rst tilbake s� mange 20-kroner som mulig og s� f�rrest
 * antall 10-kroner og 1-kroner.
 * Basert p� innbetalt bel�p som m� v�re st�rre eller lik pris. Ingen sjekk.
 * 
 * Vi ser p� to m�ter � l�se det p�
 */
	public static void main(String[] args) {
		// pris 86, bel�p 200 gir veksel 114 = 5*20 + 1*10 + 4*1
		String tallTxt = showInputDialog("Skriv inn pris:");
		int pris = parseInt(tallTxt);
		tallTxt = showInputDialog("Skriv inn bel�p:");
		int beloep = parseInt(tallTxt);
		
		int veksel = beloep - pris;
		
		//1. metode
		int ant20kr = veksel/20;
		int ant10kr = (veksel%20)/10;
		int ant1kr =  (veksel%20)%10;
		String ut = veksel + " kr kan veksles i " +
		            ant20kr + " 20-kroner og " +
				    ant10kr + " 10-kroner og " +
		            ant1kr + " 1-kroner";
		showMessageDialog(null,ut);
		
		//2. metode
		int antall20kr = veksel/20;
		int resten = veksel - 20*antall20kr;
		int antall10kr = resten/10;
		int antall1kr = resten - 10*antall10kr;
		String ut2 = veksel + " kr kan veksles i " +
	            antall20kr + " 20-kroner og " +
			    antall10kr + " 10-kroner og " +
	            antall1kr + " 1-kroner";
	showMessageDialog(null,ut2);
		 
	}
}
