package lab1;

import java.io.PrintStream;
import java.io.StreamCorruptedException;
import java.util.concurrent.Executor;

/**
 * Created by vitaliy on 2/16/16.
 */
public class Consumer {
    private Runnable task;
    private StringBuilder text;
    private int count;

    public Consumer(final ArrayBuffer buffer, final int interval, final PrintStream stream, int wordsCount) {
        this.count = wordsCount;
        text = new StringBuilder();
        this.task = new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    stream.println(consume(buffer));
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
        this.text.append(string);
        return string;
    }
}
