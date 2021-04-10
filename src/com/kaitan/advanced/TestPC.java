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
