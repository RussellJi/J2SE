package Collections.Collection.Set.HashSet.source;

import java.util.HashSet;

/**
 * HashSet实现了Set接口
 * 1.底层是HashMap(底层：数组+链表+红黑树)
 * 2.add() 
 *   hash() + equals() 
 *   单条链表的元素到6，总数大于64，链表会转树
 *   1)计算hashcode值并且与hashcode值>>>16异或（减小碰撞），返回hash，非hashcode
 *   2）put()
 *   3) putVal()
 *      若为空resize()
 *      判断计算出的结点是否为null
 *          null，创建新结点
 *          ！null，判断
*               Node<K,V> e; K k;
                // 若hashcode相同并且（key的引用相同或者equals相同）,不添加
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                // 若结点为红黑树结点，在树中判断
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                // 若结点为链表的结点，依次比较，
                    没有相等的在末尾加入
                    有相等的，不添加
                else {
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
 */
@SuppressWarnings("all")
public class HashSetSource {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("java");
        set.add("php");
        set.add("java");
    }
}
