package blackjack;

import javax.swing.JOptionPane;

import blackjack.karten.Kartenhand;

/**
 * Diese Klasse stellt diverse statische Methoden zur Verfuegung, um mit dem
 * Anwender zu kommunizieren. Da alle Methoden statisch sind, muessen keine
 * Objekte erzeugt werden und konsequenterweise wird auch gar kein oeffentlicher
 * Konstruktor angeboten.
 * 
 * @author Malte Knutz
 * 
 */
public class Benutzerinterface {

	/**
	 * Names des Spiels. Wird in jedem Fenster als Titel verwendet.
	 */
	private static final String TITEL = "Virtual Black Jack";

	/**
	 * die Bezeichnung eines moeglichen Spielzuges: hit.
	 */
	public static final String SPIELZUG_HIT = "hit (Karte nehmen)";
	/**
	 * die Bezeichnung eines moeglichen Spielzuges: stay.
	 */
	public static final String SPIELZUG_STAY = "stay (Blatt behalten)";

	/**
	 * privater Konstruktor, da niemand Objekte erzeugen sollte.
	 */
	private Benutzerinterface() {
	}

	/**
	 * Gibt die Begruessungsmeldung zum Spiel aus.
	 * 
	 */
	public static void begruessung() {
		String text = "Willkommen beim Virtual Black Jack\n"
				+ "Das Spiel wird unverzueglich starten, der Geber haelt die ersten beiden Karten schon parat...";
		JOptionPane.showMessageDialog(null, text, TITEL, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Fragt den Anwender nach dem Spielzug.
	 * 
	 * @param kartenhand
	 *            Die bisherige Kartenhand des Spielers.
	 * @return SPIELZUG_HIT oder SPIELZUG_STAY
	 */
	public static String frageNachSpielzug(Kartenhand kartenhand) {
		String text = "Ihre Karten: " + kartenhand.getTextdarstellung() + "\nIhr Spielzug?";
		// Die Moeglichkeiten des Anwenders
		String[] optionen = new String[2];
		optionen[0] = SPIELZUG_HIT;
		optionen[1] = SPIELZUG_STAY;
		// Die Frage herausgeben
		int auswahl = JOptionPane.showOptionDialog(null, text, TITEL, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, optionen, optionen[0]);
		// Die Antwort verarbeiten: Wenn der Dialog geschlossen wird (uebers
		// Kreuz), dann das Programm sofort beenden
		if (auswahl == JOptionPane.CLOSED_OPTION) {
			System.exit(0);
		}
		return optionen[auswahl];
	}

	/**
	 * Informiert den Anwender ueber die Kartenhand des Gebers.
	 * 
	 * @param kartenhand
	 *            die Kartenhand des Gebers.
	 */
	public static void informiereUeberGeberKartenzug(Kartenhand kartenhand) {
		String text = "Der Geber zieht eine Karte.\nDer Geber hat nun: " + kartenhand.getTextdarstellung();
		JOptionPane.showMessageDialog(null, text, TITEL, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Gibt eine Verloren-Meldung mit der Begruendung aus, dass der Spieler mehr
	 * als 21 Punkte hat.
	 * 
	 * @param kartenGeber
	 *            Karten des Gebers zum Spielende
	 * @param kartenSpieler
	 *            Karten des Spielers zum Spielende
	 */
	public static void verlorenUeber21(Kartenhand kartenGeber, Kartenhand kartenSpieler) {
		String text = "bust! (Schandhafte Niederlage)\n\n" + erzeugeKartenaufstellung(kartenGeber, kartenSpieler);
		JOptionPane.showMessageDialog(null, text, TITEL, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Gibt eine Gewonnen-Meldung mit der Begruendung aus, dass der Geber mehr
	 * als 21 Punkte hat
	 * 
	 * @param kartenGeber
	 *            Karten des Gebers zum Spielende
	 * @param kartenSpieler
	 *            Karten des Spielers zum Spielende
	 */
	public static void gewonnenGeberUeber21(Kartenhand kartenGeber, Kartenhand kartenSpieler) {
		String text = "G E W O N N E N\n\n" + erzeugeKartenaufstellung(kartenGeber, kartenSpieler);
		JOptionPane.showMessageDialog(null, text, TITEL, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Gibt eine Verloren-Meldung mit der Begruendung aus, dass der Geber mehr
	 * Punkte als der Spieler hat.
	 * 
	 * @param kartenGeber
	 *            Karten des Gebers zum Spielende
	 * @param kartenSpieler
	 *            Karten des Spielers zum Spielende
	 */
	public static void verlorenGeberHatMehr(Kartenhand kartenGeber, Kartenhand kartenSpieler) {
		String text = "Besonders schandhafte Niederlage\n" + erzeugeKartenaufstellung(kartenGeber, kartenSpieler);
		JOptionPane.showMessageDialog(null, text, TITEL, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Gibt eine Gewonnen-Meldung mit der Begruendung aus, dass der Spieler mehr
	 * Punkte als der Geber hat.
	 * 
	 * @param kartenGeber
	 *            Karten des Gebers zum Spielende
	 * @param kartenSpieler
	 *            Karten des Spielers zum Spielende
	 */
	public static void gewonnenGeberHatWeniger(Kartenhand kartenGeber, Kartenhand kartenSpieler) {
		String text = "G E W O N N E N\n\n" + erzeugeKartenaufstellung(kartenGeber, kartenSpieler);
		JOptionPane.showMessageDialog(null, text, TITEL, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Gibt eine Unentschieden-Meldung mit der Begruendung aus, dass Spieler und
	 * Geber gleich viele Punkte haben.
	 * 
	 * @param kartenGeber
	 *            Karten des Gebers zum Spielende
	 * @param kartenSpieler
	 *            Karten des Spielers zum Spielende
	 */
	public static void unentschieden(Kartenhand kartenGeber, Kartenhand kartenSpieler) {
		String text = "Unentschieden\n\n" + erzeugeKartenaufstellung(kartenGeber, kartenSpieler);
		JOptionPane.showMessageDialog(null, text, TITEL, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Erzeugt eine zweizeilige Textdarstellung mit den Kartenhaenden des Gebers
	 * und des Spielers.
	 * 
	 * @param kartenGeber
	 *            Karten des Gebers
	 * @param kartenSpieler
	 *            Karten des Spielers
	 * @return Textdarstellung mit den Kartenhaenden des Gebers und des Spielers
	 */
	private static String erzeugeKartenaufstellung(Kartenhand kartenGeber, Kartenhand kartenSpieler) {
		return "Ihre Karten: " + kartenSpieler.getTextdarstellung() + "\nKarten des Gebers: "
				+ kartenGeber.getTextdarstellung();
	}
}
