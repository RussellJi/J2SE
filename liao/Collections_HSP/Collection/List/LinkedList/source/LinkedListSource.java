package Collections_HSP.Collection.List.LinkedList.source;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListSource {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // LinkLast() 在末尾添加结点
        list.add(1);
        list.add(3);
        // LinkBefore() 先找到位置1的结点（succ），然后在succ和其前一个结点之间创建一个newNode（succ-pre，element，succ），new-next = succ，succ-pre = newNode
        list.add(1,2);
        // removeFirst() unlinkFirst()
        list.remove();
        // unlink(node(index))过河拆桥
        list.remove(1);

        for(Object o : list){
            System.out.println(o);
        }
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
