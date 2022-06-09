package com.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTests {
    @Test
    public void testQueue(){
        IQueue<Integer> queue = new Queue<>();
        for(int i = 0;i < 10;i++){
            queue.enqueue(i);
        }
        for(int i=0;i < 10;i++){
            int value = queue.dequeue();
            Assertions.assertEquals(i, value);
        }
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void throwExceptionIfQueueIsEmpty(){
        IQueue<Integer> queue = new Queue<>();
        Assertions.assertThrows(IllegalStateException.class, queue::dequeue);
    }
}
