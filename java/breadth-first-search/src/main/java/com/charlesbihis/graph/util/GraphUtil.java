package com.charlesbihis.graph.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.charlesbihis.graph.adjacencylist.AdjacencyListGraph;
import com.charlesbihis.graph.adjacencylist.AdjacencyListNode;

public class GraphUtil {
	public String breadthFirstSearch(AdjacencyListGraph graph) {
		Queue<AdjacencyListNode> queue = new LinkedList<AdjacencyListNode>();
		queue.add(graph.getRoot());
		
		Map<AdjacencyListNode, Boolean> visitedNodes = new HashMap<AdjacencyListNode, Boolean>();
		
		while (!queue.isEmpty()) {
			AdjacencyListNode node = queue.poll();
			visitedNodes.put(node, true);
			
			System.out.println(node.getValue());
			
			List<AdjacencyListNode> adjacencyList = graph.getAdjacencyListForNode(node);
			for (int i = 0; i < adjacencyList.size(); i++) {
				if (visitedNodes.get(adjacencyList.get(i)) == null) {
					queue.add(adjacencyList.get(i));
				}
			}
		}
		
		return null;
	}
}
