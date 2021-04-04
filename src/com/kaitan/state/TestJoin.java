package com.kaitan.state;

//测试join，想象为插队
public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("VIP is here"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //start the thread
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();


        //main thread
        for (int i = 0; i < 50; i++) {
            if(i==25){
                thread.join(); //插队
            }
            System.out.println("main"+i);
        }
    }
}
