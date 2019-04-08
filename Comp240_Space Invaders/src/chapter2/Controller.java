package chapter2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controller extends JFrame implements KeyListener, ConstantValues, GameEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int remainingAliens = 0;
	private byte keys = 0x0;
	private Timer timer;
	private long timeStamp = System.currentTimeMillis();
	private Wall walls;
	private SpaceShip ship;
	private boolean onMoveDown;

	private Canvas canvas;

	private ArrayList<Entity> entities = new ArrayList<>();
	private ArrayList<Entity> removeList = new ArrayList<>();
	private ArrayList<MarchingAlien> army = new ArrayList<>();

	private enum GameState {
		// TODO make running conditions
		Paused, Running, Stopped, Win, Lose, level_2, level_boss
	}

	private GameState gameState = GameState.Stopped;

	public Controller() {
		super("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		add(canvas);
		setIgnoreRepaint(true);
		pack();

		canvas.createBufferStrategy(2);
		addKeyListener(this);
		setVisible(true);
		walls = new Wall(0, 0, new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		addEntity(walls);
		ship = new SpaceShip(this, new Dimension(SCREEN_WIDTH / 20, SCREEN_HEIGHT / 20));
		ship.setPosition(SCREEN_WIDTH / 2 - (int) ship.getDimension().width / 2,
				-ship.getDimension().height + SCREEN_HEIGHT - 15);
		addEntity(ship);
		addAliens(4, 14);
	}

	public void addAliens(int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				MarchingAlien a = new MarchingAlien(this, new Dimension(SCREEN_WIDTH / 20, SCREEN_HEIGHT / 20));
				a.setPosition(j * SCREEN_WIDTH / 17, i * SCREEN_HEIGHT / 17);
				a.setVelocity(.2f, 0);
				army.add(a);
				remainingAliens++;
				a.activate();
			}
		}
		entities.addAll(army);
	}

	public void addEntity(Entity entity) {
		entities.add(entity);

		entity.setVelocity(0, 0);
	}

	public void start() {
		timer = new Timer(1000 / FPS, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (gameState) {
				case Running:
					render();
					break;
				case Paused:
					pausedScreen();

					break;
				case Win:
					winScreen();
					break;
				case Lose:
					loseScreen();
					break;
				default:
					break;
				}
			}
		});
		timer.start();
		timeStamp = System.currentTimeMillis();
		gameState = GameState.Running;
	}

	private void render() {
		requestFocus();
		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();

		long ElapsedTime = System.currentTimeMillis() - timeStamp;
		onMoveDown = false;

		// Clears the screen
		gc.setColor(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		displayMessage("Remaining aliens: " + remainingAliens, gc, Color.GREEN, SCREEN_HEIGHT / 2 - 5);
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.processKeys(keys);
			e.move(ElapsedTime);

			for (int j = i + 1; j < entities.size(); j++) {
				Entity a = entities.get(j);
				if (e.inCollision(a)) {
					a.inCollision(e);
					onMoveDown = true;
				}
			}
			e.draw(gc);
		}

		gc.dispose();
		entities.removeAll(removeList);
		removeList.clear();
		strategy.show();
		timeStamp = System.currentTimeMillis();
	}

	private void pausedScreen() {
		requestFocus();
		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();
		gc.setColor(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.draw(gc);
		}

		timer.stop();
		askExit();
		timer.start();
		gameState = GameState.Running;
		gc.dispose();
		strategy.show();
		timeStamp = System.currentTimeMillis();

	}

	private void winScreen() {
		requestFocus();
		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();
		gc.setColor(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		// TODO would you like to play again message?
		displayMessage("You won!", gc, Color.GREEN, 0);
		displayMessage("Press any key", gc, Color.blue, 25);
		gc.dispose();
		strategy.show();
	}

	private void loseScreen() {
		requestFocus();
		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();
		gc.setColor(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		// TODO would you like to play again message?

		displayMessage("They got you!", gc, Color.GREEN, 0);
		displayMessage("Press any key", gc, Color.blue, 25);
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.draw(gc);
		}
		timer.stop();
		gc.dispose();
		strategy.show();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			keys |= UP_KEY;
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			keys |= LEFT_KEY;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			keys |= DOWN_KEY;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			keys |= RIGHT_KEY;
			break;
		case KeyEvent.VK_SPACE:
			keys |= SPACE_KEY;
			break;
		case KeyEvent.VK_ESCAPE:
			gameState = GameState.Paused;
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			keys &= ~SPACE_KEY;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			keys &= ~UP_KEY;
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			keys &= ~LEFT_KEY;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			keys &= ~DOWN_KEY;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			keys &= ~RIGHT_KEY;
			break;
		}
	}

	private void askExit() {
		if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this, "Do You want to exit?", "Exit",
				JOptionPane.OK_CANCEL_OPTION)) {
			System.exit(0);
		}
		timeStamp = System.currentTimeMillis();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Controller gui = new Controller();
		gui.start();
	}

	@Override
	public void onEndOfLife(Entity e) {
		// removes the missile
		removeList.add(e);
		if (e instanceof MarchingAlien) {
			remainingAliens--;
			if (remainingAliens == 0) {
				gameState = GameState.Win;
			}
		}

	}

	@Override
	public void onFire(Entity e) {
		// to position missile you have to find the spaceship sits

		Missile missile = new Missile(this, new Dimension(SCREEN_WIDTH / 40, SCREEN_HEIGHT / 30));
		addEntity(missile);
		SoundFX.SHOOT.play();
		missile.setPosition(e.rx + 10, e.ry - 10);
	}

	private void displayMessage(String message, Graphics2D gc, Color color, int voffSet) {
		Color oldColor = gc.getColor();
		Font oldFont = gc.getFont();

		Font font = new Font("Courier New", Font.PLAIN, 16);
		gc.setFont(font);
		gc.setColor(color);

		int stringWidth = gc.getFontMetrics().stringWidth(message);
		gc.drawString(message, (SCREEN_WIDTH - stringWidth) / 2, SCREEN_HEIGHT / 2 + voffSet);

		gc.setColor(oldColor);
		gc.setFont(oldFont);
	}

	@Override
	public void requestLogic(Entity e) {
		if (e instanceof MarchingAlien) {
			if (onMoveDown == true) {
				for (MarchingAlien a : army) {
					a.setVelocity(-a.getVx(), 0);
					a.setPosition(a.getRx() + a.getVx() * 40, a.getRy() + a.dimension.height);
					if (a.getRy() >= 550) {
						gameState = GameState.Lose;
					}
				}
				onMoveDown = false;

				System.out.print("*");
			}
		}

	}
}