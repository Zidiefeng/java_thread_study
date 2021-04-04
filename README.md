# Multi-Thread Learning - Java


# 【狂】多线程

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

### 线程停止

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

### 线程休眠sleep

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

### 线程yield（礼让）

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

## Join

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

- [ ]  [P15多线程15：观测线程状态07:48](https://www.bilibili.com/video/BV1V4411p7EF?p=15)
- [ ]  [P16多线程16：线程的优先级07:50](https://www.bilibili.com/video/BV1V4411p7EF?p=16)
- [ ]  [P17多线程17：守护线程07:34](https://www.bilibili.com/video/BV1V4411p7EF?p=17)
- [ ]  [P18多线程18：线程同步机制08:48](https://www.bilibili.com/video/BV1V4411p7EF?p=18)
- [ ]  [P19多线程19：三大不安全案例20:33](https://www.bilibili.com/video/BV1V4411p7EF?p=19)
- [ ]  [P20多线程20：同步方法及同步块10:20](https://www.bilibili.com/video/BV1V4411p7EF?p=20)
- [ ]  [P21多线程21：CopyOnWriteArrayList03:42](https://www.bilibili.com/video/BV1V4411p7EF?p=21)
- [ ]  [P22多线程22：死锁12:34](https://www.bilibili.com/video/BV1V4411p7EF?p=22)
- [ ]  [P23多线程23：Lock锁07:23](https://www.bilibili.com/video/BV1V4411p7EF?p=23)
- [ ]  [P24多线程24：生产者消费者问题06:56](https://www.bilibili.com/video/BV1V4411p7EF?p=24)
- [ ]  [P25多线程25：管程法10:18](https://www.bilibili.com/video/BV1V4411p7EF?p=25)
- [ ]  [P26多线程26：信号灯法08:09](https://www.bilibili.com/video/BV1V4411p7EF?p=26)
- [ ]  [P27多线程27：线程池05:52](https://www.bilibili.com/video/BV1V4411p7EF?p=27)
- [ ]  [P28多线程28：总结05:14](https://www.bilibili.com/video/BV1V4411p7EF?p=28)
