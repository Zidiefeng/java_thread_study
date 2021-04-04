package com.kaitan.state;

//测试stop
//1。 建议线程正常停止，利用次数，不建议死循环
//2. 建议使用flag
//3. 别使用stop, destroy等过时方法
public class TestStop implements Runnable{

    //1. set flag 标识位
    private boolean flag = true;


    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run Thread:"+(i++));
        }
    }

    //2. 设置一个公开的方法 停止thread，转换flag
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if (i ==900){
                //调用 stop切换flag,让thread停止
                testStop.stop();
                System.out.println("stop the thread");
            }
        }
    }
}
