package br.pucrs.ap3.bst;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst);
		bst.add(20);
		System.out.println(bst);
		bst.add(11);
		System.out.println(bst);
		bst.add(31);
		System.out.println(bst);
//		System.out.printf("10: %b%n", bst.contains(10));
//		System.out.printf("20: %b%n", bst.contains(20));
//		System.out.printf("30: %b%n", bst.contains(30));
//		System.out.printf("15: %b%n", bst.contains(15));
//		//bst.add(30);
//		//System.out.println(bst);
//		System.out.printf("10: %s%n", bst.getPathTo(10));
//		System.out.printf("20: %s%n", bst.getPathTo(20));
//		System.out.printf("30: %s%n", bst.getPathTo(30));
//		//System.out.printf("15: %s%n", bst.getPathTo(15));
//		
//		System.out.printf("N0: %s%n", bst.getLevel(0));
//		System.out.printf("N1: %s%n", bst.getLevel(1));
//		System.out.printf("N2: %s%n", bst.getLevel(2));
		bst.printByOddLevel();
		
		
	}
}
