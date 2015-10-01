public class Primzahl {

	public static void main(String[] args) {

		// 10 Zahlenblöcke sollen getestet werden:
		for (int i = 0; i < 10; i++) {
			// Blockgrenzen berechnen
			int blockStart = (i * 1000) + 1;
			int blockEnde = blockStart + 999;

			// Geforderte Statisische Angaben berechnen
			int anzahlTestzahlen = blockEnde - blockStart + 1;
			int anzahlPrimzahlen = ermittleAnzahlPrimzahlen(blockStart, blockEnde);
			// Tipp: Durch multiplikation mit einem double (100.0) rechnen
			// wir sofort im double-Zahlenraum und haben keine Integer-Division
			// mehr!
			double anteilProzent = 100.0 * anzahlPrimzahlen / anzahlTestzahlen;

			System.out.println("Block " + i + " von " + blockStart + " bis " + blockEnde + " enthält " + anzahlPrimzahlen
					+ " Primzahlen (" + anteilProzent + "%).");
		}

	}

	public static boolean isPrimzahl(int testzahl) {
		// Alle Zahlen von 2 bis testzahl-1 durchprobieren
		for (int teiler = 2; teiler < testzahl; teiler = teiler + 1) {
			// Sobald ein Teiler (d.h. Rest = 0) dabei ist, sofort das
			// ergebnis zurückliefern
			if (testzahl % teiler == 0) {
				return false;
			}
		}
		// Kein Teiler gefunden...
		return true;
	}

	public static int ermittleAnzahlPrimzahlen(int von, int bis) {
		int anzahl = 0;
		// Jede Zahl "i" testen
		for (int i = von; i <= bis; i++) {
			// Wenn es eine Primzahl ist: Anzahl um 1 hochsetzen
			if (isPrimzahl(i)) {
				anzahl++;
			}
		}
		// Ergebnis zurückliefern
		return anzahl;
	}

}
