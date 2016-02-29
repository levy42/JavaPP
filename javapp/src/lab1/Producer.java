package lab1;

import java.util.Random;
import java.util.concurrent.Executor;

/**
 * Created by vitaliy on 2/16/16.
 */
public class Producer {
    private Runnable task;
    private int count;
    private String name;
    public Producer(final ArrayBuffer buffer,String name, final int interval, int cycleCount) {
        this.name = name;
        this.count = cycleCount;
        this.task = new Runnable() {
            @Override
            public void run() {
                while (cycleCount > 0) {
                    buffer.put(generate());
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
            }
        };
    }

    public void start(Executor executor){
        executor.execute(task);
    }

    public String generate(){
        System.out.println(this.name + " genarating new value");
        return String.valueOf(new Random().nextInt(5));
    }
}
