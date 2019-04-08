package chapter2;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MarchingAlien extends Entity {
	// overrides method

	private Sprite sprite;
	private final float MAX_VELOCITY = .4f;
	private final float DELTA_VELOCITY = 0.1f;

	public MarchingAlien(GameEventListener listener, Dimension dim) {
		super(listener, dim);
		sprite = new Sprite("sprites/alienSpriteSheet.png", 3);
	}

	@Override
	public void move(long tm) {
		rx = rx + vx * tm;
		ry = ry + vy * tm;
	}

	@Override
	public void draw(Graphics2D gc) {
		sprite.drawImage(gc, (int) rx, (int) ry, (int) rx + dimension.width, (int) ry + dimension.height, active);
	}

	@Override
	public void processKeys(byte keys) {

	}

	@Override
	public boolean inCollision(Entity e) {
		if (e instanceof MarchingAlien) {
			return false;
		}
		if (e instanceof Missile) {
			if (getBounds().intersects(e.getBounds())) {
				controller.onEndOfLife(this);
				SoundFX.COLLIDE.play();
				return true;
			}

		}

		if (e instanceof Wall) {
			Wall w = (Wall) e;
			Rectangle bnds = w.getBounds();
			if (rx > bnds.width - dimension.width || rx < bnds.x) {
				controller.requestLogic(this);
				return true;
			}
			if (ry > bnds.getHeight()) {
				if (vy > 0)
					controller.onEndOfLife(this);
				return true;
			}
		}
		return false;
	}

}
