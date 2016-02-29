package lab1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vitaliy on 2/16/16.
 */
public class Main {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ArrayBuffer buffer = new ArrayBuffer(4);
        Consumer consumer1 = new Consumer(buffer,"consumer1", 5000, System.out, 1000);
        Consumer consumer2 = new Consumer(buffer,"consumer2", 1000, System.out, 1000);
        Consumer consumer3 = new Consumer(buffer,"consumer3", 3000, System.out, 1000);
        Consumer consumer4 = new Consumer(buffer,"consumer4", 4000, System.out, 1000);
        Producer producer = new Producer(buffer,"producer1", 500, 1000);
        consumer1.start(executor);
        consumer2.start(executor);
        consumer3.start(executor);
        consumer4.start(executor);
        producer.start(executor);
    }
}
