package com.kaitan.demo01;

import java.util.TreeMap;

//创建thread方式2： 实现runnable 接口，重写run方法，执行thread时将 runnable接口instance 放入 thread 的 input，调用.start()
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        //run方法 Thread体
        for (int i = 0; i < 20; i++) {
            System.out.println("I am reading the code"+i);
        }
    }

    public static void main(String[] args) {
        //创建线程对象，调用start()
        TestThread3 trd3 = new TestThread3();

        // 创建线程对象， 通过线程对象开启我们的 线程，这个称为代理
//        Thread thread = new Thread(trd3);
//
//        thread.start();
        new Thread(trd3).start();


        for (int i = 0; i < 20; i++) {
            System.out.println("I am reading multi-thread"+i);
        }
    }
}
