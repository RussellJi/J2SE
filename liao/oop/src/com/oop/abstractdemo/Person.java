package com.oop.abstractdemo;
abstract class Person {
    public static int count = 0;
    static int getCount(){
        System.out.println(count);
        return count;
    }
}
