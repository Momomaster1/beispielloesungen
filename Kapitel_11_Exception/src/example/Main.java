package example;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hallo, bin gerade in Methode main, Punkt A!");
		tuWas(); 
		System.out.println("Hallo, bin gerade in Methode main, Punkt B!");
	}
	
	public static void tuWas(){
		System.out.println("Hallo, bin gerade in Methode tuWas, Punkt A!");
		int x = AnotherClass.frageAnwenderNachZahl();
		System.out.println("Hallo, bin gerade in Methode tuWas, Punkt B!");
		int xQuadrat = x*x;
		System.out.println("Hallo, bin gerade in Methode tuWas, Punkt C!");
		JOptionPane.showMessageDialog(null, "Hab das mal quadriert: "+xQuadrat);
		System.out.println("Hallo, bin gerade in Methode tuWas, Punkt D!");
		
	}

}
