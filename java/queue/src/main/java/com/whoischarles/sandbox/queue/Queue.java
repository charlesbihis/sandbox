package com.whoischarles.sandbox.queue;

/**
 * This is a shitty implementation.  I'll tell you why.  For this implementation of a queue, I'm using a linked-list
 * to store the nodes.  When I enqueue, I insert at the front of the queue, and when I dequeue, I remove from the end
 * of the queue.  Since I add at the front and I have a pointer to 'head', inserts are constant.  However, even though
 * I have a pointer to 'tail', and since this isn't a doubly-linked-list, I have to traverse the entire list to get the
 * node right before the tail in order to remove the tail.  This makes the dequeue operation linear.
 *
 * What I should do instead is enqueue by inserting at the end, and dequeue by removing from the front.  This would make
 * both operations constant.
 *
 * @param <T>
 */
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
      head = null;
      tail = null;
      size--;
      return result.getValue();
    }

    Node<T> currNode = head;
    while (currNode.getNext() != null) {
      if (currNode.getNext() == tail) {
        Node<T> result = currNode.getNext();
        tail = currNode;
        size--;
        return result.getValue();
      }
      currNode = currNode.getNext();
    }

    return null;
  }

  public int getSize() {
    return size;
  }
}
