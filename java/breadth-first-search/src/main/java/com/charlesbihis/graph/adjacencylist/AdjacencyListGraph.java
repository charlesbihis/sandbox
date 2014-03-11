package com.charlesbihis.graph.adjacencylist;

import java.util.LinkedList;
import java.util.List;

import com.charlesbihis.graph.Graph;

public class AdjacencyListGraph implements Graph {
	protected List<List<AdjacencyListNode>> adjacencyList;
	protected AdjacencyListNode root;
	
	public AdjacencyListGraph(int size, AdjacencyListNode root) {
		adjacencyList = new LinkedList<List<AdjacencyListNode>>();
		for (int i = 0; i < size; i++) {
			adjacencyList.add(new LinkedList<AdjacencyListNode>());
		}
		this.root = root;
	}
	
	public void addEdge(AdjacencyListNode src, AdjacencyListNode dest) {
		adjacencyList.get(src.getId()).add(dest);
	}
	
	public boolean isAdjacentTo(AdjacencyListNode src, AdjacencyListNode dest) {
		List<AdjacencyListNode> adjacentTo = adjacencyList.get(src.getId());
		for (int i = 0; i < adjacentTo.size(); i++) {
			if (adjacentTo.get(i).getValue().equals(dest.getValue())) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<AdjacencyListNode> getAdjacencyListForNode(AdjacencyListNode node) {
		return adjacencyList.get(node.getId());
	}
	
	public AdjacencyListNode getRoot() {
		return root;
	}
}
