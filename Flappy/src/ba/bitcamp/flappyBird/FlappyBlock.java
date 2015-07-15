package ba.bitcamp.flappyBird;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.JobAttributes;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyBlock extends JPanel implements ActionListener,
		MouseListener, KeyListener {

	private static final long serialVersionUID = 7983924444334774796L;;

	// Attributes
	public final int WINDOW_WIDTH = 1200;
	public final int WINDOW_HEIGHT = 800;

	// Rectangles
	private Rectangle block;

	private Rectangle cloud1;
	private Rectangle cloud2;
	private Rectangle cloud3;
	private Rectangle cloud4;

	private Rectangle t1;
	private Rectangle t2;
	private Rectangle t3;
	private Rectangle t4;
	private Rectangle t5;
	private Rectangle t6;
	private Rectangle t7;
	private Rectangle t8;
	private Rectangle t9;

	// Images
	private BufferedImage bird;

	private BufferedImage clouds;

	private BufferedImage tree1;
	private BufferedImage tree2;
	private BufferedImage tree3;
	private BufferedImage tree4;
	private BufferedImage tree5;
	private BufferedImage tree6;
	private BufferedImage tree7;
	private BufferedImage tree8;
	private BufferedImage tree9;

	private BufferedImage c1;
	private BufferedImage c2;
	private BufferedImage c3;
	private BufferedImage c4;

	private BufferedImage rules1;
	private BufferedImage rules2; 
	private BufferedImage rules3;
	private BufferedImage start;
	private BufferedImage over;
	private BufferedImage score;

	// Sound files
	private File die = new File("sounds/sfx_die.wav");
	private File hit = new File("sounds/sfx_hit.wav");
	private File point = new File("sounds/sfx_point.wav");
	private File wing = new File("sounds/sfx_wing.wav");

	// Movements
	private int moveY;
	private int moveX;

	// Timers
	private Timer timer;
	private Timer timerEnd;

	// Counters
	private int counter = 0;
	private int hitCount = 0;
	private int fallCount = 0;

	// Booleans
	private boolean started = false;

	private static boolean gameOver = false;

	// Constructor
	public FlappyBlock() {

		// The main timer
		timer = new Timer(18, this);

		// Timer for dialogMenu
		timerEnd = new Timer(5, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restartWindow();

			}
		});

		// Initializing Rectangles

		// Rectangle for the bird
		block = new Rectangle(WINDOW_WIDTH / 2 - 100, WINDOW_HEIGHT / 3 - 100,
				50, 50);

		// Rectangles for the clouds
		cloud1 = new Rectangle(WINDOW_WIDTH + 200, ((int) (Math.random()
				* (-300) - 200)), 436, 534);

		cloud2 = new Rectangle(cloud1.x + cloud1.width + 200,
				((int) (Math.random() * (-300) - 100)), 318, 386);

		cloud3 = new Rectangle(cloud2.x + cloud2.width + 200,
				((int) (Math.random() * (-300) - 200)), 376, 649);

		cloud4 = new Rectangle(cloud3.x + cloud3.width + 200,
				((int) (Math.random() * (-300) - 100)), 338, 462);

		// Rectangles for the trees
		t1 = new Rectangle(WINDOW_WIDTH + 300, WINDOW_HEIGHT - 240, 146, 240);

		t2 = new Rectangle(t1.x + t1.width + 300, WINDOW_HEIGHT - 236, 210, 236);

		t3 = new Rectangle((t2.x + t2.width + 300), WINDOW_HEIGHT - 242, 191,
				242);
		t4 = new Rectangle((t3.x + t3.width + 300), WINDOW_HEIGHT - 223, 214,
				223);
		t5 = new Rectangle((t4.x + t4.width + 300), WINDOW_HEIGHT - 216, 224,
				216);
		t6 = new Rectangle((t5.x + t5.width + 300), WINDOW_HEIGHT - 219, 153,
				219);
		t7 = new Rectangle((t6.x + t6.width + 300), WINDOW_HEIGHT - 240, 154,
				240);
		t8 = new Rectangle((t7.x + t7.width + 300), WINDOW_HEIGHT - 243, 169,
				243);
		t9 = new Rectangle((t8.x + t8.width + 300), WINDOW_HEIGHT - 213, 167,
				213);

		try {

			// Loading images

			bird = ImageIO.read(ResLoader.load("Black_bird_64.png"));

			clouds = ImageIO.read(ResLoader.load("sky.jpg"));

			tree1 = ImageIO.read(ResLoader.load("tree1.png"));

			tree2 = ImageIO.read(ResLoader.load("tree2.png"));

			tree3 = ImageIO.read(ResLoader.load("tree3.png"));

			tree4 = ImageIO.read(ResLoader.load("tree4.png"));

			tree4 = ImageIO.read(ResLoader.load("tree4.png"));

			tree5 = ImageIO.read(ResLoader.load("tree5.png"));

			tree6 = ImageIO.read(ResLoader.load("tree6.png"));

			tree7 = ImageIO.read(ResLoader.load("tree7.png"));

			tree8 = ImageIO.read(ResLoader.load("tree8.png"));

			tree9 = ImageIO.read(ResLoader.load("tree9.png"));

			c1 = ImageIO.read(ResLoader.load("cloud1.png"));

			c2 = ImageIO.read(ResLoader.load("cloud2.png"));

			c3 = ImageIO.read(ResLoader.load("cloud3.png"));

			c4 = ImageIO.read(ResLoader.load("cloud4.png"));

			rules1 = ImageIO.read(ResLoader.load("rules.png"));

			rules2 = ImageIO.read(ResLoader.load("space.png"));

			rules3 = ImageIO.read(ResLoader.load("clouds_trees.png"));

			start = ImageIO.read(ResLoader.load("start.png"));

			over = ImageIO.read(ResLoader.load("gameOver.png"));
			
			score = ImageIO.read(ResLoader.load("SC.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		addKeyListener(this);
		addMouseListener(this);

		timer.start();

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		// Drawing the background
		g.drawImage(clouds, 0, 0, null);

		// Drawing the bird
		g.drawImage(bird, block.x, block.y, this);

		// Drawing the clouds
		g.drawImage(c1, cloud1.x, cloud1.y, null);
		g.drawImage(c2, cloud2.x, cloud2.y, null);
		g.drawImage(c3, cloud3.x, cloud3.y, null);
		g.drawImage(c4, cloud4.x, cloud4.y, null);

		// Drawing the trees
		g.drawImage(tree1, t1.x, t1.y, null);
		g.drawImage(tree2, t2.x, t2.y, null);
		g.drawImage(tree3, t3.x, t3.y, null);
		g.drawImage(tree4, t4.x, t4.y, null);
		g.drawImage(tree5, t5.x, t5.y, null);
		g.drawImage(tree6, t6.x, t6.y, null);
		g.drawImage(tree7, t7.x, t7.y, null);
		g.drawImage(tree8, t8.x, t8.y, null);
		g.drawImage(tree9, t9.x, t9.y, null);

		// Drawing the score
		g.setColor(Color.WHITE);
		g.drawImage(score, 10, 10, null);
		g.setFont(new Font("Arial Black", Font.BOLD, 42));
		g.drawString(counter+"", 140, 66);

		// Drawing information before the player starts playing
		if (started == false) {
			g.drawImage(rules1, WINDOW_WIDTH / 8 - 140, WINDOW_HEIGHT / 2, null);
			g.drawImage(rules2, WINDOW_WIDTH / 8 - 140,
					WINDOW_HEIGHT / 2 + 110, null);
			g.drawImage(rules3, WINDOW_WIDTH / 8 - 140,
					WINDOW_HEIGHT / 2 + 220, null);
			g.drawImage(start, WINDOW_WIDTH / 3 + 30, WINDOW_HEIGHT / 3, null);

		}

		// Drawing a game over message
		if (gameOver == true) {

			g.drawImage(over, WINDOW_WIDTH / 3, WINDOW_HEIGHT / 2, null);
		}
	}

	/**
	 * Method for playing the sound files
	 * 
	 * @param sound
	 */
	private static void playSound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();

			Thread.sleep(clip.getMicrosecondLength() / 100000);
		} catch (Exception e) {

		}

	}

	/**
	 * This method restarts the window
	 */
	public void restartWindow() {

		int choice = JOptionPane.showOptionDialog(null, String.format(
				"Your score is: %d\nDo you want to play again? \nOr see the soure code on Github.com", counter), "",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new String[]{"Yes","No","Github.com"}, null);
		
		
		

		if (choice == JOptionPane.YES_OPTION) {
			timerEnd.stop();
			started = false;
			gameOver = false;

			Main.window.dispose();

			Main.restart();

		}else if(choice==JOptionPane.CANCEL_OPTION){
			try {
				Desktop.getDesktop().browse(new URI("http://klix.ba"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
		
			System.exit(0);
		}
	}

	/**
	 * This method makes the bird jump
	 */
	public void jump() {
		if (gameOver == false && started == true) {
			if (moveY > 0) {
				moveY = 0;
			}

			if (block.y - moveY <= 0) {
				moveY = 0;
			} else {
				moveY -= 20;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();
			playSound(wing);

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		((Component) e.getSource()).requestFocus();

		if (e.getButton() == MouseEvent.BUTTON1) {

			started = true;

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// The movement by X
		moveX = 4;

		// If the boolean started becomes true , the motion starts
		if (started == true) {

			// The falling motion of the bird (movement by Y)
			if (moveY < 20) {
				moveY += 2;
			}

			if (block.y + block.height < WINDOW_HEIGHT - 50) {
				block.y += moveY;

			} else {

				block.y = WINDOW_HEIGHT - 50 - block.height;
				gameOver = true;
				fallCount++;
				if (fallCount == 1) {
					playSound(die);
				}

			}

			// Making the clouds distribute evenly
			if (cloud1.x + cloud1.width <= 0) {
				cloud1.x = cloud4.x + cloud4.width + 400;
			} else if (cloud2.x + cloud2.width <= 0) {
				cloud2.x = cloud1.x + cloud1.width + 400;
			} else if (cloud3.x + cloud3.width <= 0) {
				cloud3.x = cloud2.x + cloud2.width + 400;
			} else if (cloud4.x + cloud4.width <= 0) {
				cloud4.x = cloud3.x + cloud3.width + 400;
			} else {
				cloud1.x -= moveX;

				cloud2.x -= moveX;

				cloud3.x -= moveX;

				cloud4.x -= moveX;
			}

			// Making the trees move evenly
			if (t1.x + t1.width <= 0) {

				t1.x = t9.x + t9.width + 300;

			} else if (t2.x + t2.width <= 0) {

				t2.x = t1.x + t1.width + 300;

			} else if (t3.x + t3.width <= 0) {

				t3.x = t2.x + t2.width + 300;

			} else if (t4.x + t4.width <= 0) {

				t4.x = t3.x + t3.width + 300;

			} else if (t5.x + t5.width <= 0) {

				t5.x = t4.x + t4.width + 300;

			} else if (t6.x + t6.width <= 0) {

				t6.x = t5.x + t5.width + 300;

			} else if (t7.x + t7.width <= 0) {

				t7.x = t6.x + t6.width + 300;

			} else if (t8.x + t8.width <= 0) {

				t8.x = t7.x + t7.width + 300;

			} else if (t9.x + t9.width <= 0) {

				t9.x = t8.x + t8.width + 300;

			} else {
				t1.x -= moveX;
				t2.x -= moveX;
				t3.x -= moveX;
				t4.x -= moveX;
				t5.x -= moveX;
				t6.x -= moveX;
				t7.x -= moveX;
				t8.x -= moveX;
				t9.x -= moveX;
			}

			// Checking if the bird has collided with another object
			if (block.intersects(cloud1) || block.intersects(cloud2)
					|| block.intersects(cloud3) || block.intersects(cloud4)
					|| block.intersects(t1) || block.intersects(t2)
					|| block.intersects(t3) || block.intersects(t4)
					|| block.intersects(t5) || block.intersects(t6)
					|| block.intersects(t7) || block.intersects(t8)
					|| block.intersects(t9)) {

				hitCount++;
				if (hitCount == 1) {
					playSound(hit);
				}

				gameOver = true;
			}

			// Making sure that the bird can't move trough other objects
			if (block.intersects(cloud1)) {

				block.x -= moveX;

			} else if (block.intersects(cloud2)) {

				block.x -= moveX;
			} else if (block.intersects(cloud3)) {
				block.x -= moveX;
			} else if (block.intersects(cloud4)) {
				block.x -= moveX;
			} else if (block.intersects(t1)) {

				block.x -= moveX;
			} else if (block.intersects(t2)) {
				block.x -= moveX;
			} else if (block.intersects(t3)) {
				block.x -= moveX;
			} else if (block.intersects(t4)) {
				block.x -= moveX;
			} else if (block.intersects(t5)) {
				block.x -= moveX;
			} else if (block.intersects(t6)) {
				block.x -= moveX;
			} else if (block.intersects(t7)) {
				block.x -= moveX;
			} else if (block.intersects(t8)) {
				block.x -= moveX;
			} else if (block.intersects(t9)) {
				block.x -= moveX;
			}

			// Checking the score
			if (t1.x - 2 < block.x && t1.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}
			if (t2.x - 2 < block.x && t2.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}
			if (t3.x - 2 < block.x && t3.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}
			if (t4.x - 2 < block.x && t4.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}
			if (t5.x - 2 < block.x && t5.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}
			if (t6.x - 2 < block.x && t6.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}
			if (t7.x - 2 < block.x && t7.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}
			if (t8.x - 2 < block.x && t8.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}
			if (t9.x - 2 < block.x && t9.x + 3 >= block.x) {
				counter++;
				playSound(point);
			}

		}
		repaint();

		// Checks if the block has passed zero while game is started.
		if (block.x + block.width + 10 < 0 && started == true) {
			timerEnd.start();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
