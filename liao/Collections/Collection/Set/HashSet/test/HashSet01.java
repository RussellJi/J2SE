package Collections.Collection.Set.HashSet.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class HashSet01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("1");
        set.add("1");  //fail
        set.add(new Integer(11));
        set.add(new Integer(11)); //fail

        Integer i1 = 129;
        Integer i2 = 129; 
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        set.add(i1);
        set.add(i2);  //fail

        String s1 = "abc";
        String s4 = "abc";
        String s5 = new String("abc");
        String s6 = new String("abc");
        System.out.println("s1 == s4?"+(s1==s4));
        System.out.println(s1.equals(s5));
        String s2 = "ABC";
        String s3 = s2.toLowerCase();
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        set.add(s1);
        set.add(s3);  //fail
        set.add(s5);  //fail


     
        set.add("130");
        set.add(new Dog("tom"));
        set.add(new Dog("tom"));  //succ
        System.out.println(set);


        // reflect
        Class classHashSet = set.getClass();
        // 1.HashSet的属性和方法
        Field [] fields = classHashSet.getFields(); 
        System.out.println("public fields:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Method [] methods = classHashSet.getMethods();
        System.out.println("public methods:");
        for (Method method : methods) {
            System.out.println(method);
        }
        // 2.HashSet的构造器
        Constructor[] cons = classHashSet.getConstructors();
        System.out.println("public constructor:");
        for (Constructor constructor : cons) {
            System.out.println(constructor.getName());
        }
        // 3.HashSet的接口
        Class [] interfaces = classHashSet.getInterfaces();
        System.out.println("interface:");
        for (Class class1 : interfaces) {
            System.out.println(class1.getName());
        }

        //动态代理解决的是接口的实例化 
        // 动态创建一个Set的代理对象
        InvocationHandler handler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // TODO Auto-generated method stub
                // System.out.println(method.getName());
                if (method.getName().equals("add")){
                    System.out.println(args[0]);
                }
                return null;
            }
        };
        Set  ss = (Set)Proxy.newProxyInstance(Set.class.getClassLoader(), new Class[] {Set.class}, handler);
        try {
            ss.add(new Integer(123));
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.out.println("捕获到了");
        }
        
    }
}
