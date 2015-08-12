package ba.bitcamp.gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JPanel{
	private static final long serialVersionUID = -7794879240594124323L;
	

	private JPanel mainPanel = new JPanel();
	private JPanel lowerPanel  = new JPanel();
	private JLabel usernameLabel = new JLabel("Choose username:");
	private JLabel passwordLabel = new JLabel("Choose password");
	private JLabel emailLabel = new JLabel("Enter email addres");
	private JTextField usernameField = new JTextField();
	private JTextField passwordField = new JTextField();
	private JTextField emailField = new JTextField();
	private JButton submit = new JButton("SUBMIT");
	
	
	public Register(){
		
		setLayout(new BorderLayout());
		add(mainPanel,BorderLayout.CENTER);
		add(lowerPanel,BorderLayout.SOUTH);
		mainPanel.setLayout(new GridLayout(2, 3));
		
		mainPanel.add(usernameLabel);
		mainPanel.add(usernameField);
		
		mainPanel.add(passwordLabel);
		mainPanel.add(passwordField);
		
		mainPanel.add(emailLabel);
		mainPanel.add(emailField);
		
		
		lowerPanel.add(submit);
		
		
		setVisible(true);
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new Register();
	}
	
	
}
