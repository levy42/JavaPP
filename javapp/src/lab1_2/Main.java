package lab1_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        ExecutorService producer_executor = Executors.newFixedThreadPool(5);
        ExecutorService consumer_executor = Executors.newFixedThreadPool(5);
        ArrayBuffer buffer = new ArrayBuffer(4);
        Consumer consumer1 = new Consumer(buffer,"consumer1", 6000, System.out, 1000);
        Consumer consumer2 = new Consumer(buffer,"consumer2", 6000, System.out, 1000);
        Consumer consumer3 = new Consumer(buffer,"consumer3", 6000, System.out, 1000);
        Consumer consumer4 = new Consumer(buffer,"consumer4", 6000, System.out, 1000);
        Producer producer = new Producer(buffer,"producer1", 1000, 1000);
        Producer producer2 = new Producer(buffer,"producer2", 1000, 1000);
        consumer1.start(consumer_executor);
        consumer2.start(consumer_executor);
        consumer3.start(consumer_executor);
        consumer4.start(consumer_executor);
        producer.start(producer_executor);
        producer2.start(producer_executor);
    }
}
