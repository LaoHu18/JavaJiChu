package com.vince.EIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**字节数组流
 * ByteArrayInputStream
 * ByteArrayOutputStream
 * 提取字符串中指定的数据类型
 */
public class GByteArrayStream {
    public static void main(String[] args) {
        String s = "adsdQ46556$%^&*WIEQRQ";
        ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int curr = -1;
        while((curr = bais.read())!=-1) {
            if((curr>=65 && curr<=90) || (curr>=97 && curr<=122)) {
                baos.write(curr);
            }
        }
        System.out.println(baos.toString());
    }
}
