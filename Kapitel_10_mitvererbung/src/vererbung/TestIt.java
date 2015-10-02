package vererbung;

public class TestIt {

	public static void main(String[] args) {
		testeVererbung();
		testePolymorphie();
	}
	
	private static void testeVererbung() {
		Dozent d = new Dozent("Ernst", "Müller", 42, "Informatik");
		System.out.println(d.getTextDarstellung());
		d.halteVorlesung();
		 
		System.out.println("------------------------");
		
		Student s = new Student("August", "Meier", 22, "W07d-1111");
		System.out.println(s.getTextDarstellung());
		s.besucheVorlesung();
	}
	
	private static void testePolymorphie() {
		Person[] personenliste = erzeugePersonen();
		
		for (Person p : personenliste){
			System.out.println(p.getTextDarstellung());
		}
	}

	private static Person[] erzeugePersonen(){
		Person[] personen = new Person[5];
		personen[0] = new Dozent("Ernst", "Müller", 42, "Informatik");
		personen[1] = new Student("August", "Meier", 22, "W07d-1111");
		personen[2] = new Student("Frieda", "Schulz", 21, "W07d-1111");
		personen[3] = new Person("Berta", "Meyer", 33);
		personen[4] = new Person("Sigfried", "Schultz", 58);
		return personen;
	}
	

}
