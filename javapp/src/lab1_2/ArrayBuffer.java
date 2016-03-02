package lab1_2;

import common.Box;

public class ArrayBuffer implements Box{
    private String[] buffer;
    private int size;
    private int pointer = -1;

    public ArrayBuffer(int size){
        this.buffer = new String[size];
        this.size = size;
    }

    public synchronized void put(String str) {
        while (pointer == size - 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        pointer++;
        buffer[pointer] = str;
        notify();
    }

    public synchronized String get(){
        while (pointer ==  -1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        notify();
        String result = buffer[pointer];
        StringBuilder listString = new StringBuilder("buffer [");
        for( int i = 0; i <= pointer; i++){
            listString.append(buffer[i] + "\t");
        }
        listString.append("]");

        pointer--;

        System.out.println(listString);
        return result;
    }
}
