package com.kaitan.state;

//测试守护线程
//上帝守护你
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); // default is false (user thread)

        thread.start(); // start god - daemon thread

        new Thread(you).start(); // 你用户线程


    }
}

// god
class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("God bless you");
        }
    }
}



// you
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("一生都开心的活着");
        }
        System.out.println("goodbye~! World.");
    }
}