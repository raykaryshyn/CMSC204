/**
 * @author Raymond Karyshyn
 */
public class CountUpRunnable implements Runnable {
    private int from, to;

    public CountUpRunnable(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public void run() {
        for (int i = from; i <= to; i++)
            System.out.println(i);
    }
}
