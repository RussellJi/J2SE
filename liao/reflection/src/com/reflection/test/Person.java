package com.reflection.test;

public class Person {
    private String name;
    Person(){}
    public Person(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void hello(){
        System.out.println("Person hello");
    }

}

class Student extends Person{
    Student(){
        super();
    }
    public Student(String name){
        super(name);
    }
    public int getScore(String type){
        System.out.println(99);
        return 99;
    }
    public void hello(){
        System.out.println("stu hello");
    }
}

interface Sports{
    public void hello();
}

class Bskt implements Sports{
    public void hello(){
        System.out.println("basketball");
    }
}