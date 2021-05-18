package general.test;

import java.util.StringJoiner;

public class Main {
    public static void main(String[]args){
        Pair<String> p_s = new Pair<>("ji","haohan");
        StringJoiner sj = new StringJoiner(" ","Name:",".");
        sj.add(p_s.getFirstname()).add(p_s.getLastname());
        System.out.println(sj); 

        Pair<Integer> p_i = new Pair<Integer>(12, 544);
 
        System.out.println(p_i.getFirstname()+" "+p_i.getLastname()); 

    }
} 
