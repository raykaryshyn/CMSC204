import java.util.Comparator;

/**
 * Represents a Comparator for sorting HuffmanNodes.
 * 
 * Comparison guidelines:
 * 
 * 1. If same frequency – put in priority queue alphabetically; put space (' ')
 * before other characters of the same frequency.
 * 
 * 2. Add subtrees to end of group with same priority.
 * 
 * 3. Lower number has higher priority (goes to front).
 * 
 * @author Raymond Karyshyn
 */
class HuffmanComparator implements Comparator<HuffmanNode> {
    /**
     * Compares two nodes using the descibed guidelines.
     * 
     * @param a The first node.
     * @param b The second node.
     * @return An integer representing how the two nodes compare.
     * 
     *         0 represents equality.
     * 
     *         < 0 means a is less than b.
     * 
     *         > 0 means a is greater than b.
     */
    public int compare(HuffmanNode a, HuffmanNode b) {
        int frequencyCompare = a.getFrequency() - b.getFrequency();

        if (frequencyCompare != 0)
            return frequencyCompare;
        else
            return a.getCharacter().compareTo(b.getCharacter());
    }
}
