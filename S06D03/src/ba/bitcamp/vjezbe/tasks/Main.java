package ba.bitcamp.vjezbe.tasks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {

	private static final long serialVersionUID = 4773518276314992116L;

	private JLabel text = new JLabel("Something");
	private JButton button1 = new JButton("Exit");
	private JButton button2 = new JButton("Left");
	private JButton button3 = new JButton("Right");
	
	
	
	
	public Main() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);

		JButton button = new JButton("OK");

		button.addActionListener(new Action());
		add(button);

		setVisible(true);
		setTitle("WINDOW");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new Main();

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("BLA BLA BLA");

		}

	}
}
