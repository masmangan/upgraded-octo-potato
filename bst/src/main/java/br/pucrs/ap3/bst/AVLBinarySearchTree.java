package br.pucrs.ap3.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class AVLBinarySearchTree {

	private static class Node {
		int key;
		Node left, right;
		int height;

		Node(int key) {
			this.key = key;
			left = right = null;
			height = 0;
		}
	}

	private Node root;
	private int count;

	/**
	 * 
	 */
	public AVLBinarySearchTree() {
		root = null;
		count = 0;
	}

	/**
	 * 
	 * @param key
	 */
	public void add(int key) {
		root = add0(key, root);
	}

	private Node add0(int key, Node node) {
		if (node == null) {
			count++;
			return new Node(key); // ponto de inserção localizado
		}
		if (node.key > key) {
			node.left = add0(key, node.left);
			if (h(node.left) - h(node.right) >= 2) {
				if (node.left.key > key)
					node = rotateWithLeftChild(node);
				else
					node = rotateDoubleWithLeftChild(node);
				// TODO: atualizar alturas
			}
		} else if (node.key < key) {
			node.right = add0(key, node.right);
			if (h(node.right) - h(node.left) >= 2) {
				if (node.right.key < key)
					node = rotateWithRightChild(node);
				else
					node = rotateDoubleWithRightChild(node);
				// TODO: atualizar alturas
			}
		} else
			throw new RuntimeException("Chave duplicada!");

		// atualizar alturas
		int he = h(node.left);
		int hd = h(node.right);
		int max = Math.max(he, hd);
		node.height = 1 + max;

		return node;
	}

	private Node rotateDoubleWithLeftChild(Node node) {
		node.left = rotateWithRightChild(node.left);
		return rotateWithLeftChild(node);
	}

	private Node rotateDoubleWithRightChild(Node node) {
		node.right = rotateWithLeftChild(node.right);
		return rotateWithRightChild(node);
	}	
	
	private Node rotateWithRightChild(Node k1) {
		Node k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		return k2;
	}

	private Node rotateWithLeftChild(Node k2) {
		Node k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;
	}

	private static int h(Node node) {
		if (node == null)
			return -1;
		return node.height;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
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

	public int size() {
		return count;
	}

	public List<Integer> getPathTo(int key) {
		List<Integer> path = new ArrayList<Integer>();
		getPathTo0(key, root, path);
		return path;
	}

	private void getPathTo0(int key, Node node, List<Integer> path) {
		if (node == null)
			throw new RuntimeException("Chave não encontrada!");

		path.add(node.key);

		if (node.key == key)
			return;

		if (node.key > key)
			getPathTo0(key, node.left, path);
		else
			getPathTo0(key, node.right, path);
	}

	@Override
	public String toString() {
		return "S=" + count + " " + toString0(root, 0);
	}

	private String toString0(Node node, int level) {
		if (node == null)
			return " # ";
		return toString0(node.left, level + 1) + "K=" + node.key + " D=" + degree(node) + " L=" + level + " H="
				+ height(node) + " B=" + (height(node.left) - height(node.right)) + toString0(node.right, level + 1);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	private int degree(Node node) {
		int d = 0;
		if (node.left != null)
			d++;
		if (node.right != null)
			d++;

		return d;
	}

	public List<Integer> getLevel(int level) {
		List<Integer> nodes = new ArrayList<Integer>();
		getLevel0(root, 0, level, nodes);
		return nodes;
	}

	private void getLevel0(Node node, int c, int level, List<Integer> nodes) {
		if (node == null)
			return;

		if (c == level) {
			nodes.add(node.key);
			return;
		}

		getLevel0(node.left, c + 1, level, nodes);
		getLevel0(node.right, c + 1, level, nodes);
	}

}
