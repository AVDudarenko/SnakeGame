import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameField extends JPanel {

	private final int SIZE = 320;
	private final int DOT_SIZE = 16;
	private final int ALL_DOTS = 400;

	private Image dot;
	private Image apple;

	private int[] x = new int[ALL_DOTS];
	private int[] y = new int[ALL_DOTS];

	private int appleXOne;
	private int appleYOne;
	private int appleXTwo;
	private int appleYTwo;
	private int appleXThree;
	private int appleYThree;

	private int dots;
	private Timer timer;

	private boolean inGame = true;

	public void loadImage() {
		ImageIcon imageIconApple = new ImageIcon("apple.png");
		apple = imageIconApple.getImage();
		ImageIcon imageIconDot = new ImageIcon("dot.png");
		dot = imageIconDot.getImage();
	}

	public void createApple() {
		Random random = new Random();
		appleXOne = random.nextInt(20) * DOT_SIZE;
		appleYOne = random.nextInt(20) * DOT_SIZE;
		appleXTwo = random.nextInt(20) * DOT_SIZE;
		appleYTwo = random.nextInt(20) * DOT_SIZE;
		appleXThree = random.nextInt(20) * DOT_SIZE;
		appleYThree = random.nextInt(20) * DOT_SIZE;
	}

	public void initGame() {
		dots = 3;
		for (int i = 0; i < dots; i++) {
			y[i] = 48;
			x[i] = 48 - i * DOT_SIZE;
		}
		timer = new Timer(150, this);
		timer.start();
		createApple();
	}

	public void checkEatApple() {
		if ((x[0] == appleXOne && y[0] == appleYOne) || (x[0] == appleXTwo && y[0] == appleYTwo) || (x[0] == appleXThree && y[0] == appleYThree)) {
			dots++;
			createApple();
		}
	}

}
