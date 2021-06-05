package IO_HSP.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead {
    public static void main(String[] args) {
        String filepath = "IO_HSP\\properties\\info.properties";
        Properties props = new Properties();
        try {
            props.load(new FileReader(filepath));
            String ip = props.getProperty("ip");
            String port = props.getProperty("port");
            String name = props.getProperty("name");
            props.list(System.out);
            System.out.println("ip:"+ip);
            System.out.println("port:"+port);
            System.out.println("name:"+name);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
