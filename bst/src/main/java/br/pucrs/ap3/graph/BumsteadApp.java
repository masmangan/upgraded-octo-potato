package br.pucrs.ap3.graph;

public class BumsteadApp {
	public static void main(String[] args) {
		Graph g = new Graph(9, true);
		g.addConnection(1, 2);
		g.addConnection(1, 4);
		g.addConnection(2, 3);
		g.addConnection(4, 3);
		g.addConnection(6, 7);
		g.addConnection(6, 8);
		g.addConnection(7, 4);
		g.addConnection(7, 8);
		g.addConnection(9, 8);
		
		System.out.println(g.topologicalSort());
	}
}
