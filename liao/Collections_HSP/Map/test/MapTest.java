package Collections_HSP.Map.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Map
 * 1.key不能重复，若key重复则为替换
 * 2.null可以为key，但不能重复
 * 3.key常为字符串类型
 * 4.遍历：
 *  1）for增强
 *  2）Iterator
 * 5.put(K,V)
 *  Node node = new Node<>(hash, key, value, next);
 * //Node为HashMap的静态内部类
 *  static class Node<K,V> implements Map.Entry<K,V>  //因为Entry有geKey() getValue()方法
 * 6.为方便程序员遍历，还会创建EntrySet<Entry<K,V>> K指向了Node中的Key，V指向了Node中的V   static Node<K,V> implements Entry<K,V>   
 */
@SuppressWarnings("all")
public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1","a");
        map.put("2","b");
        map.put(new Dog("mimi"),"mimi");
        map.put(new Dog("豆豆"),"豆豆");
        map.put(new Dog("mim"),"mim");

        Set set = map.entrySet();
        System.out.println(set.getClass()); 
        for(Object entry : set){
            // System.out.println(entry.getClass());
            //为了取出value，进行转型
            Map.Entry en = (Map.Entry)entry;
            System.out.println(en.getKey());
        }

        // 遍历
        Set keyset = map.keySet();
        Collection values = map.values();
        
        // 1.利用keySet获取key，map.get(key),增强for
        System.out.println("-------1.增强for，keyset");
        for(Object key:keyset){
            System.out.println(map.get(key));
        }

        // 2.利用keySet获取key，map.get(key),iterator
        System.out.println("-------2.iterator，keyset");
        Iterator it = keyset.iterator();
        while (it.hasNext()){
            System.out.println(map.get(it.next()));
        }

        // 3.利用collection 增强for
        System.out.println("-------3.增强for，collection");
        for(Object value:values){
            System.out.println(value);
        }
        // 4.利用collection Iterator
        System.out.println("-------4.iterator，collection");
        Iterator it2 = values.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        
        // 利用entryset 增强for
        System.out.println("-------5.增强for，entryset");
        for(Object entry : set){
            // System.out.println(entry.getClass());
            //为了取出value，进行转型
            Map.Entry en = (Map.Entry)entry;
            System.out.print(en.getKey()+"-");
            System.out.println(en.getValue());
        }

        // 利用entryset iterator
        Iterator it3 = set.iterator();
        System.out.println("-------6.iterator，entryset");
        while (it3.hasNext()){
            Map.Entry i = (Map.Entry)it3.next();
            System.out.println(i.getKey()+"-"+i.getValue());
        }
    }  
}

class Dog{
    private String name;
    Dog(){}
    Dog(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 100;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name:"+this.name;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Dog d = (Dog)obj;
        return this.name.equals(d.getName());
    }
}