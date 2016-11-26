package graph;

import br.pucrs.ap3.graph.Graph;
import br.pucrs.ap3.heap.Heap;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class GraphTest is the first assignment...
 */
public class GraphTest {


    @Test
    public void testSingletonColor() {
        int expected[] = {0, 2};
        Graph g = new Graph(1);
        g.bfs(1);
        int actual[] = g.getColor();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSingletonD() {
        float expected[] = {Float.POSITIVE_INFINITY, 0};
        Graph g = new Graph(1);
        g.bfs(1);
        float actual[] = g.getD();
        assertArrayEquals(expected, actual, 0.001f);
    }

    @Test
    public void testSingletonP() {
        int expected[] = {0, 0};
        Graph g = new Graph(1);
        g.bfs(1);
        int actual[] = g.getP();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testSimpleColor() {
        int expected[] = {0, 2, 2, 2};
        Graph g = new Graph(3);
        g.addConnection(1, 2);
        g.addConnection(2, 3);
        g.bfs(1);
        int actual[] = g.getColor();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSimpleNotConnectedColor() {
        int expected[] = {0, 2, 2, 0};
        Graph g = new Graph(3);
        g.addConnection(1, 2);
        //g.addConnection(2, 3);
        g.bfs(1);
        int actual[] = g.getColor();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSimpleD() {
        float expected[] = {Float.POSITIVE_INFINITY, 0, 1, 2};
        Graph g = new Graph(3);
        g.addConnection(1, 2);
        g.addConnection(2, 3);
        g.bfs(1);
        float actual[] = g.getD();
        assertArrayEquals(expected, actual, 0.001f);
    }
    @Test
    public void testSimpleP() {
        int expected[] = {0, 0, 1, 2};
        Graph g = new Graph(3);
        g.addConnection(1, 2);
        g.addConnection(2, 3);
        g.bfs(1);
        int actual[] = g.getP();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSingletonDFSColor() {
        int expected[] = {0, 2};
        Graph g = new Graph(1);
        g.dfs();
        int actual[] = g.getColor();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSimpleDFSP() {
        int expected[] = {0, 0, 1, 2};
        Graph g = new Graph(3);
        g.addConnection(1, 2);
        g.addConnection(2, 3);
        g.dfs();
        int actual[] = g.getP();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSimpleDFSColor() {
        int expected[] = {0, 2, 2, 2};
        Graph g = new Graph(3);
        g.addConnection(1, 2);
        g.addConnection(2, 3);
        g.dfs();
        int actual[] = g.getColor();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testSimpleDFSD() {
        float expected[] = {0, 1, 2, 3};
        Graph g = new Graph(3);
        g.addConnection(1, 2);
        g.addConnection(2, 3);
        g.dfs();
        float actual[] = g.getD();
        assertArrayEquals(expected, actual, 0.001f);
    }

    @Test
    public void testSimpleDFSF() {
        float expected[] = {0, 6, 5, 4};
        Graph g = new Graph(3);
        g.addConnection(1, 2);
        g.addConnection(2, 3);
        g.dfs();
        float actual[] = g.getF();
        assertArrayEquals(expected, actual, 0.001f);
    }

    @Test
    public void testDirectedAdjacentNodes() {
        Integer[] expected = {2, 3, 4};
        Graph g = new Graph(4, true);
        g.addConnection(1, 2);
        g.addConnection(1, 3);
        g.addConnection(1, 4);

        Integer[] actual = g.Adj(1).toArray(new Integer[]{});

        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    public void testDirectedAdjacentNodesCount() {
        int expected = 3;
        Graph g = new Graph(4, true);
        g.addConnection(1, 2);
        g.addConnection(1, 3);
        g.addConnection(1, 4);

        g.addConnection(2, 1);
        g.addConnection(3, 1);

        int actual = g.Adj(1).size();

        assertEquals(expected, actual);
    }
}
