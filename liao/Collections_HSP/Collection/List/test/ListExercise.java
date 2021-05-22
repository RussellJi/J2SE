package Collections_HSP.Collection.List.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExercise {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new LinkedList();
        List list3 = new Vector();
        list1.add(new Book("骆驼祥子",50,"老舍"));
        list1.add(new Book("西游记",49,"吴承恩"));
        list1.add(new Book("红楼梦",66,"曹雪芹"));

        System.out.println(list1);

        // // 冒泡排序
        // for(int i = 0; i<list1.size()-1; i++){
        //     for(int j = 0; j<list1.size()-1-i; j++){
        //         int p1 = ((Book) list1.get(j)).getPrice();
        //         int p2 = ((Book) list1.get(j+1)).getPrice();
        //         if(p1 > p2){
        //             Object temp = list1.get(j+1);
        //             list1.set(j+1,list1.get(j));
        //             list1.set(j, temp);
        //         }
        //     }
        // }
        sort(list1);
        System.out.println("list1:"+list1);

        list2.add(new Book("骆驼祥子",50,"老舍"));
        list2.add(new Book("西游记",49,"吴承恩"));
        list2.add(new Book("红楼梦",66,"曹雪芹"));

        System.out.println(list2);

        // // 冒泡排序
        // for(int i = 0; i<list2.size()-1; i++){
        //     for(int j = 0; j<list2.size()-1-i; j++){
        //         int p1 = ((Book) list2.get(j)).getPrice();
        //         int p2 = ((Book) list2.get(j+1)).getPrice();
        //         if(p1 > p2){
        //             Object temp = list2.get(j+1);
        //             list2.set(j+1,list2.get(j));
        //             list2.set(j, temp);
        //         }
        //     }
        // }
        sort(list2);
        System.out.println("list2:"+list2);

    }
    @SuppressWarnings("all")
    static void sort(List list){
        int listsize = list.size();
        for(int i = 0; i < listsize - 1; i++){
            for(int j = 0; j < listsize - 1 - i; j++){
                Book o = (Book)list.get(j);
                Book o2 = (Book)list.get(j+1);
                if(o.getPrice() > o2.getPrice()){
                    list.set(j,o2);
                    list.set(j+1,o);
                }
            }
        }
    }


}
