package Collections.Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List()
 * 1.元素按添加顺序有序，可重复
 * 2.每个元素尤其对应顺序索引，支持索引
 * 
 * method: add(index,element) indexOf() lastIndexOf() set(index,element) subList(fromIndex,toIndex)
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
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
