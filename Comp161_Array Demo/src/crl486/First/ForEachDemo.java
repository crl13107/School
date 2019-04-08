package crl486.First;

public class ForEachDemo {

	public static void doubleArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i] *= 2;
	}

	public static void printArray(int[] arr) {
		/*
		 * for (int i = 0; i < arr.length; i++) { System.out.print(arr[i] + " "); }
		 * System.out.println();
		 */
		for (int var : arr)
			System.out.print(var + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		printArray(arr);

		doubleArray(arr);

		printArray(arr);
	}
}

// public static method computerAverage /double/ takes double arrays
// double avg = 0
//
// for reach loop
//
// return avg