package no.hvl.dat100;

public class KlientStudent {

	public static void main(String[] args) {
		
		/* Oppretter et tomt student-objekt
		 * som f�r default-verdier
		 */
		 Student s1;
		 s1 = new Student();
		//Tildeling av verdier. Vi kan ikke lenger gj�re slik. Husk objektvariable er n� private
		/*
		 s1.studentNr = 141618;
		 s1.fornavn = "Malin";
		 s1.etternavn = "Dal";
		 */
		 //Vi m� bruke set-metode.
		 s1.setStudNr(141618);
		 s1.setFornavn("Malin");
		 s1.setEtternavn("Dal");
		 
		 //Utskrift. Vi kan ikke lenger gj�re det slik. Husk private objektvariable er n� private
		 /*
		  System.out.println(s1.studentNr + ": " + s1.etternavn);
		  System.out.println();
		  System.out.println(s1);
		  */
		 //Vi m� bruke get-metode
		  System.out.println(s1.getStudNr() + ": " + s1.getEtternavn());
		  
		  //Utskrift p� en annen m�te
		  System.out.println(s1);		 		

	}

}
