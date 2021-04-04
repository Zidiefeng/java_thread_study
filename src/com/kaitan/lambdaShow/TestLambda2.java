package com.kaitan.lambdaShow;

public class TestLambda2 {
    public static void main(String[] args) {
        new Love1().love(11);

        new Love2().love(22);

        //3. 局部内部类
        class Love3 implements Ilove{
            @Override
            public void love(int a) {
                System.out.println("I love you 3:"+a);
            }
        }
        new Love3().love(33);

        //4. 匿名内部类
        Ilove love4 = new Ilove(){

            @Override
            public void love(int a) {
                System.out.println("I love you 4:"+a);
            }
        };
        love4.love(44);

        //5. lambda
        Ilove love5 = (int a)->{
            System.out.println("I love you 5:"+a);
        };
        love5.love(55);

        //6. simplify lambda 1:去掉参数类型
        Ilove love6 = (a)->{
            System.out.println("I love you 6:"+a);
        };
        love6.love(66);

        //7. simplify lambda 2:去掉括号
        Ilove love7 = a->{
            System.out.println("I love you 7:"+a);
        };
        love7.love(77);

        //8. simplify lambda 3:去掉{}
        Ilove love8 = a->System.out.println("I love you 8:"+a);
        love8.love(88);



    }

    //2. 静态内部类
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

class Love1 implements Ilove{
    //1. 外部类
    @Override
    public void love(int a) {
        System.out.println("I love you 1:"+a);
    }
}