package crl486;

public class test {

	public static void printArray(int[] array) {
		for (int num : array)
			System.out.print(num + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 5 };
		int arr2[] = { 1, 2, 3, 4 };

		printArray(arr1);
		printArray(arr2);

	}
}
