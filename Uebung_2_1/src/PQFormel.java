public class PQFormel {
	public static void main(String[] args) {
		// Initialisierung der Werte fuer p und q
		double q = 15;
		double p = 8;

		// Berechnung des Terms unter der Wurzel
		double unterDerWurzel = ((p / 2) * (p / 2)) - q;
		// Berechnung des Terms vor der Wurzel
		double vorDerWurzel = -1 * p / 2;

		// Berechnung der 2 Loesungen
		double loesung1 = vorDerWurzel + Math.sqrt(unterDerWurzel);
		double loesung2 = vorDerWurzel - Math.sqrt(unterDerWurzel);

		// Ausgabe der Loesungen
		System.out.println("x1 = " + loesung1);
		System.out.println("x2 = " + loesung2);

	}
}
