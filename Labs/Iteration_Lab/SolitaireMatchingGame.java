import java.util.Random;
import java.util.ArrayList;
import java.util.ListIterator;

public class SolitaireMatchingGame {
    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            int passes = 0;

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

            System.out.println(list);

            boolean removedPair = true;
            while (removedPair) {
                removedPair = false;
                ListIterator<Integer> iterator2 = list.listIterator();
                while (iterator2.hasNext()) {
                    int next = iterator2.next();
                    if (iterator2.hasNext()) {
                        int next2 = iterator2.next();
                        if ((next / 10 == next2 / 10) || (next % 10 == next2 % 10)) {
                            /* System.out.println(next + " " + next2); */
                            iterator2.remove();
                            iterator2.previous();
                            iterator2.remove();
                            removedPair = true;
                        } else {
                            iterator2.previous();
                        }
                    }
                }

                if (removedPair) passes++;
            }

            System.out.println(passes);
            System.out.println(list);
            System.out.println();
        }
    }
}

// [15, 56, 83, 73, 14, 64, 83, 80, 75, 24, 65, 45, 24, 75, 50, 23, 99, 24, 74, 95]
// 4
// [15, 23]

// [20, 96, 53, 70, 34, 95, 70, 25, 61, 37, 12, 27, 60, 19, 44, 28, 17, 24, 81, 27]
// 0
// [20, 96, 53, 70, 34, 95, 70, 25, 61, 37, 12, 27, 60, 19, 44, 28, 17, 24, 81, 27]