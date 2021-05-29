package Collections_HSP.Collection.List.ArrayList.source;

import java.util.ArrayList;

/**
 * ArrayList底层源码
 * 1.维护了一个Object类型的数组ElementData  transient Object[] ElementData 该属性不被序列化
 * 2.无参构造器，默认为0，第一次10，若不够1.5倍扩容
 * 3.指定大小构造器，初始为指定大小，不够则1.5倍扩容
 */

@SuppressWarnings("all")
public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        for(int i = 0; i<10; i++){
            a.add(i);
        }
        for(int i = 10; i<15; i++){
            a.add(i);
        }
        a.add(200);

        ArrayList a2 = new ArrayList(4);
        for(int i = 0; i<4; i++){
            a2.add(i);
        }
        a2.add(200);
    }
}
