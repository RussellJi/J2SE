package generics.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.StringJoiner;


/**
 * ParameterizedType：参数化类型，如泛型
 * TypeVariable：T,K
 * GenericArrayType：含有泛型的数组
 * WildcardType：含有通配符的泛型
 */
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

        // 子类取得父类泛型类型 
        Intpair ip = new Intpair(1,2);
        Class c_ip = ip.getClass();
        Type t = c_ip.getGenericSuperclass();
        if(t instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType)t;
            Type[] types = pt.getActualTypeArguments();
            Type firstType = types[0];
            Class<?> typeClass = (Class<?>)firstType;
            System.out.println(typeClass);
            
        }
    }
} 
