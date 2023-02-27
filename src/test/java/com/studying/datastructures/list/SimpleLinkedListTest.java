package com.studying.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleLinkedListTest {
    @DisplayName("test add element by index works correctly and changes size")
    @Test
    void addElementToTheEndOfListAndGetWorksCorrectlyAndChangesSize() {
        SimpleLinkedList list = new SimpleLinkedList();
        assertEquals(0, list.size());
        list.add("a");
        assertEquals("a", list.get(0));
        list.add("b");
        list.add("c");
        assertEquals("c", list.get(2));
        assertEquals(3, list.size());
    }
    @DisplayName("test add element by index and get works correctly and changes size")
    @Test
    void addElementByIndexAndGetWorkCorrectlyAndChangesSize() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        list.add("w", 1);
        assertEquals("b", list.get(2));
        list.add("x", 0);
        assertEquals("a", list.get(1));
        assertEquals(4, list.size());
    }

    @DisplayName("test add element by index throws IndexOutOfBoundsException")
    @Test
    void addElementByIndexThrowIndexOutOfBoundsException() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(3, 3);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(3, -1);
        });
    }

    @DisplayName("test get throws IllegalStateException")
    @Test
    void testGetThrowIllegalStateException() {
        SimpleLinkedList list = new SimpleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.get(0);
        });
    }

    @DisplayName("test get throws IndexOutOfBoundsException")
    @Test
    void testGetThrowIndexOutOfBoundsException() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        assertEquals(2, list.get(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-2);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(3);
        });
    }

    @DisplayName("test add element to the end of LinkedList and remove work correctly and changes size")
    @Test
    void addElementToTheEndOfLinkedListAndRemoveWorkCorrectlyAndChangesSize() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(4, list.size());
        assertEquals(2, list.remove(1));
        assertEquals(3, list.size());
        assertEquals(1, list.remove(0));
        assertEquals(3, list.remove(0));
        assertEquals(4, list.remove(0));
        assertTrue(list.isEmpty());
    }

    @DisplayName("simple test: add ten items and remove all them, repeat")
    @Test
    void testAddRemovePrint() {
        SimpleLinkedList list = new SimpleLinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(list.remove(0));
        }

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(list.remove(0));
        }
    }

    @DisplayName("test add and peek work correctly")
    @Test
    void testAddAndPeek() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        assertEquals(2, list.size());
        assertEquals("a", list.peek());
        assertEquals("a", list.peek());
        assertEquals(2, list.size());
    }

    @DisplayName("test isEmpty returns true on a new LinkedList")
    @Test
    void testIsEmptyReturnTrueOnNewLinkedList() {
        SimpleLinkedList list = new SimpleLinkedList();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @DisplayName("test isEmpty returns false on LinkedList with data")
    @Test
    void testIsEmptyReturnFalseOnLinkedListWithData() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        assertFalse(list.isEmpty());
    }

    @DisplayName("test isEmpty returns true on LinkedList after clear")
    @Test
    void testIsEmptyReturnTrueOnLinkedListAfterClear() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @DisplayName("test contains returns true")
    @Test
    void testContainsReturnTrue() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        assertTrue(list.contains("b"));
    }

    @DisplayName("test contains returns false")
    @Test
    void testContainsReturnFalse() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.remove(0);
        assertFalse(list.contains("b"));
    }

    @DisplayName("test contains returns false on empty LinkedList")
    @Test
    void testContainsReturnFalseOnEmptyLinkedList() {
        SimpleLinkedList list = new SimpleLinkedList();
        assertFalse(list.contains("a"));
    }

    @DisplayName("test contains for a null value")
    @Test
    void testContainsForNullValue() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        list.remove(0);
        assertFalse(list.contains(null));
        list.add(null);
        assertTrue(list.contains(null));
    }

    @DisplayName("test throw IllegalStateException when remove on empty LinkedList")
    @Test
    void testThrowIllegalStateExceptionWhenRemoveOnEmptyLinkedList() {
        SimpleLinkedList list = new SimpleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.remove(0);
        });
    }

    @DisplayName("test remove throws IllegalStateException")
    @Test
    void removeElementByIndexThrowIllegalStateException() {
        SimpleLinkedList list = new SimpleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.remove(0);
        });
    }

    @DisplayName("test remove throws IndexOutOfBoundsException")
    @Test
    void removeElementByIndexThrowIndexOutOfBoundsException() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(3);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
    }

    @DisplayName("test throw IllegalStateException when peek on empty LinkedList")
    @Test
    void testThrowIllegalStateExceptionWhenPeekOnEmptyLinkedList() {
        SimpleLinkedList list = new SimpleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.peek();
        });
    }

    @DisplayName("test toString on empty LinkedList")
    @Test
    void testToStringOnEmptyLinkedList() {
        SimpleLinkedList list = new SimpleLinkedList();
        assertEquals("[]", list.toString());
    }

    @DisplayName("test toString on LinkedList with data")
    @Test
    void testToStringOnLinkedListWithData() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        assertEquals("[a, b]", list.toString());
        list.remove(0);
        assertEquals("[b]", list.toString());
    }

    @DisplayName("test toString on LinkedList after remove all data")
    @Test
    void testToStringOnLinkedListAfterRemoveAllData() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        assertEquals("[a, b]", list.toString());
        list.remove(1);
        assertEquals("[a]", list.toString());
        list.remove(0);
        assertEquals("[]", list.toString());
    }

    @DisplayName("test toString on LinkedList after clear")
    @Test
    void testToStringOnLinkedListAfterClear() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        assertEquals("[a]", list.toString());
        list.clear();
        assertEquals("[]", list.toString());
    }

    @DisplayName("test get and set work correctly")
    @Test
    void testGetAndSetWorkCorrectly() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
        assertEquals(3, list.set(4, 2));
        assertEquals(1, list.set(5, 0));
        assertEquals(2, list.set(6, 1));
        assertEquals("[5, 6, 4]", list.toString());
    }

    @DisplayName("test set throws IllegalStateException")
    @Test
    void testSetThrowIllegalStateException() {
        SimpleLinkedList list = new SimpleLinkedList();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.set(0, 0);
        });
    }

    @DisplayName("test set throws IndexOutOfBoundsException")
    @Test
    void testSetThrowIndexOutOfBoundsException() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(3, 2);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(3, 3);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(3, -1);
        });
    }

    @DisplayName("test indexOf works correctly")
    @Test
    void testIndexOfWorksCorrectly() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        assertEquals(-1, list.indexOf("c"));
        list.add(null, 0);
        assertEquals(1, list.indexOf("a"));
    }

    @DisplayName("test lastIndexOf works correctly")
    @Test
    void testLastIndexOfWorksCorrectly() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        assertEquals(-1, list.lastIndexOf("b"));
        list.add("b");
        list.add("b");
        assertEquals(2, list.lastIndexOf("b"));
    }

    @DisplayName("test indexOf for a null value")
    @Test
    void testIndexOfForNullValue() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        list.add("b");
        assertEquals(-1, list.indexOf(null));
        list.add(null);
        assertEquals(2, list.indexOf(null));
    }

    @DisplayName("test lastIndexOf for a null value")
    @Test
    void testLastIndexOfForNullValue() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("a");
        assertEquals(-1, list.lastIndexOf(null));
        list.add(null);
        list.add("b");
        list.add(null);
        assertEquals(3, list.lastIndexOf(null));
    }

    @DisplayName("test push and pop work correctly and change size")
    @Test
    void testPushAndPopWorkCorrectlyAndChangeSize() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push("a");
        list.push("b");

        assertEquals(2, list.size());
        assertEquals("b", list.pop());
        assertEquals("a", list.pop());
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @DisplayName("simple test: push 10 items and pop all them, repeat")
    @Test
    void testPushPopPrint() {
        SimpleLinkedList list = new SimpleLinkedList();
        for (int i = 0; i < 10; i++) {
            list.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(list.pop());
        }

        for (int i = 0; i < 10; i++) {
            list.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(list.pop());
        }
        assertEquals(0, list.size());
    }

    @DisplayName("test push and peek work correctly and changes size")
    @Test
    void testPushAndPeek() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push("a");
        list.push("b");
        assertEquals(2, list.size());
        assertEquals("b", list.peek());
        assertEquals("b", list.peek());
        assertEquals(2, list.size());
    }

    @DisplayName("test throw NoSuchElementException when pop on empty LinkedList")
    @Test
    void testThrowIllegalStateExceptionWhenPopOnEmptyLinkedList() {
        SimpleLinkedList list = new SimpleLinkedList();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            list.pop();
        });
    }
}
