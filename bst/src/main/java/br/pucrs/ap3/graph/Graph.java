package br.pucrs.ap3.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Graph {

	public static final int WHITE = 0;
	public static final int GRAY = 1;
	public static final int BLACK = 2;

	private int[][] m;
	private boolean directed;

	public Graph(int size) {
		checkSize(size);
		int n = size + 1;
		m = new int[n][n];
		directed = false;
	}

	public Graph(int size, boolean directed) {
		checkSize(size);
		int n = size + 1;
		m = new int[n][n];
		this.directed = directed;
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
		addConnection(i, j, 1);
	}
	
	public void addConnection(int i, int j, int w) {
		if (i <= 0)
			throw new IllegalArgumentException();
		if (j <= 0)
			throw new IllegalArgumentException();
		if (i >= m.length)
			throw new IllegalArgumentException();
		if (j >= m.length)
			throw new IllegalArgumentException();
		if (w <= 0)
			throw new IllegalArgumentException();
		m[i][j] = w;
		if (!directed) {
			m[j][i] = w;
		}
	}

	public List<Integer> Adj(int n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		if (n >= m.length)
			throw new IllegalArgumentException();
		List<Integer> r = new ArrayList<Integer>();
		for (int j = 1; j < m.length; j++) {
			if (m[n][j] != 0 || (directed && m[j][n] != 0)) {
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

	private int time;
	private float f[];
	private ArrayList<Integer> sorted;
	private int[][] mf;

	public void dfs() {
		// topological sort
		sorted = new ArrayList<Integer>();
		//

		d = new float[m.length];
		f = new float[m.length];
		// Linhas 1, 2 e 3
		color = new int[m.length]; // WHITE
		p = new int[m.length]; // NIL
		// Linha 4
		time = 0;
		// Linhas 5, 6 e 7
		for (int u = 1; u < d.length; u++) {
			if (color[u] == WHITE)
				dfsVisit(u);
		}
	}

	public float[] getF() {
		return f;
	}

	private void dfsVisit(int u) {
		// Linhas 1, 2 e 3
		color[u] = GRAY;
		time = time + 1;
		d[u] = time;
		// Linhas 4-7
		for (Integer v : Adj(u)) {
			if (color[v] == WHITE) {
				p[v] = u;
				dfsVisit(v);
			}
		}
		// Linhas 8 e 9
		color[u] = BLACK;
		time = time + 1;
		f[u] = time;
		// topological sort
		sorted.add(0, u);
	}

	public List<Integer> topologicalSort() {
		dfs();
		return sorted;
	}

	public void kruskal() {
			// TODO:
	}

	// MST-PRIM(G, w, r)
	// 1. para cada u E V[G]
	// 2.  u.chave = INF
	// 3.  u.p = NIL
	// 4. r.chave = 0
	// 5. Q = V[G]
	// 6. enquanto Q != VAZIO
	// 7.  u = EXTRACT-MIN(Q)
	// 8.  para cada v E Adj[u]
	// 9.   se v E Q .E. w(u, v) < v.chave
	// 10.   v.p = u
	// 11.   v.chave = w(u, v)
	public void prim(int r) {
		INITIALIZESINGLESOURCE(r);
		// Linha 5
		List<Integer> Q = new ArrayList<Integer>();
		for (int i = 1; i < d.length; i++) {
			ENQUEUE(Q, i);
		}
		// Linha 6
		while (!Q.isEmpty()) {
			Integer u = EXTRACTMIN(Q, d);
			for (Integer v : Adj(u)) {
				if (Q.contains(v) &&  m[u][v] < d[v]) {
					p[v] = u;
					d[v] = m[u][v];
				}
			}
		}
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(d));
		
	}

	private Integer EXTRACTMIN(List<Integer> Q, final float[] w) {
		Integer n;
		Collections.sort(Q, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				Float f1 = new Float(w[o1]);
				Float f2 = new Float(w[o2]);
				return f1.compareTo(f2);
			}
		});
		n = Q.remove(0);
		return n;
	}
	
	
	// SSSP-DIJKSTRA(G, w, s)
	// 1. INITIALIZE-SINGLE-SOURCE(G, s)
	// 2. S = O
	// 3. Q = V[G]
	// 4. while Q <> VAZIO
	// 5... u = EXTRACTMIN(Q)
	// 6... S = S U {u}
	// 7....for each v E Adj[u]
	// 8.......RELAX(u, v, w)
	public void dijkstra(int s) {
		INITIALIZESINGLESOURCE(s);
		// Linha 3
		List<Integer> Q = new ArrayList<Integer>();
		for (int i = 1; i < d.length; i++) {
			ENQUEUE(Q, i);
		}
		// Linha 4
		while (!Q.isEmpty()) {
			// Linha 5
			Integer u = EXTRACTMIN(Q, d);
			// Linha 7
			for (Integer v : Adj(u)) {
				RELAX(u, v);
			}
		}
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(d));
	}

	// RELAX(u, v, w)
	// 1. if v.d > u.d + w(u, v)
	// 2... v.d = u.d + w(u, v)
	// 3... v.p = u
	private void RELAX(Integer u, Integer v) {
		if (d[v] > d[u] + m[u][v] ) {
			p[v] = u;
			d[v] = d[u] + m[u][v];
		}
	}

	// INITIALIZE-SINGLE-SOURCE(G, s)
	// 1.for each v E V[G]
	// 2...v.d = INF
	// 3...v.p = NIL
	// 4.s.d = 0
	private void INITIALIZESINGLESOURCE(int s) {
		d = new float[m.length]; //chave
		for (int i = 0; i < d.length; i++) {
			d[i] = Float.POSITIVE_INFINITY;
		}
		p = new int[m.length]; // NIL
		d[s] = 0;
	}

	// FORDFULKERSON(G, s, t)
	// 1. para cada aresta(u, v) E G.E
	// 2...(u, v).f = 0
	// 3. enquanto existir um caminho p de s até t na rede residual Gf
	// 4...cf(p) = min[cf(u, v) : (u,v ) está em p]
	// 5...para cada aresta(u, v) em p
	// 6......se (u, v) E E
	// 7.........(u, v).f = (u, v).f + cf(p)
	public void fordFulkerson(int s, int t) {
		// Linhas 1 e 2
		mf = new int[m.length][m.length];
		List<Integer> path;
		while ((path = findPath(s, t)) != null) {
			// TODO:
		}
	}

	private List<Integer> findPath(int s, int t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> adjacente(int n) {
		if (n < 1 || n >= m.length) {
			throw new IllegalArgumentException();
		}
		
		ArrayList<Integer> r = new ArrayList<Integer>();
		
		for (int j = 1; j < m.length; j++) {
			if (m[n][j] != 0 && m[n][j] != Float.POSITIVE_INFINITY) {
				r.add(j);
			}
		}
		
		return r;
	}

	public ArrayList<Integer> saldoNodos() {
		
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		
		int[] origem = new int[m.length];
		int[] destino = new int[m.length];
		
		
		for(int i = 1; i< m.length; i++) {
			
			for(int k = 1; k< m.length; k++) {
				
				origem[i] += m[i][k];
				
				destino[i] += m[k][i];
				
			}
			
		}
		
		for(int l = 0; l < m.length; l++) {
			resultado.add(origem[l] - destino[l]);
		}
		
		return resultado;
	}
	
	
	
}




