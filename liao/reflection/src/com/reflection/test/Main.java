package com.reflection.test;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 反射解决在运行期，对某个类一无所知，通过实例调用其方法
 * 获取class的Class实例，三种方法：
 *  1.直接通过实例的静态变量class获取
 *  2.getClass()
 *  3.Class.forName()
 *  
 * JVM每次读到一个class，就将其加载到内存，每加载一个class，JVM都会为其创建一个Class的实例，并关联
 */

public class Main{
    public static void main(String[] argv) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        if(argv.length>0){
            create(argv[0]);
        }
        System.out.println(123);
        Person p1 = new Person("小明");
        Class p = Person.class;
        Class p2 = p1.getClass();
        Class p3 = Class.forName("com.reflection.test.Person");

        System.out.println(p.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());

        // 通过Class，获取name字段,并设置当前类的字段的值
        /**
         * getField() 获取public的field，包括父类；
         * getDeclaredField() 获取当前类的某个field，不包括父类
         * getFields() 获取所有public的fields，包括父类
         * getDeclaredFields() 获取当前类的所有fields，不包括父类
         */
        Field f = p2.getDeclaredField("name");
        f.setAccessible(true);
        // (指定的实例，修改的值)
        f.set(p1,"张书嫚");

        System.out.println(p1.getName());
        
        // 通过Class获取类的方法
        Student st = new Student("纪浩瀚");
        Class std = st.getClass();
        System.out.println(std.getMethod("getName"));
        System.out.println(std.getMethod("getScore",String.class));


        // 调用方法
        Method m = std.getMethod("getScore",String.class);
        int score = (int) m.invoke(st,"纪浩瀚");
        System.out.println("纪浩瀚考了"+score+"分");

        // 调用静态方法
        Method sm = Integer.class.getMethod("parseInt",String.class);
        int a = (int)sm.invoke(null,"12345");
        System.out.println(a);

        // 多态
        Method  hellom = Person.class.getDeclaredMethod("hello");
        hellom.invoke(new Student());

        // 反射调用构造方法
        // only public
        Constructor cons = Person.class.getConstructor(String.class);
        // Student stu = (Student) cons.newInstance("纪浩瀚");
        cons.setAccessible(true);
        Person person1 = (Person) cons.newInstance("jhh");
       
        System.out.println(person1.getName());

        Constructor cons2 = Student.class.getConstructor(String.class);
        // 获取继承关系
        Constructor cons3 = Student.class.getSuperclass().getConstructor(String.class);
        // Student stu = (Student) cons.newInstance("纪浩瀚");
        // setAccesssible可能会失败 构造方法必须是该类的，不是继承的，因此不存在多态的问题
        cons2.setAccessible(true);
        Student student_jhh = (Student) cons2.newInstance("jhh");
        Person person_zsm = (Person) cons3.newInstance("zsm");
        StringJoiner sj = new StringJoiner("&");
        sj.add(student_jhh.getName()).add(person_zsm.getName());
        System.out.println(sj.toString());

        // 获取Integer父类的接口
        Class classNumber = Integer.class.getSuperclass();
        Class[] it = classNumber.getInterfaces();
        for(Class i : it){
            // 对所有interface的Class调用getSuperclass() 为null，要获取接口的父接口，要用getInterfaces()
            System.out.println(i.getSuperclass());
            System.out.println(Arrays.toString(i.getInterfaces()));
            System.out.println(i);
        }
        System.out.println(Arrays.toString(java.lang.Number.class.getInterfaces()));

        //判断向上转型是否成立
        System.out.println(classNumber.isAssignableFrom(Object.class)); 
        //Integer.class 可以转型为 Number.class
        Number n = Integer.valueOf(123);
        System.out.println(n instanceof Integer);
        System.out.println(classNumber.isAssignableFrom(Integer.class)); 

        //静态实现，接口只能通过向上转型实例化
        Sports sp = new Bskt();
        sp.hello();

        //动态代理
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("hello")) {
                    // System.out.println(argv[0]);
                    System.out.println("basketball");
                }
                return null;
            }
        };
        Sports sp2 = (Sports) Proxy.newProxyInstance(
            Sports.class.getClassLoader(), // 传入ClassLoader
            new Class[] { Sports.class }, // 传入要实现的接口
            handler); // 传入处理调用方法的InvocationHandler
        sp2.hello();
    }

    static void create(String name){
        Person p1 = new Person(name);
        System.out.println(p1.getName());
    }
}