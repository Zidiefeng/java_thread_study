package com.kaitan.state;

import com.kaitan.demo01.TestThread4;

//模拟网络延迟
public class TestSleep implements Runnable{

    // tickets number
    private int ticketNums = 10;


    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            System.out.println( Thread.currentThread().getName()+" purchased ticket Num "+ticketNums--);

            //模拟延迟，去掉这部分没有什么问题，模拟之后，发现线程可能不安全：有重复被取的 票，还有可能出现-1票
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();
        new Thread(ticket, "P1").start();
        new Thread(ticket, "P2").start();
        new Thread(ticket, "P3").start();
    }

}
