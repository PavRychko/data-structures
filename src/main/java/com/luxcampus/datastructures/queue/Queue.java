package com.luxcampus.datastructures.queue;

public interface Queue {

    void enqueue(Object o);

    Object dequeue();

    Object peek();

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    void clear();

    String toString();
}
