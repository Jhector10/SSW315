package examples;

class BTNode {
	int data;
	BTNode left;
	BTNode right;
	
	public BTNode(int val) {
		this.data = val;
		this.left = null;
		this.right = null;
		
	}
}

class BSTDemo {
	BTNode root;
	
	public BTNode add(int val, BTNode node) {
		if (node == null) { // add to empty tree
			node = new BTNode(val); 
			return node;
		}
		if (val < node.data) {  // recursive call to add in the left subtree
			node.left = add(val, node.left);
		} else if (val > node.data) {  // recursive call to add in the right subtree {}
			node.right = add(val, node.right);
		} 
		return node;
		
	}
	
	public BTNode remove(int val, BTNode node) {
		if (node == null ) {
			return null;
		}
		if (val < node.data) {
			node.left = remove(val, node.left);
		}else if (val > node.data) {
			node.right = remove(val, node.right);
		} else {
			if (node.left == null && node.right == null) { // case 1 - leaf node
				return null;
			} else  if (node.left == null || node.right == null) { // case 2&3
				BTNode temp = null;
				temp = (node.left == null) ? node.right : node.left;
				return temp;
			} else {
				BTNode next = successor(node);
				node.data = next.data;
				node.right = remove(node.data, node.right);
				return node;	
			}
		}
		return node;
	
	}
		
	public BTNode successor(BTNode node) {
		BTNode temp = node;
		while (temp.left != null)
			temp = temp.left;
		return temp;
	}
}
	
public class BSTApp {
	public static void main(String[] args)
	 {
	     BSTDemo t = new BSTDemo();
	     BTNode root = null;
	     
	     // insert 55 to BST t;
	     root = t.add(55, root);
	     root = t.add(29, root);
	     root = t.add(87, root);
	     root = t.add(-3, root);
	     root = t.add(60, root);
	     root = t.add(42, root);
	     root = t.add(91, root);
	     
	     root = t.remove(-3, root);
	     root = t.remove(55, root);
		  
		       
	 }
	
}
