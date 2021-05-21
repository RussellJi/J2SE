package Collections.Collection.List.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List()
 * 1.元素按添加顺序有序，可重复
 * 2.每个元素尤其对应顺序索引，支持索引
 * 
 * method: add(index,element) indexOf() lastIndexOf() set(index,element) subList(fromIndex,toIndex)
 * List 的实现类的三种遍历方式：forEach for iterator  (ArrayList LinkedList vector都适用)
 */
public class ListMethod {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("纪浩瀚");
        
        list.add(0,"张书嫚");
        System.out.println("list:"+list);
        System.out.println(list.subList(0,1));

        list.set(0,"二胖");
        System.out.println("list:"+list);

        
        Iterator it = list.iterator();
        System.out.println("迭代器：");
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("for增强：");
        for(Object o:list){
            System.out.println(o);
        }

        System.out.println("普通for循环：");
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
