package com.vince.EIO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**File类：是文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作。
 *
 */
public class AFile {
    public static void main(String[] args) {
        //File类的构建方法
        File file = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\1234.txt");
        if(!file.exists()){     //判断此文件或文件夹是否存在
            try {
                file.createNewFile();       //用于实际创建
                System.out.println("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("此文件或文件夹已存在，请重新创建新的文件或文件夹");
        }

        //判断是否为文件或文件夹
        System.out.println("是否为文件"+file.isFile());
        System.out.println("是否为文件夹"+file.isDirectory());

        //删除文件或文件夹
        boolean bool = file.delete();
        System.out.println("文件是否删除成功"+bool);

        File f = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO");
        //列出当前目录下所有文件名字
        String[] name = f.list();
        System.out.println(Arrays.toString(name));
        //列出当前目录所有文件，并以文件的方式进行返回
        File[] files = f.listFiles();
        for(File file1:files){
            System.out.println("文件的长度为："+file1.length());
            System.out.println("文件的名字"+file1.getName());
            System.out.println("文件的相对路径"+file1.getPath());
            System.out.println("文件的绝对路径"+file1.getAbsolutePath());
            System.out.println("是否为隐藏文件"+file1.isHidden());
            System.out.println("是否为可读文件"+file1.canRead());
            Date date = new Date(file1.lastModified());	//获取最后的修改时间
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            System.out.println("最后修改时间"+df.format(date));
        }

        //创建新的文件夹
        File file1 = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\file1");
        file1.mkdir();

        //为文件夹重命名
        file1.renameTo(new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\newfile"));
    }

    //文件的遍历：输出一个文件夹中的所有内容
    @Test
    public void test(){
        File file = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile");
        FindFile(file);
    }
    public static  void FindFile(File file){
        File[] files = file.listFiles();
        for(File file1:files){
            if(file1.isFile()){         //判断是否为文件，是则输出相对路径，不是则递归寻找
                System.out.println(file1.getPath());
            }else
                FindFile(file1);
        }
    }
}
