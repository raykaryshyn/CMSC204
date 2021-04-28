import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Represents and maintains a queue of random directions that cars should
 * travel.
 * 
 * @author Raymond Karyshyn
 */
public class CarQueue {
    BlockingQueue<Integer> queue;
    Random direction;

    public CarQueue() {
        queue = new LinkedBlockingDeque<Integer>();
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
                while (CarTracker.FINISHED_CARS < CarTracker.TOTAL_CARS) {
                    queue.add(direction.nextInt(4));
                    System.out.println("added to queue");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException exception) {

                    }
                }

                System.out.println("program finished & no longer adding to queue");
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
