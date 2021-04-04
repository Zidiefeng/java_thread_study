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
