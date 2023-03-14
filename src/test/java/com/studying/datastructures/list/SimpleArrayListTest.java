package com.studying.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleArrayListTest extends AbstractListTest {
    @Override
    protected List<Integer> getList() {
        return new SimpleArrayList<>();
    }


    @DisplayName("test constructor with default capacity work correctly")
    @Test
    void testConstructorWithDefaultCapacityWorkCorrectly() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("a");
        list.add("b");
        assertEquals(10, list.getCapacity());
        list.clear();
        assertEquals(10, list.getCapacity());
    }

    @DisplayName("test constructor with initial capacity work correctly")
    @Test
    void testConstructorWithInitialCapacityWorkCorrectly() {
        SimpleArrayList<String> list = new SimpleArrayList<>(16);
        list.add("a");
        list.add("b");
        assertEquals(16, list.getCapacity());
    }

    @DisplayName("test constructor with initial capacity throw IllegalArgumentException")
    @Test
    void testConstructorWithInitialCapacityThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SimpleArrayList<String>(-1));
    }

    @DisplayName("test increaseCapacity for constructor with default capacity works correctly")
    @Test
    void testIncreaseCapacityForConstructorWithDefaultCapacityWorkCorrectly() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add("q");
        }
        assertEquals(16, list.getCapacity());
    }

    @DisplayName("test increaseCapacity for constructor with initial capacity works correctly")
    @Test
    void testIncreaseCapacityForConstructorWithInitialCapacityWorkCorrectly() {
        SimpleArrayList<String> list = new SimpleArrayList<>(16);
        for (int i = 0; i < 17; i++) {
            list.add("x", 0);
        }
        assertEquals(25, list.getCapacity());
    }

    @DisplayName("test increase capacity for constructor with zero initial capacity work correctly")
    @Test
    void testIncreaseCapacityForConstructorWithZeroInitialCapacityWorkCorrectly() {
        SimpleArrayList<String> list = new SimpleArrayList<>(0);
        for (int i = 0; i < 3; i++) {
            list.add("a");
        }
        assertEquals(4, list.getCapacity());
    }


}
