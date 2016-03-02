package lab1_2;

import java.util.Random;
import java.util.concurrent.Executor;

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
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(task);
        System.out.println(this.name + " started");
    }

    public String generate(){
        System.out.println(this.name + " genarating new value");
        return String.valueOf(new Random().nextInt(5));
    }
}
