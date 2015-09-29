public class BMI {

	public static void main(String[] args) {

		// Eingabewerte
		double gewicht = 100;
		double hoehe = 1.7;
		int alter = 65;
		boolean istm = true; // Wenn die Person männlich ist =>True

		// Berechnung und Ausgabe des BMI
		double bmi;
		bmi = gewicht / (hoehe * hoehe);
		System.out.println("Ihr BMI beträgt: " + bmi);

		// Festlegung der Grenzen für einen akzepablen BMI
		// Ausgangslage ist eine weibliche Person unter 25 Jahren
		// (Die habens am schwersten)
		int minbmi = 19;
		int maxbmi = 24;

		// Männliche Personen können sich einen Punkt mehr erlauben
		// (Ist eine grds. Gesetzmäßigkeit, siehe Tabelle)
		if (istm) {
			minbmi = minbmi + 1;
			maxbmi = maxbmi + 1;
		}

		// Ist man älter als 25, kann man sich einen Punkt mehr erlauben
		// (Ist eine grds. Gesetzmäßigkeit, siehe Tabelle)
		// gleiches gilt dann auch für 35,45,55,65
		if (alter >= 25) {
			minbmi = minbmi + 1;
			maxbmi = maxbmi + 1;
		}
		if (alter >= 35) {
			minbmi = minbmi + 1;
			maxbmi = maxbmi + 1;
		}
		if (alter >= 45) {
			minbmi = minbmi + 1;
			maxbmi = maxbmi + 1;
		}
		if (alter >= 55) {
			minbmi = minbmi + 1;
			maxbmi = maxbmi + 1;
		}
		if (alter >= 65) {
			minbmi = minbmi + 1;
			maxbmi = maxbmi + 1;
		}

		// Auswertung des Ergebnisses. Der BMI ist fertig berechnet
		// und die Grenzen, die als optimal gelten, wurden auch bestimmt
		if (bmi > maxbmi) {
			System.out.println("Das ist zuviel Masse! " + "Der Wert sollte max. " + maxbmi + " betragen.");
		}
		if (bmi < minbmi) {
			System.out.println("Das ist zuwenig Masse! " + "Der Wert sollte min. " + minbmi + " betragen.");
		}
		if (bmi <= maxbmi && bmi >= minbmi) {
			System.out.println("Das ist top!");
		}
	}

}
