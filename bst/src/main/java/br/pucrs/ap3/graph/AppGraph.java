package br.pucrs.ap3.graph;

public class AppGraph {
	public static void main(String[] args) {
		Graph g = new Graph(3);
		g.addConnection(1, 2);
		g.addConnection(1, 3);
		g.addConnection(2, 3);
		
		System.out.println(g);
	}
}
