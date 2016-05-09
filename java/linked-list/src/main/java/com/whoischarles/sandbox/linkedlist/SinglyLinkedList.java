package com.whoischarles.sandbox.linkedlist;

/**
 * A simple singly-linked-list implementation.
 */
public class SinglyLinkedList {
  private Node head;
  private int size;

  public SinglyLinkedList() {
    this.head = null;
    this.size = 0;
  }

  public void add(int value) {
    add(new Node(value));
  }

  public void add(Node node) {

    if (head == null) {
      head = node;
      size = 1;
      return;
    }

    Node currNode = head;
    while (currNode.getNext() != null) {
      currNode = currNode.getNext();
    }

    currNode.setNext(node);
    size++;

  }

  public Node remove(int value) {
    return remove(new Node(value));
  }

  public Node remove(Node node) {

    if (head == null) {
      return null;
    }

    if (head.getValue() == node.getValue()) {
      Node targetNode = head;
      head = head.getNext();
      size--;

      return targetNode;
    }

    Node currNode = head;
    while (currNode.getNext() != null) {
      if (currNode.getNext().getValue() == node.getValue()) {
        Node targetNode = currNode.getNext();
        currNode.setNext(currNode.getNext().getNext());
        size--;

        return targetNode;
      }
    }

    return null;
  }

  public int getSize() {
    return size;
  }
}
