package Collections_HSP.Collection.Set.TreeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 源码解读
 * 1.构造器
 *      1）无参构造器
 *      2）有参构造器
 *          实例化一个Comparator接口，重写compare方法，可以实现TreeSet的排序
 *          底层调用TreeMap，将实例化的Comparator对象传给TreeMap的一个comparator字段 private final Comparator<? super K> comparator;
 * 
 * 2.add()
 *  public boolean add(E e) {
 *      //m为TreeMap,由于是存放key，PRESENT为一个私有静态对象   //private static final Object PRESENT = new Object();
        return m.put(e, PRESENT)==null;
    }

 *  public V put(K key, V value) {
        Entry<K,V> t = root;
        if (t == null) {
            //判断key是否为空，若为空抛出异常
            compare(key, key); // type (and possibly null) check

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        int cmp;
        Entry<K,V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                parent = t;
                //动态绑定了自定义的compare方法
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                //若key比较相等，不添加
                else
                    return t.setValue(value);
            } while (t != null);
        }
        else {
            if (key == null)
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
                Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        Entry<K,V> e = new Entry<>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        fixAfterInsertion(e);
        size++;
        modCount++;
        return null;
    } 
 * 
 */

@SuppressWarnings("all")
public class TreeSetSource {
    public static void main(String[] args) {
        // TreeSet treeset = new TreeSet();
        TreeSet treeset = new TreeSet(new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                // TODO Auto-generated method stub
                // return ((String)o1).compareTo((String)o2);
                return ((String)o1).length()-((String)o2).length();
            }
        });
        treeset.add("a");
        treeset.add("bc");
        treeset.add("bc");
        treeset.add("def");
        treeset.add("cdef");
        treeset.add("abcdef");
        Iterator it = treeset.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
