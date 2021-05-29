package Collections_HSP.Collection.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("a",1));
        list.add(new Dog("b",2));
        System.out.println("list:"+list);
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        for(Object o : list){
            System.out.println(o);
        }
    }

}
