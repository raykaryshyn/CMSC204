/**
 * Program that generates the sum of values in array and the nth number in the
 * fibonacci sequence
 * 
 * @author Raymond Karyshyn
 */

public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;
	private static long[] fibTable = new long[10000];

	public static void main(String[] args) {
		// Array Sum (Driver)
		int index = 0;
		Integer[] myArray = new Integer[ARRAY_SIZE];

		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;

		double sum = sumOfArray(myArray, 3);
		System.out.println(sum);

		myArray[index++] = 7;
		myArray[index++] = 1;

		sum = sumOfArray(myArray, 5);
		System.out.println(sum);
		// END - Array Sum (Driver)

		// Fibonacci (Driver)
		System.out.println("\nFIBONACCI SEQUENCE");
		System.out.println("5th term:\t" + fibonacci(5));
		System.out.println("10th term:\t" + fibonacci(10));
		System.out.println("15th term:\t" + fibonacci(15));
		System.out.println("20th term:\t" + fibonacci(20));
		System.out.println("50th term:\t" + fibonacci(50));
		System.out.println("100th term:\t" + fibonacci(100));
		// END - Fibonacci (Driver)
	}

	/**
	 * Recursive method for generating sum of values in array
	 * 
	 * @param arr array of Numbers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	public static <T extends Number> double sumOfArray(T arr[], int num) {
		if (num < 0)
			return 0;

		return arr[num].doubleValue() + sumOfArray(arr, num - 1);
	}

	/**
	 * Recursive & dynamic programming method for generating the nth number in the
	 * fibonacci sequence
	 * 
	 * @param n term to generate in the fibonacci sequence
	 * @return nth term in the fibonacci sequence
	 */
	public static long fibonacci(int n) {
		if (fibTable[n] != 0)
			return fibTable[n];
		else if (n <= 2)
			return 1;

		long first = fibonacci(n - 1);
		long second = fibonacci(n - 2);
		fibTable[n] = first + second;
		return fibTable[n];
	}
}