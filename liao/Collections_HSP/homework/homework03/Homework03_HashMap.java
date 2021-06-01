package Collections_HSP.homework.homework03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * 
1）使用HashMap类实例化一个Map类型的对象m，键（String）和值（int）分别用于存储员

工的姓名和工资，存入数据如下： jack—650元； tom—1200元； smith—2900元；

2）将jack的工更改为2600元

3）为所有员工工资加薪100元；

4）遍历集合中所有的员工

5）遍历集合中所有的工资
 */

@SuppressWarnings("all")
public class Homework03_HashMap {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        m.put("jack",650);
        m.put("tom",1200);
        m.put("smith",2900);

        m.put("jack",2600);
        Set keyset = m.keySet();
        Collection c = m.values();
        Iterator it = keyset.iterator();
        while(it.hasNext()){
            // m.put(it.next(),(Integer)m.get(it.next())+100);
            String key = (String)it.next();
            System.out.println(key);
            System.out.println(m.get(key));
            m.put(key,(Integer)m.get(key)+100);
        }
        System.out.println("-------------");

        // for(Object key:keyset){
        //     m.put(key,(Integer)m.get(key)+100);
        // }
        

        System.out.println("----------------");
        it = m.entrySet().iterator();
        while(it.hasNext()){
            Entry e = (Entry)it.next();
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            m.put(e.getKey(),(Integer)e.getValue()+100);
        }
        
        System.out.println(m);
        
    }
}
class Employee{
    private String name;
    private int salary;
    public Employee(String name,int salary){
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name + ":"+this.salary;
    }
}