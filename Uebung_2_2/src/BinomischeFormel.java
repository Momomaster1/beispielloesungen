public class BinomischeFormel {

	public static void main(String[] args) {
		double a = 8;
		double b = 3;

		// (a+b)² = a² + 2ab + b²
		double binomLinks = Math.pow((a + b), 2);
		double binomRechts = Math.pow(a, 2) + 2 * a * b + Math.pow(b, 2);

		System.out.println("(a+b)² = " + binomLinks);
		System.out.println("a² + 2ab + b² = " + binomRechts);
	}

}
