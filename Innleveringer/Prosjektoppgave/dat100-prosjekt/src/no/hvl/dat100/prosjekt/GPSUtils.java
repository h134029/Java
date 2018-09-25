package no.hvl.dat100.prosjekt;

import static java.lang.Math.*;

public class GPSUtils {

	public GPSUtils() {
	
	}
	
	// konverter sekunder til string på formen hh:mm:ss
	public static String printTime(int secs) {
		
		String timestr = "";
		String TIMESEP = ":";
		
		// TODO
		// OPPGAVE - START
		// Modulo % gir rest etter fullverdi divisjon (heltall)
		int hr = secs/(60*60);			// Nærmeste avrundet time
		int min = (secs%(60*60)) / 60;	// Nærmeste avrundet minutt (som er rest etter delt på timer)
		int sek = (secs%(60*60)) % 60;	// Rest sekunder etter inndelt timer og minutt

		timestr = String.format("%02d:%02d:%02d", hr, min, sek);

		// OPPGAVE - SLUTT
		return timestr;
	}
	
	// beregn maximum av en tabell av doubles med minnst et element
	public static double findMax(double[] da) {

		double max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	// beregn minimum av en tabell av doubles med minst et element
	public static double findMin(double[] da) {

		// fjern = "0.0" når metoden implementeres for ikke få forkert minimum
		// setter min lik første element i tabellen
		double min = da[0];

		// TODO
		// OPPGAVE - START
		// setter min lik element d kun viss det er mindre enn det forrige
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		// OPPGAVE - SLUTT
		return min;
	}

	
	private static int R = 6371000; // jordens radius
	
	// Beregn avstand mellom to gps punkter ved bruk av Haversine formlen
	public static double distance(double latitude1, double longitude1, double latitude2, double longitude2) {

		double a,c,d; // fjern = 1.0
		
		// TODO:
		// OPPGAVE - START
		// Math.toRadians konverterer ein vinkel (deg) til radianer
		latitude1 = toRadians(latitude1);
		latitude2 = toRadians(latitude2);
		longitude1 = toRadians(longitude1);
		longitude2 = toRadians(longitude2);

		double deltaPhi = (latitude2-latitude1);
		double deltaLambda = (longitude2-longitude1);
		a = (pow((sin(deltaPhi/2)),2)) + cos(latitude1)*cos(latitude2)*(pow(sin(deltaLambda/2),2));
		c = 2*atan2(sqrt(a), sqrt(1-a));
		d = R*c;
		// OPPGAVE - SLUTT

		return d;
	}
	
	// beregn gjennomsnits hastighet i km/t mellom to gps punkter
	public static double speed(int secs, double latitude1, double longitude1, double latitude2, double longitude2) {

		double speed;

		// TODO:
		// OPPGAVE - START
		double hr = secs/3600.0;
		double d = distance(latitude1, longitude1, latitude2, longitude2);

		speed = d/hr;
		// OPPGAVE - SLUTT

		return speed;
	}
	
	private static int TEXTWIDTH = 10;
	
	// konverter double til string med 2 decimaler og streng lengde 10
	// eks. 1.346 konverteres til "      1.35" og enhet til slutt
	// Hint: se på String.format metoden
	
	public static String printDouble(double d) {
		
		String str;
		
		// TODO
		// OPPGAVE - START
		// Bruker Math.round til å gi svar med to desimaler
		// Kan også bruke metoden DecimalFormat
		double a = round(d*100.0) / 100.0;
		// String.format metoden setter String str til å alltid ha lengde 10
		str = String.format("%10s", a);
		// OPPGAVE - SLUTT
		
		return str;
	}
}
