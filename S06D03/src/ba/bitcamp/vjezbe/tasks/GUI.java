package ba.bitcamp.vjezbe.tasks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class GUI extends JFrame {

	private static final long serialVersionUID = 5838973429704798106L;
	private JButton button;
	public GUI() {

		BorderLayout layout = new BorderLayout();
		setLayout(layout);

		JLabel label = new JLabel("Hello World");
		add(label, BorderLayout.CENTER);

		label.setHorizontalAlignment(JLabel.CENTER);

		button = new JButton("Hello!");
		add(button, BorderLayout.SOUTH);
		
		button.addActionListener(new Action());
		

		setVisible(true);
		setTitle("Task 1");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		

	}

	public static void main(String[] args) {
		
		new GUI();
	}
	private class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button){
				JOptionPane.showMessageDialog(null, "Hello");
				System.exit(0);
				
			}
			
		}
		
	}
}
