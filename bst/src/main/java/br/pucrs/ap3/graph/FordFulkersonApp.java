package br.pucrs.ap3.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FordFulkersonApp {
	public static void main(String[] args) {
		Graph g = new Graph(6, true);
		g.addConnection(1, 3, 12);
		g.addConnection(2, 1, 4);
		g.addConnection(2, 4, 14);
		
		g.addConnection(3, 2, 9);
		g.addConnection(3, 6, 20);
		g.addConnection(4, 3, 7);
		
		g.addConnection(4, 6, 4);
		g.addConnection(5, 1, 16);
		g.addConnection(5, 2, 13);

	    g.fordFulkerson(5, 6);
		
	}
}
