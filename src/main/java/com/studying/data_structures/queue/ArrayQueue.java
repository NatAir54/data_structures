package com.studying.data_structures.queue;

import java.util.Arrays;

public class ArrayQueue implements Queue{
    private int nItems = 0;
    private Object[] array;
    private int front = 0;
    private int rear = -1;

    public ArrayQueue() {
        array = new Object[10];
    }

    public ArrayQueue(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void enqueue(Object value) {
        if (nItems == array.length) {
            throw new IllegalStateException("Queue is full!");
        }
        if (rear == array.length - 1) {
            rear = -1;
        }
        array[++rear] = value;
        nItems++;
    }

    @Override
    public Object dequeue() {
        if (nItems == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object deletedValue = array[front];
        array[front++] = null;
        if (front == array.length) {
            front = 0;
        }
        nItems--;
        return deletedValue;
    }

    @Override
    public Object peek() {
        if (nItems == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[front];
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
        if (value == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        nItems = 0;
    }

    // need to fix?
    @Override
    public String toString() {
        if (nItems == 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("");
        if (front <= rear) {
            for (int i = front; i <= rear; i++) {
                if (i < rear) {
                    result.append(array[i]).append(", ");

                } else {
                    result.append(array[i]);
                }
            }
        } else {
            for (int i = rear; i < array.length; i++) {
                if (i < array.length - 1) {
                    result.append(array[i]).append(", ");
                } else {
                    result.append(array[i]);
                }
            }
        }

        return "[" + result + "]";
    }
}
