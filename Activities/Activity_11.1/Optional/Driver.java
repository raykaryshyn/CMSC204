public class Driver {
    public static void main(String[] args) {
        PrintLetterRunnable a = new PrintLetterRunnable('a', 100);
        PrintLetterRunnable b = new PrintLetterRunnable('b', 100);
        CountUpRunnable countUp = new CountUpRunnable(1, 100);

        Thread aThread = new Thread(a);
        Thread bThread = new Thread(b);
        Thread countUpThread = new Thread(countUp);

        aThread.start();
        bThread.start();
        countUpThread.start();
    }
}
