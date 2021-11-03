package com.luxcampus.datastructures.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection {

public Object create(Class clazz) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
    return clazz.getDeclaredConstructor().newInstance();

}


public void useNoParamsMethods(Object object) throws InvocationTargetException, IllegalAccessException {
    for (Method declaredMethod : object.getClass().getDeclaredMethods()) {
            if(declaredMethod.getParameterCount() == 0){
                System.out.println(declaredMethod.getName() + "is used!, result is = "+ declaredMethod.invoke(object));

            }
    }
}

public void printFinalMethods(Object object) {
    for (Method declaredMethod : object.getClass().getDeclaredMethods()) {
        if (declaredMethod.getModifiers() == Modifier.FINAL) {  //int value 16
            System.out.println(declaredMethod.getName());
        }
    }
}

public void printNonPublicMethods(Object object) {
    for (Method declaredMethod : object.getClass().getDeclaredMethods()) {
        if (declaredMethod.getModifiers() != Modifier.PUBLIC) {  //int value 16
            System.out.println(declaredMethod.getName());
        }
    }
}

public void printParentAndInterfaces(Object object){
    System.out.println("superClass is = " + object.getClass().getSuperclass());
    System.out.println(" interfaces used = " + Arrays.toString(object.getClass().getInterfaces()));
}

public void setFieldsToDefault(Object object) throws IllegalAccessException {
    for (Field declaredField : object.getClass().getDeclaredFields()) {
        declaredField.setAccessible(true);
        if (declaredField.getType().equals(int.class)) {
            declaredField.set(object, 0);
        } else if (declaredField.getType().equals(String.class)) {
            declaredField.set(object, null);
        } else if (declaredField.getType().equals(boolean.class)) {
            declaredField.set(object, false);
        }
    }

}
}
