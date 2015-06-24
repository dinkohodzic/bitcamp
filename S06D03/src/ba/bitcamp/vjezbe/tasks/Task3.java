package ba.bitcamp.vjezbe.tasks;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task3 extends JFrame {

	private JLabel label;
	private JButton button1;
	private JButton button2;
	private Font c1;
	private Font c2;
	
	public Task3() {

		BorderLayout layout = new BorderLayout();
		setLayout(layout);

		label = new JLabel("Press one to disable the other!");
		add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

		button1 = new JButton("Button 1");
		add(button1, BorderLayout.NORTH);
		button1.addActionListener(new Action());
		button1.setEnabled(true);
		
		 c1 = new Font("Calibri",Font.BOLD,18);
		button2 = new JButton("Button 2");
		add(button2, BorderLayout.SOUTH);
		button2.addActionListener(new Action());
		button2.setEnabled(false);
		
		 c2 = new Font("Courier", Font.PLAIN, 16);

		setVisible(true);
		setTitle("Task 3");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class Action implements ActionListener {
		private int counter =0;
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1){
				label.setFont(c1);
				button1.setEnabled(false);
				button2.setEnabled(true);
				counter++;
			}
			else if(e.getSource()==button2){
				label.setFont(c2);
				button2.setEnabled(false);
				button1.setEnabled(true);
				counter++;
			}
			if(counter==5){
				System.exit(0);
			}
		}

	}

	private static final long serialVersionUID = 3390910935540372294L;

	public static void main(String[] args) {
		new Task3();

	}

}
