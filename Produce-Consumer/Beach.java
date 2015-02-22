package com.javarush.test.level17.lesson10.home02;

public class Beach {
    public static void main(String[] args)
    {
        Buffer buffer = new Buffer();
        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread thread_producer1 = new Thread(producer1);
        Thread thread_producer2 = new Thread(producer2);
        Thread thread_consumer = new Thread(consumer);

        thread_producer1.start();
        thread_producer2.start();
        thread_consumer.start();
    }
}
