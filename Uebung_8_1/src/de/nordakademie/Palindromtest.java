package de.nordakademie;

import javax.swing.JOptionPane;

public class Palindromtest {

	public static void main(String[] args) {

		// Eingabe lesen
		String eingabe = JOptionPane.showInputDialog(null, "Wort fuer Palindromtest:");

		// Wir arbeiten mit einem Text, der komplett kleingeschrieben ist...
		String allesInKlein = eingabe.toLowerCase();

		// Laenge der eingabe und Anzahl der notwendigen
		// Vergleiche ermitteln
		int laenge = allesInKlein.length();
		int anzahlVergleiche = laenge / 2;

		// Wir gehen mal davon aus, dass es ein
		// Palindrom ist, bis wir etwas gegenteiliges
		// feststellen...
		boolean istPalindrom = true;

		// Die einzelnen Vergleiche durchfuehren, z.B.:
		// lagerregal:
		// 1. l....|....l
		// 2. .a...|...a.
		// 3. ..g..|..g..
		// 4. ...e.|.e...
		// 5. ....r|r....
		for (int i = 0; i < anzahlVergleiche; i++) {

			// indexe der zu vergleichenden
			// Buchstaben ermitteln
			int zeichenindexVonLinks = i;
			int zeichenindexVonRechts = laenge - i - 1;

			// Buchstaben anhand des Index lesen
			String vonLinks = allesInKlein.substring(zeichenindexVonLinks, zeichenindexVonLinks + 1);
			String vonRechts = allesInKlein.substring(zeichenindexVonRechts, zeichenindexVonRechts + 1);

			// Pruefen: ist das Buchstabenpaar
			// ungleich? Dann haetten wir definitiv
			// kein Palindrom vorliegen...
			if (!vonLinks.equals(vonRechts)) {
				istPalindrom = false;
			}
		}

		// auszugebende Nachricht ermitteln..
		String message;
		if (istPalindrom) {
			message = "Jawoll! Ist ein Palindrom!";
		} else {
			message = "Nene. Ist kein Palindrom.";
		}

		// ... und ausgeben
		JOptionPane.showMessageDialog(null, message);

	}

}
