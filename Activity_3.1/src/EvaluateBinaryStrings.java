import java.util.Stack;

/**
 * This program determines if there are the same number of 0s as 1s in binary
 * strings. If the counts are not equal, the program reports how much one value
 * exceeds the other.
 * 
 * @author Raymond Karyshyn
 */
public class EvaluateBinaryStrings {
    /**
     * The class that calculates the difference in frequency of 0s and 1s in a given
     * binary string, as well as the most frequent and least frequent values.
     */
    public static class BinaryString {
        private String string;
        private int frequencyDifference, mostFrequentValue, leastFrequentValue;

        BinaryString(String stringIn) {
            string = stringIn;
            frequencyDifference = mostFrequentValue = leastFrequentValue = -1;

            // Replaces the default values of frequencyDifference, mostFrequentValue,
            // and leastFrequentValue
            evaluate();
        }

        /**
         * Uses a stack to calculate how many of a certain binary number are left over
         * after pairing 0s and 1s.
         * 
         * Always populates frequencyDifference (stack size), and only populates
         * mostFrequentValue and leastFrequentValue if the frequencyDifference is
         * greater than 0.
         */
        public void evaluate() {
            Stack<Character> stack = new Stack<>();

            // Traverses the binary string
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);

                // If the stack is empty or holds characters of the same type,
                // push c to the top of the stack.
                if (stack.empty() || stack.peek() == c)
                    stack.push(c);
                // Otherwise, if the stack is neither empty nor holds characters of the same
                // type, pop off the top character.
                // This means either a 1 is paired with a 0, or vice versa.
                else
                    stack.pop();
            }

            // Size of the stack is the same as the absolute difference between
            // the frequency of 0s and frequency of 1s.
            frequencyDifference = stack.size();

            // If the frequencyDifference is greater than 0 (meaning there is at least one
            // character in the stack),
            // then there is a "most frequent" and a "least frequent" value.
            if (frequencyDifference > 0) {
                // Since all characters in the stack are of the same type,
                // only peek at the top of the stack for the most frequent value.
                mostFrequentValue = Character.getNumericValue(stack.peek());

                // The least frequent value is the opposite of the most frequent,
                // so subtract one and calculate the absolute value.
                leastFrequentValue = mostFrequentValue - 1;
                if (leastFrequentValue < 0)
                    leastFrequentValue *= -1;
            }
        }

        /**
         * Portrays the evaluation of the binary string as a string in the format:
         * 
         * "`string`" has more `mostFrequentValue`s than `leastFrequentValue`s <br>
         * or <br>
         * "`string`" has the same amount of 0s as 1s
         */
        public String toString() {
            String result = "\"" + string + "\" has ";

            if (frequencyDifference > 0)
                result += frequencyDifference + " more " + mostFrequentValue + "s than " + leastFrequentValue + "s";
            else
                result += "the same amount of 0s as 1s";

            return result;
        }
    }

    public static void main(String[] args) {
        // Create BinaryString objects using the constructor to set the string
        BinaryString bStr1 = new BinaryString("001");
        BinaryString bStr2 = new BinaryString("11011101");
        BinaryString bStr3 = new BinaryString("101010101100");
        BinaryString bStr4 = new BinaryString("11000110101100");
        BinaryString bStr5 = new BinaryString("10110001111001001");

        // Print out the toString() evaluations of the BinaryString objects
        System.out.println(bStr1);
        System.out.println(bStr2);
        System.out.println(bStr3);
        System.out.println(bStr4);
        System.out.println(bStr5);
    }
}
