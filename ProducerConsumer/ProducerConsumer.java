package com.sumit.playjava;

//Utility class to perform wait and notify
class Utility{
    int i;
    boolean bool = false;
    public synchronized void set(int i) throws InterruptedException{
        while (bool) {
            wait();
        }
        this.i = i;
        bool = true;
        System.out.println("Producer "+i);
        notify();
    }
    public synchronized void get() throws InterruptedException {
        while (!bool) {
            wait();
        }

        bool = false;
        System.out.println("Consumer "+i);
        notify();
    }


}


//Consumer class to consume
class Consumer implements Runnable{
    private Utility utility;
    public Consumer(Utility utility){
        this.utility = utility;
        Thread consumer = new Thread(this,"Consumer");
        consumer.start();

    }

    public void run(){
        while (true){
            try {
                utility.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}




//producer class to produce
class Producer implements Runnable{

    private Utility utility;
    public Producer(Utility utility){
        this.utility = utility;
        Thread producer = new Thread (this,"Producer");
        producer.start();
    }

    public void run(){
        int i = 0;
        while (true){
            try {
                utility.set(i++);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }
}
//create a min file to run producer and consumer
public class ProducerConsumer {
    public static void main(String[] args){

    }
}