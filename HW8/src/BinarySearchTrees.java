
import java.util.*;

public class BinarySearchTrees<E extends Comparable<E>> {
	
	public class Node {
		
		private LinkedList<E> tree;
		private Node right;
		private Node left;
		private E data;
		
		public Node(E data) {
			this.data = data;
			this.tree = new LinkedList<E>();
			this.tree.add(data);
			this.right = null;
			this.left = null;
		}
		
		public Node(E data, Node left, Node right) {
			this.data = data;
			this.tree = new LinkedList<E>();
			this.tree.add(data);
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;
	private int size;

	public BinarySearchTrees() {
		root = null;
		size = 0;
	}
	
	public BinarySearchTrees(E data) {
		root = new Node(data);
		size = 1;
	}
	
	public BinarySearchTrees(E data, BinarySearchTrees<E> leftTree, BinarySearchTrees<E> rightTree) {
		// creating a BST from two inputted trees, left and right
		root = new Node(data, leftTree.root, rightTree.root);
		size = 1 + leftTree.size + rightTree.size; 
		// size = root node of whole tree, plus the size of the left and right subtrees
	}
	
	public Node add(E val, Node node) {
		if (node == null) { // add to empty tree
			node = new Node(val); 
			size++;
			return node;
		}
		
		int compare = node.tree.getFirst().compareTo(val); // get first root in linked list
		
		if (compare == 0) {  // duplicate case
			node.tree.addFirst(val);
			size++;
		} else if (compare < 0) {  // recursive call to add in the left subtree
			node.right = add(val, node.right);
		} else { // recursive call to add in the right tree
			node.left = add(val, node.left);
		}
		
		return node;
		
	}
	
	public ArrayList<E> inOrder() {
		return inOrder(root);
	}
	
	private ArrayList<E> inOrder(Node node) {
		ArrayList<E> lst = new ArrayList<E>();
		
		if (node == null) {
			return lst;
		}
		
		else {
			lst.addAll(inOrder(node.left));
			lst.addAll(node.tree);
			lst.addAll(inOrder(node.right));
			return lst;
		}
	}
	
	public E findKth(int k) {
		if (size == 0) {
			throw new IllegalStateException("Tree is empty");
		}
		
		return inOrder().get(k);
	}
	
	public String toString(Node current, int level) {
		// this is taken from my Data Structures class
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < level; i++) {
			s.append("-");
		} if (current == null) {
			s.append("*\n");
		} else {
			s.append(current.data.toString() + "\n");
			s.append(toString(current.left, level+1)); 
			s.append(toString(current.right, level+1));
		}
		
		return s.toString();
	}

}
