package com.vince.HTCPAndUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**UDP接收端的创建
 *
 */
public class CUDPServe {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        //创建存储数据的数据包
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        try {
            DatagramSocket socket = new DatagramSocket(8000);
            System.out.println("正在接收数据中");
            socket.receive(datagramPacket);
            String out = new String(datagramPacket.getData(),0,datagramPacket.getLength());
            System.out.println(out);
            socket.close();
            System.out.println("接收数据完成");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
