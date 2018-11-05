package binarytree;

public class BinaryTree {
	private  TreeNode root = null;

	
	public BinaryTree() {
		root = new TreeNode(1,"A");
		
	}
	/**
	 * create a binary tree
	 *         A
	 *     B      C
	 *  D    E       F
	 */
	public void createBinaryTree() {
		TreeNode nodeB = new TreeNode(2,"B");
		TreeNode nodeC = new TreeNode(3,"C");
		TreeNode nodeD = new TreeNode(4,"D");
		TreeNode nodeE = new TreeNode(5,"E");
		TreeNode nodeF = new TreeNode(6,"F");
		root.leftChild = nodeB;
		root.rightChild = nodeC;
		nodeB.leftChild = nodeD;
		nodeB.rightChild = nodeE;
		nodeC.rightChild = nodeF;
		
	}
	
	public class TreeNode{
		private int index;
		private String data;
		private TreeNode leftChild;
		private TreeNode rightChild;
		
		public TreeNode(int index, String data){
			this.index=index;
			this.data=data;
			this.leftChild=null;
			this.rightChild=null;
			
		}
		


	public int getIndex() {
		   return index;
	   }
		
	}
	/**
	 * calculate the height of tree
	 * @return 
	 */
	public int getHeight() {
		return getHeight(root);
	}
	
   private int getHeight(TreeNode node) {
        if(node == null) {
        	return 0;
        }else {
        	int i = getHeight(node.leftChild);
        	int j = getHeight(node.rightChild);
        	return (i<j)?j+1:i+1;
        }
	}
   
   /**
    * get number of nodes of tree
    * @return
    */
   public int getSize() {
	  return getSize(root);
   }
	
	private int getSize(TreeNode node) {
		 if(node == null) {
	        	return 0;
	        }else {
	        	int i = 1+getSize(node.leftChild)+getSize(node.rightChild);
	        	return i;
	        }
	
}	
	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		int height = binaryTree.getHeight();
		System.out.println(height);
		System.out.println(binaryTree.getSize());
		
	}

}
