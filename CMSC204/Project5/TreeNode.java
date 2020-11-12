/**
 * The external Tree Node for Linked Trees
 * 
 * @author Yared Fikremariam
 *
 * @param <T>
 */
public class TreeNode<T> {

	protected T key;
	protected TreeNode<T> left, right;

	/**
	 * Create a new TreeNode with left and right child set to null and data set to
	 * the dataNode
	 * 
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.key = dataNode;
		left = right = null;
	}

	/**
	 * used for making deep copies
	 * 
	 * @param node node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		new TreeNode<T>(node);

	}

	/**
	 * Return the data within this TreeNode
	 * 
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return key;

	}

}
