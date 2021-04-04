package com.kaitan.demo01;

public class TestThread1 extends Thread{
    @Override
    public void run() {
        //run方法 Thread体
        for (int i = 0; i < 20; i++) {
            System.out.println("I am reading the code"+i);
        }
    }

    public static void main(String[] args) {

        //主线程 main Thread

        //创建线程对象，调用start()
        TestThread1 trd1 = new TestThread1();
        trd1.start();//如果改成run()就是 先执行完之后 再执行后面的

        for (int i = 0; i < 20; i++) {
            System.out.println("I am reading multi-thread"+i);
        }
    }
}
