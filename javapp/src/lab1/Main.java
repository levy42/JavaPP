package lab1;

/**
 * Created by vitaliy on 2/16/16.
 */
public class Main {
    public static void main(String[] args){
        ArrayBuffer buffer = new ArrayBuffer(10);
        Consumer consumer = new Consumer(buffer, 500, System.out);
        Producer producer = new Producer(buffer, 1000);
        consumer.start();
        producer.start();
    }
}
