package br.pucrs.ap3.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

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

	public List<Integer> getNext(int n) {
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
		color[s] = 1; // GRAY
		p[s] = 0;// NIL
		// Linha 8
		List<Integer> Q = new ArrayList<Integer>();
		// Linha 9
		Q.add(s);
		// Linha 10
		while (!Q.isEmpty()) {
			Integer u = Q.remove(0);
			for (Integer v : getNext(u)) {
				// TODO:
			}
			color[u] = 3; // BLACK
		}
	}

}
