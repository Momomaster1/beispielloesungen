public class Kundenrabatt {

	public static void main(String[] args) {

		double bestellwert = 1000;
		double bisherigesKundenBestellvolumen = 10000;
		boolean istPremiumKunde = true;

		double rabatt = 0; // 0 entspricht 0%, 1 entspricht 100%

		// -----------------------
		// Regeln zum Mengenrabatt
		// -----------------------

		if (bestellwert >= 5000) {
			// 5000 oder mehr? Dann 5%
			rabatt = 0.05;
		} else if (bestellwert >= 2000) {
			// Mehr als 5000 warens nicht... wenigstens 2000 oder mehr? Dann 3%
			rabatt = 0.03;
		} else if (bestellwert >= 500) {
			// Mehr als 2000 warens nicht... wenigstens 500 oder mehr? Dann 2%
			rabatt = 0.02;
		} else if (bestellwert >= 100) {
			// Mehr als 5000 warens nicht... wenigstens 100 oder mehr? Dann 1%
			rabatt = 0.01;
		}

		// Verdopplung bei Premiumkunden
		if (istPremiumKunde) {
			rabatt = rabatt * 2;
		}

		// -----------------------
		// Regeln zum Treuerabatt
		// -----------------------

		if (bisherigesKundenBestellvolumen >= 50000) {
			// 50000 oder mehr? Dann 12,5% drauf
			rabatt = rabatt + 0.125;
		} else if (bisherigesKundenBestellvolumen >= 10000) {
			// Mehr als 50000 warens nicht... wenigstens 10000 oder mehr? Dann
			// 7,5%
			rabatt = rabatt + 0.075;
		}

		// -----------------------
		// Regeln zum Bonusrabatt
		// -----------------------

		if (bestellwert >= (2 * bisherigesKundenBestellvolumen)) {
			rabatt = rabatt + 0.03;
		}

		// -----------------------
		// Regeln zur Obergranze
		// -----------------------

		if (istPremiumKunde && (rabatt > 0.20)) {
			rabatt = 0.20;
		}
		if ((!istPremiumKunde) && (rabatt > 0.15)) {
			rabatt = 0.15;
		}

		// -----------------------
		// Ausgabe
		// -----------------------

		System.out.println("*** Eingabedaten ***");
		System.out.println("");
		System.out.println("Bisheriges Bestellvolumen: " + bisherigesKundenBestellvolumen);
		System.out.println("Bestellhöhe aktuell: " + bestellwert);
		if (istPremiumKunde) {
			System.out.println("Kunde ist Premiumkunde.");
		} else {
			System.out.println("Kunde ist (noch) kein Premiumkunde.");
		}

		double rabattInProzent = rabatt * 100;
		double rabattInEuro = bestellwert * rabatt;
		double neuerBestellwert = bestellwert - rabattInEuro;

		System.out.println("");
		System.out.println("*** Ergebnis Rabattrechnung ***");
		System.out.println("");
		System.out.println("Gewährter Rabatt: " + rabattInEuro + " € (" + rabattInProzent + "%)");
		System.out.println("Rechnungshöhe: " + neuerBestellwert);

	}

}
