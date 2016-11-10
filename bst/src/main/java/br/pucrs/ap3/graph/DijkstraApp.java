package br.pucrs.ap3.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraApp {
	public static void main(String[] args) {
		//Graph g = new Graph(3, false);
		//g.addConnection(1, 2, 5);
		//g.addConnection(1, 3, 10);
		//g.addConnection(2, 3, 15);
		
		//System.out.println(g);
		//g.dijkstra(1);
		Graph g = new Graph(5, false);
		g.addConnection(1, 2, 15);
		g.addConnection(1, 3, 5);
		g.addConnection(1, 4, 1);
		
		g.addConnection(2, 3, 5);
		//g.addConnection(2, 5, 1);
		
		//g.addConnection(4, 5, 1);

		System.out.println(g);
		g.dijkstra(1);
		g.prim(1);
		
	}
}
