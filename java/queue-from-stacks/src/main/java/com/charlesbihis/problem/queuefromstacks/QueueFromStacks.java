package com.charlesbihis.problem.queuefromstacks;

import java.util.Stack;

/**
 * A class to demonstrate the construction of a queue
 * using only a stack implementation.
 * 
 * @author Charles Bihis (www.whoischarles.com)
 *
 * @param <T>
 */
public class QueueFromStacks<T> implements Queue<T> {
	private Stack<T> enqueueStack;
	private Stack<T> dequeueStack;
	
	public QueueFromStacks() {
		enqueueStack = new Stack<T>();
		dequeueStack = new Stack<T>();
	}
	
	public void enqueue(T obj) {
		enqueueStack.push(obj);
	}
	
	public T dequeue() {
		if (dequeueStack.size() == 0) {
			while (enqueueStack.size() > 0) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		
		return dequeueStack.pop();
	}
	
	public int size() {
		return enqueueStack.size() + dequeueStack.size();
	}
}
