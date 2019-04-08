package crl486.arrayMult;

public class Test {


		public static void doubleArray(int[] array){
			// Create an array twice the size
			int[] temp = new int[array.length * 2];
			
			// Copy old array contents to new array
			for (int i = 0; i < array.length; i++){
				temp[i] = array[i];
			}
			// set previous array reference to new array reference
			array = temp;
		}
		
		public static void main(String[] args) {
			int[] arr = {1,2,3,4,5};
			System.out.println("Array length was " + arr.length);
			doubleArray(arr);
			System.out.println("Now array length is " + arr.length);
		}
		
	
		

	}


