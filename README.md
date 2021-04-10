
# Multi-Thread Learning - Java (多线程）

- **狂神说-java多线程-个人学习笔记 (原bilibili视频链接已附在文中)**
- **code放在了src中**

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled.png)

# 多线程

## 线程简介

- [ ]  [P1多线程01：概述03:33](https://www.bilibili.com/video/BV1V4411p7EF?p=1)
- [ ]  [P2多线程02：线程、进程、多线程11:16](https://www.bilibili.com/video/BV1V4411p7EF?p=2)

### 多任务

多件事，但是 某一瞬间 只做一件事

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%201.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%201.png)

### 多线程

同时做多件事 （并发操作）

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%202.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%202.png)

### 进程

- 运行一个程序，开启了一个 进程
- 一个进程可以有 多个线程，比如 打游戏的时候，同时有 声音，字母，图像

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%203.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%203.png)

### Process，Thread

- Process：进程
    - 程序 执行的 过程，程序要run起来才是进程
    - 真正执行的 是 进程里面的 线程(如果程序什么也不干，也有一个主线程main)
- Thread：线程
- 程序：静态的 代码和 data的 集合，跑起来才叫进程
- 目前很多多线程是 模拟出来的 （一个CPU），因为切换很快，人感觉是多线程（计算机-纳秒）

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%204.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%204.png)

### 核心概念

- 各线程 独立执行
- Java运行，即使自己没有创建 Thread，后台也会有多个Thread，如main线程，gc线程（负责垃圾清理）
- maint()为 主线程， 系统的入口
- 各Thread由 cpu调度（cpu决定具体运行哪个Thread，不能人为干预）
- 对同一份资源操作的时候，可能发生conflict,需要排队（并发控制）
- 多Thread会增加额外的 调度时间
- 每个线程 再自己的 工作内存 交互，内存控制不当会产生问题

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%205.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%205.png)

## 线程创建

- [ ]  [P3多线程03：继承Thread类10:42](https://www.bilibili.com/video/BV1V4411p7EF?p=3)

### 默认Thread

- main：自己写的，叫`用户线程`
- gc：垃圾回收，叫`守护线程`

### Thread的 3种创建方式

- 继承Thread类
- 实现Runnable接口（最后可以由Thread类实现）
- Callable接口（高级做法，这里不是重点）

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%206.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%206.png)

### 继承Thread类

（帮助文档中给的）

- 先extends Thread写一个类，重写该run方法
- 用的时候，new这个类，然后.start()执行就好

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%207.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%207.png)

### Thread.run() 与 Thread.start()

- run 是先执行完thread支线再回到main方法
- start同步执行main方法和Thread支线

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%208.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%208.png)

### 例子

```java
package com.kaitan.demo01;

public class TestThread1 extends Thread{
    @Override
    public void run() {
        //run方法 Thread体
        for (int i = 0; i < 20; i++) {
            System.out.println("I am reading the code"+i);
        }
    }

    public static void main(String[] args) {

        //主线程 main Thread

        //创建线程对象，调用start()
        TestThread1 trd1 = new TestThread1();
        trd1.start();//如果改成run()就是 先执行完之后 再执行后面的

        for (int i = 0; i < 20; i++) {
            System.out.println("I am reading multi-thread"+i);
        }
    }
}
```

results：

- main和TestThread1 交替进行
- 注意，这个根据CPU的 调度情况 运行（每次运行结果可能都不一样）

```java
I am reading multi-thread0
I am reading multi-thread1
I am reading multi-thread2
I am reading multi-thread3
I am reading the code0
I am reading multi-thread4
I am reading multi-thread5
I am reading multi-thread6
I am reading multi-thread7
I am reading the code1
I am reading the code2
I am reading the code3
I am reading the code4
I am reading the code5
I am reading the code6
I am reading the code7
I am reading multi-thread8
I am reading multi-thread9
I am reading multi-thread10
I am reading multi-thread11
I am reading the code8
I am reading the code9
I am reading the code10
I am reading the code11
I am reading the code12
I am reading the code13
I am reading multi-thread12
I am reading the code14
I am reading the code15
I am reading the code16
I am reading multi-thread13
I am reading multi-thread14
I am reading multi-thread15
I am reading multi-thread16
I am reading multi-thread17
I am reading multi-thread18
I am reading multi-thread19
I am reading the code17
I am reading the code18
I am reading the code19
```

## 网图下载

- [ ]  [P4多线程04：网图下载10:16](https://www.bilibili.com/video/BV1V4411p7EF?p=4)

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%209.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%209.png)

### 下载commonsio包 并装进IDEA 环境

- 通过网上apache commonsio下载包（我下载的 就是2.8）：[https://commons.apache.org/proper/commons-io/download_io.cgi](https://commons.apache.org/proper/commons-io/download_io.cgi)
- 然后解压，复制commons-io-2.8.0.jar文件到 IDEA中的 src.com.lib 的 package中
- 然后lib右键 add as library(此时就可能看到 包的 细节内容了)

    如下点击Project structure- library也能看到咱的这个内部目录

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2010.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2010.png)

### 同步下图Code

- 继承于Thread的一个主类
    - 构造器 初始化 变量url, file name
    - Thread 类 重写run函数 作为执行函数-下载图（调用了下载类）
    - 主方法 调用自身的 线程，实现 多线程 同步运行
- 下载类
    - 使用commonsio中的FileUtils来 将 网络文件地址下载到local

```java
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
```

## Runnable接口

- [ ]  [P5多线程05：实现Runnable接口08:36](https://www.bilibili.com/video/BV1V4411p7EF?p=5)

### 多线程实现方法

1. 继承thread()类 .start()
2. 承接Runnable 接口

### Thread vs Runnable

- Thread也implements 了Runnable接口
- Runnable接口里面只有run() 方法需要overwrite，所以无论Thread还是Runnable都需要run这个方法
- 因为不能多继承父类，但是可以同步承接接口，所以Runnable> Thread
- 使用run方法
    - Thread().start()
    - Thread(Runnable承接实例).start()

        ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2011.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2011.png)

### Runnable例子

```java
package com.kaitan.demo01;

import java.util.TreeMap;

//创建thread方式2： 实现runnable 接口，重写run方法，执行thread时将 runnable接口instance 放入 thread 的 input，调用.start()
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        //run方法 Thread体
        for (int i = 0; i < 20; i++) {
            System.out.println("I am reading the code"+i);
        }
    }

    public static void main(String[] args) {
        //创建线程对象，调用start()
        TestThread3 trd3 = new TestThread3();

        // 创建线程对象， 通过线程对象开启我们的 线程，这个称为代理
//        Thread thread = new Thread(trd3);
//
//        thread.start();
        new Thread(trd3).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("I am reading multi-thread"+i);
        }
    }
}
```

## 并发问题

- [ ]  [P6多线程06：初识并发问题05:42](https://www.bilibili.com/video/BV1V4411p7EF?p=6)

### 多个Thread操作一个资源（这里是variable）会导致Thread不安全，数据紊乱

- 用一个 Runnable接口，可以衍生出不同Thread
- 这里的情景是，总共的 票数是10，任意一个线程都可以过来取票（一次减一），直到没有票为止
- 这里多个Thread都是同样的 买票操作，所以从 同一个Runnable intput过来
- 多个thread操作同一个variable
- run方法中 的 `Thread.currentThread().getName()` 用于调取 当前线程Thread的 名称
- `Thread.sleep(120)` 模拟延迟

```java
package com.kaitan.demo01;

//多个线程 同时操作一个对象（可能出现conflict）
//比如 买火车票的例子
public class TestThread4 implements Runnable{

    // tickets number
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            System.out.println( Thread.currentThread().getName()+" purchased ticket Num "+ticketNums--);
            //模拟延迟
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();
        new Thread(ticket, "P1").start();
        new Thread(ticket, "P2").start();
        new Thread(ticket, "P3").start();
    }

}
```

- 多个thread操作同一个variable,会造成下面的 result （同时有多个thread抢到第n张票，conflict了）

```java
P1 purchased ticket Num 9
P2 purchased ticket Num 10
P3 purchased ticket Num 8
P3 purchased ticket Num 7
P1 purchased ticket Num 5
P2 purchased ticket Num 6
P3 purchased ticket Num 4
P1 purchased ticket Num 4
P2 purchased ticket Num 4
P1 purchased ticket Num 3
P2 purchased ticket Num 3
P3 purchased ticket Num 2
P3 purchased ticket Num 1
P1 purchased ticket Num 0
```

## 龟兔赛跑

- [ ]  [P7多线程07：龟兔赛跑09:54](https://www.bilibili.com/video/BV1V4411p7EF?p=7)
- Runnable中run方法：跑步（如果是兔子在跑，中途会睡觉）
- 主程序：
    - 一个兔子Thread和一个乌龟Thread 赛跑

```java
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
```

- 结果：乌龟赢

```java
Rabbit ran 6 m
Rabbit ran 7 m
Rabbit ran 8 m
Turtle ran 95 m
Rabbit ran 9 m
Turtle ran 96 m
Turtle ran 97 m
Turtle ran 98 m
Turtle ran 99 m
Turtle ran 100 m
winner is Turtle
```

### Callable接口

- [ ]  [P8多线程08：实现Callable接口07:43](https://www.bilibili.com/video/BV1V4411p7EF?p=8)

### Callable介绍

- 了解即可
- 前面两种才是重点
- 这里是用Callable接口重写call方法
- 有返回值
- 需要开启服务 执行，关闭服务

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2012.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2012.png)

### 好处

- 可以定义返回值
- 可以抛出异常

### code - 改写图片同步下载

- 使用Callable:
    - 需要规定返回值类型： `implements Callable<Boolean>`
    - 重写其中的call方法
        - 相当于Runnable中的 run方法
        - 要写返回值！
- 主执行程序：
    - 新建Callable：new TestCallable
    - 创建执行服务： `ExecutorService ser = Executors.newFixedThreadPool(3);`
    - 提交执行：`Future<Boolean> r1 = ser.submit(t1);`
    - 获取结果（这里是true）：`boolean result1 = r1.get();`
    - 关闭服务：`ser.shutdownNow();`

```java
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
```

### 静态代理模式

- [ ]  [P9多线程09：静态代理模式13:55](https://www.bilibili.com/video/BV1V4411p7EF?p=9)

### 总结

- 真实对象 和 代理对象 都要实现同一个接口 （这里是Marry）
- 代理对象要代理真实角色
    - 这里 代理对象 要传入真实角色作为input
    - 在代理对象里 实现 真实对象的 方法

### 好处

- 代理对象可以做很多 真实对象做不了的事情
- 真实对象专注 做自己的 事情就行

### Code构建

- 构建一个Marry接口
- 某一个 真实角色-人
    - 实现Marry接口：`class You implements Marry`
    - 重写Marry类的`HappyMarry`方法
- 代理
    - 实现Marry接口：`class WeddingCompany implements Marry`
    - 构造函数-定义某个 结婚的 人为 intput：`public WeddingCompany(Marry target)`
    - 重写Marry类的`HappyMarry`方法，实现具体这个人的 方法：
        - 调用 input 这个具体人 的 HappyMary方法：`this.target.HappyMarry();`
        - 加上一些 代理自身的 方法
- 执行
    - 直接 将 具体人 传入 代理，然后执行代理的方法即可
    - `new WeddingCompany(new You()).HappyMarry();`

```java
public class TestStaticProxy {

    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry{

    void HappyMarry();

}

//真实角色
class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("so happy to marry");
    }
}

//代理角色 帮你结婚
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚之前布置现场");
    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }

}

```

### 静态代理与lambda函数（Thread）类比

`new WeddingCompany(new You()).HappyMarry();`

- 具体对象 `You` 和 代理的 `WeddingCompany`
    - 都implements了 `Marry` 接口 ，均重写了其中的`HappyMarry` 方法
    - 代理 `WeddingCompany` 的 `HappyMarry` 方法 包含执行 传入的 具体对象的 `HappyMarry` 方法
- 使用时，只需要把 具体的 `You` 传入 代理的 `WeddingCompany`  ，运行 代理的 `HappyMarry` 方法即可

`new Thread(` `() → System.out.println("我爱你")` `).start();`

- 具体对象`lambda` 和代理的 `Thread`
    - 都implements了`Runnable`接口，均重写了其中的 `Run`方法
    - 代理 `Thread`的 `run`方法 包含执行 传入的 具体对象的 `run` 方法 （？）
- 使用时，只需要把 具体的 `内容`传入 代理的 `Thread`  ，运行 代理的 `start`方法即可

### lambda表达式

- [ ]  [P10多线程10：Lamda表达式27:00](https://www.bilibili.com/video/BV1V4411p7EF?p=10)

### 1. base操作-外部类

- 外部定义 Ilike接口（这里是函数型接口，只有一个抽象方法）
- 外部定义一个实现类Like 来implements这个接口Ilike
- 主方法：new这个实现类，然后调用该 方法

```java
package com.kaitan.lambdaShow;

//推导 lambda表达式

public class TestLambda1 {
    public static void main(String[] args) {
        Like like = new Like();
        like.lambda();
    }
}

//1. 定义一个 函数式 接口（只有一个抽象方法）
interface Ilike{
    void lambda();
}

// 2. 实现类
class Like implements Ilike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
```

### 2. 改写-使用静态内部类

- 就是把外部的 实现类 移到内部，使用static

```java
package com.kaitan.lambdaShow;

//推导 lambda表达式

public class TestLambda1 {
    public static void main(String[] args) {
        Like2 like2 = new Like2();
        like2.lambda();
    }

    //3. 静态内部类
    static class Like2 implements Ilike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

}

//1. 定义一个 函数式 接口（只有一个抽象方法）
interface Ilike{
    void lambda();
}
```

### 3. 改写-局部内部类

- 移到主方法里面 定义类

```java
package com.kaitan.lambdaShow;

//推导 lambda表达式

public class TestLambda1 {
    public static void main(String[] args) {

        class Like3 implements Ilike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        Like3 like3 = new Like3();
        like3.lambda();
    }

}

//1. 定义一个 函数式 接口（只有一个抽象方法）
interface Ilike{
    void lambda();
}
```

### 4. 改写- 匿名内部类

- 不定义新的 类，直接在主方法里 new一个接口/父类

```java
package com.kaitan.lambdaShow;

//推导 lambda表达式

public class TestLambda1 {
    public static void main(String[] args) {
        //5. 匿名内部类, 没有类的名称，必须借助接口或者 父类
        Ilike like4 = new Ilike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like4.lambda();
    }
}

//1. 定义一个 函数式 接口（只有一个抽象方法）
interface Ilike{
    void lambda();
}
```

### 5. lambda

- 使用lambda简化
    - 类似直接new 然后重写抽象方法
    - 因为是函数式接口，只有一个方法，这个方法名称都不重要了，直接隐藏方法名
    - 用()→{}来重写 方法，（）中是input，{}是这个方法体
    - 调用的时候，使用接口中定义好的 方法名调用（这里为lambda）

```java
package com.kaitan.lambdaShow;

//推导 lambda表达式
public class TestLambda1 {
    public static void main(String[] args) {
        //6. lambda简化
        Ilike like6 = () -> {
            System.out.println("I like lambda5");
        };
        like6.lambda();
    }

//1. 定义一个 函数式 接口（只有一个抽象方法）
interface Ilike{
    void lambda();
}
```

### lambda总结

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2013.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2013.png)

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2014.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2014.png)

### 带参数的 改写流程

1. 外部类

    ```java
    package com.kaitan.lambdaShow;

    public class TestLambda2 {
        public static void main(String[] args) {
            new Love1().love(11); //注意是传给 抽象方法 而不是 主类
        }
    }

    interface Ilove{
        void love(int a);
    }

    class Love1 implements Ilove{
        //1. 外部类
        @Override
        public void love(int a) {
            System.out.println("I love you 1:"+a);
        }
    }
    ```

2. 静态内部类

    ```java
    package com.kaitan.lambdaShow;

    public class TestLambda2 {
        public static void main(String[] args) {
            new Love2().love(22);
        }
        
        //静态内部类
        static class Love2 implements Ilove{
            //1. 外部类
            @Override
            public void love(int a) {
                System.out.println("I love you 2:"+a);
            }
        }
    }

    interface Ilove{
        void love(int a);
    }
    ```

3. 局部内部类

    ```java
    package com.kaitan.lambdaShow;

    public class TestLambda2 {
        public static void main(String[] args) {
            //3. 局部内部类
            class Love3 implements Ilove{
                @Override
                public void love(int a) {
                    System.out.println("I love you 3:"+a);
                }
            }
            new Love3().love(33);
        }
    }

    interface Ilove{
        void love(int a);
    }
    ```

4. 匿名内部类

    ```java
    package com.kaitan.lambdaShow;

    public class TestLambda2 {
        public static void main(String[] args) {
            //匿名内部类
            Ilove love4 = new Ilove(){
                @Override
                public void love(int a) {
                    System.out.println("I love you 4:"+a);
                }
            };
            love4.love(44);

        }
    }

    interface Ilove{
        void love(int a);
    }
    ```

5. lambda

    ```java
    package com.kaitan.lambdaShow;

    public class TestLambda2 {
        public static void main(String[] args) {

            //5. lambda
            Ilove love5 = (int a)->{
                System.out.println("I love you 5:"+a);
            };
            love5.love(55);

        }
    }

    interface Ilove{
        void love(int a);
    }
    ```

6. 省略
    - 去掉参数类型

        ```java
        Ilove love6 = (a)->{
            System.out.println("I love you 6:"+a);
        };
        love6.love(66);
        ```

    - 去掉括号

        ```java
        Ilove love7 = a->{
            System.out.println("I love you 7:"+a);
        };
        love7.love(77);
        ```

    - 若只有一行方法代码：去掉{}

        ```java
        Ilove love8 = a->System.out.println("I love you 8:"+a);
        love8.love(88);
        ```

### lambda省略

- 前提：接口是函数式接口（只有一个方法）
- 只有一行时，才能把{ }去掉，如果有多行，必须使用代码块{ }
- 可以去掉参数类型，多个参数 也可以去掉类型，要去掉都去掉

## 线程5大状态

- [ ]  [P11多线程11：线程停止09:29](https://www.bilibili.com/video/BV1V4411p7EF?p=11)

### 线程5大状态-生命周期

- 创建：new thread的时候，诞生了
- start之后就 是  就绪状态，等待cpu的 调度
- cpu安排上 就进入 运行状态
- 运行中 可能被 阻塞，sleep是其中一种方法
- 死亡：线程中断或结束

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2015.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2015.png)

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2016.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2016.png)

### 线程方法

- join 霸道插队
- yield 比如一个已经进Cpu了，要出来重新公平再等cpu调度一次
- interrupt不建议使用

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2017.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2017.png)

### 1-线程就绪

start

### 2-线程停止

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2018.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2018.png)

### 构思thread stop - code

- 继承 runnable，自身重写runnable，可用thread 调用形成一个线程
- 主函数 是默认开启的 一个thread
- 在主函数中，调度开启 自身的 第二线程，然后通过主函数循环 根据循环数 来靠改变自身的flag 来终止第二线程

```java
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
```

### 3-线程休眠sleep

- [ ]  [P12多线程12：线程休眠_sleep08:01](https://www.bilibili.com/video/BV1V4411p7EF?p=12)
- 当前线程阻塞的毫秒数
- InterruptedException
- sleep到时间后，进入 就绪状态
- sleep可以模拟网络延迟，倒计时
- 每个对象都有一个锁，sleep不会释放锁

### 模拟网络延迟的作用

- 不模拟延迟没问题，模拟之后，可以放大问题的发生性
- 模拟之后，发现线程不安全（多个线程操作同一个资源）：
    - 有重复被取的 票
    - 还有可能出现-1票

    ```java
    package com.kaitan.state;

    import com.kaitan.demo01.TestThread4;

    //模拟网络延迟
    public class TestSleep implements Runnable{

        // tickets number
        private int ticketNums = 10;

        @Override
        public void run() {
            while (true){
                if (ticketNums<=0){
                    break;
                }
                System.out.println( Thread.currentThread().getName()+" purchased ticket Num "+ticketNums--);

                //模拟延迟，去掉这部分没有什么问题，模拟之后，发现线程可能不安全：有重复被取的 票，还有可能出现-1票
                try {
                    Thread.sleep(120);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        public static void main(String[] args) {
            TestSleep ticket = new TestSleep();
            new Thread(ticket, "P1").start();
            new Thread(ticket, "P2").start();
            new Thread(ticket, "P3").start();
        }

    }
    ```

### sleep例子：

- 模拟倒计时：从10 倒数到1

    ```python
    package com.kaitan.state;

    import java.text.SimpleDateFormat;
    import java.util.Date;

    // 模拟倒计时
    public class TestSleep2 {

        public static void main(String[] args) {

            //模拟倒计时
            try{
                tenDown();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        public static void tenDown() throws InterruptedException {
            int num = 10;
            while (true){
                Thread.sleep(1000);
                System.out.println(num--);
                if(num<=0){
                    break;
                }
            }
        }
    }

    ```

- 每秒print 一次时间，主程序中写下面code：
    - `new Date(System.currentTimeMillis())` 表示获取当前时间
    - `new SimpleDateFormat("HH:mm:ss").format(startTime)` 调整时间格式

    ```python
    //打印当前时间
            Date startTime = new Date(System.currentTimeMillis());//获取当前时间

            while(true){
                try {
                    Thread.sleep(1000);
                    System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                    startTime=new Date(System.currentTimeMillis()); //当前时间
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
    ```

### 4-线程yield（礼让）

概念懂了，但是例子中的 结果不太明白！！！

- [ ]  [P13多线程13：线程礼让_yield05:24](https://www.bilibili.com/video/BV1V4411p7EF?p=13)
- yield含义：如果有两个线程A，B，目前CPU选择让A执行，如果此时对A施加yield，则A会被暂停从cpu中出来，A，B同时再次一起竞争CPU，这次不一定哪个进
- yield线程：让当前正在执行的线程暂停，但不阻塞，从`运行`转成`就绪`状态
- yield不一定成功

    ```python
    package com.kaitan.state;

    public class TestYield {
        public static void main(String[] args) {
            MyYield myYield = new MyYield();

            new Thread(myYield,"a").start();
            new Thread(myYield,"b").start();
        }
    }

    class MyYield implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"线程开始执行");
    /*
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    */
            Thread.yield();

            System.out.println(Thread.currentThread().getName()+"线程停止执行");
        }
    }
    ```

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2019.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2019.png)

### 5-Join

- [ ]  [P14多线程14：线程强制执行_join05:17](https://www.bilibili.com/video/BV1V4411p7EF?p=14)

- Join概念：合并线程，这个线程执行之后，才能执行其他线程
- 理解成插队

### 实操

- 如下，定义一个VIP线程testJoin(跑1-100)， 与一个主线程同步运行（跑1-50）
- 正常情况下，同步运行，两个随机进行
- 但是如果在主线程到25的时候，强行使用`thread.join()` 使VIP线程先执行完，然后再跑主线程

```python
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
```

实际结果

```python
main0
main1
main2
main3
main4
main5
main6
main7
main8
main9
main10
main11
main12
main13
main14
main15
main16
main17
main18
main19
main20
main21
main22
VIP is here0
VIP is here1
VIP is here2
VIP is here3
VIP is here4
VIP is here5
VIP is here6
VIP is here7
main23
main24
VIP is here8
VIP is here9
VIP is here10
VIP is here11
VIP is here12
VIP is here13
VIP is here14
VIP is here15
VIP is here16
VIP is here17
VIP is here18
VIP is here19
VIP is here20
VIP is here21
VIP is here22
VIP is here23
VIP is here24
VIP is here25
VIP is here26
VIP is here27
VIP is here28
VIP is here29
VIP is here30
VIP is here31
VIP is here32
VIP is here33
VIP is here34
VIP is here35
VIP is here36
VIP is here37
VIP is here38
VIP is here39
VIP is here40
VIP is here41
VIP is here42
VIP is here43
VIP is here44
VIP is here45
VIP is here46
VIP is here47
VIP is here48
VIP is here49
VIP is here50
VIP is here51
VIP is here52
VIP is here53
VIP is here54
VIP is here55
VIP is here56
VIP is here57
VIP is here58
VIP is here59
VIP is here60
VIP is here61
VIP is here62
VIP is here63
VIP is here64
VIP is here65
VIP is here66
VIP is here67
VIP is here68
VIP is here69
VIP is here70
VIP is here71
VIP is here72
VIP is here73
VIP is here74
VIP is here75
VIP is here76
VIP is here77
VIP is here78
VIP is here79
VIP is here80
VIP is here81
VIP is here82
VIP is here83
VIP is here84
VIP is here85
VIP is here86
VIP is here87
VIP is here88
VIP is here89
VIP is here90
VIP is here91
VIP is here92
VIP is here93
VIP is here94
VIP is here95
VIP is here96
VIP is here97
VIP is here98
VIP is here99
main25
main26
main27
main28
main29
main30
main31
main32
main33
main34
main35
main36
main37
main38
main39
main40
main41
main42
main43
main44
main45
main46
main47
main48
main49
```

## 线程状态观测

- [ ]  [P15多线程15：观测线程状态07:48](https://www.bilibili.com/video/BV1V4411p7EF?p=15)

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2020.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2020.png)

### 实操

- 构思：
    - 主线程来输出另一个线程的执行状态
    - 注意，只有thread才是新线程的情况，Thread.sleep只是个方法调用
- 用lambda 新建new一个线程，此时状态时NEW
- 然后开始运行，发现是RUNNABLE
- 然后进入等待TIMED_WATTING
- 最终结束时，TERMINATED
- 注意结束之后，不能再次start,因为此时这个thread已经死亡，如果想再用，需要再new一个新的instance

```python
package com.kaitan.state;
// observe the state of thread
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e ){
                    e.printStackTrace();
                }
            }
            System.out.println("-------------");
        });

        //Observe state
        Thread.State state = thread.getState();
        System.out.println(state); // should be new because has not start()

        //start and observe state
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while(state != Thread.State.TERMINATED){//constantly output state if this is not terminated
            Thread.sleep(500);
            state=thread.getState(); //update state
            System.out.println(state);
        }

        //thread.start(); //error, a dead thread cannot be re-start again, you need to new a thread

    }
}
```

results

```python
NEW
RUNNABLE
TIMED_WAITING
TIMED_WAITING
TIMED_WAITING
TIMED_WAITING
TIMED_WAITING
TIMED_WAITING
TIMED_WAITING
TIMED_WAITING
TIMED_WAITING
-------------
TERMINATED
```

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2021.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2021.png)

## 线程优先级Priority

- [ ]  [P16多线程16：线程的优先级07:50](https://www.bilibili.com/video/BV1V4411p7EF?p=16)

### Priority

- 线程执行状态由CPU决定，但是Java 可以设置优先级，优先级高不代表可以真正优先执行，但权重高
- 优先级低，意味着优先获得调度的概率低，不代表不被调用了

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2022.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2022.png)

### 实践

- 定义一个线程类，就是打印currentThread 的名字，和Priority
- 在main中，先查看当前线程（main）的Priority，发现是默认的5
- 然后new出6个线程，分别设置他们的优先级，然后start
- 查看结果，看看是不是优先级高的在前面
    - 注意，这个只是个优先级，不代表真正的顺序
    - 多次实验之后，应该大部分符合优先级高的在前

```python
package com.kaitan.state;

public class TestPriority {
    public static void main(String[] args) {
        //main thread-priority check
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t0 = new Thread(myPriority);
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);

        //set priority, start
        t0.start();

        t1.setPriority(1);
        t1.start();

        t2.setPriority(4);
        t2.start();

        t3.setPriority(Thread.MAX_PRIORITY); //10
        t3.start();

        t4.setPriority(7);
        t4.start();

        t5.setPriority(8);
        t5.start();

        //t4.setPriority(-1);
        //t4.start();

        //t5.setPriority(11);
        //t5.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
```

结果

```python
main-->5
Thread-3-->10
Thread-0-->5
Thread-5-->8
Thread-4-->7
Thread-2-->4
Thread-1-->1
```

## daemon守护线程

- [ ]  [P17多线程17：守护线程07:34](https://www.bilibili.com/video/BV1V4411p7EF?p=17)

### Daemon

- 线程（用bool）分为
    - 用户线程
    - 守护线程daemon
- 虚拟机必须确保用户线程执行完毕
    - 比如main
- 虚拟机不用等待守护线程执行完毕
    - 比如垃圾回收线程，后台记录操作日志，监控内存

### 例子

- class You：用户线程，有限循环，结束了，trigger虚拟机结束
- class God：守护线程（`thread.setDaemon(true);`）无线循环，但是因为这个是守护线程，随着用户线程结束，也就结束了
- 运行结果，守护线程会多运行一小会儿（因为虚拟机结束需要一点时间）

```python
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
```

## 线程同步

- [ ]  [P18多线程18：线程同步机制08:48](https://www.bilibili.com/video/BV1V4411p7EF?p=18)

### 并发

- 同一个对象 被 多个线程 同时操作
    - 比如一堆人抢100张票
    - 两个银行同时取钱
- 现实中的解决办法*：*排队（程序中叫做队列）

### 队列&锁

- 多线程访问同一个对象，而且某些线程还想修改这个对象，此时需要线程同步，（一种等待机制），多个需要同时访问的线程进入这个对象的等待池形成队列，等待前面的thread结束，然后下一个thread再用
- 为了安全性，需要锁
    - 比如排队上厕所，需要锁门
    - （之前sleep提到，sleep不会释放锁）

### 线程同步synchronized

- 锁机制可能会导致性能问题

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2023.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2023.png)

## 安全性问题

- [ ]  [P19多线程19：三大不安全案例20:33](https://www.bilibili.com/video/BV1V4411p7EF?p=19)

### 买票例子

- 注意用了Runnable,new出来的thread,其实只调用重新定义的run函数，其他的方法，还有attribute可以作为共用的部分
- 如下，三个人抢票，同步操作ticketNums这个var
- 

```python
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

    private void buy() throws InterruptedException {
        if (ticketNums <=0){
            flag = false;
            return;
        }

        // mock delay
        Thread.sleep(100);

        //purchase ticket
        System.out.println(Thread.currentThread().getName()+"get"+ticketNums--);
    }
}
```

RESULTS

```python
HuangNiuget10
Youget10
Meget9
Youget8
Meget7
HuangNiuget6
HuangNiuget5
Meget3
Youget4
Youget2
Meget1
HuangNiuget0
```

### 取钱例子

结构设计：

- 账户class：attr是balance，还有account名称（name）
- 银行取钱class，继承thread:
    - 启动参数：对哪个Account进行取钱，取钱的金额，谁取的钱
    - 构造器：储存account类，要取的金额，并且把人名 传为父类thread的name
    - 取钱行为：重写run方法
        - 先判断这个账户中余额够不够
        - 模拟延迟1s
        - 开始取钱-减少这个Accuont的balance，增加手中余额（初始都是0），注意操作的是对象account的balance，这个是这里所有取钱行为的 公共资源
- main方法
    - new一个账户-结婚基金，有100余额
    - new两个取钱的thread，传入同一个account，模拟两个人 分别对同一个账户取钱
    - start这两个thread，让两个线程同时开始取钱
- 结果-线程不安全的 解读

    加之个延迟，在此之前大家都判断为有钱，但是还没来得及取，不过因为判断为有钱，所有都要开始行动（开始取钱）了，导致同时操作取钱，没有重新考虑是否余额足够

    ```java
    结婚基金: balance = 50
    结婚基金: balance = -50
    GirlFriend: money in hand:100
    YOU: money in hand:50
    ```

```java
package com.kaitan.syn;

//2 persons withdraw money in bank
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");

        Drawing you = new Drawing(account, 50,"YOU");
        Drawing girlFriend = new Drawing(account, 100,"GirlFriend");

        girlFriend.start();
        you.start();

    }
}

class Account{
    int balance; //balance
    String name; // card name

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}

//bank, withdraw
class Drawing extends Thread{
    Account account;
    //取钱
    int drawingMoney;
    //手上的钱
    int nowMoney;

    //初始值: 哪个账户，取多少钱，
    public Drawing(Account account, int drawingMoney, String name){
        super(name); //将name传进父类thread的构造方法 - 直接使用thread的名字
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //银行取钱的行为
    @Override
    public void run() {
        //如果存款不够，不能取钱
        if (account.balance-drawingMoney<0){
            System.out.println(Thread.currentThread().getName()+": No Enough Money");
            return;
        }

        //加之个延迟，意思是，在此之前大家都判断为有钱，但是还没来得及取，不过因为判断为有钱，所有都要开始行动（开始取钱）了
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //如果钱够，取钱，余额减少
        account.balance = account.balance -drawingMoney;

        //手上的钱增加
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name+": balance = "+account.balance);
        //because extends Thread, getName() is inherited
        System.out.println(this.getName()+": money in hand:"+nowMoney);
    }
}
```

### 不安全的collection操作

- 建立了一个list，然后 开通10000个同步的线程，希望把所有的thread名字存到一个list里
- 不安全：发现即使加了个3s延迟再print list的结果，发现长度是9994，不是10000
- 不安全原因：多个thread可能同时append list，append到的是同一个位置，所以总长小于10000

```java
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
```

### 安全问题

- 买票-为什么可能出现负数
    - 之前有一句话：每个thread在自己的工作内存交互，内存控制不当会导致数据不一致
    - 三个人都看到只剩1张票的时候，都觉得可以（把1 放到自己的内存里），买完之后有thread就付了
- 银行取钱，为什么会出现负数
    - 加之个延迟，在此之前大家都判断为有钱，但是还没来得及取，不过因为判断为有钱，所有都要开始行动（开始取钱）了，导致同时操作取钱，没有重新考虑是否余额足够
- 线程对同一个collection（如list）进行操作，发现长度小于thread个数
    - 多个thread可能同时append list，append到的是同一个位置，所以总长小于10000

## 同步方法

- [ ]  [P20多线程20：同步方法及同步块10:20](https://www.bilibili.com/video/BV1V4411p7EF?p=20)

### 同步方法概念

- 对方法，可以通过synchronized标记为同步方法，以更加安全
- synchronized 有两种用法
    - 代码块
    - 方法
- 标记为synchronized的方法，对 对象访问的时候，必须要先获得该对象的锁，如果没有锁，这能等着。获得锁之后，独占锁，其他方法无法访问该对象，该方法return完成之后，才能释放锁
- 方法太大 容易低效，比如如果一个方法先修改 再查看，查看的时候不需要进行修改，没必要独占该对象，所以可以只对方法中的一部分加synchronized（即为代码块）

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2024.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2024.png)

### 代码例子

- 买票
    - 增加synchronized 到方法上，这里操作对象是自身this,所以锁的是自身

        ```java
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
        ```

- 取钱
    - 这里不能锁run（）方法，**synchronize 默认锁自身this**,如果应该锁别的对象，需要用到synchronize块
    - 如下，框起来需要锁account这个对象的代码，括号里写为account

    ```java
    package com.kaitan.syn;

    //2 persons withdraw money in bank
    public class UnsafeBank {
        public static void main(String[] args) {
            Account account = new Account(100,"结婚基金");

            Drawing you = new Drawing(account, 50,"YOU");
            Drawing girlFriend = new Drawing(account, 100,"GirlFriend");

            girlFriend.start();
            you.start();
        }
    }

    class Account{
        int balance; //balance
        String name; // card name

        public Account(int balance, String name) {
            this.balance = balance;
            this.name = name;
        }
    }

    //bank, withdraw
    class Drawing extends Thread{
        Account account;
        //取钱
        int drawingMoney;
        //手上的钱
        int nowMoney;

        //初始值: 哪个账户，取多少钱，
        public Drawing(Account account, int drawingMoney, String name){
            super(name); //将name传进父类thread的构造方法 - 直接使用thread的名字
            this.account = account;
            this.drawingMoney = drawingMoney;
        }

        //银行取钱的行为
        @Override
        public void run() {

            synchronized (account) {
                //如果存款不够，不能取钱
                if (account.balance-drawingMoney<0){
                    System.out.println(Thread.currentThread().getName()+": No Enough Money");
                    return;
                }

                //加之个延迟，意思是，在此之前大家都判断为有钱，但是还没来得及取，不过因为判断为有钱，所有都要开始行动（开始取钱）了
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //如果钱够，取钱，余额减少
                account.balance = account.balance -drawingMoney;

                //手上的钱增加
                nowMoney = nowMoney + drawingMoney;

                System.out.println(account.name+": balance = "+account.balance);
                //because extends Thread, getName() is inherited
                System.out.println(this.getName()+": money in hand:"+nowMoney);

            }

        }
    }
    ```

- collection
    - 直接加到list对象上

    ```java
    package com.kaitan.syn;

    import java.util.ArrayList;
    import java.util.List;

    //thread不安全的 集合
    public class UnsafeList {
        public static void main(String[] args) throws InterruptedException {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < 10000; i++) {
                new Thread(()->{
                    synchronized(list){
                        list.add(Thread.currentThread().getName());
                    }
                }).start();
            }
            Thread.sleep(3000);
            System.out.println(list.size());
        }
    }
    ```

### 同步块

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2025.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2025.png)

### 自带安全的Collection-list类

- [ ]  [P21多线程21：CopyOnWriteArrayList03:42](https://www.bilibili.com/video/BV1V4411p7EF?p=21)

这个对象自身就是安全的，不需要加synchronized 

```java
package com.kaitan.syn;

import java.util.concurrent.CopyOnWriteArrayList;

//测试JUC 安全type的 collection
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }

}
```

## 死锁

- [ ]  [P22多线程22：死锁12:34](https://www.bilibili.com/video/BV1V4411p7EF?p=22)

### 死锁

- 死锁：多个线程互相拿着对方需要的资源，形成僵持

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2026.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2026.png)

### 案例

- 一个人先拿口红，然后还想拿到镜子，这样可以开始化妆
- 另一个人先拿到镜子，然后要拿到口红，开始化妆
- 两方卡死，形成死锁
- 代码设计
    - class 口红 （共享资源）
    - class 镜子（共享资源）
    - class 化妆 继承于Thread:
        - init的变量：choice（先拿口红，还是镜子），name（人名）
        - 线程涉及的run方法：进行化妆`makeup()`
        - `makeup()`: 根据choice要求先拿A，然后保持不放手A的时候，还要拿到B

    ```java
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
    ```

- dead lock关键原因: 锁中锁，一个方法 要同时 获得 两个对象的锁
- 如何修正：解开锁中锁，保证一个方法一次只锁一个对象

```java
//化妆，互相持有对方的锁，需要拿到对方的资源
if (choice==0){
    synchronized(lipstick){
        //获得口红的锁
        System.out.println(this.girlName + "获得口红的锁");
        Thread.sleep(1000);
	  }
    synchronized (mirror){
        System.out.println(this.girlName+"获得镜子的锁");
    }

}else{
    synchronized(mirror){
        //获得口红的锁
        System.out.println(this.girlName + "获得口红的锁");
        Thread.sleep(2000);
	  }
    synchronized (lipstick){
        System.out.println(this.girlName+"获得镜子的锁");
    }
}
```

### 产生死锁的四个必要条件

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2027.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2027.png)

## Lock锁

- [ ]  [P23多线程23：Lock锁07:23](https://www.bilibili.com/video/BV1V4411p7EF?p=23)

### 什么是锁Lock

- synchronized是隐式锁，不能看到什么时候加锁，释放锁；但是Lock可以显示处理 什么时候加锁，什么时候解锁

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2028.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2028.png)

### 案例

- 不安全的例子

    ```java
    package com.kaitan.advanced;

    public class TestLock {
        public static void main(String[] args) {
            TestLocka testLocka = new TestLocka();
            //在创建上面的这个时候，就有一个testLocka.ticketNums了
            //下面分别只运行run函数，所有都对testLocka的ticketNums进行操作
            new Thread(testLocka).start();
            new Thread(testLocka).start();
            new Thread(testLocka).start();
        }
    }

    class TestLocka implements Runnable {

        static int ticketNums = 10;

        @Override
        public void run() {
            while (true){
                if (ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }
        }
    }
    ```

    ```java
    10
    8
    9
    7
    5
    6
    4
    3
    2
    1
    -1
    0
    ```

- 加lock改进
    - `private final ReentrantLock lock = new ReentrantLock();` new一个 `可重入锁` `ReentrantLock`
    - 使用这个lock 的时候
        - 推荐使用try, final结构：
        `try{lock.lock() 
             //代码-包含需要访问对象的部分} 
        final{lock.unlock()}`
    - 代码例子

        ```java
        package com.kaitan.advanced;

        import java.util.concurrent.locks.ReentrantLock;

        public class TestLock {
            public static void main(String[] args) {
                TestLocka testLocka = new TestLocka();
                //在创建上面的这个时候，就有一个testLocka.ticketNums了
                //下面分别只运行run函数，所有都对testLocka的ticketNums进行操作
                new Thread(testLocka).start();
                new Thread(testLocka).start();
                new Thread(testLocka).start();
            }
        }

        class TestLocka implements Runnable {

            static int ticketNums = 10;

            //定义lock锁
            private final ReentrantLock lock = new ReentrantLock();

            @Override
            public void run() {
                while (true){
                    try{
                        lock.lock();//加锁

                        //不安全的代码
                        if (ticketNums>0){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(ticketNums--);
                        }else {
                            break;
                        }
                    }finally{
                        lock.unlock();//解锁
                    }
                }
            }
        }
        ```

### 模板

- 必须`lock.lock()`, `lock.unlock()`
- 如果代码块有exception需要将unlock写入finally

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2029.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2029.png)

### synchronized 与lock 对比

![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2030.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2030.png)

## 线程协作

`难点`

### 生产者消费者模式

- [ ]  [P24多线程24：生产者消费者问题06:56](https://www.bilibili.com/video/BV1V4411p7EF?p=24)
- 不属23种设计模式，只是一个问题
- 生产者：生产东西，比如KFC提供食物，如果没有客户买了，但是现在没有，就去
- 消费者：去买肯德基，如果发现没食物了，要等待

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2031.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2031.png)

- synchronize不够用了：

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2032.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2032.png)

### Object中syn相关的方法

- 每个对象都有一把锁
- 对象是Object类，Object类有一些`默认方法`（在同步代码块、同步方法中用），以解决线程之间通信问题

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2033.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2033.png)

### 解决方法

- 方法1： 管程法

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2034.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2034.png)

- 方法2：信号灯发
    - 信号如果true, 等待，false就通知另外一个人

## 解决方法1-管程法

- [ ]  [P25多线程25：管程法10:18](https://www.bilibili.com/video/BV1V4411p7EF?p=25)

### 例子：KFC提供鸡

- 主方法
    - new一个container作为缓冲区
    - 开启一个producer线程，对这个container操作
    - 开启一个consumer线程，对这个container操作
    - 注意，只要不是空了、满了，两个线程会一次一次操作container（每一个分别会加锁，释放锁，所以看CPU心情，到底是谁来操作）
- class 鸡
    - init需要传入鸡的id
- class 生产者（Thread）:
    - init 需要传入一个container
    - run方法：
        - 循环一共把100个鸡放进container里 (`container.push(new Chichken(i))`)
        - 每次只操作一个鸡，一次操作会加锁，释放锁
        - 注意，只有container满了，才会进入wait，消费者每一次消费完都会唤醒一下（因为就不满了，有上架空间）
- class 消费者（Thread）:
    - init 需要传入一个container
    - run方法：
        - 循环一共陆续消费container中的100个鸡 (`container.pop()`)
        - 每次只操作一个鸡，一次操作会加锁，释放锁
        - 注意，只有container空了，才会进入wait，producer每一次生产完都会唤醒一下consumer（因为就不空了，有consume空间）
- class 缓冲区container:
    - init：建立一个10个鸡的 数组，初始count = 0 （最开始container中没有鸡）
    - 构建producer 用来上架一只chicken的push方法（`synchronized`）：
        - input 参数：一只生产出来，要放入缓冲区的chicken
        - 如果当前container中鸡的个数 == container容量（10），缓冲区已满，producer进入等待（wait释放锁，释放此container给consumer）
        - 等待消费者唤醒（通知）自己鸡不够了之后，producer将这只chicken 放到（由consumer消费而空出来的）第一个空位（消费者消费之后，会调整count），然后count++，注意，被唤醒后操作container的过程是有锁的
        - 放到container中， 会通知consumer去消费`this.notifyAll();`
    - 构建consumer用来消费一只chicken的pop方法（`synchronized`）：
        - 没有input参数，因为直接从container取，就好了
        - 如果当前没有鸡了，进入wait(释放container资源给producer来生产)
        - producer生产完了，会唤醒consumer，consumer从container中取走一只鸡，把这只取走的鸡返回出来
        - 吃完之后通知producer生产

    ```java
    package com.kaitan.advanced;
    //producer, consumer,利用缓冲区解决-管程法

    //需要producer, consumer, product, 缓冲区buffer
    public class TestPC {
        public static void main(String[] args) {
            SynContainer container = new SynContainer();

            new Producer(container).start();
            new Consumer(container).start();
        }
    }

    //producer
    class Producer extends Thread {
        SynContainer container;

        public Producer(SynContainer container) {
            this.container = container;
        }

        //produce
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                container.push(new Chicken(i));
                System.out.println("Produced "+i+" Chicken");
            }
        }
    }

    //consumer
    class Consumer extends Thread{
        SynContainer container;

        public Consumer(SynContainer container) {
            this.container = container;
        }

        //consume
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                System.out.println("Consumed id:"+container.pop().id+" Chicken");
            }
        }
    }

    //product
    class Chicken {
        int id;//product id

        public Chicken(int id) {
            this.id = id;
        }
    }

    //缓冲区
    class SynContainer{
        //container size
        Chicken[] chickens  = new Chicken[10];
        //number of products in the container
        int count = 0;

        //producer put products in the container
        //count: current number of chickens in the container
        public synchronized void push(Chicken chicken){
            //if full, wait for the consumer to consume
            if(count == chickens.length){
                //notify consumer to consume, wait to produce products
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            //if not full, put more products in the container
            chickens[count] = chicken;
            count++;

            //notify consumer to consume
            this.notifyAll();
        }

        //consumer to consume the chicken
        public synchronized Chicken pop(){
            if (count ==0){
                //wait producer to produce
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            count --;
            Chicken chicken = chickens[count];

            //ate it, notify producer to produce
            this.notifyAll();
            return chicken;
        }
    }
    ```

## 方法2：信号灯

- [ ]  [P26多线程26：信号灯法08:09](https://www.bilibili.com/video/BV1V4411p7EF?p=26)

### 代码设计

- 主函数
    - new一个show
    - 然后将show分别传入actor,audience,然后两个线程同步运行
    - 流程分析：
        - new这个show的时候，show自带两个attribute，当前的节目（show）和 当前的信号（初始化为true）
        - 然后双线程启动，因为都是同步锁，cpu分配到的那一方，进入第一个循环节的时候, 因为是true：
            - 如果是观众线程抢到，进入wait，释放锁，那演员可以先进行表演第一个节目了
            - 如果是演员抢到，可以先进行表演第一个节目
            - 那么，此时这个第一个节目就存入show这个attribute（当前节目）
            - 演员表演后，把信号改成false，然后唤醒观众，观众看到false信号，就可以开始观看这个节目（当前节目-show）了，在观众观看过程中，演员线程因为接收到的是false, 就进入了wait（hai 不能表演下一个节目），要等观众这边看完后唤醒
- class 演员 (thread)
    - init：要传入要表演的节目
    - run：依次表演20个节目，每一次都开锁关锁（共享资源是show）
- class 演员 (thread)
    - init：要传入要观看的节目
    - run：依次观看20个节目（演员表演啥就看啥），每一次都开锁关锁（共享资源是show）
- class 节目
    - init：有一个节目名称show,还有一个信号灯flag（默认为true）
    - synchronized方法perform（演员表演节目）:
        - 要传入节目名称
        - 如果flag=false，进入等待，直到被另一线程（观众）唤醒
        - 唤醒后，表演节目
        - 通知观众观看
        - 换flag（换成false，因为之前观众false→true了）
    - synchronized方法watch（观看表演节目）:
        - 不需要传入节目名称（此时show是啥就看啥）
        - 如果flag=true，进入等待，直到被另一线程（演员）唤醒
        - 唤醒后，观看节目
        - 通知演员表演节目
        - 换flag（换成true，因为之前演员true→false了）

    ```java
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
    ```

## 线程池

- [ ]  [P27多线程27：线程池05:52](https://www.bilibili.com/video/BV1V4411p7EF?p=27)

### 使用线程池

- 每次新建，销毁thread类似每次 买，扔一辆自行车，浪费资源
- 如果共享单车（线程池），可以需要用thread的时候，用池子中的thread，不用了放回去
- 可以管这个thread池子大小，多长时间不用就关掉

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2035.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2035.png)

- callable也是类似

    ![%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2036.png](%E3%80%90%E7%8B%82%E3%80%91%E5%A4%9A%E7%BA%BF%E7%A8%8B%202518505019b24e07906051941ac69663/Untitled%2036.png)

### 代码实践

- 创建一个线程池`ExecutorService service = Executors.newFixedThreadPool(10);`
- 在这个service中创建线程，用完之后关闭即可 `service.shutdown();`

```java
package com.kaitan.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//测试线程池
public class TestPool {
    public static void main(String[] args) {
        //1.创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //2. 关闭链接
        service.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
```

## 总结

### 三种新建Thread的方式

- [ ]  [P28多线程28：总结05:14](https://www.bilibili.com/video/BV1V4411p7EF?p=28)

```java
package com.kaitan.advanced;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 回顾总结线程 创建
public class ThreadNew {
    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread2()).start();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread3());
        //control+click to see the param*
        //can pass callable/runnable
        //callable extends runnable
        new Thread(futureTask).start();
        //get returned value
        try {
            Integer integer =  futureTask.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//1. extends Thread
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}

//2. implements Runnable
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}

//3. implements callable, needs a return
class MyThread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3");
        return 100;
    }
}
```
