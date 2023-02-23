package com.studying.data_structures.queue;

// FIFO
public interface Queue {
    // put a value
    void enqueue(Object value);

    // remove a value form the beginning and return it
    Object dequeue();

    Object peek();

    int size();

    boolean isEmpty();

    boolean contains(Object value);

    void clear();

    // [A, B, C] if size = 3
    String toString();
}
