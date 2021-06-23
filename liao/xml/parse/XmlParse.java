package xml.parse;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;

public class XmlParse {

    @Test
    public void xmlParse() throws IOException{
        String path = "F:\\Vscode\\JavaProject\\J2SE\\liao\\xml\\parse\\user.xml";
        Document document = Jsoup.parse(new File(path), "UTF-8");
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println(elements.get(0).text());
        System.out.println(elements.get(1).text());

    }    
    @Test
    public void strParse() throws IOException{
        // String str = "<?xml version="1.0" encoding="UTF-8"?>
        // <users>
        //     <user>
        //         <id>123</id>
        //         <name>纪浩瀚</name>
        //         <age>23</age>
        //     </user>
        //     <user>
        //         <id>124</id>
        //         <name>张书嫚</name>
        //         <age>23</age>
        //     </user>
        // </users>";
        String str = "";
        Document document = Jsoup.parse(str);
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println(elements.get(0).text());
        System.out.println(elements.get(1).text());

    }    
    @Test
    public void urlParse() throws IOException{
        URL url = new URL("http://www.baidu.com");
        Document document = Jsoup.parse(url, 5000);
        // Elements elements = document.getElementsByTag("div");

        // System.out.println(elements.get(0).text());
        System.out.println(document.toString());

    }
    @Test
    // 选择器查询
    public void xmlSelect() throws IOException{
        String path = "F:\\Vscode\\JavaProject\\J2SE\\liao\\xml\\parse\\user.xml";
        Document document = Jsoup.parse(new File(path), "UTF-8");
        // Elements elements = document.getElementsByTag("number");
        Elements elements = document.select("user[number='1'] > age");
        System.out.println(elements.text());
        // String age = elements.get(0).getElementsByTag("age").text();
        // System.out.println(age);

    }    
    @Test
    // xpath 
    public void xpath() throws IOException, XpathSyntaxErrorException{
        String path = "F:\\Vscode\\JavaProject\\J2SE\\liao\\xml\\parse\\user.xml";
        Document document = Jsoup.parse(new File(path), "UTF-8");
        
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxnode = jxDocument.selN("//users/user[@number='1']");
        // List<JXNode> jxnode = jxDocument.selN("//users/user[@number]");
        for(JXNode node:jxnode){
            System.out.println(node);
        }

    }    

}
