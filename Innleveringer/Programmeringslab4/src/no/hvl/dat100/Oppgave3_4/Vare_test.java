package no.hvl.dat100.Oppgave3_4;

public class Vare_test {
    public static void main(String[] args) {
        Vare v1 = new Vare();
        v1.setVarenr(444);
        v1.setNavn("Cola");
        v1.setPris(24.90);

        Vare v2 = new Vare(555,"Sjokolade",13.50);

        // Metoder
        System.out.println("Moms " + v1.getNavn() + ": " + v1.moms());
        System.out.println("Er " + v1.getNavn() + " billigare enn " + v2.getNavn() + "? : " + v1.billigareEnn(v2));
        System.out.println(v1.toString());
        System.out.println(v2.toString());
    }
}
