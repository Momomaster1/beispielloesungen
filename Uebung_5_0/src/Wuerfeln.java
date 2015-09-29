public class Wuerfeln {
	public static void main(String[] args) {

		// Anlegen eines Arrays vom Typ int mit 6 Elementen
		int[] augen = new int[6];

		// Zählschleife mit 50 Durchläufen
		for (int i = 0; i < 50; i++) {
			// Eine zufällige Zahl von 1 bis 6 erzeugen
			int wurf = Zufall.getZufallInt(1, 6);

			// Wir merken uns an der entsprechenden Position, dass die Zahl
			// gewürfelt wurde
			// Da unser Array ab 0 zählt, müssen wir 1 abziehen
			augen[wurf - 1]++;
		}

		// Nach den 50 Würfen geben wir den Inhalt der 6 Felder des Arrays aus
		for (int i = 0; i < augen.length; i++) {
			System.out.println((i + 1) + ": " + augen[i]);
		}
	}
}
