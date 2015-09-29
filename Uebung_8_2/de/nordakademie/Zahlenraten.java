package de.nordakademie;

import java.util.Random;

import javax.swing.JOptionPane;

public class Zahlenraten {

	public static void main(String[] args) {

		// Wir verwenden jetzt, wo wir importe kennen, die Java-Komponente
		// Random, welche einen Zufallszahlengenerator darstellt
		Random randomizer = new Random();

		// Die gesuchte Zahl
		int gesuchteZahl = randomizer.nextInt(100) + 1;

		// Einen ersten Tipp abholen
		int zuletztGetippteZahl = rateVersuch("Dein erster Tipp bitte:");
		int anzahlVersuche = 1;

		// In einer Schleife weitere Tipps abholen (falls nocht notwendig)
		while (zuletztGetippteZahl != gesuchteZahl) {

			// größer/kleiner-Tipp ermitteln
			String tipp;
			if (gesuchteZahl < zuletztGetippteZahl) {
				tipp = "Die gesuchte Zahl ist kleiner.";
			} else {
				tipp = "Die gesuchte Zahl ist größer.";
			}

			// Mit dem Tipp gleich nach der nächsten Zahl fragen
			zuletztGetippteZahl = rateVersuch("Das war nix.\n" + tipp + "\nEinfach nochmal probieren:");
			anzahlVersuche++;
		}

		// Fertig
		JOptionPane.showMessageDialog(null, "Heureka! " + zuletztGetippteZahl + " ist richtig. Anzahl Versuche: "
				+ anzahlVersuche);

	}

	private static int rateVersuch(String text) {
		String eingabe = JOptionPane.showInputDialog(text);
		return Integer.parseInt(eingabe);
	}

}
