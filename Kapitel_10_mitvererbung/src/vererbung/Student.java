package vererbung;

import java.util.Random;

public class Student extends Person{
	
	private String matrikelnummer;

	public Student(String vorname, String nachname, int alter, String matrikelnummer) {
		super(vorname, nachname, alter);
		this.matrikelnummer = matrikelnummer;
	}

	public String getMatrikelnummer() {
		return matrikelnummer;
	}
	
	public String getTextDarstellung() {
		String textOberklasse = super.getTextDarstellung();
		return textOberklasse + ", Matrikelnummer " + matrikelnummer;
	}
	
	public void besucheVorlesung() {
		Random r = new Random();
		switch (r.nextInt(3)) {
			case 0: System.out.println("Vererbung ???"); break;
			case 1: System.out.println("weiter geben ???"); break;
			case 2: System.out.println("Eigenschaften ???"); break;
		}
	}
}
