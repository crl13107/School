package crl486.aliens;

public class MarshMellowMan extends Alien {

	private final int DAMAGE = 0;
	
	public MarshMellowMan() {
		// TODO Auto-generated constructor stub
	}

	public MarshMellowMan(int health, String name) {
		super(health, name);
		setDamage(DAMAGE);
		// TODO Auto-generated constructor stub
	}
	
	public MarshMellowMan(Alien that) {
		super(that);
		setDamage(that.getDamage());

	}

}
