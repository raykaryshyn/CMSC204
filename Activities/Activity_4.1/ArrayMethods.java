/**
 * This class has two methods that both display an array backwards. One method
 * achieves this iteratively and the other recursively.
 * 
 * @author Raymond Karyshyn
 */

public class ArrayMethods {
    public static void displayBackward(int[] a, int first, int last) {
        for (int i = last; i >= first; i--)
            System.out.print(a[i] + " ");
    }

    public static void displayBackwardRecursively(int[] a, int first, int last) {
        System.out.print(a[last] + " ");

        if (last > first)
            displayBackwardRecursively(a, first, last - 1);
    }
}
