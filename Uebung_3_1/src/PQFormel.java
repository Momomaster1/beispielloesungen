public class PQFormel {
	public static void main(String[] args) {
		// Initialisierung der Werte fuer p und q
		double p = 8;
		double q = 15; // Programm auch mit 16 und 18 testen

		// Berechnung des Terms unter der Wurzel
		double unterDerWurzel = ((p / 2) * (p / 2)) - q;

		if (unterDerWurzel < 0) {// pruefen, ob der Term unter der Wurzel
									// kleiner
			// 0 ist
			System.out.println("Es existiert keine Loesung.");
		} else {
			// Berechnung des Terms vor der Wurzel
			double vorDerWurzel = -1 * p / 2;

			// Berechnung der 2 Loesungen
			double loesung1 = vorDerWurzel + Math.sqrt(unterDerWurzel);

			if (unterDerWurzel == 0) { // ist der Term unter der Wurzel 0 gibt
										// es nur eine Loesung
				System.out.println("Es existiert genau eine Loesung, x = " + loesung1);
			} else {
				double loesung2 = vorDerWurzel - Math.sqrt(unterDerWurzel);

				// Ausgabe der Loesungen
				System.out.println("x1 = " + loesung1);
				System.out.println("x2 = " + loesung2);
			}
		}
	}
}
