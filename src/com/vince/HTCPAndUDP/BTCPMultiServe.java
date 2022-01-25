package com.vince.HTCPAndUDP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//多客户端与服务器之间的通信（服务器）,利用线程池进行处理
public class BTCPMultiServe {
    public static void main(String[] args) {
        //创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            //创建服务器socket
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务器创建成功，等待连接");
            while(true){
                //等待客户端的连接，造成阻塞，如果客户端连接成功，立即返回一个socket对象
                Socket socket = serverSocket.accept();
                System.out.println("欢迎你："+socket.getInetAddress().getHostAddress());
                executorService.execute(new ServeRunnable(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//创建处理客户端信息的线程
class ServeRunnable implements Runnable{
    private Socket socket;
    public ServeRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //创建一个输入流，读取客户端传来的信息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("接收到"+socket.getLocalAddress().getHostAddress()+"传来的信息："+br.readLine());
            //创建一个输出流，向客户端回复
            PrintWriter bw = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));

            bw.println("我已收到，"+socket.getLocalAddress().getHostAddress()+"，你好");
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}