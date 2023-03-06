package com.studying.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractListTest {
    private List list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List getList();

    @DisplayName("test add element to the end of list and remove work correctly and change size")
    @Test
    void testAddElementToTheEndAndRemoveWorkCorrectlyAndChangeSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(4, list.size());
        assertEquals(2, list.remove(1));
        assertEquals(3, list.size());
        assertEquals(4, list.remove(2));
        assertEquals(1, list.remove(0));
        assertEquals(3, list.remove(0));
        assertTrue(list.isEmpty());
    }

    @DisplayName("test add element to the end work correctly and change size")
    @Test
    void testAddElementToTheEndAndGetWorkCorrectlyAndChangeSize() {
        SimpleLinkedList list = new SimpleLinkedList();
        assertEquals(0, list.size());
        list.add("a");
        assertEquals("a", list.get(0));
        list.add("b");
        list.add("c");
        assertEquals("c", list.get(2));
        assertEquals(3, list.size());
    }

    @DisplayName("simple test: fill the whole list and remove all the items, repeat")
    @Test
    void testAddRemove() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list.remove(0);
        }

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list.remove(0);
        }
    }

    @DisplayName("test add element by index and get work correctly and change size")
    @Test
    void testAddElementByIndexAndGetWorkCorrectlyAndChangeSize() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("w", 2);
        assertEquals("c", list.get(3));
        list.add("x", 0);
        assertEquals("a", list.get(1));
        assertEquals(5, list.size());
        list.add("y", 5);
        assertEquals("y", list.get(5));
        assertEquals(6, list.size());
    }

    @DisplayName("test add element by index throws IndexOutOfBoundsException")
    @Test
    void testAddElementByIndexThrowIndexOutOfBoundsException() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(3, 3);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(3, -1);
        });
    }

    @DisplayName("test remove throws IndexOutOfBoundsException")
    @Test
    void testRemoveElementByIndexThrowIndexOutOfBoundsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
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

    @DisplayName("test get and set work correctly")
    @Test
    void testGetAndSetWorkCorrectly() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
        assertEquals(3, list.set(4, 2));
        assertEquals(1, list.set(5, 0));
        assertEquals(2, list.set(6, 1));
        assertEquals("[5, 6, 4]", list.toString());
    }

    @DisplayName("test set throws IndexOutOfBoundsException")
    @Test
    void testSetThrowIndexOutOfBoundsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(0, 0);
        });
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

    @DisplayName("test get throws IndexOutOfBoundsException")
    @Test
    void testGetThrowIndexOutOfBoundsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
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

    @DisplayName("test isEmpty returns true on a new list")
    @Test
    void testIsEmptyReturnTrueOnNewList() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @DisplayName("test isEmpty returns false on the list with data")
    @Test
    void testIsEmptyReturnFalseOnListWithData() {
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @DisplayName("test isEmpty returns true on the list after clear")
    @Test
    void testIsEmptyReturnTrueOnListAfterClear() {
        list.add(1);
        list.add(2);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @DisplayName("test contains returns true")
    @Test
    void testContainsReturnTrue() {
        list.add(1);
        list.add(2);
        assertTrue(list.contains(2));
    }

    @DisplayName("test contains returns false")
    @Test
    void testContainsReturnFalse() {
        list.add(1);
        list.add(2);
        list.remove(1);
        assertFalse(list.contains(2));
    }

    @DisplayName("test contains returns false on empty list")
    @Test
    void testContainsReturnFalseOnEmptyList() {
        assertFalse(list.contains("a"));
    }

    @DisplayName("test contains for a null value")
    @Test
    void testContainsForNullValue() {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertFalse(list.contains(null));
        list.add(null);
        assertTrue(list.contains(null));
    }

    @DisplayName("test toString on empty list")
    @Test
    void testToStringOnEmptyList() {
        assertEquals("[]", list.toString());
    }

    @DisplayName("test toString on list with data")
    @Test
    void testToStringOnListWithData() {
        list.add("a");
        list.add("b");
        assertEquals("[a, b]", list.toString());
        list.remove(0);
        assertEquals("[b]", list.toString());
        list.add("c", 0);
        list.add("d", 1);
        assertEquals("[c, d, b]", list.toString());
        list.remove(0);
        assertEquals("[d, b]", list.toString());
    }

    @DisplayName("test toString on list after remove all data")
    @Test
    void testToStringOnListAfterRemoveAllData() {
        list.add("a");
        list.add("b");
        assertEquals("[a, b]", list.toString());
        list.remove(1);
        assertEquals("[a]", list.toString());
        list.remove(0);
        assertEquals("[]", list.toString());
    }

    @DisplayName("test toString on list after clear")
    @Test
    void testToStringOnListAfterClear() {
        list.add("a");
        assertEquals("[a]", list.toString());
        list.clear();
        assertEquals("[]", list.toString());
    }

    @DisplayName("test indexOf works correctly")
    @Test
    void testIndexOfWorkCorrectly() {
        assertEquals(-1, list.indexOf("c"));
        list.add("a");
        list.add("b");
        assertEquals(-1, list.indexOf("c"));
        list.add(null, 0);
        assertEquals(1, list.indexOf("a"));
    }

    @DisplayName("test lastIndexOf works correctly")
    @Test
    void testLastIndexOfWorkCorrectly() {
        assertEquals(-1, list.indexOf("c"));
        list.add("a");
        assertEquals(-1, list.lastIndexOf("b"));
        list.add("b");
        list.add("b");
        assertEquals(2, list.lastIndexOf("b"));
    }

    @DisplayName("test indexOf for a null value")
    @Test
    void testIndexOfForNullValue() {
        list.add("a");
        list.add("b");
        assertEquals(-1, list.indexOf(null));
        list.add(null);
        assertEquals(2, list.indexOf(null));
    }

    @DisplayName("test lastIndexOf for a null value")
    @Test
    void testLastIndexOfForNullValue() {
        list.add("a");
        assertEquals(-1, list.lastIndexOf(null));
        list.add(null);
        list.add("b");
        list.add(null);
        assertEquals(3, list.lastIndexOf(null));
    }


}
