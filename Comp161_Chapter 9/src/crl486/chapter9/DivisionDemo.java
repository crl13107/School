package crl486.chapter9;

//import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionDemo {

	public static double safeDivide(int numerator, int denominator) throws DivisonByZeroException {
		try {
			if (denominator == 0)
				throw new DivisonByZeroException("Denominator cannot be zero!");
		} finally {
			System.out.print("Denominator cannot be zero!");
		}
		return numerator / (double) denominator;
	}

	public static void main(String[] args) {

		try (Scanner kbd = new Scanner(System.in)) {
			System.out.print("Enter a numerator - ");
			int numerator = kbd.nextInt();

			System.out.print("Enter a denominator - ");
			int denominator = kbd.nextInt();

			double quotient = safeDivide(numerator, denominator);

			System.out.println(numerator + "/" + denominator + " = " + quotient);

		} catch (DivisonByZeroException e) {
			System.out.println(e.getMessage());
			e.getSuppressed();
			StackTraceElement[] trace = e.getStackTrace();
			for (StackTraceElement elem : trace) {
				System.out.print(elem.getMethodName() + " Line no: " + elem.getLineNumber());
			}
			System.exit(0);
		}

	}

}