package com.kaitan.lambdaShow;

//推导 lambda表达式

public class TestLambda1 {
    public static void main(String[] args) {
        Like1 like1 = new Like1();
        like1.lambda();



        Like2 like2 = new Like2();
        like2.lambda();


        //4. 局部 内部类
        class Like3 implements Ilike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        Like3 like3 = new Like3();
        like3.lambda();

        //5. 匿名内部类, 没有类的名称，必须借助接口或者 父类
        Ilike like4 = new Ilike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like4.lambda();

        //6. lambda简化
        Ilike like6 = () -> {
            System.out.println("I like lambda5");
        };
        like6.lambda();

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

// 2. 实现类
class Like1 implements Ilike{
    @Override
    public void lambda() {
        System.out.println("I like lambda1");
    }
}