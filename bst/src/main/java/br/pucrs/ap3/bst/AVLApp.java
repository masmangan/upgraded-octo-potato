package br.pucrs.ap3.bst;

/**
 * Hello world!
 *
 */

// http://visualgo.net/bst
//https://docs.oracle.com/javafx/2/ui_controls/tree-view.htm
//http://docs.oracle.com/javase/tutorial/uiswing/components/tree.html
public class AVLApp {
	public static void main(String[] args) {
		System.out.println("AVL!");
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
//		int ns[] = { 30, 20, 10 };
		int ns[] = { 10, 20, 30, 40, 50, 60, 70 };
		System.out.println(bst.dump());
		for (int n : ns) {
			bst.add(n);
			System.out.println(bst.dump());
			System.out.println();
		}
	}
}
