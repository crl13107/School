/**
 * 
 */
package crl486.aliens;

/**
 * @author crl486
 *
 */
public class Alien {

	private int health;
	private String name;
	private int damage;

	/*
	 * 
	 */

	public Alien() {
		name = "Default name";
		health = 0;

	}

	public Alien(int health, String name) {
		if (name == null || health > 0) {
			if (health <0)
				health = 0;
			name = "No name";
			health = 0;
		} else {
			this.name = name;
			this.health = health;
		}
	}
		
		public Alien(Alien that){
			this.health = that.health;
			this.name = that.name;
			
			
		}
	

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health >= 0)
			this.health = health;
		else
			this.health = 0;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null)
			name = "No name";
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;
		Alien that = (Alien) o;
		return name.equals(that.name) &&
				health == that.health &&
				damage == that.damage;
	}
	
	@Override
	public String toString(){
		return "Name: " + name + ", health = " + health + "damage= " + damage;
	}

}
