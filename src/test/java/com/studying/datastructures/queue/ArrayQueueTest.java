package com.studying.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ArrayQueueTest {
    @DisplayName("test enqueue/dequeue work correctly and changes size")
    @Test
    void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");

        assertEquals(3, arrayQueue.size());
        assertEquals("a", arrayQueue.dequeue());
        assertEquals(2, arrayQueue.size());

        arrayQueue.enqueue("d");
        assertEquals("b", arrayQueue.dequeue());
        assertEquals("c", arrayQueue.dequeue());
        assertEquals(1, arrayQueue.size());
    }

    @DisplayName("test enqueue for a null value")
    @Test
    void testEnqueueForNullValue() {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.enqueue("a");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            arrayQueue.enqueue(null);
        });
    }

    @DisplayName("simple test: fill the whole queue and delete all the items, repeat")
    @Test
    void testEnqueueDequeuePrint() {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 0; i < arrayQueue.size(); i++) {
            arrayQueue.enqueue(i);
        }
        for (int i = 0; i < arrayQueue.size(); i++) {
            System.out.println(arrayQueue.dequeue());
        }

        for (int i = 0; i < arrayQueue.size(); i++) {
            arrayQueue.enqueue(i);
        }
        for (int i = 0; i < arrayQueue.size(); i++) {
            System.out.println(arrayQueue.dequeue());
        }
    }

    @DisplayName("test enqueue and peek work correctly")
    @Test
    void testEnqueueAndPeek() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        assertEquals(2, arrayQueue.size());
        assertEquals("a", arrayQueue.peek());
        assertEquals("a", arrayQueue.peek());
        assertEquals("a", arrayQueue.peek());
        assertEquals(2, arrayQueue.size());
    }

    @DisplayName("test isEmpty returns true on a new queue")
    @Test
    void testIsEmptyReturnTrueOnNewQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("test isEmpty returns false on a queue with data")
    @Test
    void testIsEmptyReturnFalseOnQueueWithData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("a");
        assertFalse(arrayQueue.isEmpty());
    }

    @DisplayName("test isEmpty returns true on a queue after clear")
    @Test
    void testIsEmptyReturnTrueOnQueueAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("test contains returns true")
    @Test
    void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        assertTrue(arrayQueue.contains("b"));
    }

    @DisplayName("test contains returns false")
    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.dequeue();
        assertFalse(arrayQueue.contains("a"));
    }

    @DisplayName("test contains returns false on empty queue")
    @Test
    void testContainsReturnFalseOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.contains("a"));
    }

    @DisplayName("test contains for a null value")
    @Test
    void testContainsForNullValue() {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.dequeue();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            arrayQueue.contains(null);
        });
    }

    @DisplayName("test throw IllegalStateException when dequeue on empty queue")
    @Test
    void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }

    @DisplayName("test throw IllegalStateException when peek on empty queue")
    @Test
    void testThrowIllegalStateExceptionWhenPeekOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.peek();
        });
    }

    @DisplayName("test throw IllegalStateException when enqueue on full queue")
    @Test
    void testThrowIllegalStateExceptionWhenEnqueueOnFullQueue() {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.enqueue("c");
        });
    }

    @DisplayName("test toString on empty queue")
    @Test
    void testToStringOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        assertEquals("[]", arrayQueue.toString());
    }

    @DisplayName("test toString on queue with data")
    @Test
    void testToStringOnQueueWithData() {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        assertEquals("[a, b]", arrayQueue.toString());
        arrayQueue.dequeue();
        assertEquals("[b]", arrayQueue.toString());
    }

    @DisplayName("test toString on queue with data when rear is less then front")
    @Test
    void testToStringOnQueueWithDataWhenRearLessThenFront() {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");
        assertEquals("[a, b, c]", arrayQueue.toString());
        arrayQueue.dequeue();
        arrayQueue.enqueue("d");
        assertEquals("[d, b, c]", arrayQueue.toString());
    }

    @DisplayName("test toString on queue after dequeue all data")
    @Test
    void testToStringOnQueueAfterDequeueAllData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        assertEquals("[]", arrayQueue.toString());
    }

    @DisplayName("test toString on queue after clear")
    @Test
    void testToStringOnQueueAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.clear();
        assertEquals("[]", arrayQueue.toString());
    }

    @DisplayName("test create queue with initial capacity")
    @Test
    void testCreateQueueWithInitialCapacity() {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        assertEquals(5, arrayQueue.getCapacity());
        ArrayQueue arrayQueue2 = new ArrayQueue(0);
        assertEquals(10, arrayQueue2.getCapacity());
    }

    @DisplayName("test throw IllegalArgumentException when create queue with illegal capacity")
    @Test
    void testCreateQueueWithIllegalCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ArrayQueue(-1);
        });
    }
}
