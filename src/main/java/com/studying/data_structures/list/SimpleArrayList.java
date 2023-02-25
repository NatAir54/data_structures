package com.studying.data_structures.list;

import java.util.StringJoiner;

public class SimpleArrayList implements List {
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private Object[] array;
    private int nItems;


    public SimpleArrayList() {
        capacity = DEFAULT_CAPACITY;
        array = new Object[capacity];
    }


    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            capacity = initialCapacity;
            array = new Object[capacity];
        } else if (initialCapacity == 0) {
            capacity = DEFAULT_CAPACITY;
            array = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal Argument: " + initialCapacity);
        }
    }

    @Override
    public void add(Object value) {
        add(value, nItems);
    }

    int getCapacity() {
        return capacity;
    }

    private void increaseCapacity() {
        capacity = (capacity * 3 / 2) + 1;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < nItems; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = newArray;
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > nItems) {
            throw new IndexOutOfBoundsException();
        }
        if (nItems + 1 == capacity) {
            increaseCapacity();
        }
        System.arraycopy(array, index, array, index + 1, nItems - index);
        array[index] = value;
        ++nItems;
    }

    @Override
    public Object remove(int index) {
        if (nItems == 0 || index < 0 || index >= nItems) {
            throw new IndexOutOfBoundsException();
        }
        Object removedValue = array[index];
        if (index == nItems - 1) {
            array[--nItems] = null;
            return removedValue;
        }
        System.arraycopy(array, index + 1, array, index, nItems - index - 1);
        array[--nItems] = null;
        return removedValue;
    }

    @Override
    public Object get(int index) {
        if (nItems == 0 || index < 0 || index >= nItems) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public Object set(Object newValue, int index) {
        if (nItems == 0 || index >= nItems || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object oldValue = array[index];
        array[index] = newValue;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < nItems; i++) {
            array[i] = null;
        }
        nItems = 0;
    }

    @Override
    public int size() {
        return nItems;
    }

    @Override
    public boolean isEmpty() {
        return (nItems == 0);
    }

    @Override
    public boolean contains(Object value) {
        return (indexOf(value) >= 0);
    }

    @Override
    public int indexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < nItems; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
            return -1;
        } else {
            for (int i = 0; i < nItems; i++) {
                if (value.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = nItems - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
            return -1;
        } else {
            for (int i = nItems - 1; i >= 0; i--) {
                if (value.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < nItems; i++) {
            result.add(array[i].toString());
        }
        return result.toString();
    }
}
