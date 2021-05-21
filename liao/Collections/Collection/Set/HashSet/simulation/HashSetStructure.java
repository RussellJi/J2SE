package Collections.Collection.Set.HashSet.simulation;

public class HashSetStructure {
    public static void main(String[] args) {
        
        Node[] table = new Node[16]; 
        Node zoo = new Node("动物园",null); 
        table[0] = zoo;

        Node tiger = new Node("tiger",null);
        zoo.next = tiger;

        Node pig = new Node("pig",null);
        tiger.next = pig;

        Node sida = new Node("四大名著",null); 
        table[1] = sida;

        Node shuihu = new Node("水浒传",null);
        sida.next = shuihu;

        Node xiyou = new Node("西游记",null);
        shuihu.next = xiyou;



    }
    
}
class Node{
    Object item;
    Node next;
    Node(Object item,Node next){
        this.item = item;
        this.next = next;
    }
}