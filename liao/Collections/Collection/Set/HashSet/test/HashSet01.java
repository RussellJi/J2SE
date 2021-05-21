package Collections.Collection.Set.HashSet.test;

import java.util.HashSet;

public class HashSet01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("1");
        set.add("1");
        set.add(new Integer(11));
        set.add(new Integer(11));

        Integer i1 = 129;
        Integer i2 = 129;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        set.add(i1);
        set.add(i2);

        String s1 = "abc";
        String s4 = "abc";
        String s5 = new String("abc");
        String s6 = new String("abc");
        System.out.println("s1 == s4?"+(s1==s4));
        System.out.println(s1.equals(s5));
        String s2 = "ABC";
        String s3 = s2.toLowerCase();
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        set.add(s1);
        set.add(s3);
        set.add(s5);


     
        set.add("130");
        set.add(new Dog("tom"));
        set.add(new Dog("tom"));
        System.out.println(set);

    }
}
