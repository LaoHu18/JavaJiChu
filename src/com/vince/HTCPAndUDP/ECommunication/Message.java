package com.vince.HTCPAndUDP.ECommunication;

import java.io.Serializable;

/**客户端与客户端之间的即时对话
 * 客户端传递的消息包，需要进行序列化
 */
public class Message implements Serializable {
    private String Send;            //发送者的名称
    private String Receive;         //接受者的名称
    private int Type;               //发送的消息的类型
    private String info;            //发送的具体消息

    public Message() {}

    public Message(String send, String receive, int type, String info) {
        Send = send;
        Receive = receive;
        Type = type;
        this.info = info;
    }

    public String getSend() {
        return Send;
    }

    public void setSend(String send) {
        Send = send;
    }

    public String getReceive() {
        return Receive;
    }

    public void setReceive(String receive) {
        Receive = receive;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Send='" + Send + '\'' +
                ", Receive='" + Receive + '\'' +
                ", Type=" + Type +
                ", info='" + info + '\'' +
                '}';
    }
}
