package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class XPoint {

	private int x;
	private int y;

	public XPoint() {
		this.x = x;
		this.y = y;
	}

	public static Comparator<XPoint> getComparator() {
		@SuppressWarnings("unchecked")
		Comparator<XPoint> comparator = new Comparator() {

			@Override
			public int compare(Object p1, Object p2) {
				if (!(p1 instanceof XPoint) || !(p2 instanceof XPoint))
					throw new IllegalArgumentException();
				XPoint xp1 = (XPoint) p1;
				XPoint xp2 = (XPoint) p2;

				if (xp1.x < xp2.x && xp1.y == xp2.y)
					return -1;
				if (xp1.x > xp2.x && xp1.y == xp2.y)
					return 1;
				// same thing for ys
				if (xp1.x == xp2.x && xp2.y == xp2.y)
					return 0;
				if (xp1.x < xp2.x && xp1.y < xp2.y)
					return -1;

				return 1;
			}
		};

		return comparator;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public static void main(String[] args) {
		Random rand = new Random();
		XPoint[] points = new XPoint[10];

		for (int i = 0; i < points.length; i++) {
			points[i] = new XPoint(/* rand.nextInt(100), rand.nextInt(100) */);

		}

		System.out.println("Before sorting...");
		for (int i = 0; i < points.length; i++) {
			System.out.print(points[i]);
		}
		System.out.println();
		System.out.println("After sorting...");
		Arrays.sort(points, XPoint.getComparator());
		for (int i = 0; i < points.length; i++) {
			System.out.print(points[i]);
		}
		System.out.println();
	}

}
