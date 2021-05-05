import java.util.Comparator;

class HuffmanComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        int frequencyCompare = x.getFrequency() - y.getFrequency();

        if (frequencyCompare != 0)
            return frequencyCompare;
        else
            return x.getCharacter().compareTo(y.getCharacter());
    }
}
