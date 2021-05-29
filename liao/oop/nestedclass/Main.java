package oop.nestedclass;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){

        // inner class
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.outPut();

        // anonymous nested class
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>(){};
        HashMap<String, String> map3 = new HashMap<>(){
            {
                put("A","1");
                put("B","2");
            }
        };
        System.out.println(map3.get("B"));

        // static nested class
        Outer.StaticNested s = new Outer.StaticNested();
        s.output();
    }
    
}
