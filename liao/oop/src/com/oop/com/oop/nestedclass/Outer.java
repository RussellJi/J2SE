package com.oop.nestedclass;
class Outer{
    private String name = "outer";
    private static String NAME = "outer";
    class Inner{
        void outPut(){
            System.out.println("private:"+Outer.this.name);
        }
        
    }

    /**
     * static nested class can only get static field and  method
     */
    static class StaticNested{
        void output(){
            System.out.println("private static:"+NAME);
        }
    }

}