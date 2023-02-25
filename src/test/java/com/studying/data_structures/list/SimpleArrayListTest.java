package com.studying.data_structures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleArrayListTest {
    @DisplayName("test add element to the end of list works correctly and changes size")
    @Test
    void addElementToTheEndOfListAndRemoveWorksCorrectlyAndChangesSize() {
        SimpleArrayList list = new SimpleArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals(3, list.remove(2));
        assertEquals(2, list.size());
        assertEquals(1, list.remove(0));
        assertEquals(2, list.remove(0));
        assertTrue(list.isEmpty());
    }

    @DisplayName("simple test: fill the whole list and remove all the items, repeat")
    @Test
    void testAddRemovePrint() {
        SimpleArrayList list = new SimpleArrayList();
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

    @DisplayName("test add element by index works correctly and changes size")
    @Test
    void addElementByIndexWorksCorrectlyAndChangesSize() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("x", 2);
        assertEquals("c", list.get(3));
        list.add("y", 0);
        assertEquals("a", list.get(1));
        assertEquals(5, list.size());
        list.add("z", 5);
        assertEquals("z", list.get(5));
        assertEquals(6, list.size());

    }

    @DisplayName("test add element by index throws IndexOutOfBoundsException")
    @Test
    void addElementByIndexThrowIndexOutOfBoundsException() {
        SimpleArrayList list = new SimpleArrayList();
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
    void removeElementByIndexThrowIndexOutOfBoundsException() {
        SimpleArrayList list = new SimpleArrayList();
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
    void testGetAndSetWorksCorrectly() {
        SimpleArrayList list = new SimpleArrayList();
        list.add(1);
        list.add(2);
        assertEquals(2, list.get(1));
        assertEquals(2, list.set(3, 1));
        assertEquals(1, list.set(4, 0));
        assertEquals("[4, 3]", list.toString());
    }

    @DisplayName("test set throws IndexOutOfBoundsException")
    @Test
    void testSetThrowIndexOutOfBoundsException() {
        SimpleArrayList list = new SimpleArrayList();
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
        SimpleArrayList list = new SimpleArrayList();
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
        SimpleArrayList list = new SimpleArrayList();
        assertTrue(list.isEmpty());
    }

    @DisplayName("test isEmpty returns false on the list with data")
    @Test
    void testIsEmptyReturnFalseOnListWithData() {
        SimpleArrayList list = new SimpleArrayList();
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @DisplayName("test isEmpty returns true on the list after clear")
    @Test
    void testIsEmptyReturnTrueOnListAfterClear() {
        SimpleArrayList list = new SimpleArrayList();
        list.add(1);
        list.add(2);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @DisplayName("test contains returns true")
    @Test
    void testContainsReturnTrue() {
        SimpleArrayList list = new SimpleArrayList();
        list.add(1);
        list.add(2);
        assertTrue(list.contains(2));
    }

    @DisplayName("test contains returns false")
    @Test
    void testContainsReturnFalse() {
        SimpleArrayList list = new SimpleArrayList();
        list.add(1);
        list.add(2);
        list.remove(1);
        assertFalse(list.contains(2));
    }

    @DisplayName("test contains for a null value")
    @Test
    void testContainsForNullValue() {
        SimpleArrayList list = new SimpleArrayList();
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
        SimpleArrayList list = new SimpleArrayList();
        assertEquals("[]", list.toString());
    }

    @DisplayName("test toString on list with data")
    @Test
    void testToStringOnListWithData() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        list.add("b");
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
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        list.add("b");
        list.remove(0);
        list.remove(0);
        list.isEmpty();
        assertEquals("[]", list.toString());
    }

    @DisplayName("test toString on list after clear")
    @Test
    void testToStringOnListAfterClear() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        list.add("b");
        list.clear();
        assertEquals("[]", list.toString());
    }

    @DisplayName("test indexOf works correctly")
    @Test
    void testIndexOfWorksCorrectly() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        list.add("b");
        assertEquals(-1, list.indexOf("c"));
        list.add(null, 0);
        assertEquals(1, list.indexOf("a"));
    }

    @DisplayName("test lastIndexOf works correctly")
    @Test
    void testLastIndexOfWorksCorrectly() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        assertEquals(-1, list.lastIndexOf("b"));
        list.add("b");
        list.add("b");
        assertEquals(2, list.lastIndexOf("b"));
    }

    @DisplayName("test indexOf for a null value")
    @Test
    void testIndexOfForNullValue() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        list.add("b");
        assertEquals(-1, list.indexOf(null));
        list.add(null);
        assertEquals(2, list.indexOf(null));
    }

    @DisplayName("test lastIndexOf for a null value")
    @Test
    void testLastIndexOfForNullValue() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        assertEquals(-1, list.lastIndexOf(null));
        list.add(null);
        list.add("b");
        list.add(null);
        assertEquals(3, list.lastIndexOf(null));
    }

    @DisplayName("test increaseCapacity works correctly for both constructors")
    @Test
    void testIncreaseCapacityWorksCorrectly() throws NoSuchFieldException, IllegalAccessException {
        SimpleArrayList list = new SimpleArrayList();
        list.add("a");
        list.add("b");
        assertEquals(10, list.getCapacity());
        list.clear();
        assertEquals(10, list.getCapacity());

        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        assertEquals(16, list.getCapacity());
        SimpleArrayList list2 = new SimpleArrayList(16);
        for (int i = 0; i < 17; i++) {
            list2.add(i, 0);
        }
        assertEquals(25, list2.getCapacity());
    }

    @DisplayName("test constructor with initial capacity throw IllegalArgumentException")
    @Test
    void testConstructorWithInitialCapacityThrowIllegalArgumentException() {
        SimpleArrayList list = new SimpleArrayList(0);
        list.add("a");
        list.add("b");
        assertEquals(10, list.getCapacity());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SimpleArrayList(-1);
        });
    }
}