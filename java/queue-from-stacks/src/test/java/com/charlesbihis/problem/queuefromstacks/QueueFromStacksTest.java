package com.charlesbihis.problem.queuefromstacks;

import java.util.LinkedList;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

import com.charlesbihis.problem.queuefromstacks.Queue;
import com.charlesbihis.problem.queuefromstacks.QueueFromStacks;

public class QueueFromStacksTest {
	@Test
	public void testSmallIntegerQueue() {
		// create queues
		Queue<Integer> queue = new QueueFromStacks<Integer>();
		java.util.Queue<Integer> list = new LinkedList<Integer>();
		
		// populate the queues
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
			list.add(i);
		}
		
		// check that they are equal
		while (queue.size() > 0) {
			Assert.assertEquals(list.remove(), queue.dequeue());
		}
	}
	
	@Test
	public void testLargeDoubleQueue() {
		Random random = new Random();
		
		// create queues
		Queue<Double> queue = new QueueFromStacks<Double>();
		java.util.Queue<Double> list = new LinkedList<Double>();
		
		// populate the queues
		for (int i = 0; i < 500; i++) {
			Double num = random.nextDouble();
			queue.enqueue(num);
			list.add(num);
		}
		
		// check that they are equal
		while (queue.size() > 0) {
			Assert.assertEquals(list.remove(), queue.dequeue());
		}
	}
	
	@Test
	public void testSmallStringQueue() {
		// create queues
		Queue<String> queue = new QueueFromStacks<String>();
		java.util.Queue<String> list = new LinkedList<String>();
		
		// populate the queues
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		// check that they are equal
		Assert.assertEquals(list.remove(), queue.dequeue());
		Assert.assertEquals(list.remove(), queue.dequeue());
		Assert.assertEquals(list.remove(), queue.dequeue());
		Assert.assertEquals(list.remove(), queue.dequeue());
		Assert.assertEquals(list.remove(), queue.dequeue());
	}
}