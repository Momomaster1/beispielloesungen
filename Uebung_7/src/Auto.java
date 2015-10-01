public class Auto {

	// Immergültige Konstanten
	private static final double PROFILTIEFE_NEUER_REIFEN = 0.8;
	private static final double PROFILTIEFE_MINIMAL_ERLAUBT = 0.3;
	private static final double REIFENABNUTZUNG_PRO_KM = 0.00025;

	// Pro Auto unveränderbar
	private final double maxTankVolumen;
	private final double verbrauchProKm;
	private final int wagennr;

	// Veränderliche Attribute
	private double kilometerstand;
	private double tankinhalt;
	private double profiltiefeReifen;
	private Person fahrer;

	// Statische Variable
	private static int naechsteFreieWagennr = 1;

	public Auto(double maxTankVolumen, double verbrauchProKm) {
		this.maxTankVolumen = maxTankVolumen;
		this.verbrauchProKm = verbrauchProKm;

		// dieses Auto bekommt seine Wagennummer ...
		this.wagennr = naechsteFreieWagennr;
		naechsteFreieWagennr++;

		// gleich volltanken und frische Reifen drauf
		tanken();
		wechsleReifen();
	}

	public Person getFahrer() {
		return fahrer;
	}

	public void setFahrer(Person fahrer) {
		this.fahrer = fahrer;
	}

	public void fahre(double km) {
		// Ist ein Fahrer gesetzt und ist er alt genug?
		if (!isFahrerOk()) {
			return;
		}

		// Erstmal nachsehen, wie weit wir grundsätzlich kommen würden
		double reichweite = bestimmeReichweite();

		// Will jemand weiter fahren als die Reichweite beträgt?
		// Wenn ja, dann müssen wir das beschränken
		double wirklichGefahreneKm;
		if (km > reichweite) {
			wirklichGefahreneKm = reichweite;
		} else {
			wirklichGefahreneKm = km;
		}

		// Und nun kommt das eigentliche fahren
		kilometerstand = kilometerstand + wirklichGefahreneKm;
		tankinhalt = tankinhalt - (getBenzinverbrauchProKm() * wirklichGefahreneKm);
		profiltiefeReifen = profiltiefeReifen - (getReifenAbnutzungProKm() * wirklichGefahreneKm);

	}

	private double bestimmeReichweite() {
		// Reichweite des Tanks bestimmen
		double reichweiteTank = tankinhalt / getBenzinverbrauchProKm();

		// Reichweite der Reifen bestimmen
		double verfahrbaresRestprofil = profiltiefeReifen - PROFILTIEFE_MINIMAL_ERLAUBT;
		double reichweiteReifen = verfahrbaresRestprofil / getReifenAbnutzungProKm();

		// Jetzt prüfen, was mehr einschränkt. Die Reifen oder Tank?
		if (reichweiteReifen < reichweiteTank) {
			return reichweiteReifen;
		} else {
			return reichweiteTank;
		}
	}

	private double getReifenAbnutzungProKm() {
		// Diese Methode bestimmt, wie stark die Reifenabnutzung pro Km
		// wäre, wenn das Auto jetzt fahren würde
		if (!isFahrerOk()) {
			return 0;
		}
		if (fahrer.getAlter() <= 20) {
			return REIFENABNUTZUNG_PRO_KM * 1.05;
		}
		if (fahrer.getAlter() >= 60) {
			return REIFENABNUTZUNG_PRO_KM * 0.95;
		}
		return REIFENABNUTZUNG_PRO_KM;
	}

	private double getBenzinverbrauchProKm() {
		// Diese Methode bestimmt, wie stark der Benzinverbrauch pro Km
		// wäre, wenn das Auto jetzt fahren würde
		if (!isFahrerOk()) {
			return 0;
		}
		if (fahrer.getAlter() <= 20) {
			return verbrauchProKm * 1.10;
		}
		if (fahrer.getAlter() >= 60) {
			return verbrauchProKm * 0.90;
		}
		return verbrauchProKm;
	}

	private boolean isFahrerOk() {
		// Ohne Fahrer läuft hier gar nichts
		if (fahrer == null) {
			return false;
		}
		// Jünger als 18? Dann passiert auch nix
		if (fahrer.getAlter() < 18) {
			return false;
		}
		// Sonst ist alles ok
		return true;
	}

	public void gebeDatenAus() {
		String fahrername = "Kein Fahrer";
		if (fahrer != null) {
			fahrername = fahrer.getName();
		}
		System.out.println(getWagenname() + " : " + fahrername + " am Steuer, " + kilometerstand
				+ " bisher gefahren. Tankinhalt " + tankinhalt + " liter und " + profiltiefeReifen + " mm Reifenprofil übrig.");
	}

	public double getkilometerstand() {
		return kilometerstand;
	}

	public double getTankinhalt() {
		return tankinhalt;
	}

	public void tanken() {
		// Einfach Tank voll machen
		tankinhalt = maxTankVolumen;
	}

	public void wechsleReifen() {
		// Reifenprofiltiefe wieder neu
		profiltiefeReifen = PROFILTIEFE_NEUER_REIFEN;

	}

	public void tanken(double liter) {
		// Zuviel getankt?
		if (liter + tankinhalt > maxTankVolumen) {
			// Ja: Dann einfach nur Tank voll machen
			tanken();
		} else {
			// Nein: Tank um die Tankmenge füllen
			this.tankinhalt = liter + tankinhalt;
		}
	}

	public String getWagenname() {
		return "Wagen Nr. " + wagennr;
	}

}
