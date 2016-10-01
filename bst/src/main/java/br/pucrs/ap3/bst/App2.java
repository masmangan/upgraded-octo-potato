package br.pucrs.ap3.bst;

/**
 * Hello world!
 *
 */

// http://visualgo.net/bst
public class App2 {
	public static void main(String[] args) {
		System.out.println("BST!");
		BinarySearchTree bst = new BinarySearchTree();
		int ns[] = {64, 13, 84, 1, 24, 28, 50, 62};
		System.out.println(bst);
		for (int n : ns) {
			bst.add(n);
			System.out.println(bst);
		}
	}
}
