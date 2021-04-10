package com.kaitan.deadlock;

public class DeadLock {
    public static void main(String[] args) {
        Makeup g1  = new Makeup(0,"灰姑娘");
        Makeup g2  = new Makeup(1,"白雪公主");

        g1.start();
        g2.start();
    }
}


class Lipstick{
}

class Mirror{
}

class Makeup extends Thread{

    //需要的资源只有一份，用static 来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;//使用化妆品的人

    Makeup(int choice, String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    private void makeup() throws InterruptedException {
        //化妆，互相持有对方的锁，需要拿到对方的资源
        if (choice==0){
            synchronized(lipstick){
                //获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }
        }else{
            synchronized(mirror){
                //获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(2000);
                synchronized (lipstick){
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }
        }

    }

    @Override
    public void run(){
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
