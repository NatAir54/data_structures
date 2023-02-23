package com.studying.data_structures.stack;

import java.util.Arrays;

public class ArrayStack implements Stack{
    private int nItems;
    private Object[] array;

    public ArrayStack() {
        array = new Object[10];
    }

    public ArrayStack(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void push(Object value) {
        increaseCapacity();
        array[nItems] = value;
        nItems++;
    }

    private void increaseCapacity() {
        if (nItems == array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public Object peek() {
        if (nItems == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[nItems - 1];
    }

    @Override
    public Object pop() {
        if (nItems == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Object deletedValue = array[nItems - 1];
        nItems--;
        return deletedValue;
    }

    @Override
    public int size() {
        return nItems;
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) {
            for (int i = 0; i < nItems; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < nItems; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (nItems == 0);
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        nItems = 0;
    }
}
