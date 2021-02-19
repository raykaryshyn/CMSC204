public class Driver {
    public static void main(String[] args) throws Exception {
        int[] array = { 0, 1, 2, 3, 4, 5 };
        String string = "testing...";

        // Array Processing
        System.out.println("\\/\\/\\/ - - - ARRAY PROCESSING - - - \\/\\/\\/");
        System.out.print("Original:\t\t\t");
        for (int e : array)
            System.out.print(e + " ");
        System.out.print("\nBackwards Iteratively:\t\t");
        ArrayMethods.displayBackward(array, 0, 5);
        System.out.print("Backwards Recursively:\t\t");
        ArrayMethods.displayBackwardRecursively(array, 0, 5);

        // String Processing
        System.out.println("\n\\/\\/\\/ - - - STRING PROCESSING - - - \\/\\/\\/");
        System.out.println("Original:\t\t\t" + string);
        System.out.print("'' Iteratively:\t\t\t");
        StringMethods.displayBackward(string, 0, 9);
        System.out.print("'' Recursively:\t\t\t");
        StringMethods.displayBackwardRecursively(string, 0, 9);
    }
}
