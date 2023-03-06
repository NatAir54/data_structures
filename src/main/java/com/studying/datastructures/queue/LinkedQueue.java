package com.studying.datastructures.queue;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedQueue implements Queue {
    private Node head;
    private int size;

    @Override
    public void enqueue(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("LinkedQueue is empty!");
        }
        Object deleted = head.value;
        head = head.next;
        size--;
        return deleted;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("LinkedQueue is empty!");
        }
        return head.value;
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
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringJoiner result = new StringJoiner(", ", "[", "]");
        Node current = head;
        while(current != null) {
            result.add(String.valueOf(current.value));
            current = current.next;
        }
        return result.toString();
    }

    private static class Node {
        private Object value;
        private Node next;

        private Node(Object value) {
            this.value = value;
        }
    }
}
