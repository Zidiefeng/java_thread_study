package com.kaitan.advanced;

//测试 生产者 消费者问题： 信号灯法，标志位解决
public class TestPc2 {
    public static void main(String[] args) {
        Show show = new Show();
        new Actor(show).start();
        new Audience(show).start();
    }

}

//生产者- 演员
class Actor extends Thread{
    Show show;
    public Actor(Show show){
        this.show = show;
    }

    @Override
    public void  run(){
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.show.perform("快乐大本营播放中");
            }else{
                this.show.perform("广告");
            }
        }
    }

}

//消费者-观众
class Audience extends Thread{
    Show show;
    public Audience(Show show){
        this.show = show;
    }

    public void run(){
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.show.watch();
            }else{
                this.show.watch();
            }
        }
    }
}

//产品-节目
class Show {
    //演员录制表演节目，观众等待 T
    //观众观看节目，演员等待反馈 F
    String show;
    boolean flag = true;

    //表演
    public synchronized void perform(String show){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Actor performed:"+show);
        //通知观众观看
        this.notifyAll();
        this.show = show;
        this.flag = !this.flag;
    }


    //观看
    public synchronized void watch() {
        if(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Audience watched:"+show);
        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;


    }
}
