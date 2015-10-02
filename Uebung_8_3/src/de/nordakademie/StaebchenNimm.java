package de.nordakademie;

import java.util.Random;

import javax.swing.JOptionPane;

public class StaebchenNimm {

	private static final Random RANDOMIZER = new Random();

	public static void main(String[] args) {

		// Wir beginnen mit 13 bis 16 Staebchen
		int restStaebchen = 13 + RANDOMIZER.nextInt(4);

		String nachricht = "Du faengst an!";

		// Endlosschleife (wird mit System.exit() abgebrochen)
		while (true) {
			int spieler = zugVomSpieler(restStaebchen, nachricht);
			restStaebchen = restStaebchen - spieler;

			pruefeRest(restStaebchen, true);

			int computer = bestimmeComputerZug(restStaebchen);
			restStaebchen = restStaebchen - computer;
			nachricht = "Ich nehme " + computer + " Staebchen.";
			if (restStaebchen == 1) {
				nachricht = nachricht + " Looser!";
			}

			pruefeRest(restStaebchen, false);
		}

	}

	private static void pruefeRest(int rest, boolean spielerWarDran) {
		// Wenn keine Staebchen da sind hat jemand verloren
		if (rest < 1) {
			String text;
			if (spielerWarDran) {
				text = "Die KI siegt! Der Tag des juengsten Gerichts rueckt naeher...";
			} else {
				text = "Der Mensch gewinnt!";
			}
			JOptionPane.showMessageDialog(null, text, "Game over", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	private static int bestimmeComputerZug(int rest) {
		if (rest == 1) {
			// hat wohl nicht geklappt, ist nur noch 1 da
			return 1;
		}

		// Das ist mal ne kuenstliche Intelligenz...
		// Der Trick: Man gewinnt immer, wenn man dem Gegner
		// 1, 5, 9 oder 13 Staebchen uebrig laesst, d.h.
		// Fuer 2,3,4, 6,7,8, 10,11,12, 14,15,16 muessen wir
		// 1,2,3, 1,2,3, 1, 2, 3, 1, 2, 3 Staebchen nehmen
		// Diese Tabelle kann auch mathematisch bestimmt werden, indem
		// man auf die Anzahl Staebchen 3 addiert und dann modulo 4 rechnet.
		// Beispiel: (7 + 3) mod 4 ergibt 2... => 2 Staebchen nehmen
		// Nur bei 1,5,9 oder 13 muesste man eigentlich 0 nehmen, was laut
		// Spielregel nicht sein darf. Da muessen wir was zufaellig nehmen.

		int nehmen = (rest + 3) % 4;

		if (nehmen > 0) {
			return nehmen;
		} else {
			// Bei 0 muessen wir zufaellig ein paar nehmen
			return RANDOMIZER.nextInt(3) + 1;
		}
	}

	private static int zugVomSpieler(int rest, String nachrichtVomComputerspieler) {
		final String OPTION_1 = "Eins nehmen";
		final String OPTION_2 = "Zwei nehmen";
		final String OPTION_3 = "Drei nehmen";

		String text = nachrichtVomComputerspieler + "\nEs liegen noch " + rest
				+ " Staebchen auf dem Tisch\nWieviele willst du nehmen?";

		// Bestimmen, welche Optionen der Spieler ueberhaupt noch hat...
		String[] optionen;
		if (rest == 1) {
			optionen = new String[1];
			optionen[0] = OPTION_1;
		} else if (rest == 2) {
			optionen = new String[2];
			optionen[0] = OPTION_1;
			optionen[1] = OPTION_2;
		} else {
			optionen = new String[3];
			optionen[0] = OPTION_1;
			optionen[1] = OPTION_2;
			optionen[2] = OPTION_3;
		}

		int wahl = JOptionPane.showOptionDialog(null, text, "Spieler ist am Zug", JOptionPane.NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, optionen, optionen[0]);

		// Der Optionsdialog liefert -1, wenn nichts ausgewaehlt wird.
		// dies ist nur der Fall, wenn er ueber das X geschlossen wird.
		if (wahl < 0) {
			System.exit(0);
		}

		if (OPTION_1.equals(optionen[wahl])) {
			return 1;
		}
		if (OPTION_2.equals(optionen[wahl])) {
			return 2;
		}
		return 3;
	}

}
