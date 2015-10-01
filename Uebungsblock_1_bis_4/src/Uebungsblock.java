public class Uebungsblock {

	// Achtung: Zur Ausführung des Programms muss das Uebungstools.jar
	// eingebunden
	// werden. Die Anleitung finden Sie in den Folien zu dieser
	// Übung.

	/**
	 * Mainmethode: dient zum Aufruf der einzelnen Übungen
	 * 
	 */
	public static void main(String[] args) {

		boolean ende = false;
		while (!ende) {

			int nr = Eingabe.frageNachIntUeberDialog("Bitte Übungsnr eingeben (1-7, 0 zum Beenden):");

			Zeichenfenster.zeigeZeichenfenster();
			Zeichenfenster.clearZeichenfenster();
			Zeichenfenster.setzeFarbeSchwarz();

			if (nr == 1) {
				uebung1();
			}
			if (nr == 2) {
				uebung2();
			}
			if (nr == 3) {
				uebung3();
			}
			if (nr == 4) {
				uebung4();
			}
			if (nr == 5) {
				uebung5();
			}
			if (nr == 6) {
				uebung6();
			}
			if (nr == 7) {
				uebung7();
			}
			if (nr == 0) {
				System.exit(0);
			}
		}

	}

	/**
	 * Umsetzung der Übung 1.
	 */
	public static void uebung1() {

		Zeichenfenster.zeichnePunkt(10, 10);
		Zeichenfenster.zeichnePunkt(10, 12);
		Zeichenfenster.zeichnePunkt(12, 10);

		Zeichenfenster.zeichneLinie(100, 100, 500, 100);
		Zeichenfenster.zeichneLinie(500, 100, 500, 300);
		Zeichenfenster.zeichneLinie(500, 300, 100, 300);
		Zeichenfenster.zeichneLinie(100, 300, 100, 100);

		Zeichenfenster.zeichneEllipse(300, 200, 400, 200);

	}

	/**
	 * Umsetzung der Übung 2.
	 */
	public static void uebung2() {
		for (int i = 0; i < 800; i = i + 10) {
			Zeichenfenster.zeichneLinie(0, i, i, 0);
		}
	}

	/**
	 * Umsetzung der Übung 3.
	 */
	public static void uebung3() {
		for (int i = 0; i < 300; i = i + 5) {
			Zeichenfenster.zeichneEllipse(200 + i, 400, 100 + i, 100 + i);
		}
	}

	/**
	 * Umsetzung der Übung 4.
	 */
	public static void uebung4() {
		for (int i = 0; i < 600; i = i + 10) {
			Zeichenfenster.zeichneEllipse(400, 400, 799 - i, 200 + i);
		}
	}

	/**
	 * Umsetzung der Übung 5.
	 */
	public static void uebung5() {
		for (int i = 0; i < 800; i = i + 8) {
			Zeichenfenster.zeichneLinie(0 + i, 0, 799, 0 + i);
			Zeichenfenster.zeichneLinie(0, 0 + i, 0 + i, 799);
			Zeichenfenster.zeichneLinie(0, 0 + i, 799 - i, 0);
			Zeichenfenster.zeichneLinie(0 + i, 799, 799, 799 - i);
		}
	}

	/**
	 * Umsetzung der Übung 6.
	 */
	public static void uebung6() {
		// 2 verschachtelte Schleifen, um jede Kombination von x- und
		// y-Koordinate 1x zu erwischen
		for (int y = 0; y < 800; y++) {
			for (int x = 0; x < 800; x++) {
				// Abstände zu den "Farbzentren" berechnen
				double rotAbstand = ermittleAbstand(x, y, 250, 270);
				double gruenAbstand = ermittleAbstand(x, y, 550, 270);
				double blauAbstand = ermittleAbstand(x, y, 400, 530);
				// Farbe zusammensetzen
				Zeichenfenster.setzeFarbe(rechneAbstandInFarbeUmFuerUebung6(rotAbstand),
						rechneAbstandInFarbeUmFuerUebung6(gruenAbstand), rechneAbstandInFarbeUmFuerUebung6(blauAbstand));
				// Punkt zeichnen
				Zeichenfenster.zeichnePunkt(x, y);
			}
		}
	}

	/**
	 * Umsetzung der Übung 7.
	 */
	public static void uebung7() {
		// 2 verschachtelte Schleifen, um jede Kombination von x- und
		// y-Koordinate 1x zu erwischen
		for (int y = 0; y < 800; y++) {
			for (int x = 0; x < 800; x++) {
				// Abstände zu den "Farbzentren" berechnen
				double rotAbstand = ermittleAbstand(x, y, 250, 270);
				double gruenAbstand = ermittleAbstand(x, y, 550, 270);
				double blauAbstand = ermittleAbstand(x, y, 400, 530);
				// Farbe zusammensetzen
				Zeichenfenster.setzeFarbe(rechneAbstandInFarbeUmFuerUebung7(rotAbstand),
						rechneAbstandInFarbeUmFuerUebung7(gruenAbstand), rechneAbstandInFarbeUmFuerUebung7(blauAbstand));
				// Punkt zeichnen
				Zeichenfenster.zeichnePunkt(x, y);
			}
		}
	}

	/**
	 * Kleine Hilfsmethode, um den Abstand zweier Punkte zueinander zu
	 * bestimmen.
	 * 
	 * @param x1
	 *            x-Koordinate des 1. Punktes
	 * @param y1
	 *            y-Koordinate des 1. Punktes
	 * @param x2
	 *            x-Koordinate des 2. Punktes
	 * @param y2
	 *            y-Koordinate des 2. Punktes
	 * @return Den Abstand der Punke
	 */
	public static double ermittleAbstand(int x1, int y1, int x2, int y2) {
		// Abstand nach Phytagoras
		return Math.round(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));

	}

	/**
	 * In Übung 7 soll der Abstand zweier Punkt die Farbgebung (rot-, grün- oder
	 * blauAnteil) bestimmen. Diese Methode übernimmt genau diese Berechnung.
	 * 
	 * @param abstand
	 * @return
	 */
	public static double rechneAbstandInFarbeUmFuerUebung6(double abstand) {
		if (abstand > 800) {
			return 0;
		}
		return (800 - abstand) / 800;
	}

	/**
	 * In Übung 8 soll der Abstand zweier Punkt die Farbgebung (rot-, grün- oder
	 * blauAnteil) bestimmen. Diese Methode übernimmt genau diese Berechnung.
	 * 
	 * @param abstand
	 * @return
	 */
	public static double rechneAbstandInFarbeUmFuerUebung7(double abstand) {
		if (abstand > 400) {
			return 0;
		} else if (abstand < 200) {
			return 1.0;
		}
		return (400 - abstand) / 200;
	}

}
