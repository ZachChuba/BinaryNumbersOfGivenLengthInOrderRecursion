import java.util.Scanner;

public class RehashedBinaryNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// read in number of digits
		// int numDigits = Integer.parseInt(sc.nextLine());
		int numDigits = 3;

		// print binary numbers
		printNumbers(numDigits);
	}

	public static void printNumbers(int n) {
		StringBuilder largestBinaryNumber = new StringBuilder();
		StringBuilder smallestBinaryNumber = new StringBuilder();
		// build the largest and smallest binary numbers of size n
		// largest should be all 1s, smallest all 0s
		for (int i = 0; i < n; i++) {
			largestBinaryNumber.append('1');
			smallestBinaryNumber.append('0');
		}
		// recursively print all the number from smallest to largest
		printNumbersHelper(smallestBinaryNumber.toString(), largestBinaryNumber.toString());

	}

	/**
	 * 
	 * @param currentNumber
	 *            a string representation of the current binary number
	 * @param largestNumber
	 *            a string representation of the largest possible binary number
	 * @action recursively print numbers from currentNumber -> largestNumber
	 */
	public static void printNumbersHelper(String currentNumber, String largestNumber) {
		// base case: if currentNumber = largestNumber, print it and terminate recursion
		if (currentNumber.equals(largestNumber)) {
			System.out.println(currentNumber);
			return;
		} else {
			// recursive step: print the current number then add the equivalent of decimal 1
			// to the number, then pass it back to the function
			System.out.println(currentNumber);
			currentNumber = nextLargerBinaryNumber(currentNumber);
			printNumbersHelper(currentNumber, largestNumber);

		}
	}

	/**
	 * 
	 * @param binaryNumber:
	 *            a string representation the current binary number
	 * @return a string representation of the next binary number
	 */
	private static String nextLargerBinaryNumber(String binaryNumber) {
		char[] currentBinaryNumber = binaryNumber.toCharArray();
		int indexOfFirstZero = currentBinaryNumber.length - 1;
		// Iterate through the current binary number's digits, starting at the 2^0
		// position. When one of these digits is 0, makes it 1 and replaces all of
		// the preceding 1s with 0s. The equivalent of adding 1 in decimal
		for (; indexOfFirstZero >= 0; indexOfFirstZero--) {
			if (currentBinaryNumber[indexOfFirstZero] == '0') {
				currentBinaryNumber[indexOfFirstZero] = '1';
				replacePreceding1sWith0(currentBinaryNumber, indexOfFirstZero);
				break;
			}
		}
		return new String(currentBinaryNumber);
	}

	/**
	 * @param initialBinaryNumber:
	 *            char[] representation of a binary number
	 * @param indexOfZero:
	 *            int index Converts the initialBinaryNumber after indexOfZero from
	 *            1 to 0
	 */
	private static void replacePreceding1sWith0(char[] initialBinaryNumber, int indexOfZero) {
		for (int i = initialBinaryNumber.length - 1; i > indexOfZero; i--) {
			initialBinaryNumber[i] = '0';
		}
	}
}