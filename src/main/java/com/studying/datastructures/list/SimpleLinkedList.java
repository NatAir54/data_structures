package com.studying.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleLinkedList<T> extends AbstractList<T>{
    private Node<T> head;
    private Node<T> tail;


    @Override
    public void add(T value, int index) {
        checkIndexForAdd(index);
        Node<T> newNode = new Node<>(value);
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
            Node<T> current = getNode(index);
            Node<T> temp = current.prev;
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        Node<T> nodeToRemove;
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
            Node<T> temp = nodeToRemove.prev;
            Node<T> temp2 = nodeToRemove.next;
            temp.next = temp2;
            temp2.prev = temp;
        }
        size--;
        return nodeToRemove.value;
    }

    @Override
    public T set(T value, int index) {
        checkIndex(index);
        Node<T> current = getNode(index);
        T oldValue = current.value;
        current.value = value;
        return oldValue;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        Node<T> current = head;
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
    public int lastIndexOf(T value) {
        Node<T> current = tail;
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

    private Node<T> getNode(int index) {
        Node<T> current;
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

    private static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T value;

        private Node(T value) {
            this.value = value;
        }
    }

    @Override
    public MyIterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int index = 0;
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no element to iterate.");
            }
            T value = current.value;
            current = current.next;
            index++;
            return value;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

}

