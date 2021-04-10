package com.kaitan.syn;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"Me").start();
        new Thread(station,"You").start();
        new Thread(station,"HuangNiu").start();

    }
}

class BuyTicket implements Runnable{
    // ticket
    private int ticketNums = 10;
    boolean flag = true; //external stop

    @Override
    public void run() {//purchase ticket
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if (ticketNums <=0){
            flag = false;
            return;
        }

        // mock delay
        Thread.sleep(100);

        //purchase ticket
        System.out.println(Thread.currentThread().getName()+" get "+ticketNums--);
    }
}