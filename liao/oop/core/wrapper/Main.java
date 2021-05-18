package oop.core.wrapper;
/**
 * WHY wrapper
 * 1.基本数据类型无法设null，基本类型作为参数若为null会出错，而包装类不会。
 * 因此RPC框架都用包装类作为参数。
 * 2.POJO类中的数据类型都为包装类，如果是基本类型，为空时，那么数据库表中的映射就会出错。
 * (POJO类，方便使用数据库中的表，使对象与数据库的表对应，不含任何业务逻辑和继承关系的普通类，没有严格的规范，与javaBean不同)
 * （javaBean可重用组件 1.属性private；2.实现serializable接口，可序列化；3.属性具有get或set方法； 4.要有无参数的构造方法；）.
 * 3.包装类有一些常用的方法。parseInt  hashcode
 * when 基本：局部变量，用完在栈中就销毁
 */
public class Main {
    public static void main(String[] argv){
        int i = 0;
        // Integer i1 = new Integer(i); 弃用

        //valueOf 用静态方法创建Integer对象，-128到127的数会在cache中找到，然后再new
        Integer i2 = Integer.valueOf(i);
        System.out.println(i2);

        //自动装箱(valueOf)
        Integer i3 = 100;

        Integer i4 = 100;

        Integer i5 = 129;
        Integer i6 = 129;

        // -128 ~ 127指向同一个地址
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));

    }

}
