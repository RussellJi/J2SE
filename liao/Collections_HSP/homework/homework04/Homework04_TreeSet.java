package Collections_HSP.homework.homework04;

import java.util.TreeSet;
@SuppressWarnings("all")
public class Homework04_TreeSet {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();

        // Person未实现Comparator接口
        treeSet.add(new Person());
        System.out.println(treeSet);
    }
}
class Person {

}
