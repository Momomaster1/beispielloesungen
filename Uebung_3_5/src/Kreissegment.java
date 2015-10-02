public class Kreissegment {

	public static void main(String[] args) {
		double r = 1;
		double alphaGrad = 90;

		// sin und cos arbeiten mit bogenmass
		double alphaBogenmass = Math.toRadians(alphaGrad);

		// Flaeche gemaess Formel in der Aufgabe
		// (r hoch zwei wird einfach durch r*r ersetzt)
		double flaeche = (alphaGrad / 360 * r * r * Math.PI) - (0.5 * r * r * Math.sin(alphaBogenmass));

		// Hoehe gemaess Formel in der Aufgabe
		double hoehe = r - (r * Math.cos(alphaBogenmass / 2));

		// Bogenlaenge gemaess Formel in der Aufgabe
		double bogenlaenge = r * Math.PI * alphaGrad / 180;

		// Sehnenlaenge gemaess Formel in der Aufgabe
		double sehnenlaenge = 2 * Math.sqrt((r * r) - ((r - hoehe) * (r - hoehe)));

		System.out.println("r = " + r);
		System.out.println("alpha (in Grad)= " + alphaGrad);
		System.out.println("alpha (in Bogenmass)= " + alphaGrad);
		System.out.println("--------------------------------");
		System.out.println("A = " + flaeche);
		System.out.println("h = " + hoehe);
		System.out.println("b = " + bogenlaenge);
		System.out.println("s = " + sehnenlaenge);

	}

}
