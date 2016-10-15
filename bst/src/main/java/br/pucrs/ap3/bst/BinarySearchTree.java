package br.pucrs.ap3.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class BinarySearchTree {

	private static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

	private Node root;
	private int count;

	/**
	 * 
	 */
	public BinarySearchTree() {
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
		if (node.key > key)
			node.left = add0(key, node.left);
		else if (node.key < key)
			node.right = add0(key, node.right);
		else
			throw new RuntimeException("Chave duplicada!");

		return node;
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

	/**
	 * Apresente os níveis da árvore que são formados por números ímpares
	 * 
	 */
	public void printByOddLevel() {
		int c = 0;
		List<Integer> level = getLevel(c);
		while (!level.isEmpty()) {

			boolean print = true;
			for (Integer e : level) {
				if (e % 2 == 0) {
					print = false;
				}
			}
			if (print) {
				// System.out.println(level);
				System.out.println("Nível: " + c);
			}
			//
			c = c + 1;
			level = getLevel(c);
		}

	}

	/**
	 * 6. Escreva um algoritmo que apresente o caminho de um nodo que contém um
	 * determinado valor até a sua folha, considerando o caminho de maior
	 * altura.
	 * 
	 */
	public void getPathToLeaf(int key) {
		List<Integer> path = getPathToLeaf0(key, root);
		System.out.println(path);
	}

	private List<Integer> getPathToLeaf0(int key, Node node) {
		if (node == null)
			return null;
		if (node.key == key) {
			List<Integer> pathFrom = getPathToLeaf1(node);
			return pathFrom;
		}
		if (node.key > key)
			return getPathToLeaf0(key, node.left);
		return getPathToLeaf0(key, node.right);
	}

	private List<Integer> getPathToLeaf1(Node node) {
		if (node == null)
			return  new ArrayList<Integer>();
		List<Integer> left = getPathToLeaf1(node.left);
		List<Integer> right = getPathToLeaf1(node.right);
		if (left.size() > right.size()) {
			left.add(node.key);
			return left;
		} else {
			right.add(node.key);
			return right;
		}
	}

}
