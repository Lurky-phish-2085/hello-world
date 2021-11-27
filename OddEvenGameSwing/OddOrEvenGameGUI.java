import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class OddOrEvenGameGUI extends JFrame implements ActionListener {

	OddOrEvenGame game = new OddOrEvenGame();
	NumberGenerator[] nums = game.getNums();
	int index = 0;

	private final Font bigFnt = new Font("Arial", Font.BOLD, 100);
	private final Font smallFnt = new Font("Arial", Font.BOLD, 24);
	private final JLabel label = new JLabel("ODD OR EVEN?", SwingConstants.CENTER);
	private final JLabel main = new JLabel("", SwingConstants.CENTER);
	private final JLabel result = new JLabel("YOU CAN DO IT!", SwingConstants.CENTER);
	private final JButton oddBt = new JButton("ODD");
	private final JButton evenBt = new JButton("EVEN");
	private final JButton exit1 = new JButton("OK");
	private final JButton exit2 = new JButton("OK");

	OddOrEvenGameGUI() {
		setTitle("Odd Or Even Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 300);
		setLayout(new BorderLayout());

		setComponentsFont();
		addActionListeners();
		addComponents();

		initNumber();
	}

	private void setComponentsFont() {
		main.setFont(bigFnt);
		label.setFont(smallFnt);
		result.setFont(smallFnt);
		oddBt.setFont(smallFnt);
		evenBt.setFont(smallFnt);
		exit1.setFont(smallFnt);
		exit2.setFont(smallFnt);
	}

	private void addActionListeners() {
		oddBt.addActionListener(this);
		evenBt.addActionListener(this);
		exit1.addActionListener(this);
		exit2.addActionListener(this);
	}

	private void addComponents() {
		add(label, BorderLayout.NORTH);
		add(main, BorderLayout.CENTER);
		add(result, BorderLayout.SOUTH);
		add(oddBt, BorderLayout.WEST);
		add(evenBt, BorderLayout.EAST);
	}

	private void initNumber() {
		main.setText(Integer.toString(nums[index].getNumber()));
	}

	private void checkButton(JButton e) {
		if (e == exit1 || e == exit2) {
			setVisible(false);
			TitleScreen t = new TitleScreen();
			t.setVisible(true);
		} 
	}

	private boolean isFinal() {
		if (index == nums.length) {
			return true;
		}
		return false;
	}

	private void evaluateAnswer(JButton e) {
		String answer = null;

		if (e == oddBt) {
			answer = "Odd";
		} else if (e == evenBt) {
			answer = "Even";
		}

		if (answer.equalsIgnoreCase(nums[index].getParity())) {
			game.addScore(1);
		}
	}

	private void next() {
		index++;
		main.setText(Integer.toString(nums[index].getNumber()));
	}

	private void showResult() {
		String score = Integer.toString(game.getScore());
		String items = Integer.toString(nums.length);
		String result = score + "/" + items;
		main.setText(result);

		if (game.getScore() == nums.length) {
			this.result.setText("PERFECT!");
		} else if (game.getScore() == 0) {
			this.result.setText("TRY AGAIN NEXT TIME! :(");
		} else {
			this.result.setText("GAME OVER!");
		}
	}

	private void removeAnswerButtons() {
		remove(oddBt);
		remove(evenBt);
	}

	private void addExitButton() {
		add(exit1, BorderLayout.EAST);
		add(exit2, BorderLayout.WEST);
	}

	public void actionPerformed(ActionEvent e) {
		checkButton((JButton) e.getSource());
		if (!isFinal()) {
			evaluateAnswer((JButton) e.getSource());
			next();
		} else {
			showResult();
			removeAnswerButtons();
			addExitButton();
		}
	}
}
