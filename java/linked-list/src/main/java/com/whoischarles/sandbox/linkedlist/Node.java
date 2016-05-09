package com.whoischarles.sandbox.linkedlist;

public class Node {
  private int value;
  private Node next;

  public Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node node) {
    this.next = node;
  }
}
