package Collections.Collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



// Collection接口的常用方法add remove isEmpty contains addAll removeAll clear
// Collection接口实现了Iterable接口，可以使用iterator方法（迭代器），返回一个Iterator对象,通过next方法获取下一个元素
// 增强for循环，其实就是简化版的迭代器
public class CollectionMethod {
    @SuppressWarnings("all")
    public static void main(String[] args) {
    
        Collection list = new ArrayList();
        Collection list2 = new ArrayList();
        // 添加单个元素
        list.add("纪浩瀚");
        
        list.add(123);
        list.add("123");
        System.out.println("list:"+list);
        // 删除指定元素 remove 非delete
        // list.remove(1);
        list.remove("123");
        System.out.println("list："+list);
        // 查找元素是否存在
        System.out.println(list.contains("123")); 
        // 获取元素个数
        System.out.println(list.size());
        // 判断是否为空
        System.out.println(list.isEmpty());
        // 清空
        list.clear();
        System.out.println("list:"+list);
        // 添加多个元素
        list2.add("jhh");
        list2.add("zsm");
        list.addAll(list2);//一次添加多个元素
        System.out.println("list:"+list);
        // 删除多个元素
        list.add(124);
        list.add("jhh1");
        System.out.println("list:"+list);
        list.removeAll(list2);
        System.out.println("list:"+list);

        Iterator i = list.iterator();
        // 调用next()之前，必须调用hasNext()，否则NoSuchElementException
        while(i.hasNext()){
            // 返回Object
            System.out.println(i.next());
        }

        // 再次需要迭代时，要重置
        i = list.iterator();
        
        // 增强for循环,底层Iterator也可以在数组中使用
        for(Object o:list){
            System.out.println(o);
        }
    }
}
