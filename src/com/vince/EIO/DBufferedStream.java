package com.vince.EIO;

import org.junit.Test;

import java.io.*;

/**缓冲流
 * 字节缓冲流：BufferedInputStream，BufferedOutputStream
 * BufferedOutputStream 内部默认缓存大小是8kb，每次写入时存储到缓存的byte数组中，当数组存满时，会把数组中的数据写入文件，并将缓存清零
 *
 * 字符缓冲流：BufferedReader，BufferedWriter
 * BufferedReader:默认缓存大小为8k，但可以手动指定缓存大小，把数据进接读取到缓冲中，减少转换过程
 * 缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率
 */
public class DBufferedStream {
    @Test
    //字节缓冲流
    public void bytebuffer(){
        File file = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\123456.txt");
        File copy = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\copy.txt");
        long start = System.currentTimeMillis();
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copy));
            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            bis.close();
            bos.close();
            long end = System.currentTimeMillis();
            System.out.println("复制所用的时间为"+(end - start)+"毫秒");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
