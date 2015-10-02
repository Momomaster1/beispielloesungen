package blackjack;

import blackjack.karten.Kartenhand;
import blackjack.karten.Spielkartenstapel;

/**
 * Die Hauptklasse mit der Main-Methode.
 * 
 * @author Malte Knutz
 * 
 */
public class Start {

	/**
	 * Die Main-Methode. Der Einstiegspunkt bei Ausfuehung des Programmes
	 * 
	 * @param args
	 *            Kommandozeilenparameter
	 */
	public static void main(String[] args) {

		// Zuerst einmal Begruessen wir den Spieler
		Benutzerinterface.begruessung();

		// Zuerst mal einen Stapel und 2 Kartenhaende erzeugen
		Spielkartenstapel stapel = new Spielkartenstapel();
		Kartenhand handSpieler = new Kartenhand();
		Kartenhand handGeber = new Kartenhand();

		// Nun dem Spieler 2 Karten geben...
		handSpieler.nimmKarte(stapel);
		handSpieler.nimmKarte(stapel);

		// Nun wird der Spieler auch gleich gefragt, was er tun will
		// (In der einfachen Version blenden wir aus, dass er schon gewonnen
		// haben koennte...)
		String spielzug = Benutzerinterface.frageNachSpielzug(handSpieler);

		// Solange der Spieler Karten zieht, machen wir das
		while (spielzug.equals(Benutzerinterface.SPIELZUG_HIT)) {

			handSpieler.nimmKarte(stapel);

			// Pruefen, ob schon verloren
			if (handSpieler.ermittleWertOptimal() > Konstanten.ZIELWERT) {
				Benutzerinterface.verlorenUeber21(handGeber, handSpieler);
				System.exit(0);
			}

			// Vielleicht moechter der Spieler noch eine Karte haben...
			spielzug = Benutzerinterface.frageNachSpielzug(handSpieler);
		}
		// Nun hat er sich entschieden, keine Karten mehr zu ziehen. Der Geber
		// ist an der Reihe.
		// Um es spannender (nerviger?) zu machen, wird der Anwender ueber jeden
		// Schritt des Gebers informiert
		// Der Geber zieht Karten, bis er mind. 17 Punkte hat.
		while (handGeber.ermittleWertJedesAssZaehlt11() < Konstanten.LIMIT_GEBER) {
			handGeber.nimmKarte(stapel);
			Benutzerinterface.informiereUeberGeberKartenzug(handGeber);
		}

		// Nun ist das Spiel vorbei. Noch klaeren, wie es ausgegangen ist.
		// 1. Moeglichkeit: Geber liegt ueber 21
		// 2. Moeglichkeit: Geber hat mehr als der Spieler
		// 3. Moeglichkeit: Geber hat weniger als der Spieler
		// 4. Moeglichkeit: Gleichstand
		if (handGeber.ermittleWertOptimal() > Konstanten.ZIELWERT) {
			Benutzerinterface.gewonnenGeberUeber21(handGeber, handSpieler);
		} else if (handGeber.ermittleWertOptimal() > handSpieler.ermittleWertOptimal()) {
			Benutzerinterface.verlorenGeberHatMehr(handGeber, handSpieler);
		} else if (handGeber.ermittleWertOptimal() < handSpieler.ermittleWertOptimal()) {
			Benutzerinterface.gewonnenGeberHatWeniger(handGeber, handSpieler);
		} else {
			Benutzerinterface.unentschieden(handGeber, handSpieler);
		}

	}

}
