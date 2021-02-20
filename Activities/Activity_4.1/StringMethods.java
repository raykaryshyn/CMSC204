public class StringMethods {
    public static void displayBackward(String a, int first, int last) {
        for (int i = last; i >= first; i--)
            System.out.print(a.charAt(i));
    }

    public static void displayBackwardRecursively(String a, int first, int last) {
        if (last >= first) {
            System.out.print(a.charAt(last));
            displayBackwardRecursively(a, first, last - 1);
        }
    }
}