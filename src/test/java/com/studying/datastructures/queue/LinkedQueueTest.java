package com.studying.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {
    @DisplayName("test enqueue/dequeue work correctly and changes size")
    @Test
    void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        linkedQueue.enqueue("c");
        assertEquals(3, linkedQueue.size());

        assertEquals("a", linkedQueue.dequeue());
        assertEquals(2, linkedQueue.size());

        linkedQueue.enqueue("d");
        assertEquals("b", linkedQueue.dequeue());
        assertEquals(2, linkedQueue.size());
    }

    @DisplayName("simple test: enqueue 10 items and dequeue them all, repeat")
    @Test
    void testEnqueueDequeuePrint() {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            linkedQueue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(linkedQueue.dequeue());
        }

        for (int i = 0; i < 10; i++) {
            linkedQueue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(linkedQueue.dequeue());
        }
    }

    @DisplayName("test enqueue and peek work correctly")
    @Test
    void testEnqueueAndPeek() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        assertEquals(2, linkedQueue.size());
        assertEquals("a", linkedQueue.peek());
        assertEquals("a", linkedQueue.peek());
        assertEquals(2, linkedQueue.size());
    }

    @DisplayName("test isEmpty returns true on a new LinkedQueue")
    @Test
    void testIsEmptyReturnTrueOnNewLinkedQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        assertTrue(linkedQueue.isEmpty());
        assertEquals(0, linkedQueue.size());
    }

    @DisplayName("test isEmpty returns false on LinkedQueue with data")
    @Test
    void testIsEmptyReturnFalseOnLinkedQueueWithData() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        assertFalse(linkedQueue.isEmpty());
    }

    @DisplayName("test isEmpty returns true on LinkedQueue after clear")
    @Test
    void testIsEmptyReturnTrueOnLinkedQueueAfterClear() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        linkedQueue.clear();
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("test contains returns true")
    @Test
    void testContainsReturnTrue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        assertTrue(linkedQueue.contains("b"));
    }

    @DisplayName("test contains returns false on empty LinkedQueue")
    @Test
    void testContainsReturnFalseOnEmptyLinkedQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        assertFalse(linkedQueue.contains("a"));
    }

    @DisplayName("test contains for a null value")
    @Test
    void testContainsForNullValue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        linkedQueue.dequeue();
        assertFalse(linkedQueue.contains(null));
        linkedQueue.enqueue(null);
        assertTrue(linkedQueue.contains(null));
    }

    @DisplayName("test throw IllegalStateException when dequeue on empty LinkedQueue")
    @Test
    void testThrowIllegalStateExceptionWhenDequeueOnEmptyLinkedQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedQueue.dequeue();
        });
    }

    @DisplayName("test throw IllegalStateException when peek on empty LinkedQueue")
    @Test
    void testThrowIllegalStateExceptionWhenPeekOnEmptyLinkedQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedQueue.peek();
        });
    }

    @DisplayName("test toString on empty LinkedQueue")
    @Test
    void testToStringOnEmptyLinkedQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        assertEquals("[]", linkedQueue.toString());
    }

    @DisplayName("test toString on LinkedQueue with data")
    @Test
    void testToStringOnLinkedQueueWithData() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        assertEquals("[a, b]", linkedQueue.toString());
        linkedQueue.dequeue();
        assertEquals("[b]", linkedQueue.toString());
    }



    @DisplayName("test toString on LinkedQueue after dequeue all data")
    @Test
    void testToStringOnLinkedQueueAfterDequeueAllData() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        assertEquals("[a, b]", linkedQueue.toString());
        linkedQueue.dequeue();
        assertEquals("[b]", linkedQueue.toString());
        linkedQueue.dequeue();
        assertEquals("[]", linkedQueue.toString());
    }

    @DisplayName("test toString on LinkedQueue after clear")
    @Test
    void testToStringOnLinkedQueueAfterClear() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        assertEquals("[a]", linkedQueue.toString());
        linkedQueue.clear();
        assertEquals("[]", linkedQueue.toString());
    }
}
