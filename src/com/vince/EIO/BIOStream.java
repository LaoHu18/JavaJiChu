package com.vince.EIO;

import org.junit.Test;

import java.io.*;

/**IO流
 * 根据数据的流向分为：输入流和输出流。
 * 输入流 ：把数据从其他设备上读取到内存中的流。
 * 输出流 ：把数据从内存中写出到其他设备上的流。
 *
 * 根据数据的类型分为：字节流和字符流。
 * 字节流 ：以字节为单位，读写数据的流。
 * 字符流 ：以字符为单位，读写数据的流。
 */
public class BIOStream {
    public static void main(String[] args) {
        //字节流：输入流InputStream，输出流：OutputStream
        //输出流：首先定义要输出的对象
        File file = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\123456.txt");
        try {
            OutputStream out = new FileOutputStream(file,false);         //true为追加内容，false为覆盖原有内容
            String info = "小桥流水人家\r\n" ;            //代表换行
            out.write(info.getBytes());
            System.out.println("写入成功");
            out.close();        //关闭流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //输入流：从文件中读取
        try {
            InputStream in = new FileInputStream(file);         //定义文件输入流
            StringBuilder buf = new StringBuilder();            //定义字符串对象
            byte[] bytes = new byte[1024];          //创建字节数组组
            int length = -1;                //每次要读取的长度
            while((length = in.read(bytes))!=-1){
                buf.append(new String(bytes,0,length));            //字符串拼接
            }
            System.out.println(buf);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //字符流：字符输入流：Reader，字符输出流Writer
    //每次操作的单位是一个字符
    //文件字符操作流会自带缓存，默认大小为1024字节，在缓存满后或手动刷新缓存或关闭流时会把数据写入文件
    @Test
    public void CharStream(){
        File file = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\123456.txt");
        //字符输入流
        try {
            Reader reader = new FileReader(file);
            StringBuilder str = new StringBuilder();
            char[] chars = new char[1];
            int length = -1;
            while ((length = reader.read(chars))!=-1){
                str.append(new String(chars,0,length));
            }
            System.out.println(str);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //字符输出流
        try {
            Writer writer = new FileWriter(file,false);
            String info = "断肠人在天涯\r\n";
            writer.write(info);
            System.out.println("写入成功");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
