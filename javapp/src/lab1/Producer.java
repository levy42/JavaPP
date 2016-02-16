package lab1;

import java.util.Random;

/**
 * Created by vitaliy on 2/16/16.
 */
public class Producer {
    private Thread thread;
    public Producer(final ArrayBuffer buffer, final int interval) {
        this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!thread.isInterrupted()) {
                    buffer.put(generate());
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void start(){
        this.thread.start();
    }

    public synchronized void stop(){
        if(this.thread.isAlive())
            this.thread.interrupt();
    }

//    generating random string from above
    String[] strings = {"Hello", "Bonjour", "Salamaleyku", "Hi", "Kisimotoyava"};

    public String generate(){
        return this.strings[new Random().nextInt(5)];
    }
}
