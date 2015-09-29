
public class SummeBisMaximumCodingDojo {

	public static void main(String[] args) {
		
		int maximum = 1000000;
		int zaehler = 0;
		
		for (int summe=0; summe<=maximum; summe=summe+zaehler) {
			System.out.println("Summe: "+summe);
			zaehler = zaehler +1;
		}

	}

}
