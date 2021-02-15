/**
 * This class contains methods to convert infix to postfix, and vice versa. <br>
 * It also contains a method to evaluate a postfix expression, taking a string
 * and returning a double.
 * 
 * @author Raymond Karyshyn
 */

public class Notation {
    /**
     * Evaluates a postfix expression from a string to a double.
     * 
     * @param postfixExpr The postfix expression in string format.
     * @return The evaluation of the postfix expression as a double.
     * @throws InvalidNotationFormatException If the postfix expression format is
     *                                        invalid.
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
        double result;

        result = 0;

        return result;
    }

    /**
     * Converts the postfix expression to the infix expression.
     * 
     * @param postfix The postfix expression in string format.
     * @return The infix expression in string format.
     * @throws InvalidNotationFormatException If the postfix expression format is
     *                                        invalid.
     */
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        String infix = "";

        //

        return infix;
    }

    /**
     * Converts an infix expression into a postfix expression. <br>
     * MUST USE A QUEUE TO HOLD THE POSTFIX EXPRESSION.
     * 
     * @param infix The infix expression in string format.
     * @return The postfix expression in string format.
     * @throws InvalidNotationFormatException If the infix expression format is
     *                                        invalid.
     */
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
        NotationQueue<Character> postfix = new NotationQueue<>(infix.length());
        NotationStack<Character> operatorStack = new NotationStack<>(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (c == ' ')
                continue;
            else if (Character.isDigit(c)) {
                postfix.enqueue(c);
                continue;
            }

            switch (c) {
                case '(':
                    operatorStack.push(c);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                    while (!operatorStack.isEmpty() && (precedence(c) <= precedence((char) operatorStack.top())))
                        postfix.enqueue(operatorStack.pop());

                    operatorStack.push(c);
                    break;
                case ')':
                    while (!operatorStack.isEmpty() && operatorStack.top() != '(')
                        postfix.enqueue(operatorStack.pop());

                    if (!operatorStack.isEmpty())
                        operatorStack.pop();
                    else if (operatorStack.isEmpty())
                        throw new InvalidNotationFormatException();

                    break;
                default:
                    break;
            }
        }

        while (!operatorStack.isEmpty())
            postfix.enqueue(operatorStack.pop());

        return postfix.toString();
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
        }

        return -1;
    }
}
