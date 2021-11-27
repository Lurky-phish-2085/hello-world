import java.util.Scanner;

class Player {

	private String name;
	private String gender;
	private String answer;

	Player() {
		// code
	}
	Player(String name, String gender) {
		setName(name);
		setGender(gender);
	}

	void setName(String name) {
		this.name = name;
	}

	void setGender(String gender) {
		this.gender = gender;
	}

	void setAnswer(String answer) {
		this.answer = answer;
	}

	String getName() {
		return name;
	}

	String getGender() {
		return gender;
	}

	String getAnswer() {
		return answer;
	}

	void answer() {
		Scanner in = new Scanner(System.in);
		answer = in.nextLine();
	}
}
