public class StringMethods {
    public static void displayUppercase(String a, int first, int last) {
        for (int i = 0; i <= last; i++)
            System.out.print(Character.toUpperCase(a.charAt(i)));
    }

    public static void displayUppercaseRecursively(String a, int first, int last) {
        if (first <= last) {
            System.out.print(Character.toUpperCase(a.charAt(first)));
            displayUppercaseRecursively(a, first + 1, last);
        }
    }
}