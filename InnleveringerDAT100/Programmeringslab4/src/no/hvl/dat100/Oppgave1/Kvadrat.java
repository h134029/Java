package no.hvl.dat100.Oppgave1;

public class Kvadrat {
    public int sidelengde;

    public Kvadrat(int sidelengdeinit) {
        sidelengde = sidelengdeinit;
    }
    public double Areal() {
        return sidelengde*sidelengde;
    }
    public double Omkrets() {
        return 4*sidelengde;
    }
    public double Diagonal() {
        double n = Math.sqrt(Math.pow(sidelengde,2) + Math.pow(sidelengde,2));
        double roundOff = Math.round(n*100.0)/100.0;
        return roundOff;
    }
    public void Tegne() {
        for (int i = 0; i < sidelengde; i++) {
            for (int j = 0; j < sidelengde; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public void PrintInfo() {
        System.out.println("Kvadrat: " + sidelengde + ", Areal: " + Areal() + ", Omkrets: " + Omkrets() + ", Diagonal: " + Diagonal());
    }
    public boolean sum(Kvadrat a, Kvadrat b) {
        boolean c = (Math.pow(sidelengde,2) - Math.pow(a.sidelengde,2) - Math.pow(b.sidelengde, 2) == 0)  ? true : false;
        return c;
    }
}
