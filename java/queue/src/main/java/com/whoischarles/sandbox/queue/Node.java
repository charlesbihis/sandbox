package com.whoischarles.sandbox.queue;

import java.util.Objects;

public class Node<T> {
  protected T value;
  protected Node next;

  public Node (T value) {
    this.value = value;
    this.next = null;
  }

  public T getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
