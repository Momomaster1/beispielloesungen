package blackjack.karten;

import blackjack.Konstanten;

import java.util.ArrayList;

/**
 * Objekte dieser Klasse repraesentieren das Blatt eines Spielers. Es ist im
 * Wesentlichen eine Ansammlung von Spielkarten.
 * 
 * @author Malte Knutz
 * @author Bjoern Kimminich
 */
public class Kartenhand {

	/**
	 * In dieser ArrayList werden die Karten auf der Kartenhand gespeichert. Die Liste wächst nach Bedarf mit,
	 * so dass es nie Groessenprobleme gibt. Gefuellt wird sie aufsteigend.
	 */
	private ArrayList<Spielkarte> kartenAufHand = new ArrayList<Spielkarte>();

	/**
	 * Nimmt von dem uebergebenen Kartenstapel die oberste Karte und fuegt Sie
	 * dieser Kartenhand hinzu.
	 * 
	 * @param stapel
	 *            Der Kartenstapel, von dem die oberste Karte genommen wird.
	 */
	public void nimmKarte(Spielkartenstapel stapel) {
		kartenAufHand.add(stapel.getObersteKarte());
	}

	/**
	 * Ermittelt den Punktwert der Karten auf der Hand. Dabei werden die Asse so
	 * gezaehlt, dass es fuer den Spieler das optimalste Ergebnis ergibt.
	 * Beispiele: Eine 9 und ein Ass wuerden als 20 Punkte gezaehlt werden, Zwei
	 * 9en und ein Ass 19 Punkte und eine 9 und zwei Asse als 21 Punkte.
	 * 
	 * @return den optimalsten Punktwert der Kartenhand
	 */
	public int ermittleWertOptimal() {
		// Vorgehen: wir zaehlen erstmal nur die Werte der Nicht-Asse und
		// wieviele Asse es gibt
		int wertOhneAsse = 0;
		int anzahlAsse = 0;
		for (Spielkarte karte : kartenAufHand) {
			if (karte.istAss()) {
				anzahlAsse++;
			} else {
				wertOhneAsse = wertOhneAsse + karte.getBasiswert();
			}
		}

		// Jetzt wird eine Liste aller irgendwie moeglichen Kartenhandwerte
		// erstellt.
		// Zuerst die Frage: Wieviele Moeglichkeiten gibt es bei 1, 2, 3 oder 4
		// Assen?
		// Loesung: Bei 1 Ass kann man es mit 1 oder 11 zaehlen (2 Moeglichkeiten)
		// Bei 2 Assen kann man keins, eins oder beide mit 1 zaehlen und den Rest
		// mit 11 (3 Moeglichkeiten)
		// Bei 3 Assen kann man keins, eins, zwei oder alle mit 1 zaehlen und den
		// Rest mit 11 (4 Moeglichkeiten)
		// Bei 4 Assen kann man keins, eins, zwei, drei oder alle mit 1 zaehlen
		// und den Rest mit 11 (5 Moeglichkeiten)
		int[] listeAllerMoeglichenWerte = new int[anzahlAsse + 1];
		// Nun muss die Liste noch gefuellt werden.
		for (int i = 0; i < listeAllerMoeglichenWerte.length; i++) {
			// Fuer den 0. eintrag in der Liste zaehlen wir 0 Asse mit 1 und und
			// den Rest mit 11
			// Fuer den 1. eintrag in der Liste zaehlen wir 1 Asse mit 1 und und
			// den Rest mit 11 usw
			int asseMitEinsGezaehlt = i;
			int asseMitElfGezaehlt = anzahlAsse - asseMitEinsGezaehlt;
			int wertAsse = asseMitEinsGezaehlt + (asseMitElfGezaehlt * 11);

			listeAllerMoeglichenWerte[i] = wertOhneAsse + wertAsse;
		}

		// Nun haben wir eine Liste aller Varianten, mit denen man theoretisch
		// zaehlen kann.
		// Wir muessen nur noch die beste auswaehlen. Dabei soll noch
		// beruecksichtigt werden,
		// dass z.B. 22 besser ist als 32 (zwar ist beides irgendwie nix wert,
		// doch dem Anwender vorzurechnen
		// dass {Zwei Ass Ass Acht Bube} als 32 gezaehlt wird ist Mist)
		// Wir nehmen dazu erstmal den ersten Eintrag und sehen nach, was man
		// besseres findet
		int wert = listeAllerMoeglichenWerte[0];
		for (int alternativerWert : listeAllerMoeglichenWerte) {
			// wir haben also 2 Werte zur Auswahl: "wert" und "alternativerWert"
			// und muessen, wenn
			// "alternativerWert" besser ist, Ihn unter "wert" ablegen

			// Gruende dafuer, dass "alternativerWert" besser ist:
			// 1. Wenn der bisher beste wert > 21 ist und wir mit
			// "alternativerWert" unter 22 kommen, nehmen wir natuerlich den!
			boolean alternativerWertKommtUnter21 = wert > Konstanten.ZIELWERT && alternativerWert <= Konstanten.ZIELWERT;
			// 2. Wenn beide unter 22 liegen, nehmen wir "alternativerWert",
			// wenn er groesser als "wert" ist.
			boolean beideUnter22UndAlternativerWertGroesser = wert <= Konstanten.ZIELWERT
					&& alternativerWert <= Konstanten.ZIELWERT && alternativerWert > wert;
			// 3. Wenn beide ueber 21 liegen, nehmen wir "alternativerWert", wenn
			// er kleiner als "wert" ist.
			boolean beideUeber21UndAlternativerWertKleiner = wert > Konstanten.ZIELWERT
					&& alternativerWert > Konstanten.ZIELWERT && alternativerWert < wert;

			if (alternativerWertKommtUnter21 || beideUnter22UndAlternativerWertGroesser
					|| beideUeber21UndAlternativerWertKleiner) {
				wert = alternativerWert;
			}

		}

		// Nun ist alles klar. In Wert steht die beste Zaehlvariante
		return wert;

	}

	/**
	 * Ermittelt den Punktwert der Karten auf der Hand. Dabei werden alle Asse
	 * mit 11 Punkten gezaehlt.
	 * 
	 * @return Den Punktwert der Karten auf der Hand, wobei jedes Ass 11 zaehlt
	 */
	public int ermittleWertJedesAssZaehlt11() {
		int wert = 0;
		for (Spielkarte karte : kartenAufHand) {
			wert = wert + karte.getBasiswert();
		}
		return wert;
	}

	private int getAnzahlKartenAufHand() {
		return kartenAufHand.size();
	}

	/**
	 * Liefert eine Textdarstellung der Kartenhand.
	 * 
	 * @return eine Textdarstellung der Kartenhand
	 */
	public String getTextdarstellung() {
		int anzahl = getAnzahlKartenAufHand();
		if (anzahl == 0) {
			return "Keine Karten auf der Hand";
		}
		// mind. eine Karte ist auf der Hand
		String text = kartenAufHand.get(0).getTextdarstellung();
		// Alle weiteren evtl. vorhandenen Karten anhaengen
		for (int i = 1; i < anzahl; i++) {
			text = text + " | " + kartenAufHand.get(i).getTextdarstellung();
		}
		text = text + " = " + ermittleWertOptimal() + " Punkte";
		return text;
	}

}
