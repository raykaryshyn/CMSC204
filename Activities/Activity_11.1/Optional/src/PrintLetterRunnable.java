/**
 * @author Raymond Karyshyn
 */
public class PrintLetterRunnable implements Runnable {
    private char letter;
    private int frequency;

    public PrintLetterRunnable(char letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
    }

    public void run() {
        for (int i = 0; i < frequency; i++)
            System.out.println(letter);
    }
}
