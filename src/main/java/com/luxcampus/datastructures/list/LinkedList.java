package com.luxcampus.datastructures.list;


import java.util.Objects;
import java.util.StringJoiner;

class LinkedList implements List {

        Node head;
        Node tail;
        int size;

        LinkedList(){
        }

        LinkedList(int initialCapacity){
            this.size = initialCapacity;
        }

        @Override
        public void add(Object value) {
            Node temp = new Node(value);
            if (size == 0) {
                head = tail = temp;
            }else {
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
                size++;
        }

        @Override
        public void add(Object value, int index) {
            boundsCheck(index);
            Node newNode = new Node(value);
                if (size == 0 ||index == size - 1) {
                add(value);
                return;
            } else if (index == 0) {
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            }else  if(index > 0 && index < size){
                Node temp = head;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                newNode.prev = temp.prev;
                temp.prev = newNode;
                newNode.next =  temp;
                Node temp2 = newNode.prev;
                temp2.next = newNode;
            }

            size++;
        }

        @Override
        public Object remove(int index) {
            boundsCheck(index);
            Node result = head;
            if(index == 0){
                head = head.next;
                result.next = null;
                result.prev = null;
                head.prev = null;
                size--;
                return result.value;
            }else if(index == size - 1){
                result = tail;
                tail = tail.prev;
                size--;
                return result;
            }
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            Node temp = result.prev;
            temp.next = result.next;
            temp.next.prev = result.prev;
            result.prev = null;
            result.next = null;
            size--;
            return result.value;
        }

        @Override
        public Object get(int index) {
            boundsCheck(index);
            if(index == 0){
                return head.value;
            }else if(index == size-1){
                return tail.value;
            }
            Node temp = head.next;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            return temp.value;

        }

        @Override
        public Object set(Object value, int index) {
            boundsCheck(index);
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node result = new Node(temp.value);
            temp.value = value;
            return result.value;
        }

        @Override
        public void clear() {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                temp.value = null;
                temp = temp.next;
            }
            size = 0;
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
            return indexOf(value) != -1;
        }

        @Override
        public int indexOf(Object value) {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (Objects.equals(temp.value, value)) {
                    return i;
                }
                temp = temp.next;
            }
                return -1;
        }

        @Override
        public int lastIndexOf(Object value) {
                Node temp = tail;
                for (int i = size-1; i >= 0; i--) {
                    if(Objects.equals(temp.value, value)){
                        return i;
                    }
                    temp = temp.prev;
                }
            return -1;
        }

    @Override
    public String toString() {
            Node temp = head;
        StringJoiner stringJoiner = new StringJoiner(", ", "( ", ")");
        for (int i = 0; i < size; i++) {
            if(temp.value == null){
                stringJoiner.add("null");
            }
            stringJoiner.add(temp.value.toString());
        }
        return stringJoiner.toString();
    }

    void boundsCheck(int index){
            if(index >= size || index < 0){
                throw new IndexOutOfBoundsException("Index " + index +" is out of bounds for size " + size);
            }
        }

    }

