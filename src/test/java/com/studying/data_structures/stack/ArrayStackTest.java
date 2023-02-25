package com.studying.data_structures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
    @DisplayName("test push and pop work correctly and changes size")
    @Test
    void testPushAndPopWorkCorrectlyAndChangeSize() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.push("b");

        assertEquals(2, arrayStack.size());
        assertEquals("b", arrayStack.pop());
        assertEquals("a", arrayStack.pop());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

    @DisplayName("simple test: fill the whole stack and delete all the items, repeat")
    @Test
    void testPushPopPrint() {
        ArrayStack arrayStack = new ArrayStack();
        for (int i = 0; i < arrayStack.size(); i++) {
            arrayStack.push(i);
        }
        for (int i = 0; i < arrayStack.size(); i++) {
            System.out.println(arrayStack.pop());
        }

        for (int i = 0; i < arrayStack.size(); i++) {
            arrayStack.push(i);
        }
        for (int i = 0; i < arrayStack.size(); i++) {
            System.out.println(arrayStack.pop());
        }
    }

    @DisplayName("test push over initial capacity and pop work correctly and changes size")
    @Test
    void testPushOverInitialCapacityAndPopWorkCorrectlyAndChangeSize() {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        assertEquals(3, arrayStack.size());

        assertEquals("c", arrayStack.pop());
        assertEquals("b", arrayStack.pop());
        assertEquals("a", arrayStack.pop());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

    @DisplayName("test push over initial capacity and peek work correctly and changes size")
    @Test
    void testPushAndPeek() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.push("b");

        assertEquals(2, arrayStack.size());
        assertEquals("b", arrayStack.peek());
        assertEquals("b", arrayStack.peek());
        assertEquals("b", arrayStack.peek());
        assertEquals(2, arrayStack.size());
    }

    @DisplayName("test isEmpty returns true on a new stack")
    @Test
    void testIsEmptyReturnTrueOnNewStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertTrue(arrayStack.isEmpty());
    }

    @DisplayName("test isEmpty returns false on stack with data")
    @Test
    void testIsEmptyReturnFalseOnStackWithData() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        assertFalse(arrayStack.isEmpty());
    }

    @DisplayName("test isEmpty returns true on stack after clear")
    @Test
    void testIsEmptyReturnTrueOnStackAfterClear() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.clear();
        assertTrue(arrayStack.isEmpty());
    }

    @DisplayName("test contains returns true")
    @Test
    void testContainsReturnTrue() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.push("b");
        assertTrue(arrayStack.contains("b"));
    }

    @DisplayName("test contains returns false")
    @Test
    void testContainsReturnFalse() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.push("b");
        assertFalse(arrayStack.contains("c"));
    }

    @DisplayName("test contains for a null value")
    @Test
    void testContainsForNullValue() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push(null);
        assertTrue(arrayStack.contains(null));
        arrayStack.pop();
        assertFalse(arrayStack.contains(null));
    }

    @DisplayName("test contains returns false on empty stack")
    @Test
    void testContainsReturnFalseOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertFalse(arrayStack.contains("a"));
    }

    @DisplayName("test throw IllegalStateException when pop on empty stack")
    @Test
    void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayStack.pop();
        });
    }

    @DisplayName("test throw IllegalStateException when peek on empty stack")
    @Test
    void testThrowIllegalStateExceptionWhenPeekOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayStack.peek();
        });
    }
}