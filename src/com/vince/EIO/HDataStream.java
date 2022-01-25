package com.vince.EIO;

import java.io.*;

/**数据流:DataInputStream\DataOutputStream
 * 使用数据流实现文件的分割与合并
 */
public class HDataStream {
    public static void main(String[] args) {
//        File target = new File("E:\\stm32\\[艾克姆科技]IK-ZET6开发板配套资料 - B盘\\" +
//                "第5部分：教学视频\\2 - 基础实验视频\\第2-1-1讲：GPIO硬件设计及原理介绍\\第2-1-1讲：GPIO硬件设计及原理介绍.mp4");
//        File combine = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\File2");
//        Division(target,combine,1021*1024*20);

        //合并文件测试
        File target = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\File2");
        File combin = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile");
        Merge(target,combin,"mp4");
    }

    /**文件的分割
     * @param target:被分割目标文件位置
     * @param combine:文件分割后存放位置
     * @param cutsize:被分割文件后每个文件大小
     */
    public static void Division(File target,File combine,long cutsize){
        if(target == null)return;
        //计算文件分割的个数
        int num = (target.length()%cutsize == 0)?(int) (target.length()/cutsize):(int)(target.length()/cutsize+1);
        //构造文件输入流,输出流
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(target));
            BufferedOutputStream bos = null;
            byte[] bytes = null;
            int len = -1;
            int count = 0;      //每个文件要读取的次数
            for(int i=0;i<num;i++){
                String path = combine.getPath().concat("\\");
                bos = new BufferedOutputStream(new FileOutputStream(new File(path+(i+1)+target.getName())));
                if(cutsize<=1024) {
                    bytes = new byte[(int)cutsize];
                    count = 1;
                }else {
                    bytes = new byte[1024];
                    count = (int)cutsize/1024;		//计算每个分割文件需要读取的次数
                }
                while(count>0 && (len = bis.read(bytes))!=-1) {
                    bos.write(bytes,0,len);
                    bos.flush();
                    count --;
                }
                if(cutsize%1024 !=0) {
                    bytes = new byte[(int)cutsize%1024];
                    len = bis.read(bytes);
                    bos.write(bytes,0,len);
                    bos.flush();
                    bos.close();
                }
            }
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //文件的合并
    public static void Merge(File target,File combin,String type){
        if(target == null)return;
        File[] files = target.listFiles();          //创建文件夹数组
        String path = combin.getPath().concat("\\");
        long start = System.currentTimeMillis();
        try {
            BufferedInputStream bis = null;
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(path+"合并文件."+type)));
            for (int i = 0; i < files.length; i++) {        //遍历文件夹
                if(files[i].getName().endsWith(type)){
                    bis = new BufferedInputStream(new FileInputStream(files[i]));
                    byte[] bytes = new byte[1024];
                    int len = -1;
                    while ((len = bis.read(bytes))!= -1){
                        bos.write(bytes,0,len);
                    }
                    bis.close();
                }else
                    continue;
            }
            bos.close();
            long end = System.currentTimeMillis();
            System.out.println("合并用时："+(end-start)+"毫秒");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
