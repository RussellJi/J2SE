package generics.test;

import java.util.StringJoiner;

public class Main {
    public static void main(String[]args){
        Pair<String> p_s = new Pair<>("ji","haohan");
        StringJoiner sj = new StringJoiner(" ","Name:",".");
        sj.add(p_s.getFirstname()).add(p_s.getLastname());
        System.out.println(sj); 

        Pair<Integer> p_i = new Pair<Integer>(12, 544);
 
        System.out.println(p_i.getFirstname()+" "+p_i.getLastname()); 

        Pair<String> p_z = Pair.create("zhang","shuman");
        Pair<Object> p_zi = Pair.create(123,456);
        System.out.println( p_z.getFirstname()+p_z.getLastname());
        System.out.println( p_zi.getFirstname()+""+p_zi.getLastname());
    }
} 
