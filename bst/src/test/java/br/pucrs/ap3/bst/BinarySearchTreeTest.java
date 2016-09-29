package br.pucrs.ap3.bst;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testSingleNode() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(20);
		String expected = "S=1  # K=20 D=0 L=0 H=0 B=0 # ";
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
