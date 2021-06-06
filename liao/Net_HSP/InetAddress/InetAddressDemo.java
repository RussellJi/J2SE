package Net_HSP.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 通过InetAddress可以获得host对象
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        // 获取主机 1
        InetAddress host1 = InetAddress.getLocalHost();
        System.out.println(host1);
        // 获取主机 2
        InetAddress host2 = InetAddress.getByName("YHA-GWSTA");
        System.out.println(host2);
        // 根据主机对象，获取主机名，ip地址
        System.out.println(host1.getHostName());
        System.out.println(host1.getHostAddress());

        InetAddress host3 = InetAddress.getByName("www.baidu.com");
        System.out.println(host3.getHostName()+":"+host3.getHostAddress());
        
        
    }
}
