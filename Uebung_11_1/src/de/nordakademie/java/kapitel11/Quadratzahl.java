package de.nordakademie.java.kapitel11;

import javax.swing.JOptionPane;

public class Quadratzahl {

	public static void main(String[] args) {
		String eingabe;
		do {
			eingabe = JOptionPane.showInputDialog("Bitte geben Sie eine Zahl ein!");
			try {
				int zahl = Integer.parseInt(eingabe);
				System.out.println(zahl + "x" + zahl + " = " + zahl * zahl);
			} catch (NumberFormatException ex) {
				if ("".equals(eingabe)) {
					System.out.println("Sie haben nichts eingegeben!");
				} else {
					System.out.println("Sie haben keine gueltige Zahl eingegeben: " + eingabe);
				}
			}
		} while (eingabe != null);
	}

}