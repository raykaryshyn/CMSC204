import java.util.Random;
import java.util.ArrayList;
import java.util.ListIterator;

public class SolitaireMatchingGame {
    public static void main(String[] args) {
        int passes = 0, pairsRemoved = 0;

        final int MAX_SIZE = 20;
        ArrayList<Integer> list = new ArrayList<Integer>(MAX_SIZE);
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++)
            list.add(i, random.nextInt(90) + 10);

        System.out.println("Beginning list: " + list);

        boolean removedPair = true;
        while (removedPair) {
            removedPair = false;

            ListIterator<Integer> iterator = list.listIterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (iterator.hasNext()) {
                    int next2 = iterator.next();
                    if ((next / 10 == next2 / 10) || (next % 10 == next2 % 10)) {
                        iterator.remove();
                        iterator.previous();
                        iterator.remove();
                        removedPair = true;
                        pairsRemoved++;
                    } else
                        iterator.previous();
                }
            }

            if (removedPair)
                passes++;
        }

        System.out.println("\nPasses through the list: " + passes);
        System.out.println("Pairs removed: " + pairsRemoved);

        System.out.println("\nEnding list: " + list);
    }
}
