package com.luxcampus.datastructures.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.StringJoiner;


public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person malePerson = new Person(18, true, "Petya");
        Reflection reflection = new Reflection();
        reflection.useNoParamsMethods(malePerson);
        System.out.println("+++++++++++++++++++++");
        reflection.printFinalMethods(malePerson);
        System.out.println("+++++++++++++++++++++");
        reflection.printNonPublicMethods(malePerson);
        System.out.println("+++++++++++++++++++++");
        reflection.printParentAndInterfaces(malePerson);
        System.out.println("+++++++++++++++++++++");
        reflection.setFieldsToDefault(malePerson);




    }
}


