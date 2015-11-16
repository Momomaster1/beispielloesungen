package de.nordakademie.kundenverwaltung;

public class Main {

    public static void main(String[] args) {

        Person[] personen = erzeugePersonen();

        for (Person p : personen) {
            System.out.println(p);
            System.out.println("-------------------------------------------");
        }

    }

    private static Person[] erzeugePersonen() {
        Person[] personen = new Person[6];
        personen[0] = new NatuerlichePerson("Horst Nachbesteller", "Auf dem Deich 17", "Herr");
        personen[0].neueBestellung(100);
        personen[0].ergaenzeBestellung(10);

        personen[1] = new NatuerlichePerson("Tanja Umtausch", "Wiesengrund 42", "Frau");
        for (int i=0; i<10; i++) {
            personen[1].neueBestellung(100);
            personen[1].ergaenzeBestellung(-99);
        }

        personen[2] = new JuristischePerson("Nordakademie", "Koellner Chaussee 11", "gAG");
        personen[2].neueBestellung(40000);
        personen[2].neueBestellung(80000);

        personen[3] = new JuristischePerson("Gruenfrieden", "Waldweg 1", "e.V.");
        personen[3].neueBestellung(50000);
        personen[3].ergaenzeBestellung(4000);
        personen[3].ergaenzeBestellung(-300); // diese Retoure darf nicht ausgefuehrt werden

        personen[4] = new JuristischePerson("Muschel Tankstellen", "Spritgasse 7", "GmbH & Co. KG");
        personen[4].neueBestellung(99999);

        personen[5] = new Person("Crashtestdummy", "irgendwo auf dem Schrottplatz");
        personen[5].neueBestellung(1);

        return personen;

    }
}
