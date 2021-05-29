package Collections_HSP.Collection.Set.HashSet.LinkedHashSet.source;

import java.util.Iterator;
import java.util.LinkedHashSet;
/**
 * LinkedHashSet 实现了Set接口，不能重复
 * 1.底层维护了一个LinkedHashMap:tab+双向链表
 * 2.table数组中每个结点（Entry<K,V> extends Node<K,V>）有before，after保证了读取顺序一致
 * 3.new LinkedHashSet()
 * //底层创建LinkedHashMap  16,0.75
 *  HashSet(int initialCapacity, float loadFactor, boolean dummy) {
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }
 * 4.add()
 *   public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
     public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
    // 计算hash值
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict)
        ......
        //若计算出的索引位置为空创建新结点
        tab[i] = newNode(hash, key, value, null);
            
            static class Node<K,V> implements Map.Entry<K,V>{
                Node(int hash, K key, V value, Node<K,V> next) {
                    this.hash = hash;
                    this.key = key;
                    this.value = value;
                    this.next = next;
                }
            }
            // 方便修改元素
            /**
             * The head (eldest) of the doubly linked list.
             */
            //transient LinkedHashMap.Entry<K,V> head;

            /**
             * The tail (youngest) of the doubly linked list.
             */
            //transient LinkedHashMap.Entry<K,V> tail;
/*
            // link at the end of list
            private void linkNodeLast(LinkedHashMap.Entry<K,V> p) {
                LinkedHashMap.Entry<K,V> last = tail;
                tail = p;
                if (last == null)
                    head = p;
                else {
                    p.before = last;
                    last.after = p;
                }
            }
        
        

 */
@SuppressWarnings({"all"})
public class LinkedHashSetSource {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(); 
        linkedHashSet.add(123);
        linkedHashSet.add(456);
        linkedHashSet.add(456);
        linkedHashSet.add("纪浩瀚");
        linkedHashSet.add(new Dog("123"));
        linkedHashSet.add(new Dog("234"));
        linkedHashSet.add(new Dog("345"));
        System.out.println("set:"+linkedHashSet);

        System.out.println("-------iterator遍历--------");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("--------增强for遍历--------");
        for(Object o:linkedHashSet){
            System.out.println(o);
        }
        // Set没有get方法无法进行普通for遍历
    }


}
class Dog{
    private String name;
    Dog(String name){
        this.name = name;
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
        
}