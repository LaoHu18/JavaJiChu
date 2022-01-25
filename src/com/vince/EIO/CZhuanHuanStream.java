package com.vince.EIO;

import java.io.*;


/**转换流
 * 编码:字符(能看懂的)–字节(看不懂的)
 * 解码:字节(看不懂的)–>字符(能看懂的)
 * InputStreamReader类：是Reader的子类，是从字节流到字符流的桥梁
 */
public class CZhuanHuanStream {
    public static void main(String[] args) {
        //输入转换流：InputStreamReader，读取字节，并使用指定的字符集将其解码为字符
        File file = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\123456.txt");
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"UTF-8");    //默认为UTF8编码
            char[] chars = new char[1024];
            int len = -1;
            while ((len = isr.read(chars))!=-1){
                System.out.println((new String(chars, 0, len)));
            }
            isr.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //输出转换流：OutputStreamWriter，是从字符流到字节流的桥梁。使用指定的字符集将字符编码为字节
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file,false),"UTF-8");
            String info = "断肠人在天涯\r\n" ;
            osw.write(info);
            osw.close();
            System.out.println("写入完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
