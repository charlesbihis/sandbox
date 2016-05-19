package com.whoischarles.sandbox.queue;

public class Queue<T> {
  protected Node<T> head;
  protected Node<T> tail;
  protected int size;

  public void enqueue(T value) {
    Node<T> node = new Node<T>(value);
    size++;

    if (head == null) {
      head = node;
      tail = node;
      return;
    }

    node.setNext(head);
    head = node;
  }

  public T dequeue() {
    if (head == null) {
      return null;
    }

    if (head.equals(tail)) {
      Node<T> result = tail;
      tail = head;
      size--;
      return result.getValue();
    }

    Node<T> currNode = head;
    while (currNode.getNext() != null) {
      if (currNode.getNext().equals(tail)) {
        Node<T> result = currNode.getNext();
        tail = currNode;
        size--;
        return result.getValue();
      }
    }

    return null;
  }

  public int getSize() {
    return size;
  }
}
