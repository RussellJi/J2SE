package Collections_HSP.Collection.List.Vector.source;

import java.util.Vector;
/**
 * Vector底层源码
 * 1.Vector 维护了一个protected Object[] ElementData,
 * 2.Vector都是线程同步、安全的，操作方法由synchronized修饰，效率不高，每次线程同步
 * 3.无参，默认为10，满后2倍扩容
 * 4.有参，初始指定大小，满后2倍扩容
 */
@SuppressWarnings("all")
public class VectorSource {
    public static void main(String[] args) {
        Vector vec = new Vector();  
    //  public Vector() {
    //     this(10);
    // }
        for(int i = 0; i<10; i++){
            vec.add(i);
        }
        vec.add(200);
    }
}
