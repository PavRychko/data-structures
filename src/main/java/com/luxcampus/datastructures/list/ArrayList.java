package com.luxcampus.datastructures.list;

public class ArrayList implements List {
    private Object[] array;
    private int size ;

    ArrayList(){
        this.array = new Object[10];
    }

    @Override
    public void add(Object value) {
        nullCheck(value);
        arraySizeCheck();
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        boundsCheck(index);
        nullCheck(value);
        arraySizeCheck();
        System.arraycopy(array, index, array, index+1, size);
        array[index] = value;
        size++;

    }

    @Override
    public Object remove(int index) {
        boundsCheck(index);
        Object removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size-1] = null;
        size--;
        return removed;
    }

    @Override
    public Object get(int index) {
        boundsCheck(index);
        if(size == 0){
            throw new NullPointerException("ArrayList is empty!");
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        boundsCheck(index);
        nullCheck(value);
        Object old = array[index];
        Object[] temp = new Object[array.length];
        System.arraycopy(array, 0, temp, 0, size-1);
        temp[index] = value;
        array = temp;
        return old;
    }

    @Override
    public void clear() {
        size = 0;
        array = null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
         return size <= 0;
    }

    @Override
    public boolean contains(Object value) {
        nullCheck(value);
        for (int i = 0; i < size; i++) {
            if(array[i].equals(value)){
                return  true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        nullCheck(value);
        for (int i = 0; i < size; i++) {
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        nullCheck(value);
        for (int i = size-1; i >= 0; i--) {
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
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

    void setInitialSize(int initialSize) {
        if(array == null){
            array = new Object[initialSize];
        }
    }

    void boundsCheck(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index " + index +" is out of bounds for size " + size);
        }
    }

    void nullCheck(Object value){
        if(value == null){
            throw new NullPointerException("you can`t put null as a value!");
        }
    }

    void arraySizeCheck(){
        if(size == array.length){
            Object[] temp = new Object[(int)(array.length * 1.5)];
            System.arraycopy(array, 0, temp, 0, array.length-1);
            array = temp;
        }
    }


}
