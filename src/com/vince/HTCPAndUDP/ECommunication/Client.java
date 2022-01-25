package com.vince.HTCPAndUDP.ECommunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 客户端与客户端之间的即时对话
 * 客户端用来对话
 * 使用主线程发送消息，利用用户线程接收消息
 */
public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //创建线程池
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            //创建一个socket
            Socket socket = new Socket("localhost", 8888);
            System.out.println("服务器连接成功");
            //创建相关的对象流
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("请输入自己的用户名：");
            String SendName = input.nextLine();
            //创建一个消息包：首先用来登录
            Message message = new Message(SendName, null, Messagetype.TYPE_LOGIN, null);
            //向服务器发送消息
            oos.writeObject(message);
            //接收服务器传回的消息
            message = (Message) ois.readObject();
            System.out.println(message.getInfo() + message.getReceive());
            //启动读取消息的线程
            es.execute(new ReceiveRunnable(ois));
            boolean bool = true;
            while (bool) {
                Message sendmessage = new Message();
                sendmessage.setSend(SendName);
                System.out.println("请输入你要发送的用户对象名称");
                String ReceiveName = input.nextLine();
                sendmessage.setReceive(ReceiveName);
                sendmessage.setType(Messagetype.TYPE_SEND);
                System.out.println("请输入要发送的内容");
                String info = input.nextLine();
                sendmessage.setInfo(info);
                //发送消息包
                oos.writeObject(sendmessage);
            }
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

//用于读取接收来的消息
class ReceiveRunnable implements Runnable {
    private ObjectInputStream objectInputStream;
    private boolean flag = true;

    public ReceiveRunnable(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }
    public void setFlag(boolean flag){
        this.flag= flag;
    }

    @Override
    public void run() {

        try {
            while (flag) {
                //读取传来的消息包
                Message message = (Message) objectInputStream.readObject();
                System.out.println(message.getSend() + "对我说：" + message.getInfo());
            }
            if(objectInputStream != null){
                objectInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}