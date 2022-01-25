package com.vince.HTCPAndUDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**UDP发送端的创建
 *
 */
public class CUDPClient {
    public static void main(String[] args) {
        //创建要传输的数据
        System.out.println("请输入要传输的数据");
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        //将传输数据转换为数组
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        try {
            //创建数据包
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length, InetAddress.getByName("127.0.0.1"),8000);
            //创建传输socket
            DatagramSocket datagramSocket = new DatagramSocket(9000);
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
            System.out.println("传输数据完成");
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
