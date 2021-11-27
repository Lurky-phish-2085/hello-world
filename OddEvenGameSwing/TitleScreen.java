import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TitleScreen extends JFrame implements ActionListener {

	private final Font bigFnt = new Font("Arial", Font.BOLD, 36);
	private final Font smallFnt = new Font("Arial", Font.BOLD, 24);

	private final JButton play = new JButton("PLAY");
	private final JButton help = new JButton("HELP");
	private final JButton exit = new JButton("EXIT");
	private final JLabel message = new JLabel("Welcome!");

	TitleScreen() {
		setTitle("TaskPerf7 Launcher");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setLayout(new FlowLayout());

		setComponentsFont();
		addActionListeners();
		addComponents();
	}

	private void setComponentsFont() {
		play.setFont(smallFnt);
		help.setFont(smallFnt);
		exit.setFont(smallFnt);
		message.setFont(bigFnt);
	}

	private void addActionListeners() {
		play.addActionListener(this);
		help.addActionListener(this);
		exit.addActionListener(this);
	}

	private void addComponents() {
		add(play);
		add(help);
		add(exit);
		add(message);
	}

	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();

		if (button == play) {
			OddOrEvenGameGUI game = new OddOrEvenGameGUI();
			setVisible(false);
			game.setVisible(true);
		} else if (button == help) {
			message.setText("JUST PRESS PLAY!");
		} else if (button == exit) {
			System.exit(0);
		}
	}
}
