package Collections_HSP.Map.TreeMap;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings("all")
public class TreeMapSource {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        // TreeMap treeMap = new TreeMap(new Comparator(){
        //     @Override
        //     public int compare(Object o1, Object o2) {
        //         // TODO Auto-generated method stub
        //         return ((String)o1).length()-((String)o2).length();
        //     }
        // });

        treeMap.put("a",1);
        treeMap.put("c33",3);
        treeMap.put("b2",2);
        treeMap.put("d",4);

        System.out.println(treeMap);
    }   
}
