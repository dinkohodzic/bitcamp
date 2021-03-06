package ba.bitcamp.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Register extends JFrame {
	private static final long serialVersionUID = -7794879240594124323L;

	private JPanel mainPanel = new JPanel();
	private JPanel lowerPanel = new JPanel();
	private JLabel usernameLabel = new JLabel("Choose username:");
	private JLabel passwordLabel = new JLabel("Choose password");
	private JLabel emailLabel = new JLabel("Enter email addres");
	private JTextField usernameField = new JTextField();
	private JTextField passwordField = new JTextField();
	private JTextField emailField = new JTextField();
	private JButton submit = new JButton("SUBMIT");
	private String username = "";
	private String password = "";
	private String email = "";
	private ArrayList<String>msgList = new ArrayList<>();
	private static Socket registerSocket;

	public Register() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setSize(400, 150);
		setTitle("REGISTER");

		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		add(lowerPanel, BorderLayout.SOUTH);
		mainPanel.setLayout(new GridLayout(3, 2));

		mainPanel.add(usernameLabel);
		usernameLabel.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(usernameField);

		mainPanel.add(passwordLabel);
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(passwordField);

		mainPanel.add(emailLabel);
		emailLabel.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(emailField);

		lowerPanel.add(submit);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				username = usernameField.getText();
				password = passwordField.getText();
				email = emailField.getText();
				if (e.getSource() == submit) {
					if (username.equals("") || password.equals("") || email.equals("")) {
						JOptionPane.showMessageDialog(mainPanel, "Please fill in the empty fields",
								"Information missing", JOptionPane.ERROR_MESSAGE);
					} else {
						registerSocket = Communication.getSocket();
						msgList.add(username);
						msgList.add(password);
						msgList.add(email);
						Msg register = new Msg(Msg.REGISTER, msgList);
						Communication.sendMessage(register);
						JOptionPane.showMessageDialog(mainPanel, "Hello: "+username + ", Thank you for registering.",
								"Registration succesfull", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						new GUI();
					}
				}

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
