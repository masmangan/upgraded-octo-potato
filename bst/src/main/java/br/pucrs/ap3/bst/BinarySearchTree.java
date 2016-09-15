package br.pucrs.ap3.bst;

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
	
	
}
