package vererbung;

public class TestIt2 {

	public static void main(String[] args) {
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
