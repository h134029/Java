package no.hvl.dat100;

import easygraphics.EasyGraphics;

public class Flooding extends EasyGraphics {

    // nesten dekket hvis mindre en fra havoverflaten
    int NESTEN_DEKKET = 1;
    int RADIUS = 20;
    int MARGIN = 50;

    // terreng hogde
    int[][] terreng = { { 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
                        { 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
                        { 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 } };

    public static void main(String[] args) {
        launch(args);
    }

    public void run() {

        makeWindow("FLOODING", 800, 300);

        visualiser();
    }

    public void visualiser() {

        System.out.println("Angi havhøyde i tegnevinduet ...");
        int hav = Integer.parseInt(getText("havhøyde"));

        while (hav >= 0) {

            // TODO - START
            for (int j = 0; j < terreng.length; j++) {
                for (int i = 0; i < terreng[0].length; i++) {
                    if (terreng[j][i] - hav <= 0) {
                        setColor(0, 0, 255); // blå - vann
                        drawCircle(MARGIN + (i * MARGIN),MARGIN + (j  *MARGIN), RADIUS);
                        fillCircle(MARGIN + (i * MARGIN),MARGIN + (j  *MARGIN), RADIUS);
                    }
                    else if (terreng[j][i] - hav >= 0 && terreng[j][i] - hav <= 1) {
                        setColor(255,140,0); // oransje - søle
                        drawCircle(MARGIN + (i * MARGIN),MARGIN + (j  *MARGIN), RADIUS);
                        fillCircle(MARGIN + (i * MARGIN),MARGIN + (j  *MARGIN), RADIUS);
                    }
                    else if (terreng[j][i] - hav > 1) {
                        setColor(222,184,135); // lysebrun - tørt
                        drawCircle(MARGIN + (i * MARGIN),MARGIN + (j  *MARGIN), RADIUS);
                        fillCircle(MARGIN + (i * MARGIN),MARGIN + (j  *MARGIN), RADIUS);
                    }
                }
            }

            // TODO - SLUTT

            System.out.println("Angi havhøyde i tegnevinduet ...");
            hav = Integer.parseInt(getText("havhøyde"));
        }
    }
}