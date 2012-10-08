package com.charlesbihis.problem.cyclesingraphs;

import java.util.BitSet;

/**
 * Class to represent a graph.
 * 
 * @author Charles Bihis (www.whoischarles.com)
 */
public class Graph {
	
	protected BitSet[] adjacencyMatrix;
	
	/**
	 * Constructor.
	 * 
	 * @param graph A well-formed graph represented as an adjacency matrix using an array of <code>BitSet</code>s.
	 */
	public Graph(BitSet[] graph) {
		this.adjacencyMatrix = graph;
	}
	
	/**
	 * Returns the number of vertices in the graph.
	 * 
	 * @return The numnber of vertices in the graph.
	 */
	public int size() {
		return adjacencyMatrix != null ? adjacencyMatrix.length : 0;
	}
	
	/**
	 * Gets a <code>BitSet</code> representation of the adjacent vertices
	 * to the given vertex.
	 * 
	 * @param vertex The vertex for which to retrieve the adjacent vertices.
	 * 
	 * @return A <code>BitSet</code> representing the adjacent vertices to the given vertex.
	 */
	public BitSet getAdjacentVertices(int vertex) {
		return adjacencyMatrix[vertex];
	}
	
	/**
	 * Getter for the internal adjacency matrix.
	 * 
	 * @return The adjacency matrix representation of the graph.
	 */
	public BitSet[] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}
}
