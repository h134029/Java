package no.hvl.dat100.prosjekt;

import static java.lang.Double.*; // parseDouble()

public class GPSDataConverter {

	// arrays for GPS data in the original representation as array of strings
	private String[] timesstr, latitudesstr, longitudesstr, elevationsstr;

	// arrays for GPS data that we would like to transform to
	// public to simplify later code and since get/set methods have not yet been covered in the course
	public int[] times;
	public double[] latitudes, longitudes, elevations;

	public GPSDataConverter(GPSData gpsdata) {

		// initialize the arrays for the original representation
		timesstr = gpsdata.getTimes();
		latitudesstr = gpsdata.getLattitudes();
		longitudesstr = gpsdata.getLongitudes();
		elevationsstr = gpsdata.getElevations();
	}

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
	// skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26

	public static int TIME_STARTINDEX = 11; // startindex for tidspunkt

	public static int toSeconds(String timestr) {

		int secs = 0;
		int hr, min, sec;

		// TODO
		// OPPGAVE - START
		// Kan bruke ZonedDateTime metoden
		// Velger ut kva del av Stringen vi vil ha med substring metoden
		String hrstring = timestr.substring(11, 13);
		String minstring = timestr.substring(14, 16);
		String secstring = timestr.substring(17, 19);
		// Gjere stringen om til Int
		hr = Integer.parseInt(hrstring);
		min = Integer.parseInt(minstring);
		sec = Integer.parseInt(secstring);
		// Ganger ut så metoden returnerer kun sekunder
		secs = (hr * 3600) + (min * 60) + sec;
		// OPPGAVE - SLUTT
		return secs;
	}

	// konverter representation av data fra strenger (String) til tall
	public void convert() {

		// antall GPS datapunkter
		int n = timesstr.length;

		// tabeller for konvertert gps data
		times = new int[n];            // ny tabell for tidsinformasjon i sekunder (int)
		latitudes = new double[n];  // ny tabell for breddegrad (double)
		longitudes = new double[n]; // ny tabell for lengdegrad (double)
		elevations = new double[n]; // ny tabell for høyde (double)

		// tabeller som skal konverteres fra er
		// timesstr, latitudesstr, longitudesstr, elevationsstr erklært først i klassen

		// TODO
		// OPPGAVE - START

		// Hint:
		// iterer igjennom alle gps punkter (hint: bruk en for-løkke)
		// konverter hver inngang gps datapunkt 
		// - tidsinformasjon til sekunder (int) (hint: bruk toSeconds)
		// - breddegrad til double (hint: bruk Double.parseDouble)
		// - lengdegrad til double 
		// - høyde til double
		// sett konvertert data inn på rett plass i den rette tabellen
		for (int i = 0; i < n; i++) {
			times[i] = toSeconds(timesstr[i]); // toSeconds metoden gir oss sekunder inn i den tomme tabellen times
			latitudes[i] = parseDouble(latitudesstr[i]); // parseDouble metoden konverterer string til double
			longitudes[i] = parseDouble(longitudesstr[i]);
			elevations[i] = parseDouble(elevationsstr[i]);
		}
		// END
		// OPPGAVE - SLUTT ;
	}

	// skriv ut konvertert GPS data op formatet:
	// sekunder (breddegrad,lengdegrad) høyde
	public void print() {

		System.out.println("Konvertert GPS Data");
		// TODO
		// OPPGAVE - START
		int n = timesstr.length;
		for (int i = 0; i < n; i++) {
			String out = (times[i] + " (" + latitudes[i] + "," + longitudes[i] + ") " + elevations[i]);
			System.out.println(out);

			// OPPGAVE - SLUTT
		}
	}
}
