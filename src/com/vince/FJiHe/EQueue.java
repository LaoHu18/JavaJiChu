package com.vince.FJiHe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**Queue接口:队列，是一种先进先出的数据结构（排队）
 * LinkedList类实现了Queue接口
 * 请求队列，消息队列
 * Deque接口：一个线性Collection，支持在两端插入和删除操作,双端队列
 *
 * Stack：堆栈
 */

public class EQueue {
    public static void main(String[] args) {
        queue();
        System.out.println("---------");
        deque();
        System.out.println("---------");
        stack();
    }
    private static void queue() {
        Queue<String> queue = new LinkedList<>();
        queue.add("小虎");
        queue.add("喵喵");
        queue.add("花花");
        queue.add("汪汪");
        queue.add("丽丽");
        System.out.println(queue.size());
        System.out.println(queue.peek());      //检索队列的头并返回
        System.out.println(queue);
        System.out.println(queue.poll());		//检索队列的头删除并返回
        System.out.println(queue);
    }
    private static void deque() {
        Deque<String> deque =new LinkedList<>();
        deque.add("小虎");
        deque.add("喵喵");
        deque.add("花花");
        deque.add("汪汪");
        deque.add("丽丽");
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
    }
    private static void stack() {
        Stack<String> stack = new Stack<>();
        stack.push("bin");			//将项目推送到此堆栈的顶部
        stack.push("huahua");
        stack.push("wangwang");
        System.out.println(stack.empty());		//判断是否为空
        System.out.println(stack.peek());		//查看堆栈的顶部对象，而不删除他
        System.out.println(stack);
        System.out.println(stack.pop());		//删除堆栈顶部对象，并将该对象作为函数的值返回
        System.out.println(stack);

    }
}
