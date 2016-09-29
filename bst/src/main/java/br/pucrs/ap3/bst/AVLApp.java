package br.pucrs.ap3.bst;

/**
 * Hello world!
 *
 */

// http://visualgo.net/bst
public class AVLApp {
	public static void main(String[] args) {
		System.out.println("AVL!");
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
//		int ns[] = { 30, 20, 10 };
		int ns[] = { 30, 10, 20 };
		System.out.println(bst);
		for (int n : ns) {
			bst.add(n);
			System.out.println(bst);
		}
	}
}
