package com.luxcampus.datastructures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {


    @Test
    public void enqueueDequeueSizeAndIsEmptyTest(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("one");
        arrayQueue.enqueue("two");

        assertEquals(2, arrayQueue.size());
        assertFalse(arrayQueue.isEmpty());
        assertEquals("one", arrayQueue.dequeue());
        assertEquals("two", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());

    }

    @Test
    public void enqueuePeekSizeAndIsEmptyTest(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("one");
        arrayQueue.enqueue("two");

        assertEquals(2, arrayQueue.size());
        assertEquals("one", arrayQueue.peek());
        assertEquals("one", arrayQueue.peek());
        assertEquals(2, arrayQueue.size());
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    public void containsTest(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("one");
        arrayQueue.enqueue("two");

        assertTrue(arrayQueue.contains("two"));
        assertFalse(arrayQueue.contains("three"));
    }

    @Test
    public void clearTest(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("one");
        arrayQueue.enqueue("two");

        assertFalse(arrayQueue.isEmpty());
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void toStringTest(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("one");
        arrayQueue.enqueue("two");

        assertEquals("[one, two]", arrayQueue.toString());

    }

    @Test
    public void queueThrowsExceptionWhenDequeueOnEmptyTest(){
        ArrayQueue arrayQueue = new ArrayQueue();

       Exception exception =  assertThrows(IllegalStateException.class, arrayQueue::dequeue);
       String expectedMessage = "Queue is empty!";
       String actualMessage = exception.getMessage();
       assertTrue(expectedMessage.contains(actualMessage));
    }

    @Test
    public void sizeIncrementationTest() throws IllegalAccessException {
        ArrayQueue arrayQueue = new ArrayQueue();
        int initialSize = 2;
        arrayQueue.setInitialSize((2));

        arrayQueue.enqueue("One");
        arrayQueue.enqueue("two");
        arrayQueue.enqueue("three");

        assertTrue(arrayQueue.size() > initialSize);
    }



}
