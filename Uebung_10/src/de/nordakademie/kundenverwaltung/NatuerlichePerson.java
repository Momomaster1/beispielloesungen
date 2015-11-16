package de.nordakademie.kundenverwaltung;

public class NatuerlichePerson extends Person {

    private String anrede;

    public NatuerlichePerson(String name, String adresse, String anrede) {
        super(name, adresse);
        this.anrede = anrede;
    }

    public boolean istPremiumkunde() {
        return getAnzahlBestellungen() >= 10;
    }

    public boolean istRetoureErlaubt() {
        return true;
    }

    public String lieferePostanschrift() {
        return anrede + " " + getName() + "\n" + getAdresse();
    }

}
