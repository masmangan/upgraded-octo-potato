package br.pucrs.ap3.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimApp {
	public static void main(String[] args) {
		Graph g = new Graph(3, false);
		g.addConnection(1, 2, 5);
		g.addConnection(1, 3, 10);
		g.addConnection(2, 3, 15);
		
		System.out.println(g);
		g.prim(1);
		
	}
}
