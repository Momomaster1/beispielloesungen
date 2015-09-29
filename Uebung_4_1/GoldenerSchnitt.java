public class GoldenerSchnitt {

	public static void main(String[] args) {

		int alterZaehler = 1;
		int alterNenner = 1;

		// Erstmal den ersten Bruch darstellen
		bruchDarstellen(alterZaehler, alterNenner);

		// Wir machen das 30x, das soll uns reichen
		for (int i = 0; i < 30; i++) {
			// Die neuen Werte ermitteln
			int neuerZaehler = alterNenner;
			int neuerNenner = alterZaehler + alterNenner;

			// Bruch ausgeben
			bruchDarstellen(neuerZaehler, neuerNenner);

			// Nach der Ausgabe sind die ermittelten Werte alt geworden
			// und in der nächsten Runde werden neue Werte ermittelt
			alterNenner = neuerNenner;
			alterZaehler = neuerZaehler;

		}

	}

	public static void bruchDarstellen(int zaehler, int nenner) {
		// Die größere Zahl von beiden ermitteln, denn
		// diese Zahl bestimmt, wie lang der Bruchstrich sein muss
		double groessereZahl;
		if (zaehler > nenner) {
			groessereZahl = zaehler;
		} else {
			groessereZahl = nenner;
		}

		// Anzahl der Zehnerpotezen bestimmt die Länge des Bruchstriches
		int anzahlZehnerpotenzen = 1;
		while (groessereZahl >= 10) {
			anzahlZehnerpotenzen++;
			groessereZahl = groessereZahl / 10;
		}

		// Kommazahl ermitteln. Vorsicht: Die Division zweier int-Zahlen
		// ist eine Ganzzahndividion! Mind. eine zahl müssen wir
		// vorher also umwandeln!!!
		double zaehlerAlsDouble = zaehler;
		double kommazahl = zaehlerAlsDouble / nenner;

		// 2 Leerzeilen um Abstand zu bekommen
		System.out.println("");
		System.out.println("");

		// 1. Zeile der eigentlichen Ausgabe: Zähler
		System.out.println(zaehler);
		// 2. Zeile der eigentlichen Ausgabe: Bruchstrich und Komazahl
		for (int i = 0; i < anzahlZehnerpotenzen; i++) {
			System.out.print("-");
		}
		System.out.println(" = " + kommazahl);
		// 3. Zeile der eigentlichen Ausgabe: Nenner
		System.out.println(nenner);
	}

}
