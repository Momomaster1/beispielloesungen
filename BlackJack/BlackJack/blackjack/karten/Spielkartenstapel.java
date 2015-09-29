package blackjack.karten;

import java.util.Random;

/**
 * Objekte dieser Klasse repräsentieren einen Kartenstapel.
 * 
 * @author Malte Knutz
 */
public class Spielkartenstapel {

	/**
	 * Die Karten des Stapels. Werden Karten von dem Stapel genommen, werden Sie
	 * nicht wirklich entfernt. In einem anderen Attribut wird abgelegt, wie
	 * hoch der Stapel ist und verwehrt darüber den Zugriff auf Karten, die
	 * schon genommen wurden
	 */
	private Spielkarte[] karten;
	/**
	 * Hier wird abgelegt, wie hoch der Stapel ist.
	 */
	private int aktuellObersteKarte;

	/**
	 * Erzeugt einen neuen gemischten Kartenstapel.
	 * 
	 */
	public Spielkartenstapel() {
		// Karten erzeugen
		// 1. Gültige Farben und Bezeichnungen lesen
		String[] farben = Spielkarte.ermittleGueltigeFarben();
		String[] bezeichnungen = Spielkarte.ermittleGueltigeKartenbezeichnungen();

		// 2. Ein Array für die Karten vorbereiten - in der richtigen Größe
		karten = new Spielkarte[farben.length * bezeichnungen.length];

		// 3. Für jede Farbe und pro Farbe für jede Bezeichnung eine Karte
		// erzeugen
		// ...und diese dann in das Array an fortlaufender Position merken
		int index = 0;
		for (String f : farben) {
			for (String b : bezeichnungen) {
				karten[index] = new Spielkarte(f, b);
				index++;
			}
		}

		// 4. Kartenstapel neu Mischen
		neuMischen();

	}

	/**
	 * Liefert die oberste Karte des Stapels und reduziert die Höhe des Stapels
	 * damit um eins.
	 * 
	 * @return die oberste Karte des Stapels.
	 */
	public Spielkarte getObersteKarte() {
		// Zuerst mal prüfen, ob der Stapel überhaupt noch Karten hat...
		if (aktuellObersteKarte < 0) {
			System.out.println("Fehler!!! Der Kartenstapel ist leer.");
			System.exit(0);
		}
		// Nun die oberste Karte ermitteln
		Spielkarte karte = karten[aktuellObersteKarte];
		// und merken, dass der Stapel ein kleiner geworden ist
		aktuellObersteKarte--;
		return karte;
	}

	/**
	 * Setzt den Kartenstapel zurück. D.h. der Stapel wird aufgefüllt und neu
	 * gemischt.
	 */
	private void neuMischen() {

		// Die Karten mischen. Vorgehen: 1000x zwei beliebige Karten tauschen.
		// Das sollte reichen
		Random randomizer = new Random();
		for (int i = 0; i < 1000; i++) {

			// Dazu zwei beliebige Karten wählen
			int pos1 = randomizer.nextInt(karten.length);
			int pos2 = randomizer.nextInt(karten.length);

			// Die Karten "merken"
			Spielkarte karte1 = karten[pos1];
			Spielkarte karte2 = karten[pos2];

			// und vertauscht im Array ablegen
			karten[pos1] = karte2;
			karten[pos2] = karte1;
		}

		// Nun noch den "Zeiger" auf die oberste Karte des Stapels zurücksetzen
		aktuellObersteKarte = karten.length - 1;

	}

	/**
	 * Liefert eine Textdarstellung des Stapels.
	 * 
	 * @return eine Textdarstellung des Stapels.
	 */
	public String getTextdarstellung() {
		int anzahlRest = aktuellObersteKarte + 1;
		String text = "Kartenstapel (" + anzahlRest + " übrig):";
		for (int i = 0; i <= aktuellObersteKarte; i++) {
			text = text + "\n   " + karten[i].getTextdarstellung();
		}
		return text;
	}

}
