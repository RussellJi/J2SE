package Collections.Collection.Set.HashSet.test;

import java.util.HashSet;

@SuppressWarnings("all")
class HashSetExercise{
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee("纪浩瀚",23));
        set.add(new Employee("张书嫚",25));
        set.add(new Employee("纪浩瀚",23));
    }
}

class Employee{
    private String name;
    private int age;
    Employee(){

    }
    Employee(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Employee o = (Employee)obj;
        if(this.name == o.getName()&&this.age == o.getAge()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 100;
    }
}