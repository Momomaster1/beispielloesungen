public class Person {

	public String name;
	public int geburtsjahr;

	public Person(String name, int geburtsjahr) {
		this.name = name;
		this.geburtsjahr = geburtsjahr;
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return 2016 - geburtsjahr;
	}

}
