package com.vince.CDataStructure;

import java.util.Scanner;

/**
 * 简单的链表
 */
public class BLinkedlist {
    public static void main(String[] args) {
        NodeManager nm = new NodeManager();
        nm.add(5);
        nm.add(4);
        nm.add(3);
        nm.find(3);
        nm.print();
        nm.del(4);
        nm.print();
        nm.updata(3);
        nm.print();

    }
}
class NodeManager{
    //创建根节点
    private Node node;
    //创建根节点的添加方法
    public void add(int data){
        if(node == null){
          node = new Node(data);
        }else{
            node.addNode(data);
        }
    }
    //创建从根节点开始的查询方法
    public boolean find(int data){
        if(node == null){
            System.out.println("此链表中并无数据存储，无法查找对应值");
            return false;
        } else if (node != null) {
            if(node.getData() == data){
                System.out.println("已查找到对应数据，且为链表根节点");
                return true;
            }else{
                node.findNode(data);
            }
        }
        return false;
    }
    //创建根节点删除方法
    public void del(int data){
        if(node != null){
            if(node.getData() == data){
                node = node.next;
                System.out.println("已经删除完毕");
            }else{
                node.delNode(data);
            }
        }else
            System.out.println("无数据存储，请创建数据后进行删除");
    }
    //创建根节点更新
    public void updata(int data){
        if(node != null){
            if(node.getData() == data){
                System.out.println("请输入要更新的数据");
                Scanner input = new Scanner(System.in);
                int updata = input.nextInt();
                node.setData(updata);
                System.out.println("数据更新完毕 ");
            }else {
                node.updataNode(data);
            }
        }else
            System.out.println("无数据存储，请创建数据后进行更新");
    }
    //创建根节点输出方法
    public void print(){
        if(node!=null){
            System.out.print(node.getData()+"->");
            node.printNode();
            System.out.println("输出完毕");
        }else
            System.out.println("无存储数据，无法进行输出");
    }

    //创建节点内部类
    private class Node{
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        //创建添加方法
        public void addNode(int data){
            if(this.next == null){
                this.next = new Node(data);
            }else{
                this.next.addNode(data);
            }
        }
        //创建查询方法
        public boolean findNode(int data){
            if(this.next == null){
                System.out.println("并未找到对应数据");
                return false;
            }else if(this.next != null){
                if(this.next.data == data){
                    System.out.println("已找到对应数据");
                    return true;
                }else{
                    this.next.findNode(data);
                }
            }
            return false;
        }
        //创建删除方法
        public void delNode(int data){
            if(this.next != null){
                if(this.next.getData() == data){
                    this.next = this.next.next;
                    System.out.println("数据删除完毕");
                }else{
                    this.next.delNode(data);
                }
            }else
                System.out.println("请输入对应数据后进行删除");
        }
        //创建更新方法
        public void updataNode(int data){
            if(this.next != null){
                if(this.next.getData() == data){
                    System.out.println("请输入要更新的数据");
                    Scanner input = new Scanner(System.in);
                    int updata = input.nextInt();
                    this.next.setData(updata);
                    System.out.println("数据更新完毕");
                }else{
                    this.next.updataNode(data);
                }
            }else{
                System.out.println("未找到对应数据，无法更新");
            }
        }
        //创建输出方法
        public void printNode(){
            if(this.next!=null){
                System.out.print(this.next.getData()+"->");
                this.next.printNode();
            }else
                return;
        }
    }
}