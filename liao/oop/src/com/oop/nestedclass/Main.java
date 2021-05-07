package com.oop.nestedclass;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.outPut();

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>(){};
        HashMap<String, String> map3 = new HashMap<>(){
            {
                put("A","1");
                put("B","2");
            }
        };
        System.out.println(map3.get("B"));
    }
    
}
