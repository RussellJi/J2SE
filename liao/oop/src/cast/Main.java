package cast;
public class Main {
    public static void main(String [] args){
        Person p1 = new Person("ji");
        //downcasting
        if (p1 instanceof Student){
            Student ss = (Student)p1;
        }

        Student s1 = new Student("jhh");
        s1.run();

        // upcasting  ok
        Person p2 = new Student("zsm");
        if(p2 instanceof Student){
            //downcasting : instanceof first
            Student s2 = (Student)p2;
            s2.run();
        }
    }
}
