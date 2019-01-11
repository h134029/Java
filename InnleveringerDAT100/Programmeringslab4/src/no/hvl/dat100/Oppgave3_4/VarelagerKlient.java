package no.hvl.dat100.Oppgave3_4;

public class VarelagerKlient {
    public static void main(String[] args) {

        Varelager varereg = new Varelager();
        Meny meny = new Meny(varereg);
        meny.start();
    }
}
