package Collections_HSP.Collection.Set.HashSet.test;

import java.util.HashSet;

@SuppressWarnings("all")
public class Person {
    private String name;
    private MyDate birthday;
    Person(){}
    Person(String name,int year,int month,int day){
        this.name = name;
        this.birthday = new MyDate(year,month,day);
    }
    public String getName() {
        return name;
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 100;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Person p = (Person)obj;
        if(this.name == p.getName() && this.birthday.equals(p.birthday)){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name:"+this.name+",birthday:"+this.birthday.year+"/"+this.birthday.month+"/"+this.birthday.day;
    }
    class MyDate{
        int year;
        int month;
        int day;
        MyDate(){}
        MyDate(int year,int month,int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }
        @Override
        public boolean equals(Object obj) {
            // TODO Auto-generated method stub
            MyDate m = (MyDate)obj;
            if(this.year == m.year && this.month == m.month && this.day == m.day){
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Person("纪浩瀚",1998,11,4));
        set.add(new Person("张书嫚",1996,3,23));
        set.add(new Person("纪浩瀚",1998,11,4));
        System.out.println(set);
    }
}