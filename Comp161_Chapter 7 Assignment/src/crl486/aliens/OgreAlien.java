package crl486.aliens;

public class OgreAlien extends Alien {

	private final int DAMAGE = 6;
	
	public OgreAlien() {
		// TODO Auto-generated constructor stub
	}

	public OgreAlien(int health, String name) {
		super(health, name);
		setDamage(DAMAGE);
		// TODO Auto-generated constructor stub
	}
	
	public OgreAlien(Alien that) {
		super(that);
		setDamage(that.getDamage());
	
	}

}
