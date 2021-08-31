package io.codr;

public class Ingestion {
    public static void main(String[] args) {
        //our Regular way of Implementing
        //MyRunnable myRunnable = new MyRunnable();


        // small code for thread execution
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Executed!");
            }
        });
        thread.start();

        // First lambda Implementation
        Thread thread1 = new Thread(()-> System.out.println("Thread Executed !"));
        thread1.start();

        // Functional Interface execution
        MyInterface myInterface = ()-> System.out.println("Functional Interface method Ran");
        myInterface.myMethod();

        // Passing behaviour on the fly
        onTheFly(() -> System.out.println("Supplying behaviour on the fly"));





    }

    public static void onTheFly(MyInterface myInterface){
        myInterface.myMethod();
    }
}
