package com.oop.abstractdemo;
public class Student extends Person {
    Student(){
        count++;
    }
    public static void main(String[] args){
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = new Student();
        Student s6 = new Student();
        // 若想直接只用类名.方法 则该方法需设置为static方法
        Person.getCount();
    }
}
