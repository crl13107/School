package basic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Ball extends Entity {

	private Color color = Color.GREEN;
	private Dimension dimension = new Dimension(50, 50);

	@Override
	public void move(long elapsedTime) {

		if (rx > 600 - (int) dimension.getWidth()) {
			vx = -vx;
			rx = 600 - (int) dimension.getWidth();
		}
		if (rx < 0) {
			vx = -vx;
			rx = 0;
		}
		if (ry > 600 - (int) dimension.getWidth()) {
			vy = -vy;
			ry = 600 - (int) dimension.getWidth();
		}
		if (ry < 0) {
			vy = -vy;
			ry = 0;
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
		gc.fillOval((int) rx, (int) (ry), dimension.width, dimension.height);
		gc.dispose();
		strategy.show();
	}

}
