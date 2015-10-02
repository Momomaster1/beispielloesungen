public class BinomischeFormel {

	public static void main(String[] args) {
		double a = 8;
		double b = 3;

		// (a+b)^2 = a^2 + 2ab + b^2
		double binomLinks = Math.pow((a + b), 2);
		double binomRechts = Math.pow(a, 2) + 2 * a * b + Math.pow(b, 2);

		System.out.println("(a+b)^2 = " + binomLinks);
		System.out.println("a^2 + 2ab + b^2 = " + binomRechts);
	}

}
