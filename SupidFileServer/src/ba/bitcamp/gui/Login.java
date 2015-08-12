package ba.bitcamp.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {
	private static final long serialVersionUID = 5909544326247111893L;

	private JPanel mainPanel = new JPanel();
	private JPanel lowerPanel = new JPanel();
	private JButton login = new JButton("LOGIN");
	private JButton register = new JButton("REGISTER");
	private JLabel usernameLabel = new JLabel("USERNAME");
	private JLabel passwordLabel = new JLabel("PASSWORD");
	private JTextField usernameField = new JTextField();
	private JTextField passwordField = new JTextField();
	private Register registerPanel = new Register();
	public Login() {

		setSize(400, 100);
		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		add(lowerPanel, BorderLayout.SOUTH);
		mainPanel.setLayout(new GridLayout(2, 2));

		mainPanel.add(usernameLabel);
		usernameLabel.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(usernameField);
		mainPanel.add(passwordLabel);
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(passwordField);

		lowerPanel.setLayout(new GridLayout(1, 2));
		lowerPanel.add(login);
		lowerPanel.add(register);
		
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==register){
					add(registerPanel,BorderLayout.EAST);
				}
				
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}
