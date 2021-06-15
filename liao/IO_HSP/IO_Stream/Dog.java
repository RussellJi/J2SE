package IO_HSP.IO_Stream;

import java.io.Serializable;

public class Dog implements Serializable{
    private String name;
    private int id;
    private transient String color;
    private static Master master = new Master();
    long serialVersionUID = 1L;
    public Dog(String name,int id, String color){
        this.name = name;
        this.id = id;
        this.color = color;
    }
    @Override
    public String toString() {
        return "name:"+this.name+"  id:"+this.id+"  color:"+this.color+"  master:"+Dog.master;
    }
}

class Master{

}
