package com.vince.HTCPAndUDP;

import java.io.*;
import java.net.Socket;

/**TCP通信：客户端client，服务器端server
 * TCP协议四层通信：应用层、传输层、网络层、链路层
 * TCP协议中，需要三次握手：
 * 第一次握手，客户端向服务器端发出连接请求，等待服务器确认。
 * 第二次握手，服务器端向客户端回送一个响应，通知客户端收到了连接请求。
 * 第三次握手，客户端再次向服务器端发送确认信息，确认连接。
 *
 */
//单独通信客户端的创建
public class ATCPEchoClient {
    public static void main(String[] args) {
        System.out.println("准备进行连接");
        try {
            //创建客户端socket，确定ip、端口号
            Socket socket = new Socket("localhost",6666);
            //创建一个输出流，对服务器进行输出
            PrintWriter bw = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
            bw.println("你好，服务器");
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
