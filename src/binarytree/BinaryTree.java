package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
	private TreeNode root = null;

	public BinaryTree() {
		root = new TreeNode(1, "A");

	}

	/**
	 * create a binary tree 
	 *       A 
	 *    B     C 
	 * D    E      F
	 */
	public void createBinaryTree() {
		TreeNode nodeB = new TreeNode(2, "B");
		TreeNode nodeC = new TreeNode(3, "C");
		TreeNode nodeD = new TreeNode(4, "D");
		TreeNode nodeE = new TreeNode(5, "E");
		TreeNode nodeF = new TreeNode(6, "F");
		root.leftChild = nodeB;
		root.rightChild = nodeC;
		nodeB.leftChild = nodeD;
		nodeB.rightChild = nodeE;
		nodeC.rightChild = nodeF;

	}

	public class TreeNode {
		private int index;
		private String data;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;

		public TreeNode getParent() {
			return parent;
		}

		public void setParent(TreeNode parent) {
			this.parent = parent;
		}

		public TreeNode(int index, String data) {
			this.index = index;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;

		}

		public int getIndex() {
			return index;
		}

		public String getData() {
			return data;
		}

	}

	/**
	 * calculate the height of tree
	 * 
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int i = getHeight(node.leftChild);
			int j = getHeight(node.rightChild);
			return (i < j) ? j + 1 : i + 1;
		}
	}

	/**
	 * get number of nodes of tree
	 * 
	 * @return
	 */
	public int getSize() {
		return getSize(root);
	}

	private int getSize(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int i = 1 + getSize(node.leftChild) + getSize(node.rightChild);
			return i;
		}

	}

	public void preOrder() {
		preOrder(root);
	}

	public void inOrder() {
		inOrder(root);
	}

	public void postOrder() {
		postOrder(root);
	}

	/**
	 * preorder traversal
	 * 
	 * @param node
	 */
	public void preOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			System.out.println("preOrder data:" + node.getData());
			preOrder(node.leftChild);
			// if we wanna search something just add a if condition
			// if node.data.equals("aa");
			preOrder(node.rightChild);
		}
	}

	/**
	 * inorder traversal
	 * 
	 * @param node
	 */
	public void inOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			preOrder(node.leftChild);
			System.out.println("inOrder data:" + node.getData());
			preOrder(node.rightChild);
		}
	}

	/**
	 * postorder traversal
	 * 
	 * @param node
	 */
	public void postOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			preOrder(node.leftChild);
			preOrder(node.rightChild);
			System.out.println("postOrder data:" + node.getData());
		}
	}

	/**
	 * non-Recursion, use stack PreOrder Traversal
	 * 
	 * @param node
	 */
	public void nonRecursionPreOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(node);// push in the root node
			while (!stack.isEmpty()) {
				TreeNode nodeN = stack.pop();// pop out the root node
				System.out.println("nonRecursionPreOrder data:" + nodeN.getData());
				if (nodeN.rightChild != null) {
					stack.push(nodeN.rightChild); // push in the child nodes
				}
				if (nodeN.leftChild != null) {
					stack.push(nodeN.leftChild);
				}

			}
		}
	}
	
	/**
	 * createBinaryTreeByPreorder from a list
	 */
	
	public void createBinaryTreeByPreorder(ArrayList<String> data) {
		createBinaryTree( data.size(), data);
	}

	private TreeNode createBinaryTree(int size, ArrayList<String> data) {
		if(data.size()==0) {
			return null;
		}
		String d = data.get(0);
		TreeNode node;
		int index = size - data.size();
		if(d.equals("#")) {
			node = null;
			data.remove(0);
			return node;
		}
		node = new TreeNode(index,d);
        if(index == 0) {
        	// create root node
        	root = node;
        }
        data.remove(0);
        node.leftChild = createBinaryTree(++index,data);
        node.rightChild = createBinaryTree(++index,data);
        
		return node;
		
	}
	

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		int height = binaryTree.getHeight();
		// System.out.println(height);
		// System.out.println(binaryTree.getSize());

		// binaryTree.preOrder();
		// binaryTree.inOrder();
		//binaryTree.nonRecursionPreOrder(binaryTree.root);
		ArrayList<String> list  = new ArrayList<String>();
		String[] testData = new String [] {"A","B","D","#","#","E","#","#","C","#","F","#","#"};
		for(String s : testData) {
			list.add(s);
		}
		binaryTree.createBinaryTreeByPreorder(list);
		binaryTree.preOrder(binaryTree.root);
	}

}





