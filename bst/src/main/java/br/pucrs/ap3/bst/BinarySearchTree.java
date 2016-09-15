package br.pucrs.ap3.bst;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class BinarySearchTree {
<<<<<<< HEAD

	private static class Node {
		int key;
		Node left, right;

=======
 
	private static class Node {
		int key;
		Node left, right;
		
>>>>>>> 45d6c28010e5ab5ca5763466574e0a6584df0ed9
		Node(int key) {
			this.key = key;
			left = right = null;
		}
	}
<<<<<<< HEAD

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(int key) {
		root = add0(key, root);
	}

	private Node add0(int key, Node node) {
		if (node == null)
			return new Node(key);

		if (node.key > key)
			node.left = add0(key, node.left);
		else if (node.key < key)
			node.right = add0(key, node.right);
		else
			throw new RuntimeException("Chave duplicada!");

		return node;
	}

	public boolean contains(int key) {

		return contains0(key, root);
	}

	private boolean contains0(int key, Node node) {
		if (node == null)
			return false;

		if (node.key == key)
			return true;

		if (node.key > key)
			return contains0(key, node.left);

		return contains0(key, node.right);
	}

	@Override
	public String toString() {
		return toString0(root);
	}

	private String toString0(Node node) {
		if (node == null)
			return " # ";
		return toString0(node.left) + node.key + toString0(node.right);
	}

=======
	
	
	private Node root;
	
	
>>>>>>> 45d6c28010e5ab5ca5763466574e0a6584df0ed9
}
