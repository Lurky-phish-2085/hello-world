import java.util.Random;

class NumberGenerator {

	private final int MAX_RANDOM_NUMBER = 100;

	// properties
	private int number;
	private String parity;

	NumberGenerator() {
		number = generateNumber(MAX_RANDOM_NUMBER);
		parity = checkParity();
	}

	int getNumber() {
		return number;
	}

	String getParity() {
		return parity;
	}

	@Override
	public String toString() {
		String str = number + ":" + parity;

		return str; 
	}

	int generateNumber(int bound) {
		Random r = new Random();
		int out = r.nextInt(bound);

		return out;
	}

	private boolean isDivisibleByTwo() {
		if ((number % 2) == 0) {
			return true;
		}

		return false;
	}	

	String checkParity() {
		if (isDivisibleByTwo()) {
			return "Even";
		} else {
			return "Odd";
		}
	}
}
