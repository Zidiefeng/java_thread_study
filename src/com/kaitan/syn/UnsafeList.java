package com.kaitan.syn;

import java.util.ArrayList;
import java.util.List;

//thread不安全的 集合
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
