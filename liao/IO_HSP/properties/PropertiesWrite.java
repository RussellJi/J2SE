package IO_HSP.properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWrite {
    public static void main(String[] args) {
        Properties props = new Properties();
        String filepath = "IO_HSP\\properties\\pinfo.properties";
        //  map.put(key, value)
        props.setProperty("id","116");
        props.setProperty("name","纪浩瀚");
        props.setProperty("age","23");
        try {
            props.store(new FileWriter(filepath), "pinfo");
            System.out.println("写入完毕");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
