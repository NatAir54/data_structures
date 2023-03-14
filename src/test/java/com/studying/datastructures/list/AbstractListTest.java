package com.studying.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractListTest {
    private List<Integer> list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List<Integer> getList();

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
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.get(0));
        list.add(2);
        list.add(3);
        assertEquals(3, list.get(2));
        assertEquals(3, list.size());
    }

    @DisplayName("simple test: fill the whole list and remove all the items in foreach, repeat")
    @Test
    void testAddRemove() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer item : list) {
            list.remove(0);
        }
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer item : list) {
            list.remove(0);
        }
    }

    @DisplayName("test add element by index and get work correctly and change size")
    @Test
    void testAddElementByIndexAndGetWorkCorrectlyAndChangeSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(100, 2);
        assertEquals(3, list.get(3));
        list.add(200, 0);
        assertEquals(1, list.get(1));
        assertEquals(5, list.size());
        list.add(300, 5);
        assertEquals(300, list.get(5));
        assertEquals(6, list.size());
    }

    @DisplayName("test add element by index throws IndexOutOfBoundsException when index is bigger than size")
    @Test
    void testAddElementByIndexThrowIndexOutOfBoundsExceptionWhenIndexIsBiggerThanSize() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 3));
    }

    @DisplayName("test add element by index throws IndexOutOfBoundsException when index is negative")
    @Test
    void testAddElementByIndexThrowIndexOutOfBoundsExceptionWhenIndexIsNegative() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, -1));
    }

    @DisplayName("test remove throws IndexOutOfBoundsException on empty list")
    @Test
    void testRemoveElementByIndexThrowIndexOutOfBoundsExceptionOnEmptyList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @DisplayName("test remove throws IndexOutOfBoundsException when index is bigger than size")
    @Test
    void testRemoveElementByIndexThrowIndexOutOfBoundsExceptionWhenIndexIsBiggerThanSize() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }

    @DisplayName("test remove throws IndexOutOfBoundsException when index equals size")
    @Test
    void testRemoveElementByIndexThrowIndexOutOfBoundsExceptionWhenIndexEqualsSize() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }

    @DisplayName("test remove throws IndexOutOfBoundsException when index is negative")
    @Test
    void testRemoveElementByIndexThrowIndexOutOfBoundsExceptionWhenIndexIsNegative() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
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

    @DisplayName("test set throws IndexOutOfBoundsException on empty list")
    @Test
    void testSetThrowIndexOutOfBoundsExceptionOnEmptyList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 0));
    }

    @DisplayName("test set throws IndexOutOfBoundsException when index is bigger than size")
    @Test
    void testSetThrowIndexOutOfBoundsExceptionWhenIndexIsBiggerThanSize() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, 3));
    }

    @DisplayName("test set throws IndexOutOfBoundsException when index equals size")
    @Test
    void testSetThrowIndexOutOfBoundsExceptionWhenIndexEqualsSize() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, 2));
    }

    @DisplayName("test set throws IndexOutOfBoundsException when index is negative")
    @Test
    void testSetThrowIndexOutOfBoundsExceptionWhenIndexIsNegative() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, -1));
    }

    @DisplayName("test get throws IndexOutOfBoundsException on empty list")
    @Test
    void testGetThrowIndexOutOfBoundsExceptionOnEmptyList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @DisplayName("test get throws IndexOutOfBoundsException when index is bigger than size")
    @Test
    void testGetThrowIndexOutOfBoundsExceptionWhenIndexIsBiggerThanSize() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @DisplayName("test get throws IndexOutOfBoundsException when index equals size")
    @Test
    void testGetThrowIndexOutOfBoundsExceptionWhenIndexEqualsSize() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @DisplayName("test get throws IndexOutOfBoundsException when index is negative")
    @Test
    void testGetThrowIndexOutOfBoundsExceptionWhenIndexIsNegative() {
        list.add(1);
        list.add(2);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-2));
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
        assertFalse(list.contains(10));
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
        list.add(1);
        list.add(2);
        assertEquals("[1, 2]", list.toString());
        list.remove(0);
        assertEquals("[2]", list.toString());
        list.add(10, 0);
        list.add(20, 1);
        assertEquals("[10, 20, 2]", list.toString());
        list.remove(0);
        assertEquals("[20, 2]", list.toString());
    }

    @DisplayName("test toString on list after remove all data")
    @Test
    void testToStringOnListAfterRemoveAllData() {
        list.add(1);
        list.add(2);
        assertEquals("[1, 2]", list.toString());
        list.remove(1);
        assertEquals("[1]", list.toString());
        list.remove(0);
        assertEquals("[]", list.toString());
    }

    @DisplayName("test toString on list after clear")
    @Test
    void testToStringOnListAfterClear() {
        list.add(1);
        assertEquals("[1]", list.toString());
        list.clear();
        assertEquals("[]", list.toString());
    }

    @DisplayName("test indexOf works correctly")
    @Test
    void testIndexOfWorkCorrectly() {
        assertEquals(-1, list.indexOf(10));
        list.add(1);
        list.add(2);
        assertEquals(-1, list.indexOf(10));
        list.add(null, 0);
        assertEquals(1, list.indexOf(1));
    }

    @DisplayName("test lastIndexOf works correctly")
    @Test
    void testLastIndexOfWorkCorrectly() {
        assertEquals(-1, list.indexOf(10));
        list.add(1);
        assertEquals(-1, list.lastIndexOf(2));
        list.add(2);
        list.add(2);
        assertEquals(2, list.lastIndexOf(2));
    }

    @DisplayName("test indexOf for a null value")
    @Test
    void testIndexOfForNullValue() {
        list.add(1);
        list.add(2);
        assertEquals(-1, list.indexOf(null));
        list.add(null);
        assertEquals(2, list.indexOf(null));
    }

    @DisplayName("test lastIndexOf for a null value")
    @Test
    void testLastIndexOfForNullValue() {
        list.add(1);
        assertEquals(-1, list.lastIndexOf(null));
        list.add(null);
        list.add(2);
        list.add(null);
        assertEquals(3, list.lastIndexOf(null));
    }

    @DisplayName("test iterator")
    @Test
    void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer item: list) {
            System.out.print(item + " ");
        }
    }

    @DisplayName("test iterator next throw NoSuchElementException on empty list")
    @Test
    void testIteratorNextThrowNoSuchElementExceptionOnEmptyList() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Iterator<Integer> iterator = list.iterator();
            iterator.next();
        });
    }

    @DisplayName("test iterator remove works correctly")
    @Test
    void testIteratorRemoveWorksCorrectly() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.add(1);
            list.add(2);
            list.add(3);
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.remove();
            }
            assertEquals(0, list.size());
            assertTrue(list.isEmpty());
        });
    }

    @DisplayName("test iterator remove throw IllegalStateException on empty list")
    @Test
    void testIteratorRemoveThrowIllegalStateExceptionOnEmptyList() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            Iterator<Integer> iterator = list.iterator();
            iterator.remove();
        });
    }

    @DisplayName("test iterator remove throw IllegalStateException if next() hasn't been called yet")
    @Test
    void testIteratorRemoveThrowIllegalStateExceptionIfNextHasNotBeenCalledYet() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.add(1);
            Iterator<Integer> iterator = list.iterator();
            iterator.remove();
        });
    }

    @DisplayName("test iterator remove throw IllegalStateException if remove() has already been called after the last call to the next method")
    @Test
    void testIteratorRemoveThrowIllegalStateExceptionIfRemoveHasAlreadyBeenCalledAfterLastCallOfNext() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            list.add(1);
            list.add(2);
            Iterator<Integer> iterator = list.iterator();
            iterator.next();
            iterator.remove();
            iterator.remove();
        });
    }
}
