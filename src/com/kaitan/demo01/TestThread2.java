package com.kaitan.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//实现 多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;//网络图片地址
    private String name;//文件储存地址/文件名


    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片线程的 执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://en.wikipedia.org/wiki/C.C._(Code_Geass)#/media/File:CC_033_animestocks-com--2-.jpg","luluxiu.jpg");
        TestThread2 t2 = new TestThread2("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz44O_3BH7DA3JbZ8nTu8GV67ghJOyCFKICA&usqp=CAU","1.jpg");
        TestThread2 t3 = new TestThread2("https://www.google.com/imgres?imgurl=https%3A%2F%2Favatars2.githubusercontent.com%2Fu%2F5275753%3Fs%3D400%26u%3Dc71363fdc15a91c5e35765d7b7d3ab2d82b50f0f%26v%3D4&imgrefurl=https%3A%2F%2Fgithub.com%2Fluluxiu&tbnid=82q-cjKkjw7xsM&vet=12ahUKEwjTheG0zZXuAhVTgHIEHXO4DbkQMygGegUIARCbAQ..i&docid=H_-KD3OfzZwq8M&w=276&h=276&itg=1&q=luluxiu&ved=2ahUKEwjTheG0zZXuAhVTgHIEHXO4DbkQMygGegUIARCbAQ",
                "2.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO 异常， downloader方法 出现问题");
        }
    }
}