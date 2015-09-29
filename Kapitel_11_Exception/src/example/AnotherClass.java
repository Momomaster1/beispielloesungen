package example;

import javax.swing.JOptionPane;

public class AnotherClass {

	public static int frageAnwenderNachZahl(){
		System.out.println("Hallo, bin gerade in Methode frageAnwenderNachZahl, Punkt A!");
		String eingabe = JOptionPane.showInputDialog("Bitte Zahl eingeben:");
		System.out.println("Hallo, bin gerade in Methode frageAnwenderNachZahl, Punkt B!");
		int zahl = Integer.parseInt(eingabe);
		System.out.println("Hallo, bin gerade in Methode frageAnwenderNachZahl, Punkt C!");
		return zahl;
	}
	
}
