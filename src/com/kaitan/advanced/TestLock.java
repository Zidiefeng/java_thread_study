package com.kaitan.advanced;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLocka testLocka = new TestLocka();
        //在创建上面的这个时候，就有一个testLocka.ticketNums了
        //下面分别只运行run函数，所有都对testLocka的ticketNums进行操作
        new Thread(testLocka).start();
        new Thread(testLocka).start();
        new Thread(testLocka).start();
    }
}

class TestLocka implements Runnable {

    static int ticketNums = 10;

    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try{
                lock.lock();//加锁

                //不安全的代码
                if (ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }finally{
                lock.unlock();//解锁
            }
        }
    }
}
