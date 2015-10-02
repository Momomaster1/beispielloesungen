public class Wuerfeln {
	public static void main(String[] args) {

		// Anlegen eines Arrays vom Typ int mit 6 Elementen
		int[] augen = new int[6];

		// Zaehlschleife mit 50 Durchlaeufen
		for (int i = 0; i < 50; i++) {
			// Eine zufaellige Zahl von 1 bis 6 erzeugen
			int wurf = Zufall.getZufallInt(1, 6);

			// Wir merken uns an der entsprechenden Position, dass die Zahl
			// gewuerfelt wurde
			// Da unser Array ab 0 zaehlt, muessen wir 1 abziehen
			augen[wurf - 1]++;
		}

		// Nach den 50 Wuerfen geben wir den Inhalt der 6 Felder des Arrays aus
		for (int i = 0; i < augen.length; i++) {
			System.out.println((i + 1) + ": " + augen[i]);
		}
	}
}
