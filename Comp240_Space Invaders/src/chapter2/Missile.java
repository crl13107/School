package chapter2;

import java.awt.Dimension;
import java.awt.Graphics2D;

public class Missile extends Entity {

	private Sprite sprite;
	private float vy = -.001f;
	private float a = -.1f;
	private final float MAX_VELOCITY = -1f;

	public Missile(GameEventListener controller, Dimension dim) {
		super(controller, dim);
		sprite = new Sprite("sprites/projectileSpriteSheet.png", 3);

	}

	@Override
	public void move(long tm) {
		ry = ry + (int) vy * tm;
		vy = vy + (a * tm);
		if (vy < MAX_VELOCITY) {
			vy = MAX_VELOCITY;
		}
	}

	@Override
	public void draw(Graphics2D gc) {
		sprite.drawImage(gc, (int) rx, (int) ry, (int) rx + dimension.width, (int) ry + dimension.height, active);

	}

	@Override
	public void processKeys(byte keys) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean inCollision(Entity e) {
		if (e instanceof Wall) {
			Wall w = (Wall) e;
			if (ry < w.getRy()) {
				controller.onEndOfLife(this);
				return true;
			}

		}
		return false;
	}
}
