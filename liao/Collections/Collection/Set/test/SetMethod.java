package Collections.Collection.Set.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// set 实现了Collection接口
/**
 * 1.可以使用iterator，增强for，不可以通过索引遍历
 * 2.set不可添加重复的元素，可以添加一个null
 * 3.添加的顺序与取出的顺序不保证一致，但是每次取出的顺序是一定的
 * 4.没有get方法，不能通过索引取出元素
 */

public class SetMethod {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(0);
        set.add(null);
        set.add(null);
        System.out.println("set:"+set);

        System.out.print("迭代器：");
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("增强for：");
        for(Object o: set){
            System.out.print(o);
            System.out.print(" ");
        }
        
        System.out.println();
        Object [] obj = set.toArray();
        System.out.println(Arrays.toString(obj));
        
    }
}
