package lab1;

import java.io.PrintStream;
import java.io.StreamCorruptedException;

/**
 * Created by vitaliy on 2/16/16.
 */
public class Consumer {
    private Thread thread;
    private StringBuilder text;

    public Consumer(final ArrayBuffer buffer, final int interval, final PrintStream stream) {
        text = new StringBuilder();
        this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!thread.isInterrupted()) {
                    stream.println(consume(buffer));
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("error consumer");
                    }
                }
            }
        });
    }

    public void start() {
        this.thread.start();
    }

    public synchronized void stop() {
        if (this.thread.isAlive())
            this.thread.interrupt();
    }


    public String consume(ArrayBuffer buffer) {
        String string = buffer.get() + "\n";
        this.text.append(string);
        return string;
    }
}
