package com.luxcampus.datastructures.queue;

public class ArrayQueue implements Queue {
     int size;
     Object[] array;

     ArrayQueue(){
         this.array = new Object[10];
     }

    @Override
    public void enqueue(Object object) {
         if(size == array.length){
             Object[] array2 = new Object[(int) (array.length * 1.5)];
             for (int i = 0; i < array.length; i++) {
                 array2[i] = array[i];
             }
             array = array2;
         }
        this.array[size] = object;
         size++;

    }

    @Override
    public Object dequeue() {
         if(size == 0){
             throw new IllegalStateException("Queue is empty!");
         }
        Object deqObject = this.array[0];
        for (int i = 0; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return deqObject;
    }

    @Override
    public Object peek() {
        return array[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        };
        return false;
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < array.length; i++) {
            if(object.equals(array[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
         size = 0;
         array = null;

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if(i == size-1){
                result.append(array[i].toString()).append("]");
                continue;
            }
            result.append(array[i].toString()).append(", ");
        }
        return result.toString();
    }
    public void setInitialSize(int size){
         array = new Object[size];
    }
}
