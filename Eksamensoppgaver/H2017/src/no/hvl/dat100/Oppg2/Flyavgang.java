package no.hvl.dat100.Oppg2;

public class Flyavgang {
    private int nummer;
    private String destinasjon;
    private String tid;
    private char status;

    public Flyavgang(int num, String dest, String tid, char status) {
        this.nummer = num;
        this.destinasjon = dest;
        this.tid = tid;
        this.status = status;
    }
    @Override
    public String toString() {
        String s;
        switch (status) {
            case 'o':
                s = "on-time";
                break;
            case 'g':
                s = "go-to-gate";
                break;
            case 'b':
                s = "boarding";
                break;
            case 'c':
                s = "gate-closed";
                break;
            default:
                s = "-";
        }
        return nummer + " " + destinasjon + " " + tid + " " + s + "\n";
    }
    public int getNummer() {return nummer;}
    public void setStatus(char status) {this.status = status;}
}
