package no.hvl.dat100.prosjekt;

import easygraphics.EasyGraphics;

import javax.swing.*;

public class ShowRoute extends EasyGraphics {

	private static int[] times;
	private static double[] latitudes;
	private static double[] longitudes;
	private static double[] elevations;

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private static GPSComputer gpscomputer;

	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");

		GPSData gpsdata = GPSDataReaderWriter.readGPSFile(filename);

		gpscomputer = new GPSComputer(gpsdata);

		times = gpscomputer.times;
		latitudes = gpscomputer.latitudes;
		longitudes = gpscomputer.longitudes;
		elevations = gpscomputer.elevations;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(longitudes);
		double minlon = GPSUtils.findMin(longitudes);

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// y-pixels per breddegrad
	
	public double ystep() {
	
		double ystep = 1.0;
		
		// TODO
		// OPPGAVE - START
		double maxlat = GPSUtils.findMax(latitudes);
		double minlat = GPSUtils.findMin(latitudes);

		ystep = MAPYSIZE/(Math.abs(maxlat-minlat));
		// OPPGAVE SLUTT
		
		return ystep;
	}

	public void showRouteMap(int ybase) {
		
		double xstep = xstep();
		double ystep = ystep();

		double minlon = GPSUtils.findMin(longitudes);
		double minlat = GPSUtils.findMin(latitudes);

		setColor(0, 255, 0); // green
		System.out.println("Angi tidsskalering i tegnevinduet ...");
		int timescaling = Integer.parseInt(getText("Tidsskalering"));

		// draw the locations
		for (int i = 0; i < latitudes.length; i++) {

			int x,y,x2,y2;

			// TODO: OPPGAVE START
			x = MARGIN + (int) ((longitudes[i-1] - minlon) * xstep);
			y = ybase - (int) ((latitudes[i-1]- minlat) * ystep);
			//Sluttkoordinater til linjen
			x2 = MARGIN + (int) ((longitudes[i] - minlon) * xstep);
			y2 = ybase - (int) ((latitudes[i]- minlat) * ystep);

			fillCircle(x,y,2);
			drawLine(x2,y2,x,y);
			pause(times[i]/timescaling);
			// må finne punkt nr i fra latitues og longitudes tabellene
			// og sette x og y til der de skal tegnes som et punkt i vinduet
			
			// OPPGAVE SLUTT
	}
		

	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO:
		// OPPGAVE - START
		int tid = gpscomputer.totalTime();
		double distance = gpscomputer.totalDistance();
		double elevation = gpscomputer.totalElevation();
		double maxspeed = gpscomputer.maxSpeed();
		double averageSpeed = gpscomputer.averageSpeed();
		double totalKcal = gpscomputer.totalKcal(GPSComputer.WEIGHT);
		drawString(String.format("Total Time     :    %02d:%02d:%02d%n", (tid/3600), ((tid%3600)/60), (tid%60)), MARGIN, TEXTDISTANCE);
		drawString(String.format("Total distance :    %.2f km%n", distance/1000),MARGIN, TEXTDISTANCE*2);
		drawString(String.format("Total elevation:    %.2f m%n", elevation), MARGIN, TEXTDISTANCE*3);
		drawString(String.format("Max speed      :    %.2f km/t%n",  maxspeed), MARGIN, TEXTDISTANCE*4);
		drawString(String.format("Average speed  :    %.2f km/t%n",  averageSpeed), MARGIN, TEXTDISTANCE*5);
		drawString(String.format("Energy         :    %.2f kcal%n", totalKcal/1000), MARGIN, TEXTDISTANCE*6);
		// OPPGAVE - SLUTT;
	}

	public void playRoute(int ybase) {
		
		double minlat = GPSUtils.findMin(latitudes);
		double minlon = GPSUtils.findMin(longitudes);

		double xstep = xstep();
		double ystep = ystep();

		setColor(0, 0, 255); // blue;

		// make a circle in the first point
		int x = MARGIN + (int) ((longitudes[0] - minlon) * xstep);
		int y = ybase - (int) ((latitudes[0] - minlat) * ystep);

		int movingcircle = fillCircle(x, y, 7);

		// TODO: 
		// EKSTRAOPPGAVE -- START
		double maxSpeed = gpscomputer.maxSpeed();
		double [] speedScale = new double[times.length];
		double [] speeds = gpscomputer.speeds();


		for (int i=0; i<speeds.length; i++) {

			int x2 = MARGIN + (int) ((longitudes[i] - minlon) * xstep);
			int y2 = ybase - (int) ((latitudes[i]- minlat) * ystep);

			if (speeds[i]>(maxSpeed/10.0*9.0)) {
				speedScale[i]=10.0;
			}

			else if (speeds[i]>(maxSpeed/10.0*8.0)) {
				speedScale[i]=9.0;
			}

			else if (speeds[i]>(maxSpeed/10.0*7.0)) {
				speedScale[i]=8.0;
			}

			else if (speeds[i]>(maxSpeed/10.0*6.0)) {
				speedScale[i]=7.0;
			}

			else if (speeds[i]>(maxSpeed/10.0*5.0)) {
				speedScale[i]=6.0;
			}

			else if (speeds[i]>(maxSpeed/10.0*4.0)) {
				speedScale[i]=5.0;
			}

			else if (speeds[i]>(maxSpeed/10.0*3.0)) {
				speedScale[i]=4.0;
			}

			else if (speeds[i]>(maxSpeed/10.0*2.0)) {
				speedScale[i]=3.0;
			}

			else if (speeds[i]>(maxSpeed/10.0)) {
				speedScale[i]=2.0;
			}

			else if (speeds[i]<(maxSpeed/10.0)) {
				speedScale[i]=1.0;
			}

			setSpeed((int)speedScale[i]);
			moveCircle(movingcircle, x2, y2);
		}
		// Få cirklen til å flytte seg mellom punktene i vinduet
		
		// EKSTRAOPPGAVE - SLUTT
	}

}
