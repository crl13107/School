package chapter2;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity {

	protected float rx, ry; // position params
	protected float vx, vy; // Velocity params
	protected boolean active = false;
	protected GameEventListener controller;
	protected Dimension dimension = new Dimension();

	public float getRx() {
		return rx;
	}

	public float getRy() {
		return ry;
	}

	public float getVx() {
		return vx;
	}

	public float getVy() {
		return vy;
	}

	@SuppressWarnings("unused")
	private Entity() {

	}

	public Entity(GameEventListener controller, Dimension dim) {
		this.controller = controller;
		this.dimension = new Dimension(dim);
	}

	public void setPosition(float x, float y) {
		rx = x;
		ry = y;
	}

	public void setVelocity(float u, float v) {
		vx = u;
		vy = v;
	}

	public void setDimension(int width, int height) {
		dimension.width = width;
		dimension.height = height;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) rx, (int) ry, dimension.width, dimension.height);
	}

	public Dimension getDimension() {
		return new Dimension(dimension);
	}

	public void activate() {
		active = true;
	}

	public void deactivate() {
		active = false;
	}

	public void setController(GameEventListener listener) {
		controller = listener;
	}

	public abstract void move(long tm);

	public abstract void draw(Graphics2D gc);

	public abstract void processKeys(byte keys);

	public abstract boolean inCollision(Entity e);

	public void setVelocity(double d, double e) {
		// TODO Auto-generated method stub
		
	}

}
