/**
 * 
 */
package crl486.aliens;

/**
 * @author crl486
 *
 */
public class SnakeAlien extends Alien {

	private final int DAMAGE = 10;

	/**
	 * 
	 */
	public SnakeAlien() {
	}

	/**
	 * @param health
	 * @param name
	 */
	public SnakeAlien(int health, String name) {
		super(health, name);
		setDamage(DAMAGE);
	}

	public SnakeAlien(Alien that) {
		super(that);
		setDamage(that.getDamage());

	}

}
