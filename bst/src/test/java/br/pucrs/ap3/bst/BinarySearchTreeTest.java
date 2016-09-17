package br.pucrs.ap3.bst;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testSingleNode() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(20);
		String expected = "S=1  # 20 # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testEmptyTree() {
		BinarySearchTree bst = new BinarySearchTree();
		String expected = "S=0  # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}

}
