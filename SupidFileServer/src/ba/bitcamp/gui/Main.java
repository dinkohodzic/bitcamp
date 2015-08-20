package ba.bitcamp.gui;

public class Main {

	public static void main(String[] args) {

		new Login();
		Communication.connectToServer("10.202.23.110", 2424);
		System.out.println("Connection established");
		

	}

}
