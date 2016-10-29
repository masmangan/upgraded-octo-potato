package br.pucrs.ap3.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	public static final int WHITE = 0;
	public static final int GRAY = 1;
	public static final int BLACK = 2;

	private int[][] m;

	public Graph(int size) {
		checkSize(size);
		int n = size + 1;
		m = new int[n][n];
	}

	private void checkSize(int size) {
		if (size <= 0)
			throw new IllegalArgumentException();
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[i].length; j++) {
				s += m[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}

	public void addConnection(int i, int j) {
		if (i <= 0)
			throw new IllegalArgumentException();
		if (j <= 0)
			throw new IllegalArgumentException();
		if (i >= m.length)
			throw new IllegalArgumentException();
		if (j >= m.length)
			throw new IllegalArgumentException();
		m[i][j] = 1;
		m[j][i] = 1;
	}

	public List<Integer> Adj(int n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		if (n >= m.length)
			throw new IllegalArgumentException();
		List<Integer> r = new ArrayList<Integer>();
		for (int j = 1; j < m.length; j++) {
			if (m[n][j] != 0) {
				r.add(j);
			}
		}
		return r;
	}

    public float[] getD() {
        return d;
    }

    public int[] getColor() {
        return color;
    }

    public int[] getP() {
        return p;
    }

    private float d[];
	private int color[];
	private int p[];


	public void bfs(int s) {
		// Linhas 1 até 7
		d = new float[m.length];
		for (int i = 0; i < d.length; i++) {
			d[i] = Float.POSITIVE_INFINITY;
		}
		color = new int[m.length]; // WHITE
		p = new int[m.length]; // NIL
		d[s] = 0;
		color[s] = GRAY; // GRAY
		p[s] = 0;// NIL
		// Linha 8
		List<Integer> Q = new ArrayList<Integer>();
		// Linha 9
        ENQUEUE(Q, s);
        // Linha 10
		while (!Q.isEmpty()) {
			Integer u = DEQUEUE(Q);
			for (Integer v : Adj(u)) {
				if (color[v] == WHITE) {
					color[v] = GRAY;
					d[v] = d[u] + 1;
					p[v] = u;
                    ENQUEUE(Q, v);
				}
			}
			color[u] = BLACK; // BLACK
		}
	}

    private Integer DEQUEUE(List<Integer> q) {
        return q.remove(0);
    }

    private void ENQUEUE(List<Integer> q, int s) {
        q.add(s);
    }

}
