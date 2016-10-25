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

}
