package no.hvl.dat100.Oppgave3;

public class Main {
    public static void main(String[] args){

        ToDoElement TD1 = new ToDoElement("Stå på eksamen", 1, 2);
        ToDoElement TD2 = new ToDoElement("Lage middag", 2, 1);

        ToDoListe TDL1 = new ToDoListe(10);
        TDL1.leggTil(TD1);
        TDL1.leggTil(TD2);

        // toString() metoden i klassen blir automatisk printet ut
        System.out.println(TDL1.finnViktig());
    }
}
