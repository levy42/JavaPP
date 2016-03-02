package lab1_2;

import java.io.PrintStream;
import java.util.concurrent.Executor;

public class Consumer {
    private Runnable task;
    private StringBuilder text;
    private int count;
    private String name;

    public Consumer(final ArrayBuffer buffer,String name, final int interval, final PrintStream stream, int wordsCount) {
        this.count = wordsCount;
        this.name = name;
        text = new StringBuilder();
        this.task = new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    consume(buffer);
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("error consumer");
                    }
                }
                count--;
            }
        };
    }

    public void start(Executor executor) {
        executor.execute(this.task);
    }

    public String consume(ArrayBuffer buffer) {
        String string = buffer.get() + "\n";
        System.out.println("consumer " + name + " got value " + string);
        this.text.append(string);
        return string;
    }
}
