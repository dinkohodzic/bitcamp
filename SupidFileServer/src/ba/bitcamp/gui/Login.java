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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends JFrame {
	private static final long serialVersionUID = 5909544326247111893L;

	private JPanel mainPanel = new JPanel();
	private JPanel lowerPanel = new JPanel();
	private JButton login = new JButton("LOGIN");
	private JButton register = new JButton("REGISTER");
	private JLabel usernameLabel = new JLabel("USERNAME");
	private JLabel passwordLabel = new JLabel("PASSWORD");
	private JTextField usernameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private static Socket loginSocket;
	private String username = "";
	private String password = "";
	private ArrayList<String> loginList = new ArrayList<>();

	public Login() {
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

		setSize(400, 100);
		setTitle("LOGIN");

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
				if (e.getSource() == register) {
					dispose();
					new Register();
				}

			}
		});

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				username = usernameField.getText();
				char[]pass = passwordField.getPassword();
				for (int i = 0; i < pass.length; i++) {
					password+=pass[i];
				}
				System.out.println(password);
				if (e.getSource() == login) {
					if (username.equals("") || password.equals("")) {
						JOptionPane.showMessageDialog(mainPanel,
								"Please fill in the empty fields",
								"Information missing",
								JOptionPane.ERROR_MESSAGE);
					} else {
						loginSocket = Communication.getSocket();
						loginList.add(username);
						loginList.add(password);
						System.out.println(loginList);
						Msg login = new Msg(Msg.LOGIN, loginList);
						Communication.sendMessage(login);
						JOptionPane.showMessageDialog(mainPanel,
								"Hello: "+username+ " your login was succesfull.",
								"Login succesfull",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						new GUI();
						
					}

					loginSocket = Communication.getSocket();
				}

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
