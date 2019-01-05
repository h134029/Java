package no.hvl.dat100.Oppgave3;

public class ToDoListe {
    private ToDoElement[] todoTab;
    private int antall;

    public ToDoListe(int maksAntall) {
    todoTab = new ToDoElement[maksAntall];
    antall = 0;
    }
    public void leggTil(ToDoElement tde) {

        if (antall < todoTab.length) {
            todoTab[antall] = tde;
            antall++;
        } else {
            System.out.println("TODO Tabellen er full");
        }
    }
    public ToDoElement finnViktig() {

        int maks = 0;
        try {
            for (int i = 1; i < todoTab.length; i++) {
                if (todoTab[i].getPrioritet() > todoTab[maks].getPrioritet()) {
                    maks = i;
                }
            }
        }catch(NullPointerException e) {
            System.out.println();
        }
        return todoTab[maks];
    }
}

