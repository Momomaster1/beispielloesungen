public class ArraySorter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Zuerst einmal ein Int-Array erzeugen
		int[] a = Zufall.erzeugeIntArray(5);

		// Das Array einmal unsortiert ausgeben
		arrayAusgeben(a);

		// Die Methode setzeKleinsteNachVorne sucht in einem
		// Array ab einer bestimmten Position die kleinste Zahl
		// und setzt sie an diese position.
		// Wir benutzen dies, um nach und nach die kleinste Zahl nach
		// vorne zu holen. Beispiel:
		// Array a am Anfang: 8 4 2 1 6
		// wir rufen auf: setzeKleinsteNachVorne(a,0), danach: 1 4 2 8 6
		// wir rufen auf: setzeKleinsteNachVorne(a,1), danach: 1 2 4 8 6
		// wir rufen auf: setzeKleinsteNachVorne(a,2), danach: 1 2 4 8 6
		// wir rufen auf: setzeKleinsteNachVorne(a,3), danach: 1 2 4 6 8
		// wir rufen auf: setzeKleinsteNachVorne(a,3), danach: 1 2 4 6 8
		// (eigentlich überflüssig)
		for (int i = 0; i < a.length; i++) {
			setzeKleinsteNachVorne(a, i);
		}

		// Und nun sortiert ausgeben
		arrayAusgeben(a);

	}

	/**
	 * Ausgeben eines Arrays
	 * 
	 * @param array
	 */
	public static void arrayAusgeben(int[] array) {
		System.out.println("Array, Größe " + array.length + ":");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * Diese Methode sucht ab einer bestimmten Position in einem Array die
	 * kleinste Zahl und vertauscht diese mit der "ersten" (also die, bei der
	 * wir anfangen)
	 * 
	 * @param array
	 * @param abPosition
	 */
	public static void setzeKleinsteNachVorne(int[] array, int abPosition) {
		// Beispiel: 1 5 3 2 8, wir fangen ab 1 (also 2. Stelle an)

		// Wenn wir die kleinste Zahl suchen, müssen wir uns
		// immer merken, was die kleinste ist und an welcher Stelle diese ist
		// Im Beispiel wäre die bisher kleinste Zahl 5 und die Position 1
		int bisherKleinsteZahl = array[abPosition];
		int positionVonBisherKleinsteZahl = abPosition;

		// Nun suchen wir noch kleinere Zahlen ab
		// "positionVonBisherKleinsteZahl+1"
		for (int i = positionVonBisherKleinsteZahl + 1; i < array.length; i++) {
			// Wir haben eine kleinere gefunden!
			if (array[i] < bisherKleinsteZahl) {
				// das merken wir uns!
				bisherKleinsteZahl = array[i];
				positionVonBisherKleinsteZahl = i;
			}
		}

		// Nun wissen wir, wo die kleinste Zahl steht.
		// Im Beispiel: positionVonBisherKleinsteZahl = 3

		// Nun merken wir uns die beiden Zahlen, die wir tauschen wollen
		// Im Beispiel: ersteZahl = 5, kleinsteZahl = 2
		int ersteZahl = array[abPosition];
		int kleinsteZahl = array[positionVonBisherKleinsteZahl];

		// Und schreiben die Werte vertauscht zurück
		array[positionVonBisherKleinsteZahl] = ersteZahl;
		array[abPosition] = kleinsteZahl;
	}
}
