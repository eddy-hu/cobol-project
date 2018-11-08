package binarytree;

public class SearchBinaryTree {
	private TreeNode root;

	public SearchBinaryTree() {
		
	}
	/**
	 * create search binary tree, add nodes
	 */
	public TreeNode put(int data) {
		TreeNode node = null;
		TreeNode parent = null;
		if(root==null) {
			node = new TreeNode(0,data);
			root = node;
			return node;
		}
		node = root;
		while(node!=null) {
			parent = node;
			if(data>node.data) {
				node= node.rightChild;
			}else if(data<node.data){
				node=node.leftChild;
			}else {
				return node;
			}
		}
		node = new TreeNode(0,data);
		if(data<parent.data){
			parent.leftChild=node;
		}else {
			parent.rightChild=node;
		}
		node.parent =parent;
		return node;
		
	}
	
	class TreeNode{
		
		private int key;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;
		private int data;
		
		public TreeNode(int key, int data) {
			this.key = key;
			this.data = data;
			this.leftChild =null;
			this.rightChild=null;
			this.parent=null;
			
		}
		
	}
	/**
	 * inorder traversal
	 */
	public void innerOrder(TreeNode node) {
		if(node==null) {
			return;
		}else {
			innerOrder(node.leftChild);
			System.out.println("innerorder data:"+node.data);
			innerOrder(node.rightChild);
		}
	}
	
	public void deleteNode(int key) throws Exception {
		TreeNode node = searchNode(key);
		if(node == null) {
			throw new Exception("Doesn't exist");
		}else {
			delete(node);
		}
	}
	
	private void delete(TreeNode node) throws Exception {
		if(node == null) {
			throw new Exception("Doesn't exist");
		}else {
			TreeNode parent = node.parent;
			//delete a node which it doesn't have any child nodes;
			if(node.leftChild==null&node.rightChild==null) {
				if(parent.leftChild==node) {
					parent.leftChild=null;
				}else {
					parent.rightChild=null;
				}
				return;
			}
			//delete a node which it has a leftchild node but no rightchild node;
			if(node.leftChild!=null&&node.rightChild==null) {
				if(parent.leftChild == node) {
					parent.leftChild = node.leftChild;
				}else {
					parent.rightChild=node.leftChild;
				}
				return;
			}
			//delete a node which it has a rightchild node but no leftchild node;
			if(node.leftChild==null&&node.rightChild!=null) {
				if(parent.leftChild==node) {
					parent.leftChild=node.rightChild;
				}else {
					parent.rightChild=node.rightChild;
				}
				return;
			}
			//delete a node which it has both rightchild node and leftchild node;
			TreeNode successorNode = getSuccessorNode(node);
			delete(successorNode);
			node.data = successorNode.data;
		}
		
	}
	private TreeNode getSuccessorNode(TreeNode node) {
		if(node==null) {
			return null;
		}else {
			if(node.rightChild!=null) {
				//find minimum node;
				return getMinNode(node.rightChild);
			}else {
				TreeNode parent = node.parent;
				while(parent!=null&&node== parent.rightChild) {
					node = parent;
					parent = parent.parent;
				}
				return parent;
			}
		}	
		

	}
	private TreeNode getMinNode(TreeNode node) {
		if(node==null) {
			return null;
		}else {
			while(node.leftChild!=null) {
				node= node.leftChild;
				
			}
		}
		return null;
	}
	private TreeNode searchNode(int key) {
		TreeNode node = root;
		if(node==null) {
			return null;
		}else {
			while(node!=null&&key!=node.data) {
				if(key<node.data) {
					node = node.leftChild;
				}else {
					node = node.rightChild;
				}
			}
			
		}
		return node;
	}
	public static void main(String[] args) {
		SearchBinaryTree s = new SearchBinaryTree();
		int[] intArr = new int[]{50,30,44,80,16,7,77};
		for(int i:intArr) {
			s.put(i);
		}
		s.innerOrder(s.root);
		try {
			s.deleteNode(44);
			s.innerOrder(s.root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
