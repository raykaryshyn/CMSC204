public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];

		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;

		int sum = sumOfArray(myArray, 3);
		System.out.println(sum);

		myArray[index++] = 7;
		myArray[index++] = 1;

		sum = sumOfArray(myArray, 5);
		System.out.println(sum);

		// Fibonacci (Driver)
		System.out.println(fibonacci(10));
	}

	/**
	 * Recursive method for generating sum of values in array
	 * 
	 * @param arr array of Integers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	public static int sumOfArray(Integer arr[], int num) {
		if (num < 0)
			return 0;

		return (arr[num] + sumOfArray(arr, num - 1));
	}

	// Fibonacci (Recursive & Dynamic Programming)
	private static long[] table = new long[10000];

	public static long fibonacci(int n) {
		if (table[n] != 0)
			return table[n];
		else if (n <= 2)
			return 1;

		long first = fibonacci(n - 1);
		long second = fibonacci(n - 2);
		table[n] = first + second;
		return table[n];
	}
}