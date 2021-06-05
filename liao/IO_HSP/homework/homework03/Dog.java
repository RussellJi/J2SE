package IO_HSP.homework.homework03;

import java.io.Serializable;

public class Dog implements Serializable{
    String name;
    int age;
    String color;
    Dog(String name,int age,String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name:"+this.name+"\tage:"+this.age+"\tcolor:"+this.color;
    }
}
