package com.vince.HTCPAndUDP;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**URL使用字符串形式描述如何在Internet上找寻一个资源
 *
 */
public class DURL {
    public static void main(String[] args) {
        try {
            //创建url
            URL url = new URL("https://wenku.baidu.com/view/a79bbe1a844769eae009ed5a.html?fixfr=SXilVuui%252BsN8MwQyiIDKHQ%253D%253D&fr=income1-search");
            //返回连接
            // 如果你连接HTTP协议的URL, openConnection() 方法返回 HttpURLConnection 对象。
            //如果你连接的URL为一个 JAR 文件, openConnection() 方法将返回 JarURLConnection 对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //创建输入流和输出流：输入流读取网页数据
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\HTCPAndUDP\\URL\\下载")));
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len = bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            bis.close();
            bos.close();
            System.out.println("下载成功");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
