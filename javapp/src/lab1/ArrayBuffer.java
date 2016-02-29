package lab1;

import common.Box;

import java.util.ArrayList;

/**
 * Created by vitaliy on 2/16/16.
 */
public class ArrayBuffer implements Box{
    private ArrayList<String>buffer;
    private int size;
    private int pointer = 0;
    private boolean flag;

    public ArrayBuffer(int size){
        this.buffer = new ArrayList<String>(size);
        this.size = size;
    }

    public synchronized void put(String str) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        notifyAll();
        buffer.add(str);
        pointer++;
        if (pointer == size) {
            buffer = new ArrayList<String>(size);
        }
        flag = true;
    }

    public synchronized String get(){
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        notifyAll();
        String result = String.join("\n", buffer);
        buffer = new ArrayList<String>(size);
        flag = false;
        return result;
    }
}
