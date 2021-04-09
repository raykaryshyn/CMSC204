/**
 * The external Tree Node for Linked Trees
 * 
 * @param T data type of TreeNode
 */
public class TreeNode<T> {
    protected TreeNode<T> left;
    protected TreeNode<T> right;
    private T data;

    /**
     * Create a new TreeNode with left and right child set to null and data set to
     * the dataNode
     * 
     * @param dataNode the data to be stored in the TreeNode
     */
    public TreeNode(T dataNode) {
        data = dataNode;
        left = right = null;
    }

    /**
     * Used for making deep copies
     * 
     * @param node node to make copy of
     */
    public TreeNode(TreeNode<T> node) {
        left = new TreeNode<T>(node.left);
        right = new TreeNode<T>(node.right);
        data = node.data;
    }

    /**
     * Return the data within this TreeNode
     * 
     * @return the data within the TreeNode
     */
    public T getData() {
        return data;
    }
}
