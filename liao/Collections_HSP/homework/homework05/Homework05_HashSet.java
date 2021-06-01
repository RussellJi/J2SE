package Collections_HSP.homework.homework05;

import java.util.HashSet;
import java.util.Objects;


@SuppressWarnings("all")
public class Homework05_HashSet {
    public static void main(String[] args) {
        HashSet hashset = new HashSet();
        Person p1 = new Person("1",10);
        Person p2 = new Person("2",20);
        hashset.add(p1);
        hashset.add(p2);
        p1.setName("3"); 
        // p1.setId(100);

        // remove的索引值根据3,10计算，没有元素，删除不成功
        hashset.remove(p1);

        System.out.println(hashset);

        // 添加时根据3.10计算，没有元素，成功添加
        hashset.add(new Person("3",10));
        // 添加时，索引位置与p1一样，但是equals不一样，添加到p1后面
        hashset.add(new Person("1",10));
        System.out.println(hashset);

    }
}

class Person {
    private String name;
    private int id;

    Person(String name, int id){
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public void setId(int id) {
        this.id = id;
    }

    // 根据id和name重写hashcode和equals方法
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(name,id);
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Person person = (Person)obj;
        return id == person.id &&
             Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name + ":"+this.id;
    }
}