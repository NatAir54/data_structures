package com.studying.datastructures.stack;

// LIFO
public interface Stack {
    void push(Object value);

    Object peek();

    Object pop();

    int size();

    boolean contains(Object value);

    boolean isEmpty();

    void clear();
}
