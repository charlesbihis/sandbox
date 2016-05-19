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

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Node) {
      return this.getValue() == ((Node)obj).getValue();
    }

    return false;
  }

  // When overriding equals(), must also override hashCode()
  @Override
  public int hashCode() {
    return Objects.hashCode(this.value);
  }
}
