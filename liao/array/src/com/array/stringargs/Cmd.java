package com.array.stringargs;
import java.util.Arrays;
import com.array.sort.*;
/**
 * 先编译，在执行的时候追加参数，通过foreach 可以捕获参数，如何解析参数需要程序自定义。
 * 
 */
public class Cmd {
    public static void main(String[] args){
        for(String arg : args){
            if("-version".equals(arg)){
                System.out.println("arg:"+arg);
                System.out.println("jdk11.0.11");
            }
            break;
        }
        int [] arr2 = {1,3,5,2,6};
        // 若要使用另一个包中的类和函数，则该类和函数必须为public类型
        // com.array.sort.BubbleSort.sort_up(arr2);  // 可以写包名+函数名进行引用
        BubbleSort.sort_up(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
