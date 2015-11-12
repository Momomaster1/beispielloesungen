package blackjack.karten;

/**
 * Objekte dieser Klasse repraesentieren eine einzelne Spielkarte. Einmal erzeugt
 * kann eine Spielkarte Ihren Zustand nicht mehr aendern.
 * 
 * @author Malte Knutz
 * 
 */
public class Spielkarte {

	/**
	 * Die Farbe der Spielkarte. Gueltige Farben sind als Konstanten hinterlegt.
	 */
	private final String farbe;
	/**
	 * Die Bezeichnung einer Spielkarte. Gueltige Bezeichnungen sind als
	 * Konstanten hinterlegt.
	 */
	private final String bezeichnung;

	private static final String BEZEICHNUNG_ASS = "Ass";
	private static final String BEZEICHNUNG_ZWEI = "Zwei";
	private static final String BEZEICHNUNG_DREI = "Drei";
	private static final String BEZEICHNUNG_VIER = "Vier";
	private static final String BEZEICHNUNG_FUENF = "Fuenf";
	private static final String BEZEICHNUNG_SECHS = "Sechs";
	private static final String BEZEICHNUNG_SIEBEN = "Sieben";
	private static final String BEZEICHNUNG_ACHT = "Acht";
	private static final String BEZEICHNUNG_NEUN = "Neun";
	private static final String BEZEICHNUNG_ZEHN = "Zehn";
	private static final String BEZEICHNUNG_BUBE = "Bube";
	private static final String BEZEICHNUNG_DAME = "Dame";
	private static final String BEZEICHNUNG_KOENIG = "Koenig";

	private static final String FARBE_KARO = "Karo";
	private static final String FARBE_HERZ = "Herz";
	private static final String FARBE_PIK = "Pik";
	private static final String FARBE_KREUZ = "Kreuz";

	/**
	 * Erzeugt eine neue Spielkarte.
	 * 
	 * @param farbe
	 *            Die Farbe der Karte
	 * @param bezeichnung
	 *            Die Bezeichnung der Karte
	 */
	public Spielkarte(String farbe, String bezeichnung) {
		this.farbe = farbe;
		this.bezeichnung = bezeichnung;
	}

	/**
	 * Liefert eine Liste aller gueltigen Kartenbezeichnungen.
	 * 
	 * @return eine Liste aller gueltigen Kartenbezeichnungen
	 */
	public static String[] ermittleGueltigeKartenbezeichnungen() {
		String[] gueltigeKartenbezeichnungen = new String[13];
		gueltigeKartenbezeichnungen[0] = BEZEICHNUNG_ASS;
		gueltigeKartenbezeichnungen[1] = BEZEICHNUNG_ZWEI;
		gueltigeKartenbezeichnungen[2] = BEZEICHNUNG_DREI;
		gueltigeKartenbezeichnungen[3] = BEZEICHNUNG_VIER;
		gueltigeKartenbezeichnungen[4] = BEZEICHNUNG_FUENF;
		gueltigeKartenbezeichnungen[5] = BEZEICHNUNG_SECHS;
		gueltigeKartenbezeichnungen[6] = BEZEICHNUNG_SIEBEN;
		gueltigeKartenbezeichnungen[7] = BEZEICHNUNG_ACHT;
		gueltigeKartenbezeichnungen[8] = BEZEICHNUNG_NEUN;
		gueltigeKartenbezeichnungen[9] = BEZEICHNUNG_ZEHN;
		gueltigeKartenbezeichnungen[10] = BEZEICHNUNG_BUBE;
		gueltigeKartenbezeichnungen[11] = BEZEICHNUNG_DAME;
		gueltigeKartenbezeichnungen[12] = BEZEICHNUNG_KOENIG;
		return gueltigeKartenbezeichnungen;
	}

	/**
	 * Liefert eine Liste aller gueltigen Kartenfarben.
	 * 
	 * @return eine Liste aller gueltigen Kartenfarben
	 */
	public static String[] ermittleGueltigeFarben() {
		String[] gueltigeFarben = new String[4];
		gueltigeFarben[0] = FARBE_HERZ;
		gueltigeFarben[1] = FARBE_KARO;
		gueltigeFarben[2] = FARBE_KREUZ;
		gueltigeFarben[3] = FARBE_PIK;
		return gueltigeFarben;
	}

	/**
	 * Ermittelt den normalen Kartenwert, d.h. 2-10 fuer die Karten "Zwei" bis
	 * "Zehn", 10 fuer die Bildkarten Bube, Dame und Koenig sowie 11 fuer das Ass
	 * 
	 * @return den Kartenwert, von 2 bis 11
	 */
	public int getBasiswert() {
		if (getBezeichnung().equals(BEZEICHNUNG_ASS)) {
			return 11;
		} else if (getBezeichnung().equals(BEZEICHNUNG_ZWEI)) {
			return 2;
		} else if (getBezeichnung().equals(BEZEICHNUNG_DREI)) {
			return 3;
		} else if (getBezeichnung().equals(BEZEICHNUNG_VIER)) {
			return 4;
		} else if (getBezeichnung().equals(BEZEICHNUNG_FUENF)) {
			return 5;
		} else if (getBezeichnung().equals(BEZEICHNUNG_SECHS)) {
			return 6;
		} else if (getBezeichnung().equals(BEZEICHNUNG_SIEBEN)) {
			return 7;
		} else if (getBezeichnung().equals(BEZEICHNUNG_ACHT)) {
			return 8;
		} else if (getBezeichnung().equals(BEZEICHNUNG_NEUN)) {
			return 9;
		} else if (getBezeichnung().equals(BEZEICHNUNG_ZEHN)) {
			return 10;
		} else if (getBezeichnung().equals(BEZEICHNUNG_BUBE)) {
			return 10;
		} else if (getBezeichnung().equals(BEZEICHNUNG_DAME)) {
			return 10;
		} else if (getBezeichnung().equals(BEZEICHNUNG_KOENIG)) {
			return 10;
		} else {
			System.out.println("Fehler!!! Ungueltige Karte: " + getBezeichnung());
			System.exit(0);
			return 0;
		}
	}

	/**
	 * Prueft, ob die Karte ein Ass ist.
	 * 
	 * @return true, wenn die Karte ein Ass ist, false wenn nicht
	 */
	public boolean istAss() {
		return getBezeichnung().equals(BEZEICHNUNG_ASS);
	}

	/**
	 * Liefert die Bezeichnung der Karte.
	 * 
	 * @return die Bezeichnung der Karte
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * Liefert die Farbe der Karte.
	 * 
	 * @return die Farbe der Karte
	 */
	public String getFarbe() {
		return farbe;
	}

	/**
	 * Liefert eine lesbare Textdarstellung fuer diese Karte. Beispiel: Pik
	 * Sieben
	 * 
	 * @return eine lesbare Textdarstellung fuer diese Karte.
	 */
	public String getTextdarstellung() {
		return getFarbe() + " " + getBezeichnung();
	}

}
