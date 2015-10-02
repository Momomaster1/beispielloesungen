public class Fakultaet {

	public static void main(String[] args) {

		int eingabe = 31;
		int loesung = 1;

		for (int n = 2; n <= eingabe; n++) {
			loesung = loesung * n;
		}

		System.out.println("Die Fakultaet von " + eingabe + " ist " + loesung);

	}

}