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
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controller extends JFrame implements KeyListener, ConstantValues, GameEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// TODO ALIENS FALL LEVEL
	// TODO ALIENS HIT BOTTOM YOU LOSE LEVEL
	// TODO ALIENS SHOOT LEVEL
	private byte keys = 0x0;
	private Timer timer;
	private long timeStamp = System.currentTimeMillis();
	private Wall walls;
	private SpaceShip ship;
	private boolean onMoveDown;
	protected int remainingAliens = 0;
	private int level = 0;
	private int initalTime;
	private int currentTime;
	private int timeInSeconds;
	private Canvas canvas;
	private boolean isKeyPressed;
	private double alienFireTime;

	protected ArrayList<Entity> entities = new ArrayList<>();
	private ArrayList<Entity> removeList = new ArrayList<>();
	private ArrayList<MarchingAlien> army = new ArrayList<>();

	private enum GameState {
		Restart, StartScreen, Running, Paused, Win, Lose, Stopped, Level_2, Level_3, Level_4,
	}

	private GameState gameState = GameState.Stopped;

	public Controller() {
		super("Space Invaders");
		// stop lag on first shot
		SoundFX.SHOOT.name();
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
		addAliens(6, 12);
	}

	public void addAliens(int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				MarchingAlien a = new MarchingAlien(this, new Dimension(SCREEN_WIDTH / 20, SCREEN_HEIGHT / 20));
				a.setPosition((j * SCREEN_WIDTH / 16) + SCREEN_WIDTH / 10, i * SCREEN_HEIGHT / 16);
				a.setVelocity(.01f + (.02f * level), 0);
				army.add(a);
				remainingAliens++;
				a.activate();

			}
		}
		level++;
		entities.addAll(army);
	}

	private void activateArmy(boolean condition) {
		for (MarchingAlien a : army) {
			if (condition)
				a.activate();
			else
				a.deactivate();
		}
	}

	public void armySpeed(ArrayList<MarchingAlien> army) {
		for (Entity e : army) {
			e.setVelocity(e.getVx() * 1.3f, e.vy);
		}
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
				case StartScreen:
					startScreen();
					break;
				case Restart:
					clearAllEntities();
					restart();
					break;
				case Running:
					render();
					break;
				case Paused:
					pausedScreen();
					break;
				case Win:
					clearAllEntities();
					winScreen();
					break;
				case Lose:
					loseScreen();
					break;
				case Level_2:
					clearAllEntities();
					addAliens(6, 12);
					gameState = GameState.Running;
					break;
				case Level_3:
					clearAllEntities();
					addAliens(6, 12);
					gameState = GameState.Running;
					break;
				case Level_4:
					clearAllEntities();
					addAliens(6, 12);
					gameState = GameState.Running;
					break;
				default:
					break;
				}
			}
		});
		timer.start();
		initalTime = (int) System.currentTimeMillis();
		timeStamp = System.currentTimeMillis();
		alienFireTime = System.currentTimeMillis();
		// starting gameState
		level = 4;
		gameState = GameState.Level_4;
		
		
		gameState = GameState.StartScreen;
	}

	private void clearAllEntities() {
		remainingAliens = 0;
		entities.removeAll(removeList);
		entities.removeAll(army);
		army.clear();
		removeList.clear();
	}

	private void restart() {
		level = 0;
		addAliens(6, 12);
		ship.setPosition(SCREEN_WIDTH / 2 - (int) ship.getDimension().width / 2,
				-ship.getDimension().height + SCREEN_HEIGHT - 15);
		currentTime = (int) System.currentTimeMillis();
		gameState = GameState.StartScreen;

	}

	private void render() {
		requestFocus();

		activateArmy(true);

		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();

		long elapsedTime = System.currentTimeMillis() - timeStamp;
		onMoveDown = false;

		// Clears the screen
		gc.setColor(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		displayMessage("Remaining aliens: " + remainingAliens, gc, Color.YELLOW, SCREEN_HEIGHT / 2 - 5, -100);
		displayMessage("Level " + level, gc, Color.YELLOW, SCREEN_HEIGHT / 2 - 5, -300);
		currentTime = (int) System.currentTimeMillis() - initalTime;
		timeInSeconds = currentTime / 600;
		displayMessage("Elapsed time: " + timeInSeconds / 60 + "minutes " + timeInSeconds % 60 + "seconds", gc,
				Color.YELLOW, SCREEN_HEIGHT / 2 - 5, 200);

		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.processKeys(keys);
			e.move(elapsedTime);

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
		if (remainingAliens <= 0) {
			switch (level) {
			case 1:
				gameState = GameState.Level_2;
				break;
			case 2:
				gameState = GameState.Level_3;
				break;
			case 3:
				gameState = GameState.Level_4;
				break;
			case 4:
				SoundFX.WIN.play();
				gameState = GameState.Win;
				break;
			}
		}
		timeStamp = System.currentTimeMillis();
	}

	private void startScreen() {
		requestFocus();
		activateArmy(false);

		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();
		gc.setColor(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		displayMessage("Space invaders!!", gc, Color.RED, 0, 0);
		displayMessage("Press any key to play", gc, Color.GREEN, 40, 0);
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.draw(gc);
		}
		gc.dispose();
		strategy.show();

		if (isKeyPressed == true) {
			SoundFX.STRATUP.play();
			gameState = GameState.Running;
			initalTime = (int) System.currentTimeMillis();
			timeStamp = System.currentTimeMillis();
		}

	}

	private void pausedScreen() {
		requestFocus();
		activateArmy(false);
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
		gc.dispose();
		strategy.show();
		timeStamp = System.currentTimeMillis();

		gameState = GameState.Running;

	}

	private void winScreen() {
		requestFocus();

		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();
		gc.setColor(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		displayMessage(
				"You saved the Earth in " + timeInSeconds / 60 + "minutes and " + timeInSeconds % 60 + "seconds!", gc,
				Color.GREEN, 0, 0);
		displayMessage("Press any key", gc, Color.blue, 25, 0);
		gc.dispose();
		strategy.show();
		if (isKeyPressed == true) {
			timeStamp = System.currentTimeMillis();
			gameState = GameState.Restart;
		}
	}

	private void loseScreen() {
		requestFocus();
		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();
		gc.setColor(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		displayMessage("They got you!", gc, Color.GREEN, 0, 0);
		displayMessage("Press any key", gc, Color.blue, 25, 0);
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.draw(gc);
		}
		gc.dispose();
		strategy.show();
		if (isKeyPressed == true) {
			timeStamp = System.currentTimeMillis();
			gameState = GameState.Restart;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		isKeyPressed = true;
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
		isKeyPressed = false;
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

	}

	public static void main(String[] args) {
		Controller gui = new Controller();
		gui.start();
	}

	@Override
	public void onEndOfLife(Entity e) {

		removeList.add(e);
		if (e instanceof MarchingAlien) {
			remainingAliens--;
			SoundFX.COLLIDE.play();
			// if in render, speeds up even if no more aliens are killed
			if (remainingAliens % 10 == 0) {
				armySpeed(army);
			}
		}
	}

	public void alienDive() {
			int index = (int) (Math.random() * army.size());
			MarchingAlien divingAlien = army.get(index);
			if (divingAlien.rx <= 570 && divingAlien.rx >=30 ){
			army.get(index).setVelocity(0, 1);
			alienFireTime = System.currentTimeMillis();
			}
		}
		/*
		 * AlienMissile alienMissile = new AlienMissile(this, new
		 * Dimension(SCREEN_WIDTH / 40, SCREEN_HEIGHT / 30));
		 * addEntity(alienMissile); int i = (int) (Math.random() * army.size());
		 * alienMissile.setPosition(army.get(i).rx, army.get(i).ry - 20);
		 */

	

	@Override
	public void onFire(Entity e) {
		// to position missile you have to find the spaceship sits

		Missile missile = new Missile(this, new Dimension(SCREEN_WIDTH / 60, SCREEN_HEIGHT / 45));
		addEntity(missile);
		SoundFX.SHOOT.play();
		missile.setPosition(e.rx + 10, e.ry - 30);
		if ((System.currentTimeMillis() - alienFireTime) > 1000 && level==4)
			alienDive();

	}

	private void displayMessage(String message, Graphics2D gc, Color color, int voffSet, int xoffset) {
		Color oldColor = gc.getColor();
		Font oldFont = gc.getFont();

		Font font = new Font("Courier New", Font.PLAIN, 16);
		gc.setFont(font);
		gc.setColor(color);

		int stringWidth = gc.getFontMetrics().stringWidth(message);
		gc.drawString(message, (SCREEN_WIDTH - stringWidth) / 2 + xoffset, SCREEN_HEIGHT / 2 + voffSet);

		gc.setColor(oldColor);
		gc.setFont(oldFont);
	}

	@Override
	public void requestLogic(Entity e) {
		if (e instanceof MarchingAlien) {
			if (onMoveDown == true) {
				for (MarchingAlien a : army) {
					if (a.vy > 0) {
						
					} else {
						a.setVelocity(-a.getVx(), 0);
						a.setPosition(a.getRx() + a.getVx() * 40, a.getRy() + a.dimension.height);
						if (a.getRy() >= SCREEN_HEIGHT+5) {
							SoundFX.LOSE.play();
							gameState = GameState.Lose;

						}
					}
					onMoveDown = false;
				}
			}
		}
		if (e instanceof SpaceShip) {
			gameState = GameState.Lose;
		}

	}
}
