package com.vince.EIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**打印流
 * 字节打印流：PrintStream
 * 字符打印流：PrintWriter
 * 可改变输出的流向
 */
public class EPrintSream {
    public static void main(String[] args) {
        File file = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\File1\\File1test.txt");
        try {
            PrintStream ps =new PrintStream(file);
            System.out.println("这里是系统输出到控制台");
            //用打印流改变流向
            System.setOut(ps);
            System.out.println("这里是打印流");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
