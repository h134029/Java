package no.hvl.dat100;

public class Epost {
    // a)
    private String til;
    private String emne;
    private String innhold;
    private int dag;
    private int maaned;

    // b)
    public Epost(String tilinit, String emneinit, String innholdinit, int daginit, int maanedinit) {

        til = tilinit;
        emne = emneinit;
        innhold = innholdinit;
        dag = daginit;
        maaned = maanedinit;
    }
    // c)
    public void setTil(String til){
        this.til = til;
    }
    public void setDag(int dag){
        this.dag = dag;
    }
    public String getTil() {
        return til;
    }
    public int getDag() {
        return dag;
    }

    // d)

    public int lengde() {

        int i = innhold.length();
        return i;
    }
    // e)

    public String toString() {

        String ut = "Dato: " + dag + "." + maaned + ", Til: " + til + ", Emne: " + emne;
        return ut;
    }
    // f)

    public boolean harSammeMottaker(Epost e){
        boolean samme = (til == e.til);

        return samme;

    }
    // g)

    public int compareTo(Epost e){

        int compare = 0;
        if (maaned > e.maaned) {
            compare = 1;
        } else if (maaned < e.maaned) {
            compare = -1;
        } else if (dag > e.dag) {
            compare = 1;
        } else if (dag < e.dag) {
            compare = -1;
        }
        return compare;
    }
}
