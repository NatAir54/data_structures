package com.studying.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleArrayList<T> extends AbstractList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;


    public SimpleArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid capacity : " + initialCapacity);
        }
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T value, int index) {
        checkIndexForAdd(index);
        if (size == array.length) {
            increaseCapacity();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedValue = array[index];
        if (index != size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        array[size - 1] = null;
        size--;
        return removedValue;
    }

    @Override
    public T set(T newValue, int index) {
        checkIndex(index);
        T oldValue = array[index];
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
    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    int getCapacity() {
        return array.length;
    }

    private void increaseCapacity() {
        T[] newArray = (T[]) new Object[array.length * 3 / 2 + 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index %d is out of bounds [0, %d) : " + index + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index %d is out of bounds [0, %d] : " + index + size);
        }
    }

    @Override
    public MyIterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int index = 0;
        private boolean allowedToRemove;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no element to iterate.");
            }
            allowedToRemove = true;
            return array[index++];
        }

        @Override
        public void remove() {
            if (!allowedToRemove) {
                throw new IllegalStateException("This element has been removed already.");
            }
            SimpleArrayList.this.remove(index - 1);
            allowedToRemove = false;
            index--;
        }
    }

}
