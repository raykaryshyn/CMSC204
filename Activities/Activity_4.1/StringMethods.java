public class StringMethods {
    public static void displayBackward(String a, int first, int last) {
        for (int i = last; i >= first; i--)
            System.out.print(a.charAt(i));

        System.out.println();
    }

    public static void displayBackwardRecursively(String a, int first, int last) {
        System.out.print(a.charAt(last));

        if (last > first)
            displayBackwardRecursively(a, first, last - 1);
        else
            System.out.println();
    }
}