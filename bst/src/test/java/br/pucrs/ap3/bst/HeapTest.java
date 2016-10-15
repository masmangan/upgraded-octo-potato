package br.pucrs.ap3.bst;

import br.pucrs.ap3.heap.Heap;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HeapTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullHeap() {
        boolean actual = Heap.isMinHeap(null);
    }

    @Test
    public void testSingletonHeap() {
        int v[] = {0, 3};
        boolean expected = true;
        boolean actual = Heap.isMinHeap(v);
        assertEquals(expected, actual);
    }

    @Test
    public void testDuoHeap() {
        int v[] = {0, 1, 2};
        boolean expected = true;
        boolean actual = Heap.isMinHeap(v);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinHeap() {
        int v[] = {0, 1, 2, 3};
        boolean expected = true;
        boolean actual = Heap.isMinHeap(v);
        assertEquals(expected, actual);
    }

    @Test
    public void testLargerHeap() {
        int v[] = {0, 1, 2, 3, 4};
        boolean expected = true;
        boolean actual = Heap.isMinHeap(v);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxHeap() {
        int v[] = {0, 3, 2, 1};
        boolean expected = false;
        boolean actual = Heap.isMinHeap(v);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinHeapfy() {
        int actual[] = {0, 1, 2, 3};
        int expected[] = {0, 1, 2, 3};
        Heap.heapfy(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMaxHeapfy() {
        int actual[] = {0, 3, 2, 1};
        int expected[] = {0, 1, 2, 3};
        Heap.heapfy(actual);
        assertArrayEquals(expected, actual);
    }


}
