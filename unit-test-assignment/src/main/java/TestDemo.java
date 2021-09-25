import java.util.Random;

public class TestDemo {

	public int addPositive (int a, int b) {
		int c = 0;
		if (a > 0 && b > 0) {
			c = a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return c;
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	public int randomNumberSquared() {
		return getRandomInt() * getRandomInt();
	}
}
