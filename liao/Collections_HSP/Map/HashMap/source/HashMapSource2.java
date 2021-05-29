package Collections_HSP.Map.HashMap.source;
import java.util.HashMap;

public class HashMapSource2 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashMap hashmap = new HashMap();
        for(int i=0;i<12;i++){
            hashmap.put(new A(i),"hello");
        }
        for(int i=12;i<100;i++){
            hashmap.put(new A(i),"hello");
        }
        System.out.println(hashmap);
    }
}

class A{
    private int id;
    A(){}
    A(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }
    // @Override
    // public int hashCode() {
    //     // TODO Auto-generated method stub
    //     return 200;
    // }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Integer i = this.id;
        return i.toString();
    }
}
