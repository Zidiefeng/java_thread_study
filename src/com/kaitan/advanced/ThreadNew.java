package com.kaitan.advanced;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 回顾总结线程 创建
public class ThreadNew {
    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread2()).start();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread3());
        //control+click to see the param*
        //can pass callable/runnable
        //callable extends runnable
        new Thread(futureTask).start();
        //get returned value
        try {
            Integer integer =  futureTask.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//1. extends Thread
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}

//2. implements Runnable
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}

//3. implements callable, needs a return
class MyThread3 implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3");
        return 100;
    }
}