package crl4862Stack;

import linkedStructures.LinkedStack;
import arrayStructures.Stack;

public class Evaluate {

	private static Double evaluate(String expression) {
		Stack<String> operators = new LinkedStack<String>();
		Stack<Double> operands = new LinkedStack<Double>();

		// Separates equation into tokens based on spacing
		String[] token = expression.split("[\\s]+");
		for (String a : token) {

			// checks what each token is, then adds to proper stack

			if (a.matches("\\d*\\.*\\d+")) {
				// converts number string to a double, then adds to stack
				double number = Double.parseDouble(a);
				operands.push(number);
			}

			else if (a.matches("[*/\\-+(^]|(sqrt)")) {
				if (!operators.isEmpty()) {
					String operater_2 = operators.pop();
					if (getPrecedence(operater_2) <= getPrecedence(a)) {
						operators.push(a);
						operators.push(operater_2);
					} else
						operators.push(operater_2);
					operators.push(a);

				} else {
					operators.push(a);
				}
			}

			else if (a.matches("[)]")) {

				Double secondNumber, firstNumber;
				String operand;

				operand = operators.peek();

				if (operand.equals("sqrt")) {
					operators.pop();
					firstNumber = operands.pop();
					operands.push(Math.sqrt(firstNumber));
				}

				else if (operand.equals("(")) {
					if (operands.isEmpty()) {
						operands.push(0.0);

					}

				}

				else {
					operators.pop();
					secondNumber = operands.pop();
					firstNumber = operands.pop();//

					if (operand.equals("-")) {
						operands.push(firstNumber - secondNumber);

					} else if (operand.equals("+")) {
						operands.push(secondNumber + firstNumber);

					} else if (operand.equals("*")) {
						operands.push(secondNumber * firstNumber);

					} else if (operand.equals("/")) {
						if (secondNumber == 0) {
							throw new java.lang.ArithmeticException("divison by zero error found");
						} else
							operands.push(firstNumber / secondNumber);
					}
				}

				if (operators.peek().equals("(")) {
					operators.pop();

				}

			} else {
				System.out.print("Invalid operand, or number detected!! setting awnser to ");
				return null;
			}
		}

		System.out.println(operands.isEmpty());
		System.out.println(operators.peek());
		return operands.pop();

	}

	public static int getPrecedence(String a) {
		if (a.equals(")"))
			return 6;
		if (a.equals("sqrt"))
			return 4;
		if (a.equals("/") || a.equals("*"))
			return 3;
		if (a.equals("+") || a.equals("-"))
			return 2;
		else
			return 0;

	}

	public static void main(String[] args) {

		String expr = "( )";

		System.out.println(evaluate(expr));

	}
}

// http://www.oxfordmathcenter.com/drupal7/node/630
