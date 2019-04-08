package chapter2;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Wall extends Entity implements ConstantValues {

	private Rectangle bounds;

	public Wall(int x, int y, Dimension dim) {
		super(null, dim);
		bounds = new Rectangle(x, y, dim.width, dim.height);
	}

	@Override
	public void move(long tm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D gc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processKeys(byte keys) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean inCollision(Entity e) {
		Dimension d = e.dimension;
		if (e.getRx() >= bounds.width - d.width)
			return true;
		if (e.getRx() <= bounds.x)
			return true;
		if (e.getRy() >= bounds.height)
			return true;
		if (e.getRy() <= bounds.height - d.height)
			return true;

		return false;

		// return !bounds.contains(new Point((int) e.getRx(), (int) e.getRy()));

	}

	public Rectangle getBounds() {
		return new Rectangle(bounds);
	}

}
