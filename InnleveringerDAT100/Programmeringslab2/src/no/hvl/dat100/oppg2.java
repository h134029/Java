package no.hvl.dat100;
import static javax.swing.JOptionPane.*;
import static java.lang.String.*;
import static java.lang.Double.*;

public class oppg2 {
    public static void main(String[] args) {

        double trinn0 = 0;
        double trinn1 = 0.93;
        double trinn2 = 2.41;
        double trinn3 = 11.52;
        double trinn4 = 14.52;

        String lonn = showInputDialog("Beløp: ");
        double i = parseDouble(lonn);
        double skatt = trinn0;

        if (0 <= i && i <= 164100) {
            skatt = 0;
        }
        if (164101 <= i && i <= 230950) {
            skatt = (i * trinn1)/100;
        }
        if (230951 <= i && i <= 580650) {
            skatt = (i * trinn2)/100;
        }
        if (580651 <= i && i <= 934050) {
            skatt = (i * trinn3)/100;
        }
        if (934051 <= i) {
            skatt = (i * trinn4)/100;
        }
        String ut = "Trinn skatten blir: " + format("%.2f",skatt) + ",-";
        showMessageDialog(null, ut);
    }
}
