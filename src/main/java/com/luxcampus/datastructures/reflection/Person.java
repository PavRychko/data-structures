package com.luxcampus.datastructures.reflection;

public class Person {
    public  int age;
    private boolean isMale;
    String name;

    Person(){
        age = 18;
    }

    Person(int age, boolean isMale, String name){
        this.age = age;
        this.isMale = isMale;
        this.name = name;
    }

    final void sayHi(){
        System.out.println("Hi");
    }

    public int getAge(){
        return age;
    }

    public boolean isMale(){
        return isMale;
    }

    public String getName() {
        return name;
    }

     void setAge(int age) {
        this.age = age;
    }



     void setName(String name) {
        this.name = name;
    }
}
