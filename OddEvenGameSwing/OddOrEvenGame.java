class OddOrEvenGame {

	private final int MAX_NUMBERS_COUNT = 5;

	private Player p1; 
	private NumberGenerator[] nums;
	private int score = 0;

	OddOrEvenGame() {
		generateNumbers(MAX_NUMBERS_COUNT);
		p1 = new Player();
	}

	int getScore() {
		return score;
	}

	NumberGenerator[] getNums() {
		return nums;
	}
	NumberGenerator getNums(int index) {
		if (!(index > (nums.length - 1))) {
			return nums[index];
		} else {
			System.err.println("index out of bounds!");
			return null;
		}
	}

	void generateNumbers(int maxCount) {
		nums = new NumberGenerator[maxCount];
		for (int i = 0; i < maxCount; i++) {
			nums[i] = new NumberGenerator();
		}
	}

	void addScore(int increment) {
		score += increment;
	}

	void startGame() {
		System.out.println("Odd or Even?");
		for (int i = 0; i < nums.length; i++) {
			int number = nums[i].getNumber();
			String parity = nums[i].getParity();

			System.out.println("\n" + number);
			System.out.print("Your answer: ");
			p1.answer();
			String answer = p1.getAnswer();

			if (answer.equalsIgnoreCase(parity)) {
				score++;
			}
		}

		System.out.println("RESULT: " + score + "/" + nums.length);
	}

	//public static void main(String[] args) {
	//	// code
	//	OddOrEvenGame o = new OddOrEvenGame();
	//	//o.startGame();
	//	NumberGenerator[] ng1 = o.getNums();
	//	for (int i = 0; i < ng1.length; i++) {
	//		System.out.println(ng1[i].toString());
	//	}
	//
	//	System.out.println("get 0");
	//	System.out.println(o.getNums(4));
	//}
}
