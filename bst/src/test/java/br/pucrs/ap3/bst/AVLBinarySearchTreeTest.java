package br.pucrs.ap3.bst;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AVLBinarySearchTreeTest {

	@Test
	public void testSingleNode() {
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
		bst.add(20);
		String expected = "S=1  # K=20 D=0 L=0 H=0 B=0 # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testEmptyTree() {
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
		String expected = "S=0  # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSimpleTreeFirst() {
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
		bst.add(10);
		bst.add(20);
		bst.add(30);
		String expected = "S=3  # K=10 D=0 L=1 H=0 B=0 # K=20 D=2 L=0 H=1 B=0 # K=30 D=0 L=1 H=0 B=0 # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSimpleTreeSecond() {
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
		bst.add(30);
		bst.add(20);
		bst.add(10);
		String expected = "S=3  # K=10 D=0 L=1 H=0 B=0 # K=20 D=2 L=0 H=1 B=0 # K=30 D=0 L=1 H=0 B=0 # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSimpleTreeThird() {
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
		bst.add(10);
		bst.add(30);
		bst.add(20);
		String expected = "S=3  # K=10 D=0 L=1 H=0 B=0 # K=20 D=2 L=0 H=1 B=0 # K=30 D=0 L=1 H=0 B=0 # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSimpleTreeForth() {
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
		bst.add(20);
		bst.add(10);
		bst.add(30);
		String expected = "S=3  # K=10 D=0 L=1 H=0 B=0 # K=20 D=2 L=0 H=1 B=0 # K=30 D=0 L=1 H=0 B=0 # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}


	@Test
	public void testSimpleTreeFifth() {
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
		bst.add(30);
		bst.add(10);
		bst.add(20);
		String expected = "S=3  # K=10 D=0 L=1 H=0 B=0 # K=20 D=2 L=0 H=1 B=0 # K=30 D=0 L=1 H=0 B=0 # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}


	@Test
	public void testSimpleTreeSixth() {
		AVLBinarySearchTree bst = new AVLBinarySearchTree();
		bst.add(20);
		bst.add(30);
		bst.add(10);
		String expected = "S=3  # K=10 D=0 L=1 H=0 B=0 # K=20 D=2 L=0 H=1 B=0 # K=30 D=0 L=1 H=0 B=0 # ";
		String actual = bst.toString();
		assertEquals(expected, actual);
	}
}
