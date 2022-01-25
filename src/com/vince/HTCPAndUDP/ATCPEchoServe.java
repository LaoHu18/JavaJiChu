package com.vince.HTCPAndUDP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//单独通信服务器的创建
public class ATCPEchoServe {
    public static void main(String[] args) {
        try {
            //创建一个服务器socket
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务器已创建，等待连接");
            //等待客户端的连接，造成阻塞，如果客户端连接成功，立即返回一个socket对象
            Socket socket = serverSocket.accept();
            System.out.println("客户端连接成功："+socket.getLocalAddress().getHostAddress());
            //创建一个输入流，读取客户端传来的信息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(br.readLine());
            //创建一个输出流，向客户端回复
            PrintWriter bw = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
            bw.println("我已收到，客户端，你好");
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
