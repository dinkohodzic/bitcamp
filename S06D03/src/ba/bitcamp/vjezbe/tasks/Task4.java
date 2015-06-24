package ba.bitcamp.vjezbe.tasks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task4 extends JFrame {

	private JLabel label;
	private JButton button;

	public Task4() {

		BorderLayout layout = new BorderLayout();
		setLayout(layout);

		label = new JLabel("Don't press it");
		add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

		button = new JButton("Button");
		add(button, BorderLayout.SOUTH);
		button.addActionListener(new Action());

		setVisible(true);
		setTitle("Task 3");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private static final long serialVersionUID = -8040654169145689108L;

	private class Action implements ActionListener {
		private int counter = 1;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				if (counter == 1) {
					label.setText("I told you not to press it!");
				} else if (counter == 2) {
					label.setText("Look, it's simple. Dont press it!");
				} else if (counter == 3) {
					label.setText("Stop it allready!!!");
				} else {
					label.setText("Don't press it");
				}
			}
			counter++;
			if (counter > 3) {
				counter = 0;
			}
		}

	}

	public static void main(String[] args) {
		new Task4();

	}

}
