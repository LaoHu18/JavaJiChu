package com.vince.JGenericsAndRegulars;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**正则表达式
 *
 */
public class BRegulars {
    public static void main(String[] args){
        //创建一个匹配模式模板
        Pattern compile = Pattern.compile("a*b*");      //表示由多个a和b组成
        Matcher match = compile.matcher("aaabb");
        boolean b = match.matches();            //进行比较
        System.out.println(b);
    }
}
