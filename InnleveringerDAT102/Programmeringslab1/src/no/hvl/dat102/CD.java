package no.hvl.dat102;

public class CD {

    private int cdnr;
    private String artist;
    private String tittel;
    private int release;
    private String plateselskap;
    private Sjanger sjanger;

    public CD() {
        this(0,"","",0,"",null);
    }
    public CD(int cdnr, String artist, String tittel, int release, String plateselskap, Sjanger sjanger) {
        this.cdnr = cdnr;
        this.artist = artist;
        this.tittel = tittel;
        this.release = release;
        this.plateselskap = plateselskap;
        this.sjanger = sjanger;
    }
    //GET
    public int getCdnr() {return cdnr;}
    public String getArtist() {return artist;}
    public String getTittel() {return tittel;}
    public int getRelease() {return release;}
    public String getPlateselskap() {return plateselskap;}
    public Sjanger getSjanger() {return sjanger;}

    @Override
    public String toString() {
        return cdnr + "#" + artist + "#" + tittel + "#" + release + "#" + plateselskap + "#" + sjanger;
    }
}
