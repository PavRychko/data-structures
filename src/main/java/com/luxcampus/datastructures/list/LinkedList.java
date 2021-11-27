package com.luxcampus.datastructures.list;


import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

class LinkedList<T> implements List<T> {

    Node<T> head;
    Node<T> tail;
    int size;


    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        boundsCheck(index);
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
        } else if (index > 0 && index < size) {
            Node<T> temp = getNode(index);
            newNode.prev = temp.prev;
            temp.prev = newNode;
            newNode.next = temp;
            Node<T> temp2 = newNode.prev;
            temp2.next = newNode;
        }
        size++;
    }


    @Override
    public T remove(int index) {
        sizeCheck(index);
        boundsCheck(index);
        Node<T> result = head;
        if (index == 0) {
            head = head.next;
            result.next = null;
            result.prev = null;
            head.prev = null;
        } else if (index == size) {
            result = tail;
            tail = tail.prev;
            result.prev = null;
        } else {
            result = getNode(index);
            Node<T> temp = result.prev;
            temp.next = result.next;
            temp.next.prev = result.prev;
            result.prev = null;
            result.next = null;
        }
        size--;
        return result.value;
    }


    @Override
    public T get(int index) {
        sizeCheck(index);
        boundsCheck(index);
        if (index == 0) {
            return head.value;
        } else if (index == size-1) {
            return tail.value;
        }
        return getNode(index).value;

    }

    @Override
    public T set(T value, int index) {
        sizeCheck(index);
        boundsCheck(index);
        Node<T> temp = getNode(index);
        Node<T> result = new Node<>(temp.value);
        temp.value = value;
        return result.value;
    }

    @Override
    public void clear() {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            temp.value = null;
            temp = temp.next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !(size > 0);
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(temp.value, value)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        Node<T> temp = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(temp.value, value)) {
                return i;
            }
            temp = temp.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        StringJoiner stringJoiner = new StringJoiner(", ", "( ", ")");
        for (int i = 0; i < size; i++) {
            if (temp.value == null) {
                stringJoiner.add("null");
            }
            stringJoiner.add(temp.value.toString());
        }
        return stringJoiner.toString();
    }

    void boundsCheck(int index) {
        if (index > size || index < 0 ) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + size);
        }
    }
    void sizeCheck(int index){
        if(size == 0 || index == size){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + size);
        }
    }

    private Node<T> getNode(int index) {
        boundsCheck(index);
        return index > size / 2 ? getNodeFromTail(index) : getNodeFromHead(index);
    }

    private Node<T> getNodeFromHead(int index) {
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = head.next;
        }
        return temp;
    }

    private Node<T> getNodeFromTail(int index) {
        Node<T> temp = tail;
        for (int i = index; i > 0; i--) {
            temp = tail.prev;
        }
        return temp;
    }

    static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    private class ListIterator<T> implements Iterator<T> {
        Node<T> current = (Node<T>) head;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                current = current.next;
                return current.value;
            }
            return null;
        }


    }

}

