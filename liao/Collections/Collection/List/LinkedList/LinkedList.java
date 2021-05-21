package Collections.Collection.List.LinkedList;

public class LinkedList {
    // 双向链表
    Node first;
    Node last;
    // 内部类，pre，next，item
    public class Node{
        Object item;
        Node pre;
        Node next;
        public Node(Node pre, Object item, Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList.Node n = list.new Node(null,2,null);
        list.first = n;
        list.last = n; 

        LinkedList.Node n2 = list.new Node(n,1,null);
        list.last = n2;
        
        n.next = n2;
        while(list.first != null){
            System.out.println(list.first.item);
            list.first = list.first.next;
        }
        

        // 插入3
        LinkedList.Node n3 = list.new Node(n,3,n2);
        n2.pre = n3;
        n.next = n3;

        while(list.last != null){
            System.out.println(list.last.item);
            list.last = list.last.pre;
        }
    }
    
}
