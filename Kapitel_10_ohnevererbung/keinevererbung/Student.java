package keinevererbung;
import java.util.Random;

public class Student {
	private String vorname;
	private String nachname;
	private int alter;
	private String matrikelnummer;

	public Student(String vorname, String nachname, int alter, String matrikelnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
		this.matrikelnummer = matrikelnummer;
	}

	public String getTextDarstellung() {
		return vorname + " " + nachname + " (" + alter + ")" + ", Matrikelnummer " + matrikelnummer;
	}

	public void besucheVorlesung() {
		Random r = new Random();
		switch (r.nextInt(3)) {
			case 0: System.out.println("Vererbung ???"); break;
			case 1: System.out.println("weiter geben ???"); break;
			case 2: System.out.println("Eigenschaften ???"); break;
		}
	}
	
	// im folgenden nur noch 4 get-Methoden...
}
