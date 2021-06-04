package IO_HSP.IO_Stream.OutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import IO_HSP.IO_Stream.Dog;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        String filepath = "F:\\Vscode\\JavaProject\\J2SE\\liao\\IO_HSP\\IO_Stream\\OutputStream\\dog.dat";
        ObjectOutputStream oos = null;
        Dog dog = new Dog("mim", 123, "white");
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filepath));
            oos.writeInt(123);
            oos.writeBoolean(true);
            oos.writeObject(dog);
            System.out.println("写入完毕");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                oos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
