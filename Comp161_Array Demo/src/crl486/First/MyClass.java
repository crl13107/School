package crl486.First;

public class MyClass {

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// method that compares two arrays and returns a boolean
	public static boolean equalsArrray(int[] a, int[] b) {
		if (a == b)
			return true;
		else
			return false;
		
	}

	public static void main(String[] args) {
		int[] even = new int[10];
		int[] myarray = new int[10];
		for (int i = 0; i < even.length; i++) {
			even[i] = (i + 1) * 2;
			myarray[i] = even[i];
		}

		if (even == myarray)
			System.out.println("They are equal");
		else
			System.out.println("The arrays are different");

		int[] odd = new int[10];
		for (int i = 0; i < odd.length; i++)
			odd[i] = 2 * i + 1;

		printArray(odd);
		printArray(even);

		char[] message = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' };

		// System.out.println(message);

		String str = new String(message);

		String str2 = new String(message, 6, 5);

		// System.out.println(str2);

		MyClass[] classArray = new MyClass[10];

		for (int i = 0; i < classArray.length; i++) {
			classArray[i] = new MyClass();
		}

		System.out.println(equalsArrray(even, odd));
		// runs the method and returns true if the arrays are equal, or false if
		// they are not
	}
}
