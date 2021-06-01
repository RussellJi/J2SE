package Collections_HSP.homework.homework02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 
使用ArrayList完成对 对象 Car｛name，price｝的各种操作 

Car car＝new Car（＂宝马”，400000） Car car2＝new Car（＂宾利”，5000000） 


1．add：添加单个元素

2．remove：删除指定元素

3．contains：查找元素是否存在

4．size：获取元素个数

5．isEmpty：判断是否为空 6．clear：清空

7．addAll：添加多个元素

8．containsAll：查找多个元素是否都存在

9．removeAll：删除多个元素

使用增强for和迭代器来遍历所有的car，需要重写Car的toString方法
 */

@SuppressWarnings("all")
public class Homework02_ArrayList {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        List list2 = new ArrayList();
        Car car1 = new Car("宝马",4000000);
        Car car2 = new Car("宾利",5000000);
        list.add(car1);
        list.add(car2);
        System.out.println(list);

        list.remove(car1);
        System.out.println(list);

        System.out.println(list.contains(car1));

        System.out.println(list.size());

        // list.clear();
        System.out.println(list.isEmpty());
        list2.add(car1);
        list2.add(car2); 
        list.addAll(list2);

        System.out.println(list);
        System.out.println(list.containsAll(list2));

        // list.removeAll(list2);
        System.out.println(list);

        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for(Object o:list){
            System.out.println(o);
        }


    }

}

class Car {
    private String name;
    private int price;

    public Car(String name,int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name+":"+this.price;
    }
}