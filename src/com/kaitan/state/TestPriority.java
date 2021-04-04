package com.kaitan.state;

public class TestPriority {
    public static void main(String[] args) {
        //main thread-priority check
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t0 = new Thread(myPriority);
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);

        //set priority, start
        t0.start();

        t1.setPriority(1);
        t1.start();

        t2.setPriority(4);
        t2.start();

        t3.setPriority(Thread.MAX_PRIORITY); //10
        t3.start();

        t4.setPriority(7);
        t4.start();

        t5.setPriority(8);
        t5.start();

        //t4.setPriority(-1);
        //t4.start();

        //t5.setPriority(11);
        //t5.start();



    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
