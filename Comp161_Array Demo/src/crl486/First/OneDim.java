/**
 * 
 */
package crl486.First;

/**
 * @author crl486
 *
 */
public class OneDim {

	public static void printArray(int[] arr, int[] srr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		//

		for (int i = 0; i < srr.length; i++) {
			System.out.print(srr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] even = new int[10];
		for (int x = 0; x < even.length; x++) {
			even[x] = (x + 1) * 2;
		}

		int[] odd = new int[10];
		for (int x = 0; x < odd.length; x++) {
			odd[x] = (x * 2) + 1;
		}
		// even = odd;

		printArray(even, odd);
		// printArray(odd);

		char[] msg = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' };
		System.out.println(msg);
		
		String str = new String(msg);
		String str2 = new String(msg, 6, 5);
		
		System.out.println(str);
		System.out.println(str2);
		MyClass[] classArray = new MyClass[10];
		
		for (int i = 0; i < classArray.length; i++){
			classArray[i] = new MyClass();
		}
	}
}

