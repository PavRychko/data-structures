package com.luxcampus.datastructures.reflection;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;


public class ReflectionTest {
  Reflection reflection = new Reflection();



    @Test
    public void createTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object actual = reflection.create(Person.class);
        assertEquals( Person.class, actual.getClass());
        Person actualPerson = (Person) actual;
        assertEquals(18, actualPerson.getAge());
    }


    @Test
    public void setFieldsToDefaultTest() throws NoSuchFieldException, IllegalAccessException {
        Person malePerson = new Person(18, true, "Petya");
        Person femalePerson = new Person(18, false, "Marina");
        assertEquals(18, malePerson.getAge());
        assertEquals(18, femalePerson.getAge());
        assertTrue(malePerson.isMale());
        assertFalse(femalePerson.isMale());
        assertEquals("Petya", malePerson.getName());
        assertEquals("Marina", femalePerson.getName());

        reflection.setFieldsToDefault(malePerson);
        reflection.setFieldsToDefault(femalePerson);
        assertEquals(0, malePerson.getAge());
        assertEquals(0, femalePerson.getAge());
        assertFalse(malePerson.isMale());
        assertFalse(femalePerson.isMale());
        assertEquals(null, malePerson.getName());
        assertEquals(null, femalePerson.getName());
    }

    
}
