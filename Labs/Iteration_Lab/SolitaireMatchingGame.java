import java.util.Random;
import java.util.ArrayList;
import java.util.ListIterator;

public class SolitaireMatchingGame {
    public static void main(String[] args) {
        int passes = 0, pairsRemoved = 0;

        final int MAX_SIZE = 20;
        ArrayList<Integer> list = new ArrayList<Integer>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++)
            list.add(i, 0);

        ListIterator<Integer> iterator = list.listIterator();
        Random random = new Random();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            iterator.add(random.nextInt(90) + 10);
        }

        System.out.println("Beginning list: " + list);

        boolean removedPair = true;
        while (removedPair) {
            removedPair = false;
            
            ListIterator<Integer> iterator2 = list.listIterator();
            while (iterator2.hasNext()) {
                int next = iterator2.next();
                if (iterator2.hasNext()) {
                    int next2 = iterator2.next();
                    if ((next / 10 == next2 / 10) || (next % 10 == next2 % 10)) {
                        iterator2.remove();
                        iterator2.previous();
                        iterator2.remove();
                        removedPair = true;
                        pairsRemoved++;
                    } else
                        iterator2.previous();
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
