package com.vince.MGUI;

import java.awt.*;
import java.awt.event.*;

public class AGUI {
    public static void main(String[] args) {
        MyFram myFram = new MyFram();
    }
}

class MyFram extends Frame implements ActionListener {
    //创建我的窗口
    public MyFram(){
        //设置窗口的长宽
        this.setSize(600,400);
        //设置窗口的标题
        this.setTitle("我的第一个GUI窗口");
        //创建一个按钮
        Button button = new Button("点我一下，有惊喜哦！");
        //给按钮添加单击事件
        button.addActionListener(this);
        //创建一个线性布局
        FlowLayout flowLayout = new FlowLayout();
        //将线性布局应用到窗体上
        this.setLayout(flowLayout);
        //给窗体添加关闭事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //将按钮应用到窗体上
        this.add(button);
        //显示窗口
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("惊喜来了");
    }
}