package com.vince.HTCPAndUDP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//多客户端与服务器之间的通信（客户端）
public class BTCPMultiClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("准备进行连接");
        try {
            //创建客户端socket，确定ip、端口号
            Socket socket = new Socket("localhost",6666);
            //创建一个输出流，对服务器进行输出
            PrintWriter bw = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
            System.out.println("请输入想要传输给服务器的内容");
            String info = input.nextLine();
            bw.println(info);
            bw.flush();
            //创建一个输入流，读取服务器传过来的信息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(br.readLine());
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
