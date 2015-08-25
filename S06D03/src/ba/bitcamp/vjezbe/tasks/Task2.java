package ba.bitcamp.vjezbe.tasks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task2 extends JFrame {

	private static final long serialVersionUID = -1213687285586780079L;

	private JButton button1;
	private JButton button2;
	private JLabel label;

	public Task2() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);

		label = new JLabel("Choose one");
		add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

		button1 = new JButton("EXIT");
		add(button1, BorderLayout.SOUTH);
		button1.addActionListener(new Action());

		button2 = new JButton("Do not exit");
		add(button2, BorderLayout.NORTH);
		button2.addActionListener(new Action());

		setVisible(true);
		setTitle("Task 1");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				System.exit(0);
			} else if (e.getSource() == button2) {
				label.setText("It did not exit");
			}

		}

	}

	public static void main(String[] args) {
		new Task2();
	}

}
