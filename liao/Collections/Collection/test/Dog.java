package Collections.Collection.test;

public class Dog {
    private String name;
    private int age;
    Dog(){}
    Dog(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name+":"+this.age;
    }
}
