package IO_HSP.IO_Stream.InputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import IO_HSP.IO_Stream.Dog;

public class ObjectInputSteamDemo {
    public static void main(String[] args) {
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\OutputStream\\dog.dat";
        ObjectInputStream ois = null;
        
        try {
            ois = new ObjectInputStream(new FileInputStream(filepath));

            // 反序列化时要按顺序读取
            System.out.println(ois.readInt());
            System.out.println(ois.readBoolean());
            try {
                // 向下转型
                Dog dog = (Dog)ois.readObject();
                System.out.println(dog);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
