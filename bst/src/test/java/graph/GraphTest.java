package graph;

import br.pucrs.ap3.graph.Graph;
import br.pucrs.ap3.heap.Heap;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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

}
