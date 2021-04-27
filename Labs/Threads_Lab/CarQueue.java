import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Random;

/**
 * Represents and maintains a queue of random directions that cars should
 * travel.
 * 
 * @author Raymond Karyshyn
 */
public class CarQueue {
    Queue<Integer> queue;
    Random direction;

    public CarQueue() {
        queue = new ArrayDeque<Integer>();
        direction = new Random();

        for (int i = 0; i < 6; i++)
            queue.add(direction.nextInt(4));
    }

    public void addToQueue() {
        class QueueRunnable implements Runnable {
            /**
             * Adds 0, 1, 2, or 3 to queue <br>
             * 0 = up <br>
             * 1 = down <br>
             * 2 = right <br>
             * 3 = left
             */
            public void run() {
                try {
                    while (true) {
                        queue.add(direction.nextInt(4));
                        Thread.sleep(20);
                    }
                } catch (InterruptedException exception) {

                }
            }
        }

        Runnable r = new QueueRunnable();
        Thread t = new Thread(r);
        t.start();
    }

    public Integer deleteQueue() {
        try {
            return queue.remove();
        } catch (NoSuchElementException exception) {
            return -1;
        }
    }
}
