package com.charlesbihis.sandbox.queuefromstacks;

public interface Queue<T> {
	public void enqueue(T obj);
	public T dequeue();
	public int size();
}
