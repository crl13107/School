/**
 * 
 */
package crl486.arrayMult;

/**
 * @author crl486
 *
 */
public class ArrayMult {

	public static void printArray(double[][] array) {
		if (array == null)
			return;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println("\t");
		}
		System.out.println("-------");
	}

	public static double[][] mult(double[][] left, double[][] right) {
		if (left == null || right == null || (left[0].length != right.length))
			return null;
		double[][] result = new double[left.length][right[0].length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				double sum = 0;
				for (int k = 0; k < result.length; k++) {
					sum += left[i][k] * right[k][j];

				}
				result[i][j] = sum;
				System.out.println(sum + " ");
			}

		}

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[][] left = { { 1.0, 2.0 }, { 3.0, 4.0 } };
		double[][] right = { { 10.0 }, { 20.0 } };
		printArray(left);
		printArray(right);
		mult(left, right);

	}

}

/*
 * method public static double[][] transpose(double[][]array){
 * 
 * double[][]result
 * 
 * return result;
 */
