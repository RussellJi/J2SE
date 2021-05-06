package cast;
class Person {
    private String name;
    Person(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }
    void run(){
        System.out.println("person run");
    }
}
