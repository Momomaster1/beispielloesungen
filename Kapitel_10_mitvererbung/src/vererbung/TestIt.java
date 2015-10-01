package vererbung;

public class TestIt {

	public static void main(String[] args) {

		
		Dozent d = new Dozent("Ernst", "Müller", 42, "Informatik");
		System.out.println(d.getTextDarstellung());
		d.halteVorlesung();
		 
		System.out.println("------------------------");
		
		Student s = new Student("August", "Meier", 22, "W07d-1111");
		System.out.println(s.getTextDarstellung());
		s.besucheVorlesung();
		
	}
	

}
