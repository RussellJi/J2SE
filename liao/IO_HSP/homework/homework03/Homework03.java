package IO_HSP.homework.homework03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

/**
 * 读取dog.properties配置文件，用Properties类
 * getProperty(key)
 */
public class Homework03 {
    public static void main(String[] args) throws ClassNotFoundException {
        String filepath = "IO_HSP\\homework\\homework03\\dog.properties";
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(filepath));
            String name = props.getProperty("name");
            String color = props.getProperty("color");
            int age = Integer.parseInt(props.getProperty("age"));
            Dog dog = new Dog(name,age,color);
            System.out.println(dog);

            // 序列化对象
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(new FileOutputStream("IO_HSP\\homework\\homework03\\dog.dat"));
            oos.writeObject(dog);
            System.out.println("dog Object写入成功");
            oos.close();

            // 反序列化
            ObjectInputStream ois  = null;
            ois = new ObjectInputStream(new FileInputStream("IO_HSP\\homework\\homework03\\dog.dat"));
            Dog dog2 = (Dog)ois.readObject();
            System.out.println(dog2);
            ois.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
