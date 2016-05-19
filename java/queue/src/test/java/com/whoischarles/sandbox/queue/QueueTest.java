package com.whoischarles.sandbox.queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

  @Test
  public void testEnqueueAndDequeue() {
    Queue<Integer> queue = new Queue<Integer>();
    Assert.assertEquals(0, queue.getSize());

    queue.enqueue(12345);
    Assert.assertEquals(1, queue.getSize());

    int result = queue.dequeue();
    Assert.assertEquals(12345, result);
    Assert.assertEquals(0, queue.getSize());
  }
}
