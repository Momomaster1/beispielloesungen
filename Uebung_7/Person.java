public class Person {

	private static final int REFERENZ_JAHR = 2007;

	private final String name;
	private final int geburtsjahr;

	public Person(String name, int geburtsjahr) {
		this.name = name;
		this.geburtsjahr = geburtsjahr;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return REFERENZ_JAHR - geburtsjahr;
	}

}
