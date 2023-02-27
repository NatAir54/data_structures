package com.studying.datastructures.list;

import com.studying.datastructures.stack.Stack;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class SimpleLinkedList implements List, Stack {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Illegal argument: " + index);
        }
        Node node = new Node(value);
        if(size == 0) {
            head = tail = node;
        } else if (index == size) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else if (index == 0){
            head.prev = node;
            node.next = head;
            head = node;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node temp = current.prev;
            temp.next = node;
            node.prev = temp;
            node.next = current;
            current.prev = node;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        if(size == 0) {
            throw new IllegalStateException("LinkedList is empty");
        }
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Illegal argument: " + index);
        }
        return getByIndex(head, index);
    }

    private Object getByIndex(Node head, int index) {
        Node current = head;
        if (index == 0) {
            return head.value;
        } else if (index == size - 1) {
            return tail.value;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        return current.value;
    }

    @Override
    public Object remove(int index) {
        if (size == 0) {
                throw new IllegalStateException("LinkedList is empty!");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node temp = head;
            head = temp.next;
            size--;
            return temp.value;
        } else if (index == size - 1) {
            Node temp = tail;
            tail = temp.prev;
            tail.next = null;
            size--;
            return temp.value;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node temp = current.prev;
        Node temp2 = current.next;
        temp.next = temp2;
        temp2.prev = temp;
        size--;
        return current.value;
    }

    @Override
    public Object set(Object value, int index) {
        if (size == 0) {
            throw new IllegalStateException("LinkedList is empty!");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node node = new Node(value);
        if (index == 0) {
            Node temp = head;
            Node temp2 = head.next;
            head = node;
            temp2.prev = head;
            head.next = temp.next;
            return temp.value;
        } else if (index == size - 1) {
            Node temp = tail;
            Node temp2 = temp.prev;
            tail = node;
            tail.prev = temp2;
            temp2.next = tail;
            return temp.value;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node temp = current;
        Node temp2 = current.prev;
        Node temp3 = current.next;
        current = node;
        current.prev = temp2;
        current.next = temp3;
        temp2.next = current;
        temp3.prev = current;
        return temp.value;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public void push(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("LinkedList is empty!");
        }
        return head.value;
    }

    @Override
    public Object pop() {
        Node deleted = head;
        if (size == 0) {
            throw new NoSuchElementException("LinkedList is empty!");
        }else if (size == 1) {
            head = tail = null;
            size--;
            return deleted.value;
        } else if (size == 2) {
            head = tail;
            head.prev = null;
            size--;
            return deleted.value;
        }
        Node temp = deleted.next;
        Node temp1 = temp.next;
        head = temp;
        head.prev = null;
        head.next = temp1;
        temp1.prev = head;
        size--;
        return deleted.value;
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

}

