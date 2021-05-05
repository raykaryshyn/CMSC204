import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Driver {
    public static void main(String[] args) {
        int n = 11;
        String[] charArray = { "c", "r", "e", "a", "t", " ", "h", "u", "f", "m", "n" };
        int[] charfreq = { 1, 2, 4, 3, 2, 3, 1, 1, 2, 1, 1 };

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new HuffmanComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode(charArray[i], charfreq[i]);

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode(x.getFrequency() + y.getFrequency(), x, y);

            root = f;

            q.add(f);
        }

        printCode(root, "");

        System.out.println(t);

        codeLetter(t, "c");
        codeLetter(t, "r");
        codeLetter(t, "e");
        codeLetter(t, "a");
        codeLetter(t, "t");
        codeLetter(t, "e");
        codeLetter(t, " ");
        codeLetter(t, "a");
        codeLetter(t, " ");
        codeLetter(t, "h");
        codeLetter(t, "u");
        codeLetter(t, "f");
        codeLetter(t, "f");
        codeLetter(t, "m");
        codeLetter(t, "a");
        codeLetter(t, "n");
        codeLetter(t, " ");
        codeLetter(t, "t");
        codeLetter(t, "r");
        codeLetter(t, "e");
        codeLetter(t, "e");
    }

    private static TreeMap<String, String> t = new TreeMap<>();

    public static void printCode(HuffmanNode root, String s) {

        if (root.getLeft() == null && root.getRight() == null) {
            System.out.println("'" + root.getCharacter() + "' : " + s);

            t.put(root.getCharacter(), s);

            return;
        }

        printCode(root.getLeft(), s + "0");
        printCode(root.getRight(), s + "1");
    }

    public static int codeLetter(TreeMap<String, String> t, String letter) {
        int result = -1;

        for (Map.Entry<String, String> n : t.entrySet()) {
            if (letter == n.getKey())
                System.out.print(n.getValue());
        }

        return result;
    }
}
