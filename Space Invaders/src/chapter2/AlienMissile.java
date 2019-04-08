package chapter2;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class AlienMissile extends Entity {

	private Sprite sprite;
	private float vy = .001f;
	private float a = .001f;
	private final float MAX_VELOCITY = 1f;

	public AlienMissile(GameEventListener controller, Dimension dim) {
		super(controller, dim);
		sprite = new Sprite("sprites/projectileSpriteSheet.png", 3);
		// TODO find new sprite online
	}

	@Override
	public void move(long tm) {
		ry = ry + vy * tm;
		vy = vy + (a * tm);
		if (vy > MAX_VELOCITY) {
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
			return false;
		}
		if (e instanceof SpaceShip){
			Rectangle rect = e.getBounds();
			if (getBounds().intersects(rect)){
				controller.onEndOfLife(this);
				controller.requestLogic(e);
				return true;
			}
		}
	
		return false;
	}

}
