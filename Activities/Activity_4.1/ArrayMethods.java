public class ArrayMethods {
    public static void displayBackward(int[] a, int first, int last) {
        for (int i = last; i >= first; i--)
            System.out.print(a[i] + " ");

        System.out.println();
    }

    public static void displayBackwardRecursively(int[] a, int first, int last) {
        System.out.print(a[last] + " ");

        if (last > first)
            displayBackwardRecursively(a, first, last - 1);
        else
            System.out.println();
    }
}
