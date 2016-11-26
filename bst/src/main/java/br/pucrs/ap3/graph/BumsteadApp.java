package br.pucrs.ap3.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Map<Integer, String> names;
		names = new HashMap<Integer, String>();
		names.put(1, "shirt");
		names.put(2, "tie");
		names.put(3, "jacket");
		names.put(4, "belt");
		names.put(5, "watch");
		names.put(6, "undershorts");
		names.put(7, "pants");
		names.put(8, "shoes");
		names.put(9, "socks");

		List<Integer> topologicalSort = g.topologicalSort();
		System.out.println(topologicalSort);

		List<String> namesSorted = new ArrayList<String>();
		
	}
}
