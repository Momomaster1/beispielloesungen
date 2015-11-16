package de.nordakademie.kundenverwaltung;

public class JuristischePerson extends Person {

    private String rechtsform;

    public JuristischePerson(String name, String adresse, String rechtsform) {
        super(name, adresse);
        this.rechtsform = rechtsform;
    }

    public boolean istPremiumkunde() {
        // Kapitalgesellschaften benötigen doppelt so viel Bestellvolumen für den Premium-Status
        if (istKapitalgesellschaft()) {
            return getBisherigesBestellvolumen() >= 100000;
        } else {
            return getBisherigesBestellvolumen() >= 50000;
        }
    }

    public boolean istRetoureErlaubt() {
        return false;
    }

    public boolean istKapitalgesellschaft() {
        // Vereinfachte Bestimmung basierend auf https://de.wikipedia.org/wiki/Kapitalgesellschaft
        return (rechtsform.contains("AG") || rechtsform.contains("GmbH") || rechtsform.contains("KGaA"));
    }

    public String lieferePostanschrift() {
        return getName() + " " + rechtsform + "\n" + getAdresse();
    }

}
