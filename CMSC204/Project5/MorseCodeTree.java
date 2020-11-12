import java.util.ArrayList;

/**
 * 
 * @author Yared Fikremariam
 * @param <T>
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	public TreeNode<String> root = null;
	public String r;

	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * Returns a reference to the root
	 */
	@Override
	public TreeNode<String> getRoot() {

		return this.root;
	}

	/**
	 * sets the root of the MorseCodeTree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;

	}

	/**
	 * Adds element to the correct position in the tree based on the code. This
	 * method will call the recursive method addNode
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {

		addNode(root, code, result);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code.
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		if (code.length() == 1) {
			if (code.equals(".")) {
				root.left = new TreeNode<String>(letter);
			}

			else {
				root.right = new TreeNode<String>(letter);
			}
		} else {
			if (code.substring(0, 1).equals(".")) {
				addNode(root.left, code.substring(1), letter);
			} else {
				addNode(root.right, code.substring(1), letter);
			}
		}

	}

	/**
	 * Fetch the data in the tree based on the code This method will call the
	 * recursive method fetchNode
	 */
	@Override
	public String fetch(String code) {

		String o = fetchNode(root, code);
		return o;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code A '.' (dot) means traverse to the left.
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {

		if (code.length() == 1) {
			if (code.equals(".")) {
				r = root.left.getData();
			}

			else {
				r = root.right.getData();
			}
		} else if (code.length() > 1) {
			// System.out.println(code.substring(0,1));

			if (code.substring(0, 1).equals("."))

			{
				fetchNode(root.left, code.substring(1));
			} else {
				fetchNode(root.right, code.substring(1));
			}
		}

		return r;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level
	 * by level based on the code.
	 */
	@Override
	public void buildTree() {

		root = new TreeNode<String>("");

		insert(".", "e");
		insert("-", "t");

		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder)
	 * Traversal order Used for testing to make sure tree is built correctly
	 */
	@Override
	public ArrayList<String> toArrayList() {

		ArrayList<String> r = new ArrayList<String>();

		LNRoutputTraversal(root, r);

		return r;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR
	 * (Inorder)
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {

		if (root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}

	}

}
