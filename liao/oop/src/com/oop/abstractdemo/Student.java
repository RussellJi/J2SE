package com.oop.abstractdemo;
public class Student extends Person {
    Student(){
        count++;
    }
    public static void main(String[] args){
        new Student();
        new Student();
        new Student();
        new Student();
        new Student();
        new Student();
        // 若想直接只用类名.方法 则该方法需设置为static方法
        Person.getCount();
    }
}
