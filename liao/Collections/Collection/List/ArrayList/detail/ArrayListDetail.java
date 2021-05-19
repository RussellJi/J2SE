package Collections.Collection.List.ArrayList.detail;

import java.util.ArrayList;

/**
 * ArrayList注意事项：
 * 1.可以加入null，可以加多个null
 * 2.由数组实现数据存储
 * 3.基本等同于Vector，除了ArrayList是线程不安全的（执行效率高）,没有synchronized修饰（线程互斥）
 *      在多线程的情况下，不建议使用ArrayList
 */
@SuppressWarnings("all")
public class ArrayListDetail {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(null);
        arr.add(null);
        arr.add("jack");
        System.out.println(arr);
        
    }
}
