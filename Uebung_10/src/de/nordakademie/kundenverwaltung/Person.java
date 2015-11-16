package de.nordakademie.kundenverwaltung;

public class Person{

    private String name;

    private String adresse;

    public Person(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    private int bisherigesBestellvolumen = 0;

    private int anzahlBestellungen = 0;

    public void neueBestellung(int anzahl) {
        anzahlBestellungen++;
        bisherigesBestellvolumen = bisherigesBestellvolumen + anzahl;
    }

    public void ergaenzeBestellung(int anzahl) {
        if (anzahl >= 0 || anzahl < 0 && istRetoureErlaubt()) {
            bisherigesBestellvolumen = bisherigesBestellvolumen + anzahl;
        }
    }

    public int getWichtigkeit() {
        return anzahlBestellungen + bisherigesBestellvolumen / 10000 ;
    }

    public boolean istPremiumkunde() {
        return false;
    }

    public boolean istRetoureErlaubt() {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAnzahlBestellungen() {
        return anzahlBestellungen;
    }

    public int getBisherigesBestellvolumen() {
        return bisherigesBestellvolumen;
    }

    public String lieferePostanschrift() {
        return name + "\n" + adresse;
    }

    public String toString() {
        return "Kunde: " + name + (istPremiumkunde() ? " (Premium!)\n" : "\n") +
                "Bestellungen: " + anzahlBestellungen + " (Umsatz: " + bisherigesBestellvolumen + ")\n" +
                "Wichtigkeit: " + getWichtigkeit() + "\n" +
                "Lieferanschrift:\n" + lieferePostanschrift();
    }

}
