package ba.bitcamp.flappyBird;


import javax.swing.JFrame;

public class Main extends JFrame {

	private static final long serialVersionUID = -4738949043229487125L;
	public static JFrame window = new JFrame();
	

	public Main() {

		// Initializing
		FlappyBlock flappyblock = new FlappyBlock();

		// Setting up the frame
		window.setContentPane(flappyblock);
		window.setResizable(false);
		window.setSize(flappyblock.WINDOW_WIDTH, flappyblock.WINDOW_HEIGHT);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

	/**
	 * Method used to restart the game
	 */
	public static void restart() {
		main(null);
	}

}
