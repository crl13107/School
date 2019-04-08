package project;

import java.util.Random;

public class Tester {

	public static void main(String[] args) {

		HistogramFirstTry hh = new HistogramFirstTry();
		HistogramSecondTry ss = new HistogramSecondTry();
		int tokenCount = 10;
		int arraySize = 20;

		Random rand = new Random();

		int[] array = new int[arraySize];

		// initialize the array
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(tokenCount);
		}

		// hh.printArray(array);
		System.out.println("******");
		int[][] h1 = hh.histogram(array);
		int[][] h2 = ss.histogram(array);
		ss.printArray(h2);
		System.out.println("******");
		hh.printArray(h1);
	}
}
