package com.charlesbihis.graph.util;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import com.charlesbihis.graph.adjacencylist.AdjacencyListGraph;
import com.charlesbihis.graph.adjacencylist.AdjacencyListNode;

public class TestGraphUtil extends TestCase {
	private GraphUtil graphUtil;
	
	public void setUp() {
		graphUtil = new GraphUtil();
	}
	
	/**
	 * Null test.
	 */
	@Test
	public void testNull() {
		AdjacencyListNode a = new AdjacencyListNode(0, "a");
		AdjacencyListNode b = new AdjacencyListNode(1, "b");
		AdjacencyListNode c = new AdjacencyListNode(2, "c");
		AdjacencyListNode d = new AdjacencyListNode(3, "d");
		AdjacencyListNode e = new AdjacencyListNode(4, "e");
		AdjacencyListNode f = new AdjacencyListNode(5, "f");
		AdjacencyListNode g = new AdjacencyListNode(6, "g");
		AdjacencyListNode h = new AdjacencyListNode(7, "h");
		
		AdjacencyListGraph graph = new AdjacencyListGraph(8, a);
		graph.addEdge(a, b);
		graph.addEdge(a, c);
		graph.addEdge(b, a);
		graph.addEdge(b, d);
		graph.addEdge(b, e);
		graph.addEdge(c, a);
		graph.addEdge(c, f);
		graph.addEdge(c, g);
		graph.addEdge(d, b);
		graph.addEdge(e, b);
		graph.addEdge(e, h);
		graph.addEdge(f, c);
		graph.addEdge(g, c);
		graph.addEdge(h, e);
		
		boolean isConnected = graph.isAdjacentTo(a, c);
		Assert.assertTrue(isConnected);
		
		graphUtil.breadthFirstSearch(graph);
	}
}
