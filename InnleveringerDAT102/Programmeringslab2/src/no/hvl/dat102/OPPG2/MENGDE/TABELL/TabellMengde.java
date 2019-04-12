package no.hvl.dat102.OPPG2.MENGDE.TABELL;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import no.hvl.dat102.OPPG1.ADT.MengdeADT;
import no.hvl.dat102.OPPG2.MENGDE.KJEDET.KjedetMengde;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// Søker etter og fjerner element. Retur med null ved ikke-funn
		
		boolean funnet = false;
		T svar = null;

		for (int i = 0; i < antall && !funnet; i++) {
			if (tab[i] == element) {
				svar = element;
				tab[i] = tab[antall];
				tab[antall] = null;
				antall--;
				funnet = true;
			}
		}
		return svar;
	}
/* Lite effektiv!
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return (MengdeADT<T>)begge;
	}
	*/
	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}
	
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			((TabellMengde<T>)begge).settInn(tab[i]);
		}
		Iterator<T> itm2 = m2.oppramser();
		while(itm2.hasNext()) {
			begge.leggTil(itm2.next());
		}
		return begge;
	}//
	
	

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		Iterator<T> itm1 = this.oppramser();
		T element;

		while (itm1.hasNext()) {
			element = itm1.next();
			if (m2.inneholder(element)) {
				((TabellMengde<T>) snittM).settInn(itm1.next());
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		Iterator<T> itm1 = this.oppramser();
		T element;

		while (itm1.hasNext()) {
			element = itm1.next();
			if (!m2.inneholder(element)) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}
		
		return differensM;
	}



	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		T element;

		boolean likeMengder = (m2.antall() == antall());
		Iterator<T> itm2 = m2.oppramser();

		while (likeMengder) {
			try {
				likeMengder = inneholder(itm2.next());
			}catch (NoSuchElementException e) {
				//Iterator done
				break;
			}
		}
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}
	

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}


}// class
