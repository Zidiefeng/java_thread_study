package com.kaitan.demo02;
//线程创建方式3：实现callable接口

import com.kaitan.demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    private String url;//网络图片地址
    private String name;//文件储存地址/文件名


    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片线程的 执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://en.wikipedia.org/wiki/C.C._(Code_Geass)#/media/File:CC_033_animestocks-com--2-.jpg","luluxiu.jpg");
        TestCallable t2 = new TestCallable("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz44O_3BH7DA3JbZ8nTu8GV67ghJOyCFKICA&usqp=CAU","1.jpg");
        TestCallable t3 = new TestCallable("https://www.google.com/imgres?imgurl=https%3A%2F%2Favatars2.githubusercontent.com%2Fu%2F5275753%3Fs%3D400%26u%3Dc71363fdc15a91c5e35765d7b7d3ab2d82b50f0f%26v%3D4&imgrefurl=https%3A%2F%2Fgithub.com%2Fluluxiu&tbnid=82q-cjKkjw7xsM&vet=12ahUKEwjTheG0zZXuAhVTgHIEHXO4DbkQMygGegUIARCbAQ..i&docid=H_-KD3OfzZwq8M&w=276&h=276&itg=1&q=luluxiu&ved=2ahUKEwjTheG0zZXuAhVTgHIEHXO4DbkQMygGegUIARCbAQ",
                "2.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        boolean result1 = r1.get();
        boolean result2 = r2.get();
        boolean result3 = r3.get();

        //print
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);


        // 关闭服务
        ser.shutdownNow();
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