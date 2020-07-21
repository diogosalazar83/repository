package test;

public class Main {

	public static void main(String[] args) {
		final Scientist s1 = new Scientist("Charles");
		final Scientist s2 = new Scientist("Pier");
		final Scientist s3 = new Scientist("Bob");
		final Scientist s4 = new Scientist("Ivan");

		final Spoon spoon = new Spoon(s1);

		new Thread(() -> s1.eat(spoon, s2)
		).start();
		new Thread(() -> s2.eat(spoon, s3)
		).start();
		new Thread(() -> s3.eat(spoon, s4)
		).start();
		new Thread(() -> s4.eat(spoon, s1)
		).start();
	}
}
