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