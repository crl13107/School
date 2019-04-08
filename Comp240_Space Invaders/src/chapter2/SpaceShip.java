package chapter2;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SpaceShip extends Entity implements ConstantValues {

	private Sprite sprite;
	private final float MAX_VELOCITY = .4f;
	private final float DELTA_VELOCITY = 0.02f;
	private final long FIRING_INTERAL = 200;
	private long lastFired = System.currentTimeMillis();

	public SpaceShip(GameEventListener controller, Dimension dim) {
		super(controller, dim);
		sprite = new Sprite("sprites/shipSpriteSheet.png", 3);

	}

	@Override
	public void move(long tm) {
		rx = rx + vx * tm;
	}

	@Override
	public void draw(Graphics2D gc) {
		sprite.drawImage(gc, (int) rx, (int) ry, (int) rx + dimension.width, (int) ry + dimension.height, active);
	}

	@Override
	public void processKeys(byte keys) {
		if ((keys & LEFT_KEY) != 0) {
			vx = -Math.abs(vx) - DELTA_VELOCITY;
		}
		if (((keys & RIGHT_KEY) != 0)) {

			vx = Math.abs(vx) + DELTA_VELOCITY;
		}
		if ((keys & 0x0F) == 0) {
			vx = 0;
		}
		if (((keys & SPACE_KEY) != 0)) {
			if (System.currentTimeMillis() - lastFired > FIRING_INTERAL) {
				lastFired = System.currentTimeMillis();
				controller.onFire(this);
			}

		}

		if (vx < -MAX_VELOCITY)
			vx = -MAX_VELOCITY;
		if (vx > MAX_VELOCITY)
			vx = MAX_VELOCITY;

	}

	@Override
	public boolean inCollision(Entity e) {
		if (e instanceof Wall) {
			Wall w = (Wall) e;
			Rectangle bnds = w.getBounds();
			if (rx > bnds.x + bnds.width - dimension.width) {

				vx = 0;
				rx = bnds.x + bnds.width - dimension.width;
			}
			if (rx < 0) {
				vx = 0;
				rx = 0;
			}
		}

		return false;
	}

}
