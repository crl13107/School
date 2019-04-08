/**
 * 
 */
package crl486.chapter9;

import java.util.Scanner;

/**
 * @author crl486
 *
 */
public class DanceLessons {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("Enter number of male dancers - ");
		int men = k.nextInt();

		System.out.print("enter number of of female dancers - ");
		int women = k.nextInt();
		

		try {
			if (men == 0 && women == 0) {
				throw new Exception("Classes are cancled!! No students!");

			} else if (men == 0) {
				throw new Exception("Classes are cancelled, no men!");

			} else if (women == 0) {
				throw new Exception("Classes are cancelled, no women!");

			}
			

			if (women >= men) {
				System.out.print("Each man must dance with " + women / (double) men + " women. \n");
			} else {
				System.out.print("Each woman must dance with " + men / (double) women + " men. \n");
			}
			

		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println(message);
			k.close();
			System.exit(0);

		}
		

		System.out.println("Let the dance begin!");
	}
}
