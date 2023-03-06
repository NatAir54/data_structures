package com.studying.datastructures.list;

import java.util.Objects;
import java.util.StringJoiner;

public class SimpleLinkedList implements List{
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        checkIndexForAdd(index);
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node current = getNode(index);
            Node temp = current.prev;
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.value;
        }
        if (index == size - 1) {
            return tail.value;
        }
        return getNode(index).value;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Node nodeToRemove;
        if (size == 1) {
            nodeToRemove = head;
            head = tail = null;
        } else if (index == 0) {
            nodeToRemove = head;
            head = nodeToRemove.next;
            head.prev = null;
        } else if (index == size - 1) {
            nodeToRemove = tail;
            tail = nodeToRemove.prev;
            tail.next = null;
        } else {
            nodeToRemove = getNode(index);
            Node temp = nodeToRemove.prev;
            Node temp2 = nodeToRemove.next;
            temp.next = temp2;
            temp2.prev = temp;
        }
        size--;
        return nodeToRemove.value;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndex(index);
        Node current = getNode(index);
        Object oldValue = current.value;
        current.value = value;
        return oldValue;
    }

    @Override
    public void clear() {
        head = null;
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
    public int indexOf(Object value) {
        Node current = head;
        int index = -1;
        while (current != null) {
            ++index;
            if (Objects.equals(current.value, value)) {
                return index;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return index;
            }
            index--;
            current = current.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current != null) {
            result.add(String.valueOf(current.value));
            current = current.next;
        }
        return result.toString();
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

    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private static class Node {
        private Node next;
        private Node prev;
        private Object value;

        private Node(Object value) {
            this.value = value;
        }
    }

}

