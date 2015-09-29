public class BodyMassIndex {
	public static void main(String[] args) {
		// Initialisieren der Ausgangswerte
		double gewichtInKilo = 80;
		double groesseInMeter = 1.78;
		int alter = 26;
		boolean maennlich = true;

		// Berechnung des Body-Mass-Index
		double bmi = gewichtInKilo / (groesseInMeter * groesseInMeter);

		// Ausgabe der Werte
		System.out.println("Gewicht: " + gewichtInKilo + " kg");
		System.out.println("Größe: " + groesseInMeter + " m");
		System.out.println("Alter: " + alter + " Jahre");
		if (maennlich) {
			System.out.println("männlich");
		} else {
			System.out.println("weiblich");
		}
		System.out.println("Body-Mass-Index: " + bmi);

		if (maennlich) {
			// bei Männern wird 1 abgezogen, so dass gegen die Tabelle
			// der Frauen verglichen werden kann
			bmi = bmi - 1;
		}

		if (alter <= 24) {
			if (bmi < 19) {
				System.out.println("Untergewichtig.");
			} else if (bmi <= 24) {
				System.out.println("Normalgewichtig.");
			} else {
				System.out.println("Übergewichtig.");
			}
		} else if (alter < 35) {
			if (bmi < 20) {
				System.out.println("Untergewichtig.");
			} else if (bmi <= 25) {
				System.out.println("Normalgewichtig.");
			} else {
				System.out.println("Übergewichtig.");
			}
		} else if (alter < 45) {
			if (bmi < 21) {
				System.out.println("Untergewichtig.");
			} else if (bmi <= 26) {
				System.out.println("Normalgewichtig.");
			} else {
				System.out.println("Übergewichtig.");
			}
		} else if (alter < 55) {
			if (bmi < 22) {
				System.out.println("Untergewichtig.");
			} else if (bmi <= 27) {
				System.out.println("Normalgewichtig.");
			} else {
				System.out.println("Übergewichtig.");
			}
		} else if (alter < 65) {
			if (bmi < 23) {
				System.out.println("Untergewichtig.");
			} else if (bmi <= 28) {
				System.out.println("Normalgewichtig.");
			} else {
				System.out.println("Übergewichtig.");
			}
		} else // Alter >= 65
		{
			if (bmi < 24) {
				System.out.println("Untergewichtig.");
			} else if (bmi <= 29) {
				System.out.println("Normalgewichtig.");
			} else {
				System.out.println("Übergewichtig.");
			}
		}

	}
}
