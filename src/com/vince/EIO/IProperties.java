package com.vince.EIO;

import java.io.*;
import java.util.Properties;

/**配置文件操作：Properties
 * 用于读取配置文件
 */
public class IProperties {
    public static String VINCE = "";
    public static String USERNAME = "";
    public static String PASSWORD = "";
    public static void main(String[] args) {
        //对配置文件进行读取
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\IConfig.properties");
            properties.load(inputStream);           //加载文件
            VINCE = properties.getProperty("VINCE");                //从配置文件中获取对应的信息
            USERNAME = properties.getProperty("USERNAME");
            PASSWORD = properties.getProperty("PASSWORD");
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(IProperties.VINCE);
        updata("2","laohu","5841314");
    }

    //对配置文件进行更新
    public static void updata(String vince,String username,String password){
        Properties properties = new Properties();
        properties.put("VINCE",vince);              //参数分别为：所需更改的内容名称；更改后的内容
        properties.put("USERNAME",username);
        properties.put("PASSWORD",password);
        try {
            OutputStream outputStream = new FileOutputStream("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\IConfig.properties");
            properties.store(outputStream,"updata");            //写入更改
            System.out.println("更新完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
