package oop.core.string;
// 字符串不可变特性 由private final char[]决定


// 比较值用equals,比较引用用==
public class Main {
    public static void main(String[] args){
        String s1 = "abc";
        String s3 = "abc";
        
        String s4 = "ABC".toLowerCase();
        String s2 = s1.toUpperCase();
        System.out.println(s2==s1); // false
        System.out.println(s2.equals(s1)); //false

        System.out.println(s1.equals(s3)); //true
        System.out.println(s1 == s3); //false  -> true s1,s3的abc都为常量池中的abc，因此引用一样

        System.out.println(s1.equals(s4)); //true
        System.out.println(s1 == s4); //false

        //String 不可变特性，字符串内容不可变
        String s5 = s1;
        s1 = "abcd";
        System.out.println(s5);

        
    }
}
