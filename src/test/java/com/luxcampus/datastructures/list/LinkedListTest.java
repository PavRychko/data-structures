package com.luxcampus.datastructures.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    
    LinkedList linkedList = new LinkedList();

    @DisplayName("add, get, size and isEmpty test with exceptions")
    @Test
    public void addTest() {
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        assertFalse(linkedList.isEmpty());
        assertEquals(3, linkedList.size());
        assertEquals("1", linkedList.get(0));
        assertEquals("2", linkedList.get(1));
        assertEquals("3", linkedList.get(2));

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
        String expectedMessage = "Index 3 is out of bounds for size 3";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

//    [A, B, C, null, null] size = 3
//    add (D, [0,1,2,3]) => add(F, 4)
//    we can add value by index between [0, size]
//    otherwise throw new IndexOutOfBoundsException
//    void add(Object value, int index);

    @DisplayName("add by index test with exceptions")
    @Test
    public void addByIndexTest(){
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        assertEquals(3, linkedList.size());
        Exception exception = assertThrows(IndexOutOfBoundsException.class,() -> linkedList.add("4", 4));
        String expectedMessage = "Index 4 is out of bounds for size 3";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        linkedList.add("4", 1);
        assertEquals("4", linkedList.get(1));
        assertEquals("3", linkedList.get(3));
        assertEquals(4, linkedList.size());

    }

    // we can remove value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException

    // [A, B, C] remove = 0
    // [B (index = 0) , C (index = 1)]
    // Object remove(int index);

    @DisplayName("remove by index test with exceptions")
    @Test
    public void removeTest(){
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        linkedList.remove(1);
        assertEquals("1", linkedList.get(0));
        assertEquals("3", linkedList.get(1));
        Exception exception = assertThrows(IndexOutOfBoundsException.class,() -> linkedList.get(3));
        String expectedMessage = "Index 3 is out of bounds for size 2";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

    // we can set value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
//    Object set(Object value, int index);
    @DisplayName("set value Test with exceptions")
    @Test
    public void setValueTest(){
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        assertEquals("2", linkedList.set("4", 1));
        assertEquals("4", linkedList.get(1));
        assertEquals(3, linkedList.size());

        Exception exception = assertThrows(IndexOutOfBoundsException.class,() -> linkedList.set("5", 3));
        String expectedMessage = "Index 3 is out of bounds for size 3";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("clear Test with exceptions")
    @Test
    public void clearTest() {
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        assertFalse(linkedList.isEmpty());
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        Exception exception = assertThrows(IndexOutOfBoundsException.class,() -> linkedList.get(0));
        String expectedMessage = "Index 0 is out of bounds for size 0";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("contains test with exceptions")
    @Test
    public void containsTest(){
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        assertFalse(linkedList.contains("11"));
        assertTrue(linkedList.contains("1"));
    }

    // [A, B, A, C] indexOf(A) -> 0
    // -1 if not exist
//    int indexOf(Object value);
    @DisplayName("index of and last index of test with exceptions" )
    @Test
    public void indexOfTest(){
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("2");

        assertEquals(1, linkedList.indexOf("2"));
        assertEquals(3, linkedList.lastIndexOf("2"));
        assertEquals(-1, linkedList.indexOf("4"));
        assertEquals(-1, linkedList.lastIndexOf("4"));

    }

}
