package com.charlesbihis.problem.cyclesingraphs;

import java.util.BitSet;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import com.charlesbihis.problem.cyclesingraphs.Graph;
import com.charlesbihis.problem.cyclesingraphs.GraphUtil;

/**
 * Test class for the <code>GraphUtil</code> utility class.
 * 
 * @author Charles Bihis
 */
public class GraphUtilTest extends TestCase {
	private GraphUtil graphUtil;
	
	public void setUp() {
		graphUtil = new GraphUtil();
	}

	/**
	 * Null test.
	 */
	@Test
	public void testNull() {
		Assert.assertFalse(graphUtil.hasCycle(null));
	}
	
	/**
	 * Test with only one vertex.
	 * 
	 * e.g.		0
	 */
	@Test
	public void testIdentity() {
		BitSet[] adjacencyList = new BitSet[1];
		adjacencyList[0] = new BitSet();
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertFalse(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Test with two vertices.
	 * 
	 * e.g.		0
	 * 			|
	 * 			1
	 */
	@Test
	public void testTwoVertices() {
		BitSet[] adjacencyList = new BitSet[2];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[1].set(0);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertFalse(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Three vertices that make a tree, no cycle.
	 * 
	 * e.g.		0
	 * 		   / \
	 * 		  1   2
	 */
	@Test
	public void testThreeVerticesInTree() {
		BitSet[] adjacencyList = new BitSet[3];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[1].set(0);
		adjacencyList[2].set(0);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertFalse(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Three vertices that make a cycle.
	 * 
	 * e.g.		0
	 * 		   / \
	 * 		  1 - 2
	 */
	@Test
	public void testThreeVerticesInCycle() {
		BitSet[] adjacencyList = new BitSet[3];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[1].set(0);
		adjacencyList[1].set(2);
		adjacencyList[2].set(0);
		adjacencyList[2].set(1);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertTrue(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Four vertices, no cycle.
	 * 
	 * e.g.		0
	 * 		   / \
	 * 		  1   2
	 *       /
	 *      3
	 */
	@Test
	public void testFourVerticesInTree() {
		BitSet[] adjacencyList = new BitSet[4];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[1].set(0);
		adjacencyList[1].set(3);
		adjacencyList[2].set(0);
		adjacencyList[3].set(1);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertFalse(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Four vertices in a square.
	 * 
	 * e.g.		0 - 1
	 * 		    |   |
	 * 		    2 - 3
	 */
	@Test
	public void testFourVerticesInSquare() {
		BitSet[] adjacencyList = new BitSet[4];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[1].set(0);
		adjacencyList[1].set(3);
		adjacencyList[2].set(0);
		adjacencyList[2].set(3);
		adjacencyList[3].set(1);
		adjacencyList[3].set(2);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertTrue(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Five vertices in a tree.
	 * 
	 * e.g.		0
	 * 		   / \
	 * 		  1   2
	 *       / \
	 *      3   4
	 */
	@Test
	public void testFiveVerticesInTree() {
		BitSet[] adjacencyList = new BitSet[5];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[1].set(0);
		adjacencyList[1].set(3);
		adjacencyList[1].set(4);
		adjacencyList[2].set(0);
		adjacencyList[3].set(1);
		adjacencyList[4].set(1);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertFalse(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Five vertices with a cycle.
	 * 
	 * e.g.		0
	 * 		   / \
	 * 		  1   2
	 *       / \ /
	 *      3   4
	 */
	@Test
	public void testFiveVerticesWithCycle() {
		BitSet[] adjacencyList = new BitSet[5];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[1].set(0);
		adjacencyList[1].set(3);
		adjacencyList[1].set(4);
		adjacencyList[2].set(0);
		adjacencyList[2].set(4);
		adjacencyList[3].set(1);
		adjacencyList[4].set(1);
		adjacencyList[4].set(2);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertTrue(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Test long chain.
	 * 
	 * e.g.		0
	 * 		    |
	 * 		    1
	 *          |
	 *          2
	 *          |
	 *          3
	 *          |
	 *          4
	 *          |
	 *          5
	 *          |
	 *          6
	 *          |
	 *          7
	 */
	@Test
	public void testLongChain() {
		BitSet[] adjacencyList = new BitSet[8];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[1].set(0);
		adjacencyList[1].set(2);
		adjacencyList[2].set(1);
		adjacencyList[2].set(3);
		adjacencyList[3].set(2);
		adjacencyList[3].set(4);
		adjacencyList[4].set(3);
		adjacencyList[4].set(5);
		adjacencyList[5].set(4);
		adjacencyList[5].set(6);
		adjacencyList[6].set(5);
		adjacencyList[6].set(7);
		adjacencyList[7].set(6);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertFalse(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Test long chain with loop.
	 * 
	 * e.g.		0--
	 * 		    |  |
	 * 		    1  |
	 *          |  |
	 *          2  |
	 *          |  |
	 *          3  |
	 *          |  |
	 *          4  |
	 *          |  |
	 *          5  |
	 *          |  |
	 *          6  |
	 *          |  |
	 *          7--
	 */
	@Test
	public void testLongChainWithLoop() {
		BitSet[] adjacencyList = new BitSet[8];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(7);
		adjacencyList[1].set(0);
		adjacencyList[1].set(2);
		adjacencyList[2].set(1);
		adjacencyList[2].set(3);
		adjacencyList[3].set(2);
		adjacencyList[3].set(4);
		adjacencyList[4].set(3);
		adjacencyList[4].set(5);
		adjacencyList[5].set(4);
		adjacencyList[5].set(6);
		adjacencyList[6].set(5);
		adjacencyList[6].set(7);
		adjacencyList[7].set(6);
		adjacencyList[7].set(1);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertTrue(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Test long chain with multiple loops.
	 * 
	 * e.g.		0--------
	 * 		    |  |  |  |
	 * 		    1  |  |  |
	 *          |  |  |  |
	 *          2--   |  |
	 *          |     |  |
	 *        --3     |  |
	 *       |  |     |  |
	 *       |  4     |  |
	 *       |  |     |  |
	 *        --5     |  |
	 *          |     |  |
	 *          6-----   |
	 *          |        |
	 *          7--------
	 */
	@Test
	public void testLongChainWithMultipleLoops() {
		BitSet[] adjacencyList = new BitSet[8];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[0].set(6);
		adjacencyList[0].set(7);
		adjacencyList[1].set(0);
		adjacencyList[1].set(2);
		adjacencyList[2].set(0);
		adjacencyList[2].set(1);
		adjacencyList[2].set(3);
		adjacencyList[3].set(2);
		adjacencyList[3].set(4);
		adjacencyList[3].set(5);
		adjacencyList[4].set(3);
		adjacencyList[4].set(5);
		adjacencyList[5].set(3);
		adjacencyList[5].set(4);
		adjacencyList[5].set(6);
		adjacencyList[6].set(0);
		adjacencyList[6].set(5);
		adjacencyList[6].set(7);
		adjacencyList[7].set(6);
		adjacencyList[7].set(1);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertTrue(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Larger graph, no cycles
	 * 
	 * e.g.		0
	 * 		   /|\
	 * 		  1 2 3
	 *       /| |
	 *      4 5 6
	 *          |
	 *          7
	 *         / \
	 *        8   9
	 */
	@Test
	public void testTenVerticesInTree() {
		BitSet[] adjacencyList = new BitSet[10];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[0].set(3);
		adjacencyList[1].set(0);
		adjacencyList[1].set(4);
		adjacencyList[1].set(5);
		adjacencyList[2].set(0);
		adjacencyList[2].set(6);
		adjacencyList[3].set(0);
		adjacencyList[4].set(1);
		adjacencyList[5].set(1);
		adjacencyList[6].set(2);
		adjacencyList[6].set(7);
		adjacencyList[7].set(6);
		adjacencyList[7].set(8);
		adjacencyList[7].set(9);
		adjacencyList[8].set(7);
		adjacencyList[9].set(7);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertFalse(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Larger graph with cycles
	 * 
	 * e.g.		0
	 * 		   /|\
	 * 		  1 2 3
	 *       /| | |
	 *      4 5-6-
	 *          |
	 *          7
	 *         / \
	 *        8 - 9
	 */
	@Test
	public void testTenVerticesWithCycles() {
		BitSet[] adjacencyList = new BitSet[10];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(2);
		adjacencyList[0].set(3);
		adjacencyList[1].set(0);
		adjacencyList[1].set(4);
		adjacencyList[1].set(5);
		adjacencyList[2].set(0);
		adjacencyList[2].set(6);
		adjacencyList[3].set(0);
		adjacencyList[3].set(6);
		adjacencyList[4].set(1);
		adjacencyList[5].set(1);
		adjacencyList[5].set(6);
		adjacencyList[6].set(2);
		adjacencyList[6].set(3);
		adjacencyList[6].set(5);
		adjacencyList[6].set(7);
		adjacencyList[7].set(6);
		adjacencyList[7].set(8);
		adjacencyList[7].set(9);
		adjacencyList[8].set(7);
		adjacencyList[8].set(9);
		adjacencyList[9].set(7);
		adjacencyList[9].set(8);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertTrue(graphUtil.hasCycle(graph));
	}
	
	/**
	 * Test a dense graph.
	 * 
	 * e.g.		0---1---2
	 *          | X | X |
	 *          3---4---5
	 */
	@Test
	public void testDenseGraphWithCycles() {
		BitSet[] adjacencyList = new BitSet[6];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new BitSet();
		}
		adjacencyList[0].set(1);
		adjacencyList[0].set(3);
		adjacencyList[0].set(4);
		adjacencyList[1].set(0);
		adjacencyList[1].set(2);
		adjacencyList[1].set(3);
		adjacencyList[1].set(4);
		adjacencyList[1].set(5);
		adjacencyList[2].set(1);
		adjacencyList[2].set(4);
		adjacencyList[2].set(5);
		adjacencyList[3].set(0);
		adjacencyList[3].set(1);
		adjacencyList[3].set(4);
		adjacencyList[4].set(0);
		adjacencyList[4].set(1);
		adjacencyList[4].set(2);
		adjacencyList[4].set(3);
		adjacencyList[4].set(5);
		adjacencyList[5].set(1);
		adjacencyList[5].set(2);
		adjacencyList[5].set(4);
		Graph graph = new Graph(adjacencyList);
		
		Assert.assertTrue(graphUtil.hasCycle(graph));
	}
}
