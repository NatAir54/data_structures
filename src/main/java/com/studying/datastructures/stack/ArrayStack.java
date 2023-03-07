package com.studying.datastructures.stack;

import com.studying.datastructures.list.SimpleArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayStack implements Stack, Iterable {
    private int size;
    private Object[] array;

    public ArrayStack() {
        array = new Object[10];
    }

    public ArrayStack(int initialCapacity) {
        if (initialCapacity > 0) {
            array = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            array = new Object[10];
        } else {
            throw new IllegalArgumentException("Illegal Argument: " + initialCapacity);
        }
    }

    int getCapacity() {
        return array.length;
    }

    @Override
    public void push(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("IllegalArgument: " + null);
        }
        increaseCapacity();
        array[size] = value;
        size++;
    }

    private void increaseCapacity() {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[size - 1];
    }

    @Override
    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Object deletedValue = array[size - 1];
        size--;
        return deletedValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("IllegalArgument: " + null);
        }
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public Iterator iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            return array[index++];
        }
    }
}
