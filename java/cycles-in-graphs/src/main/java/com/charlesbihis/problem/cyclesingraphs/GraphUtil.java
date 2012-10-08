package com.charlesbihis.problem.cyclesingraphs;

import java.util.BitSet;
import java.util.Stack;

/**
 * This utility class contains the method, <code>hasCycle()</code>, which can be used to determine
 * if a given graph contains a cycle.  During the interview, I mentioned that I would probably 
 * choose to represent the graph using adjacency lists.  But, after some more thought, I realized
 * that it wouldn't be an efficient approach.  Instead, I've chosen to represent the graph as an
 * adjacency matrix using an array of <code>BitSet</code>s.
 * 
 * 
 * Approach:
 * 
 * In order to detect a cycle in a given graph, I attempt to perform a depth-first traversal starting
 * from a particular vertex, taking note of the vertices visited and the edges walked.  If a
 * previously untraversed edge leads to the discovery of an already visited vertex, then a cycle
 * must exist in the graph.
 * 
 * 
 * Performance Considerations:
 * 
 * I chose to represent the graph as an adjacency matrix using an array of <code>BitSet</code>s.  This
 * gives significant space and performance gains, particularly allowing certain common tasks to be performed
 * in constant time.  For instance, looking up the adjacent vertices to a given vertex, or determining
 * the next unvisited, adjacent vertex.  These are common procedures in the algorithm and can now be done
 * in constant time which adds a significant performance improvement.  Also, I chose to perform the
 * depth-first traversal in an iterative manner as opposed to taking the recursive approach.  This
 * would save from the overhead accumulated from all of the function calls using a recursive approach.
 * 
 * 
 * Assumptions:
 * 
 * -I am only detecting cycles, not attempting to fix them.
 * -I own the data structure and so I can represent the graph in any way I choose.
 * -Vertices are identified by a vertex number and do not carry any extra information.  This can 
 *  be changed easily if the need arises.
 * 
 * 
 * Complexity:
 * 
 * The method performs a maximum of one depth-first traversal on the given graph, and so the 
 * complexity is O(|V| + |E|).
 * 
 * 
 * @author Charles Bihis
 */
public class GraphUtil {
	/**
	 * Utility method to determine whether a given graph contains a cycle.
	 * 
	 * @param graph A well-formed graph for which to check for cycles.
	 * 
	 * @return <code>true</code> if a cycle is present in the given graph.  <code>false</code> otherwise.
	 */
	public boolean hasCycle(Graph graph) {
		
		// check for trivial cases
		if (graph == null || graph.size() < 3) {
			return false;
		}
		
		// create our traversed-edge matrix to keep track of which edges we've walked
		BitSet[] traversedEdgeMatrix = new BitSet[graph.size()];
		for (int i = 0; i < traversedEdgeMatrix.length; i++) {
			traversedEdgeMatrix[i] = new BitSet();
		}
		
		// create our working stack and push the first vertex
		Stack<Integer> workingStack = new Stack<Integer>();
		workingStack.push(0);
		
		// keep track of which vertices we've already visited
		BitSet visited = new BitSet(graph.size());
		visited.set(0);
		
		int currentVertex;
		BitSet adjacentAndVisited;
		BitSet adjacentAndUnvisited;
		while(!workingStack.isEmpty()) {
			
			currentVertex = workingStack.peek();
			
			// determine set of vertices adjacent to the current that we've already visited
			adjacentAndVisited = (BitSet)graph.getAdjacentVertices(currentVertex).clone();
			adjacentAndVisited.and(visited);
			
			// check for cycles here!																// There are 4 conditions for detecting a cycle, all of which must be true
			if (adjacentAndVisited.nextSetBit(0) >= 0 &&												// 1. we must be past the root
					graph.getAdjacentVertices(currentVertex).get(adjacentAndVisited.nextSetBit(0)) &&	// 2. next vertex to hit is adjacent to the current
					visited.get(adjacentAndVisited.nextSetBit(0)) &&									// 3. next vertex has already been visited
					!traversedEdgeMatrix[currentVertex].get(adjacentAndVisited.nextSetBit(0)) &&		// 4. the edge we are using to visit this already-visited
					!traversedEdgeMatrix[adjacentAndVisited.nextSetBit(0)].get(currentVertex)) {		//    vertex has been untraversed
				return true;
			}
			
			// check to see if there are any more unvisited nodes adjacent to the current
			if (adjacentAndVisited.cardinality() < graph.getAdjacentVertices(currentVertex).cardinality()) {
				
				// determine set of adjacent vertices from current vertex which are also unvisited
				adjacentAndUnvisited = (BitSet)graph.getAdjacentVertices(currentVertex).clone();
				adjacentAndUnvisited.andNot(visited);
				
				// record that we've walked this edge
				traversedEdgeMatrix[currentVertex].set(adjacentAndUnvisited.nextSetBit(0));
				traversedEdgeMatrix[adjacentAndUnvisited.nextSetBit(0)].set(currentVertex);
				
				// move on to next vertex
				workingStack.push(adjacentAndUnvisited.nextSetBit(0));
				visited.set(adjacentAndUnvisited.nextSetBit(0));
			} else {
				// done with this vertex
				workingStack.pop();
			}
		}
		
		return false;
	}
}
