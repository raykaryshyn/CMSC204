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
     * @param postfix The postfix expression in string format.
     * @return The evaluation of the postfix expression as a double.
     * @throws InvalidNotationFormatException If the postfix expression format is
     *                                        invalid.
     */
    public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException {
        NotationStack<Double> valueStack = new NotationStack<>(postfix.length());

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (c == ' ')
                continue;
            else if (Character.isDigit(c)) {
                valueStack.push(Double.parseDouble(Character.toString(c)));
                continue;
            }

            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                    if (valueStack.size() < 2)
                        throw new InvalidNotationFormatException();

                    double operand2 = valueStack.pop();
                    double operand1 = valueStack.pop();

                    switch (c) {
                        case '+':
                            valueStack.push(operand1 + operand2);
                            break;
                        case '-':
                            valueStack.push(operand1 - operand2);
                            break;
                        case '*':
                            valueStack.push(operand1 * operand2);
                            break;
                        case '/':
                            valueStack.push(operand1 / operand2);
                            break;
                        case '%':
                            valueStack.push(operand1 % operand2);
                            break;
                        default:
                            break;
                    }

                    break;
                default:
                    break;
            }
        }

        if (valueStack.size() > 1)
            throw new InvalidNotationFormatException();

        return valueStack.top();
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
        NotationStack<String> infix = new NotationStack<>(postfix.length());

        for (int i = 0; i < postfix.length(); i++) {
            String c = String.valueOf(postfix.charAt(i));

            if (c == " ")
                continue;
            else if (Character.isLetterOrDigit(c.charAt(0))) {
                infix.push(c);
                continue;
            }

            switch (c) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    if (infix.size() < 2)
                        throw new InvalidNotationFormatException();

                    String operand2 = infix.pop();
                    String operand1 = infix.pop();

                    String result = "(" + operand1 + c + operand2 + ")";
                    infix.push(result);
                    break;
                default:
                    break;
            }
        }

        if (infix.size() > 1)
            throw new InvalidNotationFormatException();

        return infix.toString();
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
            else if (Character.isLetterOrDigit(c)) {
                postfix.enqueue(c);
                continue;
            }

            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                    while (!operatorStack.isEmpty() && (precedence(c) <= precedence(operatorStack.top())))
                        postfix.enqueue(operatorStack.pop());

                    operatorStack.push(c);
                    break;
                case '(':
                    operatorStack.push(c);
                    break;
                case ')':
                    // Keep popping the stack and adding to the queue
                    // until the opening parentheses is found.
                    while (!operatorStack.isEmpty() && operatorStack.top() != '(')
                        postfix.enqueue(operatorStack.pop());

                    // If the stack is empty, then there was no opening parenteses
                    // and the notation format was invalid.
                    if (operatorStack.isEmpty())
                        throw new InvalidNotationFormatException();

                    // Get rid of opening parentheses.
                    operatorStack.pop();
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
