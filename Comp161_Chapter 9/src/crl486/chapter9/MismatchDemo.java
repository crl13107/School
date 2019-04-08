package crl486.chapter9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MismatchDemo {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int number = 0;
		boolean done = false;
		do {
			try {
				System.out.print("enter a number - ");

				number = k.nextInt();
				System.out.println("Processed input from user");
			} catch (InputMismatchException e) {
				System.out.println("Incorrect format entered - enter whole numbers!!");
				System.out.println("Please retry!");
				k.nextLine();
			}
		} while (!done);
		System.out.println("You entered " + number);

		k.close();

	}

}
