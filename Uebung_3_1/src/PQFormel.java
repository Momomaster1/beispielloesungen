public class PQFormel {
	public static void main(String[] args) {
		// Initialisierung der Werte für p und q
		double p = 8;
		double q = 15; // Programm auch mit 16 und 18 testen

		// Berechnung des Terms unter der Wurzel
		double unterDerWurzel = ((p / 2) * (p / 2)) - q;

		if (unterDerWurzel < 0) {// prüfen, ob der Term unter der Wurzel
									// kleiner
			// 0 ist
			System.out.println("Es existiert keine Lösung.");
		} else {
			// Berechnung des Terms vor der Wurzel
			double vorDerWurzel = -1 * p / 2;

			// Berechnung der 2 Lösungen
			double loesung1 = vorDerWurzel + Math.sqrt(unterDerWurzel);

			if (unterDerWurzel == 0) { // ist der Term unter der Wurzel 0 gibt
										// es nur eine Lösung
				System.out.println("Es existiert genau eine Lösung, x = " + loesung1);
			} else {
				double loesung2 = vorDerWurzel - Math.sqrt(unterDerWurzel);

				// Ausgabe der Lösungen
				System.out.println("x1 = " + loesung1);
				System.out.println("x2 = " + loesung2);
			}
		}
	}
}
