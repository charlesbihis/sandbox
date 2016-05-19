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

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(3);
    queue.enqueue(5);
    Assert.assertEquals(6, queue.getSize());

    result = queue.dequeue();
    Assert.assertEquals(1, result);

    result = queue.dequeue();
    Assert.assertEquals(2, result);

    result = queue.dequeue();
    Assert.assertEquals(3, result);

    result = queue.dequeue();
    Assert.assertEquals(4, result);

    result = queue.dequeue();
    Assert.assertEquals(3, result);

    result = queue.dequeue();
    Assert.assertEquals(5, result);
  }
}
