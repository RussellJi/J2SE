package Collections_HSP.Collection.List.test;
public class Book {
    private String name;
    private int price;
    private String author;
    Book(){}
    Book(String name, int price, String author){
        this.name = name;
        this.price = price;
        this.author = author;
    }
    public int getPrice(){
        return this.price;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name:"+name+",price:"+price+",author:"+author;
    }
}
