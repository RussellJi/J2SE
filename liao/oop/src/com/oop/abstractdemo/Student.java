package com.oop.abstractdemo;
public class Student extends Person {
    Student(){
        count++;
    }
    public static void main(String[] args){
        Student s1 = new Student();
        s1.getCount();
    }
}
