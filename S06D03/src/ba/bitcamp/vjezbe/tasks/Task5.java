package ba.bitcamp.vjezbe.tasks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Task5 extends JFrame {

	private static final long serialVersionUID = 3184990474850761793L;
	private JLabel label;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton buttonRemove;
	private int x=0;
	private String s = "EXAMPLE SENTENCE";
	
	public Task5(){
		
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		label = new JLabel(s);
		add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		buttonRight = new JButton(">");
		add(buttonRight, BorderLayout.EAST);
		buttonRight.addActionListener(new Action());
		
		buttonLeft = new JButton("<");
		add(buttonLeft,BorderLayout.WEST);
		buttonLeft.addActionListener(new Action());
		
		buttonRemove = new JButton("Remove");
		add(buttonRemove, BorderLayout.SOUTH);
		buttonRemove.addActionListener(new Action());
		
		
		
		setVisible(true);
		setTitle("Task 5");
		setSize(600, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	private class Action implements ActionListener{
		private String s1;
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonLeft){
				s1=label.getText();
				label.setText(s1.substring(0, x)+"_"+s1.substring(x+1, s1.length()));
				if(x>0){
					x--;
				}
			}
			if(e.getSource()==buttonRight){
				s1=label.getText();
				
				label.setText(s1.substring(0, x)+"_"+s1.substring(x+1, s1.length()));
				if(x<s1.length()){
					x++;
				}
				
				//More to come...
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new Task5();
	}

}
