package Collections_HSP.Map.HashMap.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("all")
public class HashMapExerxice {
    public static void main(String[] args) {
        HashMap hashmap = new HashMap();
        Employee e1 = new Employee("纪浩瀚",36000,116);
        Employee e2 = new Employee("张书嫚",36001,157);
        Employee e3 = new Employee("小明",18000,102);
        // hashmap.put(e1.getId(),e1);
        // hashmap.put(e2.getId(),e2);
        // hashmap.put(e3.getId(),e3);
        hashmap.put("java",1);
        hashmap.put("php",2);
        hashmap.put("java",10);
        
        Set set = hashmap.keySet();
        for (Object s:set){
            Employee e = (Employee)hashmap.get(s);
            if(e.getSalary()>18000){
                System.out.println(e);
            }
            
        }

        Set entryset = hashmap.entrySet();
        Iterator it = entryset.iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            int id = (int)entry.getKey();
            Employee e = (Employee)hashmap.get(id);
            if(e.getSalary()>18000){
                System.out.println(e);
            }
        }

        
    }
}

@SuppressWarnings("all")
class Employee{
    private String name;
    private int salary;
    private int id;
    Employee(){}
    Employee(String name,int salary,int id){
        this.name = name;
        this.salary = salary;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}