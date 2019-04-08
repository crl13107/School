package basic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Box extends Entity {

	private Color color = Color.BLACK;
	private Dimension dimension = new Dimension(5, 5);

	@Override
	// vx first, then vy
	public void move(long elapsedTime) {

		if (rx >= 590) {
			setVelocity(-1, vy);
		}
		if (ry >= 590) {
			setVelocity(vx, -1);
		}
		if (rx <= 0) {
			setVelocity(1, vy);
		}
		if (ry <= 0) {
			setVelocity(vx, 1);
		}

		rx += elapsedTime * vx;
		ry += elapsedTime * vy;

	}

	@Override
	public void draw(Canvas canvas) {
		BufferStrategy strategy = canvas.getBufferStrategy();
		Graphics2D gc = (Graphics2D) strategy.getDrawGraphics();
		gc.setXORMode(gc.getBackground());
		gc.setColor(color);
		gc.fillRect((int) rx, (int) (ry), dimension.width, dimension.height);
		gc.dispose();
		strategy.show();
	}

}
