package com.whoischarles.sandbox.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

  @Test
  public void testAdd() throws Exception {
    SinglyLinkedList list = new SinglyLinkedList();
    Assert.assertEquals(0, list.getSize());

    // Add a value, check the size
    list.add(3);
    Assert.assertEquals(1, list.getSize());


    // Add another value, this time using overloaded add(), check the size
    Node node = new Node(7);
    list.add(node);
    Assert.assertEquals(2, list.getSize());
  }

  @Test
  public void testRemove() throws Exception {
    SinglyLinkedList list = new SinglyLinkedList();
    Assert.assertEquals(0, list.getSize());

    // Check removal from an empty list
    Node removedNode = list.remove(0);
    Assert.assertNull(removedNode);

    // Add a value and remove it, check the removed value and re-check the size
    list.add(3);
    Assert.assertEquals(1, list.getSize());
    removedNode = list.remove(3);
    Assert.assertEquals(3, removedNode.getValue());

    // Add 2 more values, remove the second, check the removed value and re-check the size
    Node node = new Node(7);
    list.add(node);
    Assert.assertEquals(1, list.getSize());
    list.add(9);
    Assert.assertEquals(2, list.getSize());
    removedNode = list.remove(9);
    Assert.assertEquals(9, removedNode.getValue());
    Assert.assertEquals(1, list.getSize());

    // Try removing a non-existant value
    removedNode = list.remove(777);
    Assert.assertNull(removedNode);

    // Finally, remove the last value in the list, re-check the size (should be 0 now)
    removedNode = list.remove(7);
    Assert.assertEquals(7, removedNode.getValue());
    Assert.assertEquals(0, list.getSize());
  }

}