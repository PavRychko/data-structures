package com.luxcampus.datastructures.list;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    // add value to the end of the list
    //  void add(Object value);
    @DisplayName("add, get, size and isEmpty test with exceptions")
    @Test
    public void addTest() {
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        assertFalse(arrayList.isEmpty());
        assertEquals(3, arrayList.size());
        assertEquals("1", arrayList.get(0));
        assertEquals("2", arrayList.get(1));
        assertEquals("3", arrayList.get(2));

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(3));
        String expectedMessage = "Index 3 is out of bounds for size 3";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        Exception exception2 = assertThrows(NullPointerException.class,() -> arrayList.add(null));
        String expectedMessage2 = "you can`t put null as a value!";
        String actualMessage2 = exception2.getMessage();
        assertEquals(expectedMessage2, actualMessage2);
    }

//    [A, B, C, null, null] size = 3
//    add (D, [0,1,2,3]) => add(F, 4)
//    we can add value by index between [0, size]
//    otherwise throw new IndexOutOfBoundsException
//    void add(Object value, int index);

    @DisplayName("add by index test with exceptions")
    @Test
    public void addByIndexTest(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        assertEquals(3, arrayList.size());
       Exception exception = assertThrows(IndexOutOfBoundsException.class,() -> arrayList.add("4", 4));
        String expectedMessage = "Index 4 is out of bounds for size 3";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        Exception exception2 = assertThrows(NullPointerException.class,() -> arrayList.add(null, 1));
        String expectedMessage2 = "you can`t put null as a value!";
        String actualMessage2 = exception2.getMessage();
        assertEquals(expectedMessage2, actualMessage2);

        arrayList.add("4", 2);
        assertEquals("4", arrayList.get(2));
        assertEquals("3", arrayList.get(3));
        assertEquals(4, arrayList.size());

    }

    // we can remove value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException

    // [A, B, C] remove = 0
    // [B (index = 0) , C (index = 1)]
    // Object remove(int index);

    @DisplayName("remove by index test with exceptions")
    @Test
    public void removeTest(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        arrayList.remove(1);
        assertEquals("1", arrayList.get(0));
        assertEquals("3", arrayList.get(1));
        Exception exception = assertThrows(IndexOutOfBoundsException.class,() -> arrayList.get(3));
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
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        assertEquals("2", arrayList.set("4", 1));
        assertEquals("4", arrayList.get(1));
        assertEquals(3, arrayList.size());

        Exception exception = assertThrows(IndexOutOfBoundsException.class,() -> arrayList.set("5", 3));
        String expectedMessage = "Index 3 is out of bounds for size 3";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        Exception exception2 = assertThrows(NullPointerException.class,() -> arrayList.set(null, 1));
        String expectedMessage2 = "you can`t put null as a value!";
        String actualMessage2 = exception2.getMessage();
        assertEquals(expectedMessage2, actualMessage2);
    }

    @DisplayName("clear Test with exceptions")
    @Test
public void clearTest() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        assertFalse(arrayList.isEmpty());
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());
        Exception exception = assertThrows(IndexOutOfBoundsException.class,() -> arrayList.get(0));
        String expectedMessage = "Index 0 is out of bounds for size 0";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("contains test with exceptions")
    @Test
    public void containsTest(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        assertFalse(arrayList.contains("11"));
        assertTrue(arrayList.contains("1"));

        Exception exception2 = assertThrows(NullPointerException.class,() -> arrayList.contains(null));
        String expectedMessage2 = "you can`t put null as a value!";
        String actualMessage2 = exception2.getMessage();
        assertEquals(expectedMessage2, actualMessage2);
    }

    // [A, B, A, C] indexOf(A) -> 0
    // -1 if not exist
//    int indexOf(Object value);
    @DisplayName("index of and last index of test with exceptions" )
    @Test
    public void indexOfTest(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("2");

        Exception exception2 = assertThrows(NullPointerException.class,() -> arrayList.indexOf(null));
        String expectedMessage2 = "you can`t put null as a value!";
        String actualMessage2 = exception2.getMessage();
        assertEquals(expectedMessage2, actualMessage2);

        assertEquals(1, arrayList.indexOf("2"));
        assertEquals(3, arrayList.lastIndexOf("2"));
        assertEquals(-1, arrayList.indexOf("4"));
        assertEquals(-1, arrayList.lastIndexOf("4"));

    }
    @DisplayName("increment size test")
    @Test
    public void sizeIncrementationTest() throws IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        int initialSize = 2;
        arrayList.setInitialSize((2));
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");


        assertTrue(arrayList.size() > initialSize);
    }

    }



