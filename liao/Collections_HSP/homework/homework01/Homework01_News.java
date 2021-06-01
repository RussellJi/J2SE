package Collections_HSP.homework.homework01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * （1）封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；

   （2）只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
      
        新闻一：新冠确诊病例超干万，数百万印度教信徒赴恒河“圣浴”引民众担忧

        新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生

   （3）将新闻对象添加到ArrayList集合中，并且进行倒序遍历；

   （4）在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后在后边加"..."

   （5）在控制台打印遍历出经过处理的新闻标题；
 */

 @SuppressWarnings("all")
public class Homework01_News {
    public static void main(String[] args) {

        ArrayList<News> arr = new ArrayList<News>();
        arr.add(new News("新闻一：新冠确诊病例超干万，数百万印度教信徒赴恒河“圣浴”引民众担忧。"));
        arr.add(new News("新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生."));


        Collections.reverse(arr);



        
        // Iterator遍历集合
        Iterator iter = arr.iterator();
        while(iter.hasNext()){
            // StringBuilder sb = new StringBuilder();
            String s = iter.next().toString();
            if(s.length() > 15){
                
                s = s.substring(0, 15)+"...";
            }
            System.out.println(s);
        }
    }
}
class News {
    private String title;
    private String content;

    public News(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

    // 修改toSring，只打印标题
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.title;
    }
}