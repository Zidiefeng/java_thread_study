package com.kaitan.demo01;

//多个线程 同时操作一个对象（可能出现conflict）
//比如 买火车票的例子
public class TestThread4 implements Runnable{

    // tickets number
    private int ticketNums = 10;


    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            System.out.println( Thread.currentThread().getName()+" purchased ticket Num "+ticketNums--);
            //模拟延迟
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();
        new Thread(ticket, "P1").start();
        new Thread(ticket, "P2").start();
        new Thread(ticket, "P3").start();
    }


}
