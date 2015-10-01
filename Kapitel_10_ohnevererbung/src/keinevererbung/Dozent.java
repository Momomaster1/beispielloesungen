package keinevererbung;


public class Dozent{
	private String vorname;
	private String nachname;
	private int alter;
	private String fachbereich;

	public Dozent(String vorname, String nachname, int alter, String fachbereich) {
		this.fachbereich = fachbereich;
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
	}

	public String getTextDarstellung() {
		return vorname + " " + nachname + " (" + alter + ")" + ", Fachbereich " + fachbereich;
	}

	public void halteVorlesung() {
		System.out.println("...Vererbung erlaubt Eigenschaften und Methoden weiter zu geben...");
		System.out.println("...beispielsweise soll eine Klasse Student und eine Klasse Dozent erstellt werden...");
		System.out.println("...beide Klassen besitzen gemeinsame Eigenschaften...");
	}
	
	//im folgenden nur noch 4 get-Methoden...
}
