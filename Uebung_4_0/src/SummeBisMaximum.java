
public class SummeBisMaximum {

	public static void main(String[] args) {
		int maximum = 100000000;
		int summe = 0;
		for (int i=1; summe<=maximum; i=i+1) {
			System.out.println("Summe: " + summe + " / " + maximum);
			summe = summe + i;
		}
	}

}
