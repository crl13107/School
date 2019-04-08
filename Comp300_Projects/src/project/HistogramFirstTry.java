/**
 * 
 */
package project;

import java.util.ArrayList;
import java.util.List;

/**
 * @author crl486
 *
 */
public class HistogramFirstTry {

	/**
	 * @param args
	 */
	class Node {
		int number;
		int count;

		Node(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}

	private int getIndex(int number, List<Node> list) {

		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).number == number)
				return index;
		}
		return -1;
	}

	private void add(int number, List<Node> list) {
		int index = getIndex(number, list);
		if (index < 0)
			list.add(new Node(number, 1));
		else
			list.get(index).count++;
	}

	public int[][] histogram(int[] array) {
		List<Node> list = new ArrayList<>();

		System.out.println("Brute force apparoch!");

		// The cataloging work starts here
		long time = System.currentTimeMillis();
		for (int number : array)
			add(number, list);
		System.out.println("Elapased time: " + (System.currentTimeMillis() - time + " milleseconds"));

		// cataloging end
		// display part, not to be timed
		int[][] histogram = new int[list.size()][2];
		for (int index = 0; index < list.size(); index++) {
			histogram[index][0] = list.get(index).number;
			histogram[index][1] = list.get(index).count;
		}
		return histogram;
	}

	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
			if ((i + 1) % 20 == 0) // +1 so first item doesn't make a new line
				System.out.println();
		}
		System.out.println();
	}

	public void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i][0] + "\t" + array[i][1]);
		}
	}

}
