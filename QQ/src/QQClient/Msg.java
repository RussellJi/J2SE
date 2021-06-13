package QQClient;

import java.io.Serializable;


/*
*消息对象的结构：
* 1.消息类型；
* 2.接收人；
* 3.消息内容；
* 4.序列化版本号
*
*  */
public class Msg implements Serializable {
    private MIME type;
    private String destination = null;
    private String content = null;
    private long serialVersionUID = 1L;

    public Msg(MIME type, String destination, String content) {
        this.type = type;
        this.destination = destination;
        this.content = content;
    }

    public MIME getType() {
        return type;
    }

    public String getDestination() {
        return destination;
    }

    public String getContent() {
        return content;
    }
}

