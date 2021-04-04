package com.kaitan.demo01;
//模拟龟兔赛跑
public class Race implements Runnable{

    private static String winner;


    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {

            if(Thread.currentThread().getName().equals("Rabbit") && i%10==0){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            System.out.println(Thread.currentThread().getName()+" ran "+i+" m");
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps){
        if(winner !=null){
            return true;

        }else {
            if(steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is "+winner);
                return true;
            }
        }

        return false;

    }


    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"Turtle").start();
        new Thread(race,"Rabbit").start();

    }
}
