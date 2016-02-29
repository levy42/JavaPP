package lab1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vitaliy on 2/16/16.
 */
public class Main {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ArrayBuffer buffer = new ArrayBuffer(10);
        Consumer consumer = new Consumer(buffer, 500, System.out, 1000);
        Producer producer = new Producer(buffer, 2000, 1000);
        consumer.start(executor);
        producer.start(executor);
    }
}
