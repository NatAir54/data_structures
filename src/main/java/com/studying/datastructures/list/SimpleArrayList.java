package com.studying.datastructures.list;

import java.util.Objects;
import java.util.StringJoiner;

public class SimpleArrayList implements List {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public SimpleArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid capacity : " + initialCapacity);
        }
        array = new Object[initialCapacity];
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        checkIndexForAdd(index);
        if (array.length == 0) {
            increaseCapacity();
        }
        if (size == array.length) {
            increaseCapacity();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        ++size;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object removedValue = array[index];
        if (index == size - 1) {
            array[--size] = null;
            return removedValue;
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removedValue;
    }

    @Override
    public Object set(Object newValue, int index) {
        checkIndex(index);
        Object oldValue = array[index];
        array[index] = newValue;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            result.add(array[i].toString());
        }
        return result.toString();
    }

    int getCapacity() {
        return array.length;
    }

    private void increaseCapacity() {
        Object[] newArray = new Object[array.length * 3/2 + 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal argument: " + index);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Illegal argument: " + index);
        }
    }
}
