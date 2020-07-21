package codewarriors;

public class Calculator {
	public static Double evaluate(String expression) {
		int indexOfMultiplication = expression.indexOf(" * ")+1;
		int indexOfDivision = expression.indexOf(" / ")+1;
		while (indexOfDivision > 0 || indexOfMultiplication > 0) {
			String[] subExpression = null;
			if (firstOperation(indexOfMultiplication, indexOfDivision)== indexOfDivision) {
				subExpression = getSubExpression(expression, indexOfDivision);
			} else {
				subExpression = getSubExpression(expression, indexOfMultiplication);
			}
			expression = expression.replace(subExpression[0]+" "+subExpression[1]+" "+subExpression[2], Double.toString(calculation(subExpression)));
			indexOfMultiplication = expression.indexOf(" * ")+1;
			indexOfDivision = expression.indexOf(" / ")+1;
		}//end of while for multiplication and division
		
		int indexOfAddition = expression.indexOf(" + ")+1;
		int indexOfSubtraction = expression.indexOf(" - ")+1;
		while (indexOfAddition > 0 || indexOfSubtraction > 0) {
			String[] subExpression = null;
			if (firstOperation(indexOfAddition, indexOfSubtraction)== indexOfAddition) {
				subExpression = getSubExpression(expression, indexOfAddition);
			} else {
				subExpression = getSubExpression(expression, indexOfSubtraction);
			}
			expression = expression.replace(subExpression[0]+" "+subExpression[1]+" "+subExpression[2], Double.toString(calculation(subExpression)));
			indexOfAddition = expression.indexOf(" + ")+1;
			indexOfSubtraction = expression.indexOf(" - ")+1;
		}//end of while for multiplication and division
		return Double.parseDouble(expression);
	}
	
	private static int firstOperation(int operation1, int operation2) {
		if (operation1 == 0 && operation2 != 0) {
			return operation2;
		} else if (operation1 != 0 && operation2 == 0) {
			return operation1;
		} else if ((operation1 != 0 && operation2 != 0) && operation1 < operation2) {
			return operation1;
		} else if ((operation1 != 0 && operation2 != 0) && operation1 > operation2) {
			return operation2;
		}
		return Integer.MAX_VALUE;
	}

	private static double calculation(String[] subExpression) {
		double firstNumber = Double.parseDouble(subExpression[0]);
		double secondNumber = Double.parseDouble(subExpression[2]);
		double result = 0;
		switch(subExpression[1].charAt(0)) {
		case '+':
			result = firstNumber + secondNumber;
			break;
		case '-':
			result = firstNumber - secondNumber;
			break;
		case '*':
			result = firstNumber * secondNumber;
			break;
		case '/':
			result = firstNumber / secondNumber;
			break;
		default:
			// code block
		}
		return result;
	}

	private static String[] getSubExpression(String expression, int indexOfOperator) {
		String firstNumber = "";
		String secondNumber = "";
		boolean foundNumber = false;
		int pointerToFirstNumber = indexOfOperator -2;
		int pointerToSecondNumber = indexOfOperator +2;
		while (!foundNumber && pointerToFirstNumber > -1) {
			if (Character.isDigit(expression.charAt(pointerToFirstNumber)) || expression.charAt(pointerToFirstNumber) == '.' || expression.charAt(pointerToFirstNumber) == '-') {
				firstNumber = expression.substring(pointerToFirstNumber, indexOfOperator-1);
			}

			pointerToFirstNumber--;
			if (pointerToFirstNumber < 0 || expression.charAt(pointerToFirstNumber)==' ') {
				foundNumber = true;
			}
		}//end of while for first number
		foundNumber = false;
		while (!foundNumber && pointerToSecondNumber < expression.length()) {
			if (Character.isDigit(expression.charAt(pointerToSecondNumber)) || expression.charAt(pointerToSecondNumber) == '.' || expression.charAt(pointerToFirstNumber) == '-') {
				secondNumber = expression.substring(indexOfOperator+2, pointerToSecondNumber+1);
			}

			pointerToSecondNumber++;
			if (pointerToSecondNumber >= expression.length() || expression.charAt(pointerToSecondNumber)==' ') {
				foundNumber = true;
			}
		}//end of while for second number
		String[] subexpression = new String[] {firstNumber, expression.substring(indexOfOperator, indexOfOperator+1), secondNumber};
		return subexpression;
	}
}
