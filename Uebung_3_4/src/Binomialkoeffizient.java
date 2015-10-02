public class Binomialkoeffizient {

	public static void main(String[] args) {

		int n = 49;
		int k = 6;

		// /n\ n!
		// | | = ---------------
		// \k/ k! * (n - k)!

		// double-Datentyp wegen dem grossen Wertebereich
		double n_fak = 1;
		double k_fak = 1;
		double n_minus_k_fak = 1;

		// mit Schleifen die Fakultaet berechnen
		// Es haette sonst ein extra jar dafuer gegeben, aber
		// als Beispielloesung koennen wir drauf verzichten,
		// da es naechste Veranstaltung sowieso Schleifen gibt...

		for (int i = 2; i <= n; i = i + 1) {
			n_fak = n_fak * i;
		}

		for (int i = 2; i <= k; i = i + 1) {
			k_fak = k_fak * i;
		}

		for (int i = 2; i <= (n - k); i = i + 1) {
			n_minus_k_fak = n_minus_k_fak * i;
		}

		double ergebnis = n_fak / (k_fak * n_minus_k_fak);

		System.out.println("Ergebnis: " + ergebnis);

	}

}
