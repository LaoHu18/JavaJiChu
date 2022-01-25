package com.vince.HTCPAndUDP.ECommunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 客户端与客户端之间的即时对话
 * 服务器端用来判定客户端传来的消息的类型并作出相应的处理
 */
public class Serve {
    public static void main(String[] args) {
        //创建线程池集合
        Vector<ServeRunnable> vector = new Vector<>();
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            //创建服务器socket
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器创建成功，等待连接.....");
            while (true){
                Socket socket = serverSocket.accept();
                ServeRunnable serveRunnable = new ServeRunnable(socket,vector);
                executorService.execute(serveRunnable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//创建线程：该线程用于处理相关客户端消息
class ServeRunnable implements Runnable {
    private String name;        //客户端的用户名称
    private Socket socket;
    private Vector<ServeRunnable> vector;       //客户端处理线程的集合
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean flag = true;

    public ServeRunnable(Socket socket, Vector<ServeRunnable> vector) {
        this.socket = socket;
        this.vector = vector;
        vector.add(this);
    }

    @Override
    public void run() {
        try {
            System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "连接成功");
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            while (flag) {
                Message message = (Message) ois.readObject();
                name = message.getSend();
                int type = message.getType();
                switch (type) {
                    case Messagetype.TYPE_LOGIN:               //此时为登录类型
                        message.setInfo("欢迎你：" + message.getSend());
                        message.setSend("服务器");
                        oos.writeObject(message);
                        break;

                    case Messagetype.TYPE_SEND:             //此时为发送消息类型
                        //vector.get(i).name为该线程的名字，message.getTo()为消息包要发送给某个线程的名字
                        String receivename = message.getReceive();
                        for (int i = 0; i < vector.size(); i++) {
                            if (receivename.equals(vector.get(i).name) && vector.get(i) != this) {
                                vector.get(i).oos.writeObject(message);
                                break;
                            }
                        }
                        break;
                }
            }
            oos.close();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
