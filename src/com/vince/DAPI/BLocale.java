package com.vince.DAPI;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**Locale 表示地区。
 * 每一个Locale对象都代表了一个特定的地理、政治和文化地区。
 */
public class BLocale {
    public static void main(String[] args) {
        //创建对象,获取默认Local
        Locale locale = Locale.getDefault();
        System.out.println(locale);

        Locale locale_CN = new Locale("zh","CN");
        Locale locale_US = new Locale("en","US");

        //使用需要创建相应的配置文件
        //用于绑定属性文件的工具类(参数：属性文件的基本名（就是前缀）,所需使用的语言环境对象）
        ResourceBundle rb = ResourceBundle.getBundle("com.vince.DAPI.Binfo", locale_CN);
        Scanner input = new Scanner(System.in);
        System.out.println(rb.getString("sysytem.name"));
        System.out.println(rb.getString("input.username"));
        String username = input.nextLine();
        System.out.println(rb.getString("input.password"));
        String password = input.nextLine();
        if("admin".equals(username)&&"123".equals(password)) {
            System.out.println(rb.getString("login.success"));
            //获取动态文本,使用MessageFormat.format(参数对象, 动态参数);
            String welcome = rb.getString("welcome");
            System.out.println(MessageFormat.format(rb.getString("welcome"), username));
        }else
            System.out.println(rb.getString("login.error"));
    }
}
